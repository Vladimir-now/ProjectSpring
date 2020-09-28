package Lesson_1.Marathon;

/**
 *  В итоге должно быть:
 * public static void main(String[] args) {
 * Course c = new Course(...); // Создаем полосу препятствий
 * Team team = new Team(...); // Создаем команду
 * c.doIt(team); // Просим команду пройти полосу
 * team.showResults(); // Показываем результаты
 * }
 */


public class Main {
    public static void main(String[] args) {
        Course c = new Course(new Cross(80), new Water(5), new Wall(1), new Cross(120));
        Team team = new Team("Не бременские музыканты!", new Human("Боб"), new Cat("Барсик"), new Dog("Бобик"));
        team.printInfoTeam();
        c.doIt(team);
        team.showResults();

    }
}