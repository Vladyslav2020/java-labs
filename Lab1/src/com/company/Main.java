package com.company;

public class Main {

    public static void main(String[] args) {
        PatientModel patientModel = new PatientModel(10);
        PatientView patientView = new PatientView();
        PatientController patientController = new PatientController(patientModel, patientView);
        patientController.run();
    }
}
