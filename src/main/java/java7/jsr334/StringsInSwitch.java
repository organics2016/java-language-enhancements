package java7.jsr334;

/**
 * https://docs.oracle.com/javase/7/docs/technotes/guides/language/strings-switch.html
 */
public class StringsInSwitch {

    public String after(String dayOfWeekArg) {
        switch (dayOfWeekArg) {
            case "Monday":
                return "Start of work week";
            case "Tuesday":
            case "Wednesday":
            case "Thursday":
                return "Midweek";
            case "Friday":
                return "End of work week";
            case "Saturday":
            case "Sunday":
                return "Weekend";
            default:
                throw new IllegalArgumentException("Invalid day of the week: " + dayOfWeekArg);
        }
    }
}
