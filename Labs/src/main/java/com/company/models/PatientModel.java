package com.company.models;

import com.company.entities.Patient;
import com.company.repositories.PatientDatabase;
import com.company.utilities.Range;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PatientModel {
    private List<Patient> patients;

    public PatientModel(PatientDatabase patientDatabase) throws IOException {
        this.patients = patientDatabase.getAllEntities();
    }

    public List<Patient> getPatientWithDiagnosis(String diagnosis) {
        return this.patients
                .stream()
                .filter(patient -> patient.getDiagnosis().equalsIgnoreCase(diagnosis))
                .collect(Collectors.toList());
    }

    public List<Patient> getPatientsInRange(Range range) {
        return this.patients
                .stream()
                .filter(patient -> range.isInRange(patient.getMedicalCardNumber()))
                .collect(Collectors.toList());
    }

    public List<Patient> getPatients() {
        return new ArrayList<>(patients);
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }
}
