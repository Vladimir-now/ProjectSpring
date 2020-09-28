package Lesson_1.Marathon;

/**
 * Добавить класс Course (полоса препятствий), в котором будут находиться:
 * массив препятствий,
 * метод, который будет просить команду пройти всю полосу.
 */

public class Course {

    private Obstacle[] course;

    public Course(Obstacle... course) {
        this.course = course;
    }

//    Метод, который будет просить команду пройти всю полосу
    public void doIt (Team team) { ;
        for (Competitor player : team.getTeam()) {
            for (Obstacle o : course) {
                o.doIt(player);
                if (!(player).isOnDistance()) break;
            }
        }
    }

}
