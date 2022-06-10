package com.company.controllers;

import com.company.models.entities.Patient;
import com.company.models.PatientModel;
import com.company.utilities.Range;
import com.company.views.PatientView;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PatientController {
    Logger logger = Logger.getLogger(PatientController.class);

    private PatientModel patientModel;
    private PatientView patientView;

    public PatientController(PatientModel patientModel, PatientView patientView) {
        this.patientModel = patientModel;
        this.patientView = patientView;
    }

    public void run() {
        int chosenOperation;
        while (true) {
            chosenOperation = (int) patientView.getOperation();
            List<Patient> result = new ArrayList<>();
            switch (Operation.values()[chosenOperation - 1]) {
                case SHOW_ALL_PATIENTS -> {
                    result = patientModel.getPatients();
                    patientView.printPatients(result);
                }
                case SHOW_PATIENTS_WITH_SPECIFIC_DIAGNOSIS -> {
                    String diagnosis = patientView.getDiagnosis();
                    result = patientModel.getPatientWithDiagnosis(diagnosis);
                    patientView.printPatients(result);
                }
                case SHOW_PATIENTS_IN_RANGE -> {
                    Range range = patientView.getRange();
                    result = patientModel.getPatientsInRange(range);
                    patientView.printPatients(result);
                }
                case EXIT -> System.exit(0);
            }

            if (patientView.isSaveRequired() && !result.isEmpty()) {
                try {
                    patientModel.savePatients(result);
                    patientView.reportSuccessfulSave();
                } catch (IOException e) {
                    logger.error("Cannot save result to file", e);
                    patientView.reportUnsuccessfulSave();
                }
                patientView.confirm();
            }
        }
    }

    public enum Operation {
        SHOW_ALL_PATIENTS,
        SHOW_PATIENTS_WITH_SPECIFIC_DIAGNOSIS,
        SHOW_PATIENTS_IN_RANGE,
        EXIT
    }
}
