import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        final String FILE_PATH = "INPUT.txt";
        int answer = 0;

        int min = 100000000;

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] numberLine = line.split(" ");
                int n1 = Integer.parseInt(numberLine[0]);
                int n2 = Integer.parseInt(numberLine[1]);
                answer += Math.max(n1, n2);
                if (Math.abs(n1 - n2) % 3 != 0) {
                    min = Math.min(Math.abs(n1 - n2), min);
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла: " + e.getMessage());
        }
        if (answer % 3 != 0) System.out.println(answer);
        else System.out.println(answer - min);
    }
}