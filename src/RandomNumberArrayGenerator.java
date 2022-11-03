import java.util.*;

public class RandomNumberArrayGenerator {

    public int[] generateArray(){
        List<Integer> numbersList = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
        int[] lineToBeGuessed = new int[4];

        for (int index = 9; index > 5; index--) {
            int randomIndex = (int) (Math.random() * (index + 1));
            lineToBeGuessed[index - 6] = numbersList.get(randomIndex);
            numbersList.remove(randomIndex);
        }

        return lineToBeGuessed;
    }

}
