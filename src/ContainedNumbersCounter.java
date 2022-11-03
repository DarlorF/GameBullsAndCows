public class ContainedNumbersCounter {

    public int countCows(int[] inputNumbers, int[] lineToBeGuessed){
        int cows = 0;
        int[] copiedInput = new int[inputNumbers.length];
        System.arraycopy(inputNumbers, 0, copiedInput, 0, 4);

        for (int outIndex = 0; outIndex < 4; outIndex++) {
            for (int inIndex = 0; inIndex < 4; inIndex++) {
                if (copiedInput[outIndex] == lineToBeGuessed[inIndex]) {
                    cows++;
                    copiedInput[outIndex] = -1;
                }
            }
        }
        return cows;
    }

}
