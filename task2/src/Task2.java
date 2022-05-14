import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Task2 {

    public static void main(String[] args) {

        try {

            Scanner scanner = new Scanner(new FileReader(args[0]));
            ArrayList<String> array_of_lines_info = new ArrayList<>();

            while (scanner.hasNextLine()) {
                array_of_lines_info.add(scanner.nextLine());
            }

            Scanner scanner2 = new Scanner(new FileReader(args[1]));
            ArrayList<String> array_of_lines_coord = new ArrayList<>();

            while (scanner2.hasNextLine()) {
                array_of_lines_coord.add(scanner2.nextLine());
            }

            float xOne = Float.parseFloat(array_of_lines_info.get(0).split(" ")[0]);
            float yOne = Float.parseFloat(array_of_lines_info.get(0).split(" ")[1]);
            float radius = Float.parseFloat(array_of_lines_info.get(1));

            for (String s : array_of_lines_coord) {

                try {
                    float xTwo = Float.parseFloat(s.split(" ")[0]);
                    float yTwo = Float.parseFloat(s.split(" ")[1]);

                    float i = (xTwo - xOne) * (xTwo - xOne) + (yTwo - yOne) * (yTwo - yOne);

                    if (i == radius * radius) {
                        System.out.println(0);
                    } else if (i < radius * radius) {
                        System.out.println(1);
                    } else {
                        System.out.println(2);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid arguments");
                }

            }

            scanner.close();
            scanner2.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid number of arguments");
        } catch (NumberFormatException e) {
            System.out.println("Invalid arguments");
        }

    }

}