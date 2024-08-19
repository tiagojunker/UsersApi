package com.UserApi.Api.Utils;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class DateUtils {

    public LocalDate dateConverter(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate formatedDate = LocalDate.parse(date, formatter);
        return formatedDate;
    }

}
