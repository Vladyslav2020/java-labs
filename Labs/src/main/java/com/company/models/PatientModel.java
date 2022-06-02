package com.company.models;

import com.company.PatientDatabase;
import com.company.Range;
import com.company.entities.Patient;

import java.util.ArrayList;
import java.util.List;

public class PatientModel {
    private List<Patient> patients;

    public PatientModel(PatientDatabase patientDatabase) {
        this.patients = patientDatabase.readAllPatients();
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

    public List<Patient> getPatientWithDiagnosis(String diagnosis) {
        List<Patient> patients = new ArrayList<>();
        for (Patient patient : this.patients) {
            if (patient.getDiagnosis().equalsIgnoreCase(diagnosis)) {
                patients.add(patient);
            }
        }
        return patients;
    }

    public List<Patient> getPatientsInRange(Range range) {
        List<Patient> patients = new ArrayList<>();
        for (Patient patient : this.patients) {
            if (range.isInRange(patient.getMedicalCardNumber())) {
                patients.add(patient);
            }
        }
        return patients;
    }

}
