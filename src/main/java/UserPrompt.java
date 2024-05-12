

import java.util.Scanner;

public class UserPrompt {
    public static void show(String message){
        System.out.println(message);
    }

    public static int codeLength(){
        String message = "Input the length of the secret code:";
        UserPrompt.show(message);

        Scanner scanner = new Scanner(System.in);
        String inputFromUser = scanner.nextLine();
        int returnValue = -1;
        try {
            returnValue = Integer.parseInt(inputFromUser);
        } catch (Exception err){
            String errMessage = String.format("Error: \"%s\" isn't a valid number.",inputFromUser);
            System.out.println(errMessage);
            System.exit(0);
        }
        return returnValue;
    }

    public static int possibleSymbols(){
        String message = "Input the number of possible symbols in the code:";
        UserPrompt.show(message);

        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static String guess(int nrTurn){
        String message = String.format("Turn %d: ",nrTurn);
        UserPrompt.show(message);

        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    public static void startMessage(){
        String message = "Okay, let's start a game!";
        UserPrompt.show(message);
    }

    public static void prepareSecretMessageWithRange(int intEnd){
        String starsCount = stars(intEnd);
        String message = String.format("The secret is prepared: %s (0-%d)",starsCount,intEnd);
        UserPrompt.show(message);
    }

    public static void prepareSecretMessageWithAscii(int asciiStart, int asciiEnd){
        int uBound = asciiEnd - asciiStart + 10;
        String starsCount = stars(uBound);
        String message = String.format("The secret is prepared: %s (0-9, %c-%c)", starsCount, asciiStart, asciiEnd);
        UserPrompt.show(message);
    }

    private static String stars(int uBound) {
        StringBuilder starsCount = new StringBuilder();
        for(int i = 0; i< uBound; i++){
            starsCount.append("*");
        }
        return starsCount.toString();
    }
}

