package com.gabriel.strconsumer.exceptions;

import lombok.extern.log4j.Log4j2;
import org.apache.kafka.clients.consumer.Consumer;
import org.springframework.kafka.listener.KafkaListenerErrorHandler;
import org.springframework.kafka.listener.ListenerExecutionFailedException;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class ErrorCustomHandler implements KafkaListenerErrorHandler {


    @Override
    public Object handleError(Message<?> message, ListenerExecutionFailedException exception) {
        log.info("Excenption Handler ::: CAPTURED");
        log.info("Excenption Message ::: {}}", exception.getMessage());
        log.info("Payload ::: {}", message.getPayload());
        log.info("Headers ::: {}", message.getHeaders());
        log.info("Offset ::: {}, Partition ::: {}, Topic ::: {}, GroupId ::: {}",
                message.getHeaders().get("kafka_offset"),
                message.getHeaders().get("kafka_receivedPartitionId"),
                message.getHeaders().get("kafka_receivedTopic"),
                message.getHeaders().get("kafka_groupId"));
        return null;
    }

    @Override
    public Object handleError(Message<?> message, ListenerExecutionFailedException exception, Consumer<?, ?> consumer) {
        return KafkaListenerErrorHandler.super.handleError(message, exception, consumer);
    }

    @Override
    public Object handleError(Message<?> message, ListenerExecutionFailedException exception, Consumer<?, ?> consumer, Acknowledgment ack) {
        return KafkaListenerErrorHandler.super.handleError(message, exception, consumer, ack);
    }
}
