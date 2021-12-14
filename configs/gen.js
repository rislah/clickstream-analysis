const faker = require('faker')
const { Kafka } = require('kafkajs')

const BASE_URL = "http://fakeurl.com"
const PATHS = ["path1", "path2", "path3", "path4"]

const kafka = new Kafka({
    clientId: "gen",
    brokers: ["localhost:9092"],
})

const producer = kafka.producer()

async function gen() {
    await producer.connect()
    for (let i = 0; i < 50_000; i++) {
        let userId = faker.datatype.number(100);
        let d = Math.random();
        
        let userOpenPage = {
            user_id: userId.toString(),
            referrer: "",
            page: "",
        }

        let userLeavePage = {
            user_id: userId.toString(),
            page: "",
            duration_sec: faker.datatype.number(600),
        }

        let userClickPromotion = {
            user_id: userId.toString(),
            promotion_id: faker.datatype.number(5).toString(),
        }

        if (d < 0.5) {
            userOpenPage.referrer = faker.internet.url();
        }

        if (d < 0.2) {
            userOpenPage.page = new URL(PATHS[faker.datatype.number(3)], BASE_URL)
            userLeavePage.page = userOpenPage.page
        
            await producer.send({
                topic: "user-open-page",
                messages: [
                    { value: JSON.stringify(userOpenPage) },
                ]
            })

            await producer.send({
                topic: "user-leave-page",
                messages: [
                    { value: JSON.stringify(userLeavePage)},
                ]
            })
        }

        if (d < 0.8) {
            await producer.send({
                topic: "user-click-promotion",
                messages: [
                    { value: JSON.stringify(userClickPromotion)},
                ]
            })
        }

    }
}

gen()
    .then(res => {
        console.log(res)
    })
    .catch(err => {
        console.log(err)
    })
// fs.writeFileSync('data.json', JSON.stringify(data, null, '\t'))
