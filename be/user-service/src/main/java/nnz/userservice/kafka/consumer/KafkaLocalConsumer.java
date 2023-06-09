package nnz.userservice.kafka.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.kafka.annotation.KafkaListener;

public class KafkaLocalConsumer extends KafkaConsumer {

    public KafkaLocalConsumer(KafkaMessageHandler handler) {
        super(handler);
    }

    @Override
    @KafkaListener(topics = "js-nanum")
    public void consumeNanumMessage(String message) throws JsonProcessingException {
        super.consumeNanumMessage(message);
    }

    @Override
    @KafkaListener(topics = "js-show-sync")
    public void consumeShowMessage(String message) throws JsonProcessingException {
        super.consumeShowMessage(message);
    }

    @Override
    @KafkaListener(topics = "js-usernanum")
    public void consumeReceiveNanumMessage(String message) throws JsonProcessingException {
        super.consumeReceiveNanumMessage(message);
    }
}
