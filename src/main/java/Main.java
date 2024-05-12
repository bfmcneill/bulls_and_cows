

public class Main {

    public static void main(String[] args) {
        final int MIN_DIFFICULTY = 1;
        final int MAX_DIFFICULTY = 36;

        int codeLength = -1;
        int possibleSymbols = -1;


        codeLength = UserPrompt.codeLength();
        possibleSymbols = UserPrompt.possibleSymbols();

        try {
            if (codeLength < MIN_DIFFICULTY) {
                String msg = String.format("Error: minimum number of possible symbols in the code is %d", MIN_DIFFICULTY);
                throw new RuntimeException(msg);
            } else if (codeLength > MAX_DIFFICULTY) {
                String msg = String.format("Error: maximum number code length is %d", MAX_DIFFICULTY);
                throw new RuntimeException(msg);
            } else if (possibleSymbols > MAX_DIFFICULTY){
                String msg = "Error: maximum number of possible symbols in the code is %d (0-9, a-z).";
                throw new RuntimeException(msg);
            } else if (codeLength>possibleSymbols){
                String msg = String.format("Error: it's not possible to generate a code with a length of %d with %d unique symbols.", codeLength, possibleSymbols);
                throw new RuntimeException(msg);
            }
        } catch (Exception err) {
            System.out.println(err.getMessage());
            System.exit(0);
        }



        String secretCode = Secret.fromDiffLevel(codeLength, possibleSymbols);
        //Secret.debug(secretCode);

        UserPrompt.startMessage();
        GameLoop.startGame(codeLength, secretCode);
    }

}
