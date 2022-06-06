package com.company.views;

import com.company.entities.Patient;
import com.company.utilities.InputOutputHelper;
import com.company.utilities.Range;
import com.company.utilities.tables.TablePrinter;

import java.util.List;

public class PatientView {
    private InputOutputHelper inputOutputHelper;
    private TablePrinter<Patient> tablePrinter;

    public PatientView(InputOutputHelper inputOutputHelper, TablePrinter<Patient> tablePrinter) {
        this.inputOutputHelper = inputOutputHelper;
        this.tablePrinter = tablePrinter;
    }

    public void printMenu() {
        inputOutputHelper.writeString("Menu of the program:");
        inputOutputHelper.writeString("1 - to see all patients");
        inputOutputHelper.writeString("2 - to get patients with a certain diagnosis");
        inputOutputHelper.writeString("3 - to get patients in a certain range");
        inputOutputHelper.writeString("4 - to exit the program");
    }

    public long getOperation() {
        printMenu();
        return inputOutputHelper.readNumber("Choose the operation you need: ", new Range(1, 4));
    }

    public String getDiagnosis() {
        return inputOutputHelper.readString("Input a diagnosis: ");
    }

    public Range getRange() {
        inputOutputHelper.writeString("Input a range for the medical card number:");
        return new Range(inputOutputHelper.readNumber("Input lower bound: "), inputOutputHelper.readNumber("Input upper bound: "));
    }

    public void confirm() {
        inputOutputHelper.readString("Press 'Enter' to continue: ");
    }

    public void printPatients(List<Patient> patients) {
        if (patients.size() == 0) {
            inputOutputHelper.writeString("No patients to display");
            return;
        }
        tablePrinter.printTable(patients);
    }
}
