package com.company.utilities.tables;

import com.company.models.entities.Patient;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PatientTablePrinter extends TablePrinterBase<Patient> {
    private List<String> columns = Stream.of(Columns.values()).map(Columns::getName).collect(Collectors.toList());

    @Override
    public Collection<String> getColumnNames() {
        return columns;
    }

    @Override
    public String getValueInColumn(String columnName, Patient patient) {
        Optional<Columns> columnOptional = Stream.of(Columns.values()).filter(column -> column.getName().equals(columnName)).findFirst();
        if (columnOptional.isPresent()) {
            return switch (columnOptional.get()) {
                case ID -> String.valueOf(patient.getIdentificationNumber());
                case NAME -> patient.getName();
                case SURNAME -> patient.getSurname();
                case PATRONYMIC -> patient.getPatronymic();
                case ADDRESS -> patient.getAddress();
                case PHONE_NUMBER -> patient.getPhoneNumber();
                case MEDICAL_CARD_NUMBER -> String.valueOf(patient.getMedicalCardNumber());
                case DIAGNOSIS -> patient.getDiagnosis();
            };
        }
        throw new IllegalArgumentException("Column name is invalid");
    }

    @Override
    public int getIndent() {
        return 2;
    }

    private enum Columns {
        ID("ID"),
        NAME("Name"),
        SURNAME("Surname"),
        PATRONYMIC("Patronymic"),
        ADDRESS("Address"),
        PHONE_NUMBER("Phone number"),
        MEDICAL_CARD_NUMBER("Medical card number"),
        DIAGNOSIS("Diagnosis");

        private String name;

        Columns(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}
