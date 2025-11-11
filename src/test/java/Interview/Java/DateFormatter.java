package Interview.Java;

import net.bytebuddy.asm.Advice;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class DateFormatter {

    public static void main(String[] args) {
        LocalDate date = LocalDate.now();

        String month = date.format(DateTimeFormatter.ofPattern("MMMM"));
        String mon = date.format(DateTimeFormatter.ofPattern("MMM"));   //Sep

        String year = date.format(DateTimeFormatter.ofPattern("YYYY"));  //2025
        String weekday = date.format(DateTimeFormatter.ofPattern("EEEE"));  //Tuesday

        String prev_month = date.minusMonths(1).format(DateTimeFormatter.ofPattern("MMM"));

        System.out.println(month+" "+year+" "+weekday+" "+prev_month);

        String dateStr = "23-09-2025";

        LocalDate Date = LocalDate.parse(dateStr,DateTimeFormatter.ofPattern("dd-MM-yyyy"));

        System.out.println(Date.getMonth());

       System.out.println( Date.getEra());


        LocalDate dat = LocalDate.parse(dateStr,DateTimeFormatter.ofPattern("dd-MM-yyyy"));

        dat.getDayOfMonth();


    }
}
