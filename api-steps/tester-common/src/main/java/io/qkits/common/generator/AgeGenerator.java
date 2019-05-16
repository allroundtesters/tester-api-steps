package io.qkits.common.generator;

import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;


public class AgeGenerator {

    //todo
    public static Integer getAge(String birthDate){
        Integer currentYear = Year.now().getValue();
        Integer birthYear = Year.parse(birthDate, DateTimeFormatter.ofPattern("yyyy-mm-dd")).getValue();
        return currentYear-birthYear;
    }

    //todo
    public static Integer intervalYears(String fromDate){
        Integer currentYear = Year.now().getValue();
        Integer fromYear = Year.parse(fromDate, DateTimeFormatter.ofPattern("yyyy-mm-dd")).getValue();
        return currentYear-fromYear;
    }

    public static int intervalMonths(String fromDate){
        Integer currentYear = Year.now().getValue();
        Integer fromYear = Year.parse(fromDate, DateTimeFormatter.ofPattern("yyyy-mm-dd")).getValue();
        LocalDate from =  LocalDate.parse(fromDate);
        Integer fromMonth = from.getMonthValue();
        LocalDate current = LocalDate.now();
        Integer toMonth = current.getMonthValue();

        return (currentYear-fromYear)*12+toMonth-fromMonth;
    }
}
