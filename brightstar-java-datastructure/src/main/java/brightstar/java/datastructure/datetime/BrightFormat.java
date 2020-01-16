package brightstar.java.datastructure.datetime;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BrightFormat {

	public static void main(String[] args) {
		LocalDate now = LocalDate.now();
		System.out.print(now.format(DateTimeFormatter.BASIC_ISO_DATE));

	}

}
