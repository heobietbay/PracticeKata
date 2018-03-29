package easy;

import java.text.MessageFormat;

/**
 Create an application that can read in pairs of dates in the following
 format -

 DD MM YYYY, DD MM YYYY

 Validate the input data, and compute the difference between the two dates
 in days.

 Output of the application should be of the form -

 DD MM YYYY, DD MM YYYY, difference

 Where the first date is the earliest, the second date is the latest and the difference is the number of days.

 Input can be from a file, or from standard input, as the developer chooses.

 Provide test data to exercise the application.

 Constraints:

 The application may not make use of the platform / SDK libraries for date manipulation
 (for example Date, Calendar classes).

 The application can limit calculation on an input range of dates from 1900 to 2010

 */
public class DateDifference {

    public static void main(String[] args) {
        String input = readInput();
        boolean isInputValid = isInputValid(input);
        if(!isInputValid)
        {
            System.err.println("Invalid input.");
            return;
        }

        String[] dateStrs = input.split(",");
        MyDate date1 = fromString(dateStrs[0].trim());
        MyDate date2 = fromString(dateStrs[1].trim());

        int daysDifference = calculateDifference(date1,date2);

        String outputTemplate = "{0}, {1}, {2}";
        //TODO: correct date order
        System.out.println(MessageFormat.format(outputTemplate,date1.toString(),date2.toString(),daysDifference));
    }

    private static boolean isInputValid(String input) {
        return true;
    }

    private static String readInput() {
        return SAMPLE;
    }

    private static int calculateDifference(MyDate date1, MyDate date2) {
        return date1.calculateDayNumber() - date2.calculateDayNumber();
    }

    private static MyDate fromString(String s) {
        String[] parts = s.split(" ");
        int day = Integer.valueOf(parts[0].trim());
        int month = Integer.valueOf(parts[1].trim());
        int year = Integer.valueOf(parts[2].trim());
        return MyDate.build(day,month,year);
    }

    static class MyDate {
        int day;
        int month;
        int year;

        static MyDate build(int day, int month, int year)
        {
            MyDate myDate = new MyDate();
            myDate.day = day;
            myDate.month = month;
            myDate.year = year;
            return myDate;
        }

        public boolean isLeap()
        {
            if(year %4 == 0)
            {
                if(year % 100 == 0){
                    return year % 400 == 0;
                }
                else {
                    return true;
                }
            }
            return false;
        }


        MyDate()
        {

        }
        /*
        Calculate date from day number
    All division is integer division, operator % is modulus.
    Given day number g, calculate year, month, and day:

    function d(g)
    y = (10000*g + 14780)/3652425
    ddd = g - (365*y + y/4 - y/100 + y/400)
    if (ddd < 0) then
     y = y - 1
     ddd = g - (365*y + y/4 - y/100 + y/400)
     endif
    mi = (100*ddd + 52)/3060
    mm = (mi + 2)%12 + 1
    y = y + (mi + 2)/12
    dd = ddd - (mi*306 + 5)/10 + 1
    return y, mm, dd
        */

        /**
         * All division is integer division, operator % is modulus.
         * @return
         */
        int calculateDayNumber()
        {
            int mm = (month + 9) % 12;
            int yyyy = year - mm/10;
            return 365*yyyy + yyyy/4 - yyyy/100 + yyyy/400 + (mm*306 + 5)/10 + ( day - 1 );
        }

        @Override
        public String toString() {
            return "" + day +
                    " " + month +
                    " " + year;
        }
    }

    static String SAMPLE = "19 02 1988, 20 01 1980";
}
