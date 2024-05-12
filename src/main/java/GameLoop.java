

public class GameLoop {
    static void startGame(int diffLevel, String secretCode) {
        int nrTurn = 0;

        do {
            nrTurn ++;

            String guess = UserPrompt.guess(nrTurn);
            String[][] vanillaMatrix =
                    GameMatrix.init(diffLevel);
            String[][] processedMatrix =
                    GameMatrix.processGuess(vanillaMatrix,guess, secretCode);
            Grade grade = Grade.fromMatrix(processedMatrix);
            if (grade.bullCount == secretCode.length()){
                grade.showMessage(secretCode);
                System.out.println("Congratulations! You guessed the secret code.");
                break;
            }else{
                grade.showMessage(secretCode);
            }
        } while (true);
    }
}
