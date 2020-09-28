package Lesson_1.Marathon;

/**
 * Добавить класс Team, который будет содержать:
 * название команды,
 * массив из 4-х участников (т.е. в конструкторе можно сразу всех участников указывать),
 * метод для вывода информации о членах команды прошедших дистанцию,
 * метод вывода информации обо всех членах команды.
 * */

public class Team {

    private String teamName;
    private Competitor[] team;


    public Team (String teamName, Competitor... team) {
        this.teamName = teamName;
        this.team = team;
    }

//    Метод дающий доступ к массиву
    public Competitor[] getTeam() {
        return team;
    }

//    Метод для вывода информации о членах команды прошедших дистанцию
    public void showResults() {
        System.out.println('\n' + "Участники справившиеся с препятствиями:");
        for (Competitor player : team) {
            if (player.isOnDistance()) player.info();
        }
    }

//    Метод вывода информации обо всех членах команды
    public void printInfoTeam(){
        System.out.println("Команда: " + "\"" + teamName + "\"" + '\n' + "Участники:");
        int count = 1;
        for (Competitor player : team) {
            System.out.println(count + ". " + (player instanceof Animal ? (((Animal) player).getType()) + " " : "" ) + player.getName());
            count++;
        }
        System.out.println();
    }



}