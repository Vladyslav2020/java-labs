package com.company;

public class PatientModel {
    private Patient[] patients;
    private PatientDatabase patientDatabase;

    public PatientModel(PatientDatabase patientDatabase) {
        this.patientDatabase = patientDatabase;
        this.patients = patientDatabase.readAllPatients();
    }

    public Patient[] getPatients() {
        return patients;
    }

    public void setPatients(Patient[] patients) {
        this.patients = patients;
    }

    public Patient[] getPatientWithDiagnosis(String diagnosis) {
        int count = 0;
        for (Patient patient : this.patients) {
            if (patient.getDiagnosis().equalsIgnoreCase(diagnosis)) {
                count++;
            }
        }
        Patient[] patients = new Patient[count];
        int i = 0;
        for (Patient patient : this.patients) {
            if (patient.getDiagnosis().equalsIgnoreCase(diagnosis)) {
                patients[i] = patient;
                i++;
            }
        }
        return patients;
    }

    public Patient[] getPatientsInRange(Range range) {
        int count = 0;
        for (Patient patient : this.patients) {
            if (range.isInRange(patient.getMedicalCardNumber())) {
                count++;
            }
        }
        Patient[] patients = new Patient[count];
        int i = 0;
        for (Patient patient : this.patients) {
            if (range.isInRange(patient.getMedicalCardNumber())) {
                patients[i] = patient;
                i++;
            }
        }
        return patients;
    }

}
