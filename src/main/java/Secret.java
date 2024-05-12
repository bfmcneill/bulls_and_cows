
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Secret {

    public static String shuffle(List<String> characters, int codeLength){

        // shuffle characters and ensure first character is not zero
        do{
            Collections.shuffle(characters);
        } while (characters.get(0).equals("0"));

        StringBuilder result = new StringBuilder(codeLength);
        for (int i = 0; i < characters.size() && i < codeLength; i++) {
            result.append(characters.get(i));
        }

        return result.toString();
    }

    private static int intEnd(int possibleSymbols){
        final int INT_END = 9;
        return Math.min(possibleSymbols, INT_END);
    }

    private static int asciiEnd(int possibleSymbols){
        final int ASCII_START = 97;
        final int ASCII_END = 122;
        final int MAX_INT_ELEMENTS = 10;
        return Math.min(ASCII_END, ASCII_START - MAX_INT_ELEMENTS + possibleSymbols -1);
    }

    private static List<String> createNumberAndLettersList(int possibleSymbols) {
        List<String> characters = new ArrayList<>();

        int INT_START = 0;
        int INT_END = intEnd(possibleSymbols);

        // Populate the list with digits
        for (int i = INT_START; i < INT_END; i++) {
            characters.add(String.valueOf(i));
        }

        // handle scenario where user wants to work with more than 10 symbols
        if(possibleSymbols>9) {
            // populate list with letters
            int ASCII_START = 97;
            int ASCII_END = asciiEnd(possibleSymbols);
            for (int i = ASCII_START; i <= ASCII_END; i++) {
                char c = (char) i;
                characters.add(String.valueOf(c));
            }
            UserPrompt.prepareSecretMessageWithAscii(ASCII_START,ASCII_END);
        } else {
            UserPrompt.prepareSecretMessageWithRange(INT_END);
        }
        return characters;
    }

    public static String fromDiffLevel(int codeLength, int possibleSymbols) {
        List<String> characters = createNumberAndLettersList(possibleSymbols);
        return Secret.shuffle(characters,codeLength);

    }



    public static void debug(String secret){
        int len = secret.length();
        System.out.println("=====DEBUG=====");
        System.out.println(String.format("Secret Code: %s",secret));
        System.out.println(String.format("Matrix Size: %dx%d",len,len));
        System.out.println("=====DEBUG=====");
    }
}
