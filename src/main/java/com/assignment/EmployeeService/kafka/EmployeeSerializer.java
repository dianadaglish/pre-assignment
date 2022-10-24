package com.assignment.EmployeeService.kafka;

import com.assignment.EmployeeService.dtos.EmployeeDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;

public class EmployeeSerializer implements Serializer <EmployeeDTO>{

     private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void configure(Map configs, boolean isKey) {
    }

    @Override
    public byte[] serialize(String topic, EmployeeDTO data) {
        try {
            if (data == null) {
                return null;
            }
            return objectMapper.writeValueAsBytes(data);
        } catch (Exception e) {
            throw new SerializationException("Error serialising dto");
        }
    }


    @Override
    public void close() {

    }
}
