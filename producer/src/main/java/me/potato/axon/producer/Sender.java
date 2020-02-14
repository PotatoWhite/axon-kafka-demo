/*
 * © 2018 CREALOGIX. All rights reserved.
 */
package me.potato.axon.producer;

import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.AbstractEventBus;
import org.axonframework.eventhandling.EventMessage;
import org.axonframework.eventhandling.GenericEventMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
class Sender {

    @Autowired
    private AbstractEventBus eventBus;

    <T> void send(T event) {
        log.info("publishing event {}", event);
        EventMessage<T> eventMessage = GenericEventMessage.asEventMessage(event);

        eventBus.publish(eventMessage);
    }
}
