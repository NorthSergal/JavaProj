import java.util.ArrayList;

public class Task1 {

    public static void main(String[] args) {

        try {

            ArrayList<Integer> table_steps = new ArrayList<>();
            int n = Integer.parseInt(args[0]);
            int m = Integer.parseInt(args[1]);

            for (int i = 0; i <= n; i++) {

                int step = 1 + (i + m - 2) % n;

                table_steps.add(step);

            }

            int flag = 1;

            do {

                System.out.print(flag);

                flag = table_steps.get(flag % n);

            } while (flag != 1);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid number of arguments");
        } catch (NumberFormatException e) {
            System.out.println("Invalid arguments");
        }

    }

}