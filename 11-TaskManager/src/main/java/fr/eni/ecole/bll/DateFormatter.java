package fr.eni.ecole.bll;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateFormatter {
	public static LocalDate stringToDate(String dateString) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		return LocalDate.parse(dateString, formatter);
	}
	
	public static LocalTime stringToTime(String timeString) {
		if (timeString.length() == 5) {
			timeString = timeString + ":00";
		}
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        return LocalTime.parse(timeString, formatter);
	}
}
