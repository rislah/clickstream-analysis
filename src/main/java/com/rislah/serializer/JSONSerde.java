package com.rislah.serializer;

import com.rislah.models.*;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;

public class JSONSerde {
    public static Serde<UserClickPromotion> UserClickPromotion() {
        JSONSerializer<UserClickPromotion> serializer = new JSONSerializer<>();
        JSONDeserializer<UserClickPromotion> deserializer = new JSONDeserializer<>(UserClickPromotion.class);
        return Serdes.serdeFrom(serializer, deserializer);
    }

    public static Serde<UserLeavePage> UserLeavePage() {
        JSONSerializer<UserLeavePage> serializer = new JSONSerializer<>();
        JSONDeserializer<UserLeavePage> deserializer = new JSONDeserializer<>(UserLeavePage.class);
        return Serdes.serdeFrom(serializer, deserializer);
    }

    public static Serde<UserOpenPage> UserOpenPage() {
        JSONSerializer<UserOpenPage> serializer = new JSONSerializer<>();
        JSONDeserializer<UserOpenPage> deserializer = new JSONDeserializer<>(UserOpenPage.class);
        return Serdes.serdeFrom(serializer, deserializer);
    }

    public static Serde<VisitedPages> VisitedPages() {
        JSONSerializer<VisitedPages> serializer = new JSONSerializer<>();
        JSONDeserializer<VisitedPages> deserializer = new JSONDeserializer<>(VisitedPages.class);
        return Serdes.serdeFrom(serializer, deserializer);
    }

    public static Serde<PageDuration> PageDuration() {
        JSONSerializer<PageDuration> serializer = new JSONSerializer<>();
        JSONDeserializer<PageDuration> deserializer = new JSONDeserializer<>(PageDuration.class);
        return Serdes.serdeFrom(serializer, deserializer);
    }

    public static Serde<PageDurationCountAndSum> PageDurationCountAndSum() {
        JSONSerializer<PageDurationCountAndSum> serializer = new JSONSerializer<>();
        JSONDeserializer<PageDurationCountAndSum> deserializer = new JSONDeserializer<>(PageDurationCountAndSum.class);
        return Serdes.serdeFrom(serializer, deserializer);
    }

    public static Serde<UserPageDuration> UserPageDuration() {
        JSONSerializer<UserPageDuration> serializer = new JSONSerializer<>();
        JSONDeserializer<UserPageDuration> deserializer = new JSONDeserializer<>(UserPageDuration.class);
        return Serdes.serdeFrom(serializer, deserializer);
    }
}
