package com.rislah;

import com.rislah.models.*;
import com.rislah.serializer.JSONSerde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.kstream.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClickAnalysisTopology {
    private static final Logger log = LoggerFactory.getLogger(ClickAnalysisTopology.class);

    public static Topology build() {
        StreamsBuilder streamsBuilder = new StreamsBuilder();

        KStream<Void, UserOpenPage> userOpenPage = streamsBuilder
                .stream("user-open-page", Consumed.with(Serdes.Void(), JSONSerde.UserOpenPage()));

        KStream<Void, UserLeavePage> userLeavePage = streamsBuilder
                .stream("user-leave-page", Consumed.with(Serdes.Void(), JSONSerde.UserLeavePage()));

        KStream<Void, UserClickPromotion> userClickPromotion = streamsBuilder
                .stream("user-click-promotion", Consumed.with(Serdes.Void(), JSONSerde.UserClickPromotion()));

        userOpenPage
                .selectKey((k, v) -> v.getPage())
                .groupByKey(Grouped.with(Serdes.String(), JSONSerde.UserOpenPage()))
                .count()
                .toStream()
                .mapValues(VisitedPages::new)
                .to("visited-pages", Produced.with(Serdes.String(), JSONSerde.VisitedPages()));

        userLeavePage
                .groupBy((k, v) -> v.getPage(), Grouped.with(Serdes.String(), JSONSerde.UserLeavePage()))
                .aggregate(PageDurationCountAndSum::new, (key, value, aggregate) -> {
                    aggregate.setCount(aggregate.getCount() + 1);
                    aggregate.setSum(aggregate.getSum() + value.getDurationSeconds());
                    return aggregate;
                }, Materialized.with(Serdes.String(), JSONSerde.PageDurationCountAndSum()))
                .mapValues((k, v) -> new PageDuration(k, v.getSum() / v.getCount()),
                        Materialized.with(Serdes.String(), JSONSerde.PageDuration()))
                .toStream()
                .to("page-average-view-duration", Produced.with(Serdes.String(), JSONSerde.PageDuration()));

        userLeavePage
                .groupBy((k, v) -> v.getUserId(), Grouped.with(Serdes.String(), JSONSerde.UserLeavePage()))
                .aggregate(PageDurationCountAndSum::new, (key, value, aggregate) -> {
                    aggregate.setCount(aggregate.getCount() + 1);
                    aggregate.setSum(aggregate.getSum() + value.getDurationSeconds());
                    return aggregate;
                }, Materialized.with(Serdes.String(), JSONSerde.PageDurationCountAndSum()))
                .mapValues((k, v) -> new UserPageDuration(k, v.getSum() / v.getCount()),
                        Materialized.with(Serdes.String(), JSONSerde.UserPageDuration()))
                .toStream()
                .to("user-average-page-view-duration", Produced.with(Serdes.String(), JSONSerde.UserPageDuration()));

        return streamsBuilder.build();
    }
}
