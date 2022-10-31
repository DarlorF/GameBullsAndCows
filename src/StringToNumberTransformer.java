public class StringToNumberTransformer {

    public static int[] transformStringToNumber(String input){
        int[] result = new int[4];

        for (int index = 0; index < 4; index++) {
            char inputChar = input.charAt(index);
            String inputCharString = String.valueOf(inputChar);
            result[index] = Integer.parseInt(inputCharString);
        }

        return result;
    }

}
