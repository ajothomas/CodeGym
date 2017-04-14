package src.JavaMisc;

/**
 * Created by ajothomas on 3/23/17.
 */

enum Day {
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
}

public class EnumExample {
    Day day;

    EnumExample(Day day){
        this.day = day;
    }

    public void tellItLikeItIs() {
        switch (day) {
            case MONDAY:
                System.out.println("Mondays are bad.");
                break;

            case FRIDAY:
                System.out.println("Fridays are better.");
                break;

            case SATURDAY: case SUNDAY:
                System.out.println("Weekends are best.");
                break;

            default:
                System.out.println("Midweek days are so-so.");
                break;
        }
    }

    public static void main(String args[]){
        EnumExample firstDay = new EnumExample(Day.MONDAY);
        firstDay.tellItLikeItIs();
        EnumExample seventhDay = new EnumExample(Day.SUNDAY);
        seventhDay.tellItLikeItIs();
    }
}
