package me.potato.axon.consumer.aggregate;


import events.SagaEndEvent;
import events.SagaStartEvent;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.saga.EndSaga;
import org.axonframework.eventhandling.saga.SagaEventHandler;
import org.axonframework.eventhandling.saga.SagaLifecycle;
import org.axonframework.eventhandling.saga.StartSaga;
import org.axonframework.spring.stereotype.Saga;

@Slf4j
@Saga
@ProcessingGroup("DemoSagaProcessor")
public class DemoSaga {

    @StartSaga
    @SagaEventHandler(associationProperty = "startId")
    public void handleStart(SagaStartEvent startEvent) {
        SagaLifecycle.associateWith("endId", startEvent.getStartId());
        log.info(startEvent.toString());
    }


    @SagaEventHandler(associationProperty = "endId")
    @EndSaga
    public void handleEnd(SagaEndEvent endEvent) {
        log.info("Saga ended with the endId {}", endEvent.getEndId());
    }

}
