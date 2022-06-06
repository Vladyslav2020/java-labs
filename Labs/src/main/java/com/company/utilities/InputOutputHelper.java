package com.company.utilities;

import java.util.Scanner;

public class InputOutputHelper {
    private Scanner scanner = new Scanner(System.in);

    public InputOutputHelper() {
        scanner.useDelimiter("\n");
    }

    public long readNumber(String message, Range range) {
        long number = 0;
        boolean firstCheck = true;
        while (firstCheck || !range.isInRange(number)) {
            try {
                number = firstCheck ? readNumber(message) : readNumber("Invalid input, please try again: ");
            } catch (Exception e) {
                scanner.next();
            }
            firstCheck = false;
        }
        return number;
    }

    public long readNumber(String message) {
        writeString(message);
        while (true) {
            try {
                return readNumber();
            } catch (IllegalArgumentException e) {
                scanner.next();
                writeString("Invalid input, please try again: ");
            }
        }
    }

    public String readString(String message) {
        writeString(message);
        return scanner.next();
    }

    public void writeString(String message) {
        System.out.println(message);
    }

    private long readNumber() {
        return scanner.nextLong();
    }
}
