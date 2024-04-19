package com.gabriel.strconsumer.listeners;

import com.gabriel.strconsumer.custom.StrConsumerCustomListener;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class StrConsumerListener {

    // o groupId não pode ser mais que o nmr de partições
    // se houver duas partições e um groupId com um listener apenas, ele irá se associar as duas partições
    // se houver duas partições e um groupId com dois listener, cada um irá assumir uma partição

//    @KafkaListener(groupId = "groupOne", topics = "str-topic", containerFactory = "kafkaListenerContainerFactory")
//    public void create(String message) {
//       log.info("CREATE ::: Received message: {}", message);
//    }

//    @KafkaListener(groupId = "groupOne", topics = "str-topic", containerFactory = "kafkaListenerContainerFactory")
//    public void log(String message) {
//        log.info("LOG ::: Received message: {}", message);
//    }

//    @KafkaListener(groupId = "groupTwo", containerFactory = "validMessageContainerFactory", topics = "str-topic")
//    public void history(String message) {
//        log.info("HISTORY ::: Received message: {}", message);
//        throw new IllegalArgumentException("EXCEPTION UEEEEEE");
//    }

    // abaixo como informar qual partição o tópico deve se associar
    // partitions = {} é um array pode receber mais de uma partição

    @StrConsumerCustomListener(groupId = "groupOne")
    public void create(String message) {
        log.info("PARTITION 0 ::: Received message: {}", message);
    }

    @StrConsumerCustomListener(groupId = "groupOne")
    public void log(String message) {
        log.info("PARTITION 1 ::: ::: Received message: {}", message);
    }

    @StrConsumerCustomListener(groupId = "groupTwo")
    public void history(String message) {
        log.info("HISTORY ::: Received message: {}", message);
        throw new IllegalArgumentException("EXCEPTION UEEEEEE");
    }
}
