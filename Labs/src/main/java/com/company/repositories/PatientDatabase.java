package com.company.repositories;

import com.company.entities.Patient;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.List;

public class PatientDatabase implements EntityDatabase<Patient> {
    private static ObjectMapper objectMapper = new ObjectMapper();

    private File file;

    public PatientDatabase(String fileName) {
        this.file = new File(fileName);
    }

    @Override
    public List<Patient> getAllEntities() throws IOException {
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            String data = new String(fileInputStream.readAllBytes());
            return objectMapper.readValue(data, new TypeReference<>() {
            });
        }
    }

    @Override
    public void saveEntities(Collection<Patient> patients) throws IOException {
        try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {
            String data = objectMapper.writeValueAsString(patients);
            fileOutputStream.write(data.getBytes(StandardCharsets.UTF_8));
        }
    }
}