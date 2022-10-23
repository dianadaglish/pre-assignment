package com.assignment.EmployeeService.kafka;

import com.assignment.EmployeeService.dtos.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducer {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value(value = "${topic.name}")
    private String topicName;

    public void sendMessage(String employee) {
        kafkaTemplate.send(topicName, employee);
    }
}
