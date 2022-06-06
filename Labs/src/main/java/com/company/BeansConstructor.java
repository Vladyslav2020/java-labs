package com.company;

import com.company.controllers.PatientController;
import com.company.entities.Patient;
import com.company.models.PatientModel;
import com.company.repositories.PatientDatabase;
import com.company.utilities.InputOutputHelper;
import com.company.utilities.tables.PatientTablePrinter;
import com.company.utilities.tables.TablePrinter;
import com.company.views.PatientView;
import org.apache.log4j.Logger;

import java.io.IOException;

public class BeansConstructor {
    private Logger logger = Logger.getLogger(BeansConstructor.class);

    public PatientController getPatientController() {
        InputOutputHelper inputOutputHelper = new InputOutputHelper();
        PatientModel patientModel = null;
        PatientView patientView = null;
        try {
            PatientDatabase patientDatabase = new PatientDatabase("src/main/resources/data.txt");
            patientModel = new PatientModel(patientDatabase);
            TablePrinter<Patient> patientTablePrinter = new PatientTablePrinter();
            patientView = new PatientView(inputOutputHelper, patientTablePrinter);
        } catch (IOException e) {
            logger.error("Cannot read data from the file", e);
            inputOutputHelper.writeString("Program bootstrap failed: cannot read data from the database. Check the program configuration.");
            System.exit(-1);
        } catch (Exception e) {
            logger.error("An error occurred while constructing the beans", e);
            inputOutputHelper.writeString("Program bootstrap failed. An unhandled error has occurred.");
            System.exit(-1);
        }
        return new PatientController(patientModel, patientView);
    }
}
