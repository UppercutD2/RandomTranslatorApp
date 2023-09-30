package Date_Time_Ops;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DateTimeFormat_Ops {


    public static String getNowDate(LocalDateTime date)
    {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyy HH:mm:ss");
        String now = dtf.format(date);

        return now;

    }


    public static  String getDuration(LocalTime start, LocalTime end)
    {
        int seconds =(int) ChronoUnit.SECONDS.between(start,end);
        return "Game time " + seconds +" seconds";
    }

}
