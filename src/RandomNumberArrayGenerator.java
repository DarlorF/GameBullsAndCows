public class RandomNumberArrayGenerator {

    public int[] generateArray(){

        int[] lineToBeGuessed = new int[4];

        for (int index = 0; index < 4; index++) {
            lineToBeGuessed[index] = (int) (Math.random() * 10);
        }

        return lineToBeGuessed;
    }

}
