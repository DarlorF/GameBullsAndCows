import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GamePlay {

    private final InputTerminalReader reader;
    private final ContainedNumbersCounter cowsCounter;
    private final MatchedNumbersCounter bullsCounter;
    private final RandomNumberArrayGenerator generator;
    private final ResultPrinter resultPrinter;
    private final FileReaderWriter fileReaderWriter;

    public GamePlay(){
        reader = new InputTerminalReader();
        cowsCounter = new ContainedNumbersCounter();
        bullsCounter = new MatchedNumbersCounter();
        generator = new RandomNumberArrayGenerator();
        resultPrinter = new ResultPrinter();
        fileReaderWriter = new FileReaderWriter();
    }
    public void play() throws IOException {

        List<String> stringList = fileReaderWriter.getStringListFromFile();
        String fileAsString = fileReaderWriter.getFileAsString(stringList);
        int gamesCounter = fileReaderWriter.getLastGameNumber(fileAsString);

        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy hh:mm");
        String strDate = dateFormat.format(date);

        int[] lineToBeGuessed = generator.generateArray();
        String stringToBeGuessed = resultPrinter.printLineToBeGuessed(lineToBeGuessed);

        boolean isLineFound = false;

        int attemptCounter = 0;

        List<String> attempts = new ArrayList<>();

        while (!isLineFound) {

            String input = reader.getStringFromKeyboard();

            int[] inputNumbers = StringToNumberTransformer.transformStringToNumber(input);

            int cows = cowsCounter.countCows(inputNumbers, lineToBeGuessed);

            int bulls = bullsCounter.countBulls(inputNumbers, lineToBeGuessed);

            if (bulls > 0) cows = cows - bulls;

            String cowsResult = resultPrinter.printCows(cows);

            String bullsResult = resultPrinter.printBulls(bulls);

            String currentResult = cowsResult + bullsResult;

            System.out.println(currentResult);

            attempts.add("      Запрос: " + input + ". Ответ: " + currentResult);
            attemptCounter++;
            if (bulls == 4) {
                isLineFound = true;
                gamesCounter++;
            }
        }

        StringBuilder resultBuilder = new StringBuilder();

        for (String line : stringList) {
            resultBuilder.append("\n").append(line);
        }

        resultBuilder.append("\n\n" + "Game №" + gamesCounter + " " + strDate + "\n" + "   Загаданная строка: " + stringToBeGuessed);
        for (String attempt : attempts) {
            resultBuilder.append("\n");
            resultBuilder.append(attempt);
        }
        resultBuilder.append("\n").append("   ").append(resultPrinter.printAttempts(attemptCounter));
        resultBuilder.append("\n");

        fileReaderWriter.writeStringIntoFile(resultBuilder.toString());
    }
}
