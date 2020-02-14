package me.potato.axon.consumer.aggregate;

import events.GreetingEvent;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@ProcessingGroup("DemoProcessor")
public class DemoEventHandler {
    @EventHandler
    public void handleDemoEvent(GreetingEvent event){
        log.info(event.toString());
    }
}
