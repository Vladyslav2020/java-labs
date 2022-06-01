package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class PatientView {
    private static Scanner scanner = new Scanner(System.in);

    public PatientView() {
        scanner.useDelimiter("\n");
    }

    public void printMenu() {
        System.out.println("Menu of the program:");
        System.out.println("1 - to see all patients");
        System.out.println("2 - to get patients with a certain diagnosis");
        System.out.println("3 - to get patients in a certain range");
        System.out.println("4 - to exit the program");
    }

    public long getOperation() {
        printMenu();
        return readNumber("Choose the operation you need: ", new Range(1, 4));
    }

    private long readNumber(String message, Range range) {
        long number;
        do {
            number = readNumber(message);
            if (!range.isInRange(number)) {
                System.out.println("Invalid input, please try again: ");
                message = null;
            }
        }
        while (!range.isInRange(number));
        return number;
    }

    private long readNumber(String message) {
        if (message != null) {
            System.out.println(message);
        }
        while (true) {
            try {
                return readNumber();
            } catch (IllegalArgumentException e) {
                scanner.next();
                System.out.println("Invalid input, please try again: ");
            }
        }
    }

    private long readNumber() {
        return scanner.nextLong();
    }

    public String getDiagnosis() {
        System.out.println("Input a diagnosis: ");
        return scanner.next();
    }

    public Range getRange() {
        System.out.println("Input a range for the medical card number:");
        return new Range(readNumber("Input lower bound: "), readNumber("Input upper bound: "));
    }

    public void confirm() {
        System.out.println("Press 'Enter' to continue: ");
        scanner.next();
    }

    public void printPatients(Patient[] patients) {
        if (patients.length == 0) {
            System.out.println("No patients to display");
            return;
        }
        int[] columnWidth = calculateColumnWidth(patients);
        StringBuilder stringBuilder = new StringBuilder("-");
        for (int column : columnWidth) {
            char[] chars = new char[column + 2];
            Arrays.fill(chars, '-');
            stringBuilder.append(chars);
        }
        String separator = stringBuilder.toString();
        System.out.println(separator);
        System.out.printf("| %" + columnWidth[0] + "s| %" + columnWidth[1] + "s| %" + columnWidth[2] + "s| %"
                + columnWidth[3] + "s| %" + columnWidth[4] + "s| %" + columnWidth[5] + "s| %" + columnWidth[6] + "s| %"
                + columnWidth[7] + "s|", "ID", "Name", "Surname", "Patronymic", "Address", "Phone number", "Medical card number", "Diagnosis");
        System.out.println();
        System.out.println(separator);
        for (Patient patient : patients) {
            System.out.printf("| %" + columnWidth[0] + "s| %" + columnWidth[1] + "s| %" + columnWidth[2] + "s| %"
                            + columnWidth[3] + "s| %" + columnWidth[4] + "s| %" + columnWidth[5] + "s| %" + columnWidth[6] + "s| %"
                            + columnWidth[7] + "s|", patient.getIdentificationNumber(), patient.getName(), patient.getSurname(), patient.getPatronymic(),
                    patient.getAddress(), patient.getPhoneNumber(), patient.getMedicalCardNumber(), patient.getDiagnosis());
            System.out.println();
            System.out.println(separator);
        }
    }

    private int[] calculateColumnWidth(Patient[] patients) {
        int[] result = new int[8];
        result[0] = 12;
        result[1] = 4;
        result[2] = 7;
        result[3] = 10;
        result[4] = 7;
        result[5] = 12;
        result[6] = 19;
        result[7] = 9;
        for (Patient patient : patients) {
            // name
            result[1] = Math.max(result[1], patient.getName().length());
            // surname
            result[2] = Math.max(result[2], patient.getSurname().length());
            // patronymic
            result[3] = Math.max(result[3], patient.getPatronymic().length());
            // address
            result[4] = Math.max(result[4], patient.getAddress().length());
            // phoneNumber
            result[5] = Math.max(result[5], patient.getPhoneNumber().length());
            // diagnosis
            result[7] = Math.max(result[7], patient.getDiagnosis().length());
        }
        return result;
    }

}
