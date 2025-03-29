package com.knowledge.KafkaAnalysisKnowledgeConsumerV1.service;

import com.knowledge.KafkaAnalysisKnowledgeConsumerV1.dto.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class KafkaConsumerService {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private Employee lastConsumedEmployee;

    @KafkaListener(topics = "employee-producer", groupId = "user-group")
    public void consumeFromKafka(String employee) {
        log.info("Consumed message: {}", employee);
        try {
            lastConsumedEmployee = objectMapper.readValue(employee, Employee.class);
            log.info("Transformed message to Employee DTO: {}", lastConsumedEmployee);
        } catch (Exception e) {
            log.error("Error while parsing employee message to DTO: {}", e.getMessage(), e);
        }
    }

    public Employee consume() {
        return lastConsumedEmployee;
    }
}
