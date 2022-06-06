package com.company.controllers;

import com.company.models.PatientModel;
import com.company.utilities.Range;
import com.company.views.PatientView;

public class PatientController {
    private PatientModel patientModel;
    private PatientView patientView;

    public PatientController(PatientModel patientModel, PatientView patientView) {
        this.patientModel = patientModel;
        this.patientView = patientView;
    }

    public void run() {
        int currentOperation;
        while (true) {
            currentOperation = (int) patientView.getOperation();
            switch (Operation.values()[currentOperation - 1]) {
                case SHOW_ALL_PATIENTS -> patientView.printPatients(patientModel.getPatients());
                case SHOW_PATIENTS_WITH_SPECIFIC_DIAGNOSIS -> {
                    String diagnosis = patientView.getDiagnosis();
                    patientView.printPatients(patientModel.getPatientWithDiagnosis(diagnosis));
                }
                case SHOW_PATIENTS_IN_RANGE -> {
                    Range range = patientView.getRange();
                    patientView.printPatients(patientModel.getPatientsInRange(range));
                }
            }
            if (Operation.values()[currentOperation - 1] == Operation.EXIT) {
                break;
            }
            patientView.confirm();
        }
    }

    public enum Operation {
        SHOW_ALL_PATIENTS,
        SHOW_PATIENTS_WITH_SPECIFIC_DIAGNOSIS,
        SHOW_PATIENTS_IN_RANGE,
        EXIT
    }
}
