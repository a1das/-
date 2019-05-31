
package com.example.downloader.exception;

public class FileAlreadyExistException extends DLException {
    private static final long serialVersionUID = 1L;

    public FileAlreadyExistException(String message) {
        super(message);
    }

}
