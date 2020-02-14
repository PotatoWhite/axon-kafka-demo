package me.potato.axon.producer;

import events.GreetingEvent;
import events.SagaEndEvent;
import events.SagaStartEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.kafka.KafkaAutoConfiguration;

import java.util.concurrent.TimeUnit;

@Slf4j
@SpringBootApplication(exclude = KafkaAutoConfiguration.class)
public class ProducerApplication implements CommandLineRunner {
    @Autowired
    private Sender sender;

    public static void main(String[] args) {
        SpringApplication.run(ProducerApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        TimeUnit.SECONDS.sleep(5);

        log.info("Start sending");
        final long processId = 1234;
        sender.send(new SagaStartEvent(processId));

        for (int i = 1; i <= 20; i++) {
            TimeUnit.SECONDS.sleep(5);
            sender.send(new GreetingEvent(String.format("Hi there %d", i)));
        }
        sender.send(new SagaEndEvent(processId));
        log.info("Send completed");
    }
}
