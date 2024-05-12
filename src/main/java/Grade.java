

public class Grade {
    int bullCount;
    int cowCount;

    Grade(int bullCount,int cowCount){
        this.bullCount=bullCount;
        this.cowCount=cowCount;
    }

    public void debugMessage(){
        String message = String.format("bullCount: %d, cowCount: %d",bullCount,cowCount);
        System.out.println(message);
    }

    public void showMessage(String secretCode){
        String bullsMessage = "";
        String cowsMessage = "";
        String andMessage = "";
        String finalMessage = "";

        if(bullCount>0) {
            bullsMessage=String.format("%d bull(s)", bullCount);
        }

        if(cowCount>0) {
            cowsMessage=String.format("%d cows(s)", cowCount);
        }

        if((bullCount>0) && (cowCount>0)){
            andMessage=" and ";
        }

        if(bullsMessage.isEmpty() && cowsMessage.isEmpty()){
            finalMessage = "Grade: None.";
        }else{
            finalMessage = String.format("Grade: %s%s%s.",bullsMessage, andMessage, cowsMessage);
        }

        System.out.println(finalMessage);
    }

    public static int countOccurrences(String token,String search){
        int count = 0;
        int lastIndex = 0;

        while (lastIndex != -1) {
            lastIndex = token.indexOf(search, lastIndex);
            if (lastIndex != -1) {
                count++;
                lastIndex += search.length();
            }
        }

        return count;
    }

    public static Grade fromMatrix(String[][] matrix) {
        int countOfBulls = 0;
        int countOfCows = 0;

        for (String[] row : matrix) {
            String rowString = String.join("", row);
            countOfCows+=countOccurrences(rowString,"C");
            countOfBulls+=countOccurrences(rowString,"B");
        }
        return new Grade(countOfBulls, countOfCows);
    }
}
