import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import static java.lang.Math.abs;

public class Task4 {

    public static void main(String[] args) throws IOException {

        try {

            String file_array = args[0];

            BufferedReader reader_file_array = new BufferedReader(new FileReader(file_array));

            ArrayList<Integer> numes = new ArrayList<>();
            int total = 0;
            int total2 = 0;

            Scanner scanner = new Scanner(new FileReader(file_array));
            ArrayList<String> array_of_lines = new ArrayList<>();

            while (scanner.hasNextLine()) {
                array_of_lines.add(scanner.nextLine());
            }

            for (String line : array_of_lines) {
                numes.add(Integer.parseInt(line));
            }

            Collections.sort(numes);

            int index = numes.size() / 2;

            if (numes.size() % 2 == 1) {
                for (int num : numes) {
                    total = abs(num - numes.get(index)) + total;
                }
            } else {
                for (int num : numes) {
                    total = abs(num - numes.get(index - 1)) + total;
                    total2 = abs(num - numes.get(index + 1)) + total2;
                }
            }

            if (total > total2 && total2 != 0) {
                System.out.println(total2);

            } else {
                System.out.println(total);
            }

            reader_file_array.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid number of arguments");
        } catch (NumberFormatException e) {
            System.out.println("Invalid arguments");
        }

    }

}
