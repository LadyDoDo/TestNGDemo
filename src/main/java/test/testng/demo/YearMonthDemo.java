package test.testng.demo;

import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

/**
 * @author fokui
 * @date 2019/6/12 15:53
 */
public class YearMonthDemo {
    public static void main(String[] args) {
        LocalDateTime dateTime = LocalDateTime.now().plusMonths(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss");
        String time = dateTime.format(formatter);
        System.out.println(time);

        LocalDateTime dateTime1 = dateTime.plusMonths(1);
        String time1 = dateTime1.format(formatter);
        System.out.println(time1);

        LocalDateTime dateTime2 = LocalDateTime.now().plusDays(2);
        String time2 = dateTime2.format(formatter);
        System.out.println(time2);

    }
}
