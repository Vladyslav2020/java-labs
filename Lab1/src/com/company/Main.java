package com.company;

public class Main {

    public static void main(String[] args) {
        PatientDatabase patientDatabase = new PatientDatabase("data.txt");
//        patientDatabase.writePatientsToDatabase(10);
        PatientModel patientModel = new PatientModel(patientDatabase);
        PatientView patientView = new PatientView();
        PatientController patientController = new PatientController(patientModel, patientView);
        patientController.run();
    }
}
