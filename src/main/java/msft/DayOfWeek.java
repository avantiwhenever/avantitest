package msft;
import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/discuss/interview-question/398047/
 */
public class DayOfWeek {

    public static void main(String[] args) {
        printResult("Sat", 2);
    }

    private static void printResult(String day, int daysToAdd) {
        System.out.println(
                "Current day: " + day + "; Add days = " + daysToAdd + "; Answer - " + getDayOfTheWeek(day, daysToAdd));
    }

    public static String getDayOfTheWeek(String s, int k) {
        String[] week = new String[] { "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat" };
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < 7; i++) {
            map.put(week[i], i);
        }
        return week[(map.get(s) + k) % 7];
    }

}