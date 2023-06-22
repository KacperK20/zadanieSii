package com.example.zadaniesi.Service;

import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
@Service
public class EmailService {


    public void sendEmail(String to, String content) {


        String date = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));


        try(FileWriter fileWriter = new FileWriter("powiadomienia.txt", true)) {
            fileWriter.write(String.format("Date: %s, To: %s, Content: %s%n", date, to, content));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


