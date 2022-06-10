package com.company.models.repositories;

import com.company.models.entities.Patient;
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

    private File readFile;
    private File writeFile;

    public PatientDatabase(String dataSourceFileName, String intermediateResultsFileName) {
        this.readFile = new File(dataSourceFileName);
        this.writeFile = new File(intermediateResultsFileName);
    }

    @Override
    public List<Patient> getAllEntities() throws IOException {
        try (FileInputStream fileInputStream = new FileInputStream(readFile)) {
            String data = new String(fileInputStream.readAllBytes());
            return objectMapper.readValue(data, new TypeReference<>() {
            });
        }
    }

    @Override
    public void saveEntities(Collection<Patient> patients) throws IOException {
        try (FileOutputStream fileOutputStream = new FileOutputStream(writeFile)) {
            String data = objectMapper.writeValueAsString(patients);
            fileOutputStream.write(data.getBytes(StandardCharsets.UTF_8));
        }
    }
}