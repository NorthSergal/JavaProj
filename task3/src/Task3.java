import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Task3 {

    public static void main(String[] args) throws IOException {

        int id = 0;

        try {

            String file_tests = args[0];
            String file_values = args[1];

            BufferedReader reader_file_tests = new BufferedReader(new FileReader(file_tests));
            BufferedWriter file_result = new BufferedWriter(new FileWriter("report.json"));

            Scanner scanner = new Scanner(new FileReader(file_tests));
            ArrayList<String> array_of_lines = new ArrayList<>();

            while (scanner.hasNextLine()) {
                array_of_lines.add(scanner.nextLine());
            }

            for (String line : array_of_lines) {

                if (line.contains("\"id\"")) {

                    int begin_index_id = line.indexOf("\"id\"") + 6;
                    int end_index_id = line.length() - 1;

                    id = Integer.parseInt(line.substring(begin_index_id, end_index_id));

                    file_result.append(line).append("\n");

                } else {

                    if (line.contains("\"value\"")) {

                        String value = searcher(id, file_values);

                        int begin_index_value = line.indexOf("\"value\"") + 10;
                        int end_index_value = line.indexOf("\"\"") + 1;

                        String formed_string = line.substring(0, begin_index_value) + value + line.substring(end_index_value);

                        file_result.append(formed_string).append("\n");

                    } else {
                        file_result.append(line).append("\n");
                    }

                }

            }

            reader_file_tests.close();
            file_result.flush();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid number of arguments");
        }

    }

    public static String searcher(int id, String file_values) throws IOException {

        BufferedReader reader_file_values = null;
        try {
            reader_file_values = new BufferedReader(new FileReader(file_values));
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid number of arguments");
        }

        Scanner scanner = new Scanner(new FileReader(file_values));
        ArrayList<String> array_of_lines = new ArrayList<>();

        while (scanner.hasNextLine()) {
            array_of_lines.add(scanner.nextLine());
        }

        String pattern = " " + id + ",";

        ArrayList<String> array_of_words = new ArrayList<>();
        String active_value = "";

        for (int i = 0; i < array_of_lines.size(); i++) {

            if (array_of_lines.get(i).contains(pattern)) {

                String[] words = array_of_lines.get(i + 1).split("\"");

                array_of_words.addAll(Arrays.asList(words));

                active_value = array_of_words.get(3);
            }

        }

        assert reader_file_values != null;
        reader_file_values.close();

        return active_value;

    }


}
