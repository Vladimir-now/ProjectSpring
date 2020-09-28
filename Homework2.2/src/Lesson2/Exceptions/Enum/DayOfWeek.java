package Lesson2.Exceptions.Enum;

/**
 * 4. Требуется реализовать enum DayOfWeek, который будет представлять дни недели.
 * С его помощью необходимо решить задачу определения кол-ва рабочих часов до конца недели по заднному текущему дню.
 *
 * Возвращает кол-во оставшихся рабочих часов до конца
 * недели по заданному текущему дню. Считается, что
 * текущий день ещё не начался, и рабочие часы за него
 * должны учитываться.
 *
 * public class DayOfWeekMain {
 *
 * public static void main(final String[] args) {
 * System.out.println(getWorkingHours(DayOfWeek.MONDAY));
 * }
 */


public enum DayOfWeek {
    MONDAY("Понедельник", 8), TUESDAY("Вторник", 8), WEDNESDAY("Среда", 8),
    THURSDAY("Четверг", 8), FRIDAY("Пятница", 8), SATURDAY("Суббота", 0),
    SUNDAY("Воскресенье", 0);

    private String russianTitle;
    private int workHours;

    DayOfWeek (String russianTitle, int workHours) {
        this.russianTitle = russianTitle;
        this.workHours = workHours;
    }

    public String getRussianTitle() {
        return russianTitle;
    }

    public int getWorkHours() {
        return workHours;
    }


}
