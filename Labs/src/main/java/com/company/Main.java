package com.company;

import com.company.controllers.PatientController;

public class Main {

    public static void main(String[] args) {
        BeansConstructor beansConstructor = new BeansConstructor();
        PatientController patientController = beansConstructor.getPatientController();
        patientController.run();
    }
}
