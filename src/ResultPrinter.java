public class ResultPrinter {

    public String printCows(int cows){
        String result;
        if (cows == 0) {
           result =  "0 коров. ";
        } else if (cows == 1) {
           result =  "1 корова. ";
        } else {
           result = cows + " коровы. ";
        }
        return result;
    }

    public String printBulls(int bulls){
        String result;
        if (bulls == 0) {
            result = "0 быков.";
        } else if (bulls == 1) {
            result = "1 бык.";
        } else {
            result = bulls + " быка.";
        }
        return result;
    }

    public String printLineToBeGuessed(int[] input){
        StringBuilder sb = new StringBuilder();
        for (int in : input) {
            sb.append(in);
        }
        return sb.toString();
    }

    public String printAttempts(int attempts){
        if(attempts == 1){
            return "Строка была угадана за 1 попытку.";
        } else if (attempts > 1 && attempts < 5) {
            return "Строка была угадана за " + attempts + " попытки.";
        } else {
            return "Строка была угадана за " + attempts + " попыток.";
        }
    }
}
