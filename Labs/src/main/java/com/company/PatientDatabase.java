package com.company;

import com.company.entities.Patient;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class PatientDatabase {
    Logger logger = Logger.getLogger(PatientDatabase.class);

    private static ObjectMapper objectMapper = new ObjectMapper();
    private String fileName;
    private File file;

    public PatientDatabase(String fileName) {
        this.fileName = fileName;
        this.file = new File(fileName);
    }

    public List<Patient> readAllPatients() {
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            String data = new String(fileInputStream.readAllBytes());
            return objectMapper.readValue(data, new TypeReference<>() {});
        } catch (IOException e) {
            logger.error("Cannot read patients from the file", e);
            throw new RuntimeException(e);
        }
    }

    public void writePatientsToDatabase(List<Patient> patients) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {
            String data = objectMapper.writeValueAsString(patients);
            fileOutputStream.write(data.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            logger.error("Cannot write a data to the file", e);
            throw new RuntimeException(e);
        }
    }
}