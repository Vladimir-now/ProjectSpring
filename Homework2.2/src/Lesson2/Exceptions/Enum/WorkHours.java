package Lesson2.Exceptions.Enum;

public class WorkHours {

    //    Расчет количества оставшихся рабочих часов до конца недели
    public static String getWorkingHours(DayOfWeek day) {
        if (day.getWorkHours() != 0) {
            int workingHoursLeft =  48 - 8 * day.ordinal();
            return "Сегодня: " + day.getRussianTitle() +".\n" + "Осталось рабочих часов до конца недели: " + workingHoursLeft;
        } else {
            if (day.ordinal() == 5) {
                return "Сегодня: " + day.getRussianTitle() +".\n"  + "Выходные, йехууу!!!";
            } else {
                return "Сегодня: " + day.getRussianTitle() +".\n"  + "Последний день выходных!";
            }
        }
    }
}
