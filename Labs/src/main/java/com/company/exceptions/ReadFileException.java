package com.company.exceptions;

import java.io.File;

public class ReadFileException extends RuntimeException {
    private File file;

    public ReadFileException(String message, File file, Throwable cause) {
        super(message, cause);
        this.file = file;
    }

    public File getFile() {
        return file;
    }
}
