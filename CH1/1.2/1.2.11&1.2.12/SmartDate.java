import edu.princeton.cs.algs4.StdOut;

public class SmartDate {
    private int year;
    private int month;
    private int day;
    private int l_year;
    private String week;

    public SmartDate(int y, int m, int d) {
        year = y;
        month = m;
        day = d;
        l_year = 0;
    }

    public int years() {
        if (year < 0)
            throw new RuntimeException("Invalid year input(must be positive)\n");
        return year;
    }

    public int months() {
        float q = month / 13;
        if ((q <= 0) || (q >= 1))
            throw new RuntimeException("Invalid month input(must be within 1~12)\n");
        return month;
    }

    public int days() {
        double q = day / 31.0;
        if ((q <= 0) || (q >= 1))
            throw new RuntimeException("Invalid day input(must be within 1~31)\n");
        return day;
    }

    public String dayOfTheWeek() {
        for (int i = 2000; i < year - 1; i++) {
            if (i % 4 == 0)
                l_year++;
        }
        int pastyear = year - 2001 + l_year;//pastyear+date of 2000=date of now
        int pastday = day;
        int weekday = 6;
        switch (month) {
            case 1:
                pastday += 0;
                break;
            case 2:
                pastday += 31;
                break;
            case 3:
                pastday += 60;
                break;
            case 4:
                pastday += 91;
                break;
            case 5:
                pastday += 121;
                break;
            case 6:
                pastday += 152;
                break;
            case 7:
                pastday += 182;
                break;
            case 8:
                pastday += 213;
                break;
            case 9:
                pastday += 244;
                break;
            case 10:
                pastday += 274;
                break;
            case 11:
                pastday += 305;
                break;
            case 12:
                pastday += 335;
                break;
        }
        if ((month > 2) && (year % 4 == 0))
            pastday++;
        weekday += pastyear;
        weekday += (pastday - 1) % 7;
        weekday %= 7;

        switch (weekday) {
            case 1:
                week = "Monday";
                break;
            case 2:
                week = "Tuesday";
                break;
            case 3:
                week = "Wednesday";
                break;
            case 4:
                week = "Thursday";
                break;
            case 5:
                week = "Friday";
                break;
            case 6:
                week = "Saturday";
                break;
            case 0:
                week = "Sunday";
                break;
        }
        return week;
    }

    public static void main(String[] args) {
        int years = Integer.parseInt(args[0]);
        int months = Integer.parseInt(args[1]);
        int days = Integer.parseInt(args[2]);
        SmartDate data = new SmartDate(years, months, days);
        //StdOut.println(data.months());
        StdOut.println(data.days());
        StdOut.println(data.dayOfTheWeek());
    }
}
