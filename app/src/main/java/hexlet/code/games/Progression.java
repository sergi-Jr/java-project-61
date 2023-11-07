package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.Random;

public final class Progression {
    private static final int PROGRESSION_LENGTH = 10; //max numbers count in progression
    /**
     * Local method shows arithmetic progression randomly generated by parameters.
     * @param start First progression number
     * @param increment Progression step
     * @param position Position of element that must be replaced by dots in output
     * @return Arithmetic progression represents string format
     */
    private static String getQuestionStatement(int start, int increment, int position) {
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < PROGRESSION_LENGTH; i++) {
            var currentSymbolToOutput = i == position ? ".." : start;
            output.append(currentSymbolToOutput).append(" ");
            start += increment;
        }
        return String.valueOf(output);
    }
    public static void start() {
        String rules = "What number is missing in the progression?";
        String[] questions = new String[Engine.MAX_SUCCESSES_COUNT];
        String[] answers = new String[questions.length];
        Random rnd = new Random();
        for (int i = 0; i < questions.length; i++) {
            int progressionIncrement = Utils.getRandomInt(0, 100);
            int progressionStartValue = Utils.getRandomInt(0, 100);
            int missingValuePosition = rnd.nextInt(0, PROGRESSION_LENGTH);
            questions[i] = getQuestionStatement(progressionStartValue, progressionIncrement, missingValuePosition);
            int solution = progressionStartValue + missingValuePosition * progressionIncrement;
            answers[i] = String.valueOf(solution);
        }
        Engine.execute(rules, questions, answers);
    }
}
