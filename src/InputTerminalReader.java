import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputTerminalReader {

    public String getStringFromKeyboard() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите число");

        boolean isLine4symbolsLength = false;

        String input = null;

        while (!isLine4symbolsLength) {
            input = reader.readLine(); // считать строку с клавиатуры
            if (input.length() == 4) {
                isLine4symbolsLength = true;
            } else {
                System.out.println("Введите четыре цифры одной строкой");
            }
        }
        return input;
    }

}
