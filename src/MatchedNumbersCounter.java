public class MatchedNumbersCounter {

    public int countBulls(int[] inputNumbers, int[] lineToBeGuessed){
        int result = 0;
        for  (int index = 0; index < 4; index++) {
            if (inputNumbers[index] == lineToBeGuessed[index]) {
                result++;
            }
        }
        return result;
    }
}
