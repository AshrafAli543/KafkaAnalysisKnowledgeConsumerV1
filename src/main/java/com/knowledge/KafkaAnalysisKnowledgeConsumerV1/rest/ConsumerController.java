package com.knowledge.KafkaAnalysisKnowledgeConsumerV1.rest;

import com.knowledge.KafkaAnalysisKnowledgeConsumerV1.dto.Employee;
import com.knowledge.KafkaAnalysisKnowledgeConsumerV1.service.KafkaConsumerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.knowledge.KafkaAnalysisKnowledgeConsumerV1.constants.KafkaConsumerConstants.CONSUMER;

@RestController
@RequestMapping(value = CONSUMER)
public class ConsumerController {

    private final KafkaConsumerService kafkaConsumerService;

    public ConsumerController(KafkaConsumerService kafkaConsumerService) {
        this.kafkaConsumerService = kafkaConsumerService;
    }

    @GetMapping(value = "/consume")
    public Employee consume() {
        return kafkaConsumerService.consume();
    }
}
