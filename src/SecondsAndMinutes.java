public class SecondsAndMinutes {
    public static final String INVALID_VALUE_MESSAGE = "Invalid value";
    public static void main(String[] args) {
        System.out.println(getDurationString(61, 0));
        System.out.println(getDurationString(9030));
    }
    public static String getDurationString(int minutes, int seconds) {
        if(minutes < 0 || seconds < 0 || seconds > 59) {
            return INVALID_VALUE_MESSAGE;
        }
        int hours = minutes / 60;
        minutes = minutes % 60;
        String stringHours = hours + "h ";
        if(hours < 10) {
            stringHours = "0" + stringHours;
        }
        String stringMinutes = minutes + "m ";
        if(minutes < 10) {
            stringMinutes = "0" + stringMinutes;
        }
        String stringSeconds = seconds + "s";
        if(seconds < 10) {
            stringSeconds = "0" + stringSeconds;
        }
        return stringHours + stringMinutes + stringSeconds;
    }
    public static String getDurationString(int seconds) {
        if(seconds < 0) {
            return INVALID_VALUE_MESSAGE;
        }
        int minutes = seconds / 60;
        seconds = seconds % 60;
        return getDurationString(minutes, seconds);
    }
}
