/**
 * Не универсальное решение.
 */

public class Spiral {

    public static void main(String[] args) {
        int m = 5;
        int n = 5;

        int[][] mass = new int[m][n];

        int count = 0;
        int lastCount = m * n;

        for (int i = 0; i < n; i++) {
            mass[0][i] = count;
            count++;
        }

        for (int i = 1; i < m; i++) {
            mass[i][n - 1] = count;
            count++;
        }

        for (int i = n - 2; i >= 0  ; i--) {
            mass[m - 1][i] = count;
            count++;
        }

        for (int i = m - 2; i > 0 ; i--) {
            mass[i][0] = count;
            count++;
        }


        int a = 1;
        int b = 1;

        while (count < lastCount - 1) {

            while (mass[a][b + 1] == 0) {
                mass[a][b] = count;
                count++;
                b++;
            }

            //Движемся вниз.
            while (mass[a + 1][b] == 0) {
                mass[a][b] = count;
                count++;
                a++;
            }

            //Движемся влево.
            while (mass[a][b - 1] == 0) {
                mass[a][b] = count;
                count++;
                b--;
            }

            //Движемся вверх.
            while (mass[a - 1][b] == 0) {
                mass[a][b] = count;
                count++;
                a--;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mass[i][j] == 0) {
                    mass[i][j] = count;
                    mass[0][0] = 0; //кастыль
                }
            }
        }

        for (int i = 0; i < mass.length; i++) {
            for (int j = 0; j < mass[i].length; j++) {
                System.out.print(mass[i][j] + " ");
            }
            System.out.println();
        }
    }
}
