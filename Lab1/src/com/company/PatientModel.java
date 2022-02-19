package com.company;

import static com.company.DataGenerator.getRandomPatient;

public class PatientModel {


    private Patient[] patients;

    public PatientModel(int numberPatients) {
        this.patients = getPreparedPatients(numberPatients);
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
            if (patient.getMedicalCardNumber() >= range.getLowerBound() && patient.getMedicalCardNumber() <= range.getUpperBound()) {
                count++;
            }
        }
        Patient[] patients = new Patient[count];
        int i = 0;
        for (Patient patient : this.patients) {
            if (patient.getMedicalCardNumber() >= range.getLowerBound() && patient.getMedicalCardNumber() <= range.getUpperBound()) {
                patients[i] = patient;
                i++;
            }
        }
        return patients;
    }

    private Patient[] getPreparedPatients(int numberPatients) {
        Patient[] patients = new Patient[numberPatients];
        for (int i = 0; i < numberPatients; i++) {
            patients[i] = getRandomPatient();
        }
        return patients;
    }
}
