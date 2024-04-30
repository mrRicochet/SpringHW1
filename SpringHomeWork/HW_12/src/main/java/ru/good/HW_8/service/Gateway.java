package ru.good.HW_8.service;

import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.file.FileHeaders;
import org.springframework.messaging.handler.annotation.Header;

import java.io.FileNotFoundException;

@MessagingGateway(defaultRequestChannel = "textInputChanel")
public interface Gateway {
    void writeToFile(@Header(FileHeaders.FILENAME) String filename, String data) throws FileNotFoundException;
}
