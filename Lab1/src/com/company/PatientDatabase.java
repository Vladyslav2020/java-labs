package com.company;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class PatientDatabase {
    private static ObjectMapper objectMapper = new ObjectMapper();
    private String fileName;
    private File file;

    public PatientDatabase(String fileName) {
        this.fileName = fileName;
        this.file = new File(fileName);
        try {
            this.file.createNewFile();
        } catch (IOException e) {
            // logging
        }
    }

    public Patient[] readAllPatients() {
        File file = new File(fileName);
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            String data = new String(fileInputStream.readAllBytes());
            return objectMapper.readValue(data, Patient[].class);
        } catch (IOException e) {
            // logging
        }
        return new Patient[0];
    }

    public void writePatientsToDatabase(int numberPatients) {
        File file = new File(fileName);
        try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {
            String data = objectMapper.writeValueAsString(getPreparedPatients(numberPatients));
            fileOutputStream.write(data.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            // logging
        }
    }

    private Patient[] getPreparedPatients(int numberPatients) {
        Patient[] patients = new Patient[numberPatients];
        for (int i = 0; i < numberPatients; i++) {
            patients[i] = DataGenerator.getRandomPatient();
        }
        return patients;
    }
}