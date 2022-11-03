import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class FileReaderWriter {

    private final String PATH = "D:\\Games\\gameHistory.txt";

    public int getLastGameNumber(String fileAsString) {

        if (fileAsString == null) return 0;

        int gameIndex = fileAsString.lastIndexOf("Game №") + 6;
        String space = " ";

        StringBuilder numberStringBuilder = new StringBuilder();

        while (fileAsString.charAt(gameIndex) != space.charAt(0)) {
            numberStringBuilder.append(fileAsString.charAt(gameIndex));
            gameIndex++;
        }

        String numberString = numberStringBuilder.toString();
        return Integer.parseInt(numberString);

    }

    public String getFileAsString(List<String> input){
        if (input.isEmpty()) return null;
        StringBuilder sb = new StringBuilder();
        input.forEach(sb::append);
        return sb.toString();
    }

    public List<String> getStringListFromFile() {

        File file = new File(PATH);
        FileReader fileReader;
        try {
            fileReader = new FileReader(file);
        } catch (FileNotFoundException e) {
            return new ArrayList<>();
        }
        BufferedReader br = new BufferedReader(fileReader);
        return br.lines().collect(Collectors.toList());

    }

    public void writeStringIntoFile(String content) throws IOException {
        FileWriter writer = new FileWriter(PATH);
        writer.write(content);
        writer.close();
    }

}
