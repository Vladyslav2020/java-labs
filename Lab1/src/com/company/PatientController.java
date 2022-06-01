package com.company;

public class PatientController {
    private PatientModel patientModel;
    private PatientView patientView;

    public PatientController(PatientModel patientModel, PatientView patientView) {
        this.patientModel = patientModel;
        this.patientView = patientView;
    }

    public void run() {
        long currentOperation = 0;
        while (currentOperation != -1) {
            currentOperation = patientView.getOperation();
            if (currentOperation == 1) {
                patientView.printPatients(patientModel.getPatients());
            } else if (currentOperation == 2) {
                String diagnosis = patientView.getDiagnosis();
                patientView.printPatients(patientModel.getPatientWithDiagnosis(diagnosis));
            } else if (currentOperation == 3) {
                Range range = patientView.getRange();
                patientView.printPatients(patientModel.getPatientsInRange(range));
            } else if (currentOperation == 4) {
                break;
            }
            patientView.confirm();
        }
    }
}
