import java.util.Scanner;

public class Lymbda {

    public static void main(String[] args) {
        Operationable addition ;
        Operationable subtraction;
        Operationable multiplication;
        Operationable division ;

        addition = (x,y) -> x+y;
        subtraction = (x,y) -> x-y;
        multiplication = (x,y) -> x*y;
        division = (x,y) -> x/y;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an expression: x action y");
        String[] str = scanner.nextLine().split(" ");
        int x = Integer.parseInt(str[0]);
        int y = Integer.parseInt(str[2]);

        switch (str[1]) {
            case ("+"):
                System.out.println(addition.calculate(x, y));
                break;
            case ("-"):
                    System.out.println(subtraction.calculate(x, y));
                    break;
            case ("*"):
                    System.out.println(multiplication.calculate(x, y));
                    break;
            case ("/"):
                    System.out.println(division.calculate(x, y));
                    break;
        }
        scanner.close();
    }
}

interface Operationable{
    int calculate(int x, int y);
}

