package com.kta.sample.util;

import java.time.LocalDate;

public class ArchUnitUtils {

    public static String getCurrentDateStr(){
        return "Today";
    }

    public LocalDate getCurrentDate(){
        return LocalDate.now();
    }
}
