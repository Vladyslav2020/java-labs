package com.company;

import com.company.controllers.PatientController;
import com.company.models.PatientModel;
import com.company.views.PatientView;

public class Main {

    public static void main(String[] args) {
        PatientDatabase patientDatabase = new PatientDatabase("src/main/resources/data.txt");
        PatientModel patientModel = new PatientModel(patientDatabase);
        PatientView patientView = new PatientView();
        PatientController patientController = new PatientController(patientModel, patientView);
        patientController.run();
    }
}
