package normal;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

/**
 * Your task in order to complete this Kata is to write a function which formats a duration, given as a number of seconds, in a human-friendly way.
 <p>
 * The function must accept a non-negative integer. If it is zero, it just returns <b>now</b>.
 * Otherwise, the duration is expressed as a combination of <b>years, days, hours, minutes</b> and <b>seconds</b>.
 </p>
 <p>
 It is much easier to understand with an example:
 <code>
     <p>formatDuration(62)    // returns "1 minute and 2 seconds"</p>
     <p>formatDuration(3662)  // returns "1 hour, 1 minute and 2 seconds"</p>
 </code>
 </p>
 <p>For the purpose of this Kata, a year is 365 days and a day is 24 hours.</p>

 <p></p>
 <p>Note that spaces are important.</p>

 <p></p>
 <p><b>Detailed rules</b></p>

 <p>
 The resulting expression is made of components like <font color='blue'>4 seconds, 1 year, etc.</font>
 In general, a positive integer and one of the valid units of time, separated by a space. The unit of time is used in plural if the integer is greater than 1.</p>

 <p>
 The components are separated by a comma and a space <font color='blue'>(", ")</font>.
 Except the last component, which is separated by <font color='blue'>" and "</font>, just like it would be written in English.</p>

 <p>
 A more significant units of time will occur before than a least significant one.
 Therefore, 1 second and 1 year is not correct, but <font color='blue'>1 year and 1 second</font> is.</p>

 <p>
 Different components have different unit of times. So there is not repeated units like in <font color='blue'>5 seconds and 1 second</font>.</p>

 <p>
 A component will not appear at all if its value happens to be zero.
 Hence, 1 minute and 0 seconds is <font color='red'>not</font> valid, but it should be just <font color='blue'>1 minute</font>.</p>

 <p>
 A unit of time must be used "as much as possible". It means that the function should not return 61 seconds, but 1 minute and 1 second instead.
 Formally, the duration specified by of a component must not be greater than any valid more significant unit of time.</p>
 */
public class DateInHumanReadableFormat {
    public static void main(String[] args) {
        int timeInNumber = 3662;
        String formatted = formatDuration(timeInNumber);
        System.out.println(formatted);

        System.out.println(formatDuration(YEAR_IN_SEC));
        System.out.println(formatDuration(62));
    }

    private static String formatDuration(int timeInNumber) {
        if(timeInNumber == 0)
            return "now";

        int year = timeInNumber / YEAR_IN_SEC;
        int sum = 0 + (year*YEAR_IN_SEC);

        int day = (timeInNumber - sum ) / DAY_IN_SEC;
        sum += day * DAY_IN_SEC;

        int hour = (timeInNumber - sum ) / HOUR_IN_SEC;
        sum += hour * HOUR_IN_SEC;

        int minute = (timeInNumber - sum ) / MINUTE_IN_SEC;
        sum += minute * MINUTE_IN_SEC;

        int seconds = timeInNumber - sum  ;

        String templateString = buildTemplateString(year, day, hour, minute, seconds);
        List<Integer> args = new ArrayList<>();
        args.add(year);
        args.add(day);
        args.add(hour);
        args.add(minute);
        args.add(seconds);
        args = args.stream().filter( val -> val > 0).collect(Collectors.toList());
        return MessageFormat.format( templateString,args.toArray());
    }

    private static String buildTemplateString(int year, int day, int hour, int minute, int seconds) {
        List<String> temp = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder("");
        if(year != 0 )
            temp.add( year == 1 ? "year" : "years");

        if(day != 0 )
            temp.add( day == 1 ? "day" : "days");

        if(hour != 0 )
            temp.add( hour == 1 ? "hour" : "hours");

        if(minute != 0 )
            temp.add( minute == 1 ? "minute" : "minutes");

        if(seconds != 0 )
            temp.add( seconds == 1 ? "second" : "seconds");

        int i = 0;
        // use string joiner, so we dont have to deal with the last ","
        StringJoiner sj = new StringJoiner(", ");
        for(; i < temp.size() - 1; i++)
        {
            sj.add("{" + i + "}" + " " + temp.get(i));
        }
        String tmp = sj.toString();
        stringBuilder.append(tmp);
        stringBuilder.append(i > 0 ? " and " + "{" + i + "}" + " " + temp.get(i) : "{" + i + "}" + " " + temp.get(i));

        return stringBuilder.toString();
    }

    static int YEAR_IN_SEC = 31536000;
    static int DAY_IN_SEC = 86400;
    static int HOUR_IN_SEC = 3600;
    static int MINUTE_IN_SEC = 60;
}
