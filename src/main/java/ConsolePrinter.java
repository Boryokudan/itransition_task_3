import java.util.Arrays;

public class ConsolePrinter {
    public static void printInsufficientArgumentsWarning(int len) {
        System.out.println("\nYou should provide at least 3 arguments!");
        System.out.println("Current number: " + len + ".");
    }

    public static void printEvenArgumentsWarning(int len) {
        System.out.println("\nYou should provide an odd number of arguments (3 or more)!");
        System.out.println("Current number: " + len + ".");
    }

    public static void printDuplicatesFoundWarning(String[] args) {
        System.out.println("\nArguments should not contain duplicate values!");
        System.out.println("Arguments passed: " + Arrays.toString(args) + ".");
        System.out.println("Examples of correct input:");
        System.out.println("\t1) Rock Paper Scissors");
        System.out.println("\t2) Rock Paper Scissors Lizard Spock");
        System.out.println("\t3) 1 2 3 4 5 6 7 8 9");
    }

    public static void printAvailableMoves(String[] moves) {
        System.out.println('\n');
        for (int i = 0; i < moves.length; i++) {
            System.out.println((i + 1) + " - " + moves[i]);
        }
        System.out.println("0 - exit");
        System.out.println("? - help");
    }

    public static void printHMAC(byte[] hmac) {
        if (hmac != null) {
            System.out.println("HMAC: " + HMACGenerator.bytesToHex(hmac));
        }
    }

    public static void printHMACkey(byte[] key) {
        String keyString = HMACGenerator.bytesToHex(key);
        System.out.println("\nHMAC key: " + keyString);
    }

    public static void printPlayersMove(int playersMove, String[] availableMoves) {
        System.out.println("\nYour move: " + availableMoves[playersMove]);
    }

    public static void printPCsMove(int pcMove, String[] availableMoves) {
        System.out.println("PC's move: " + availableMoves[pcMove]);
    }

    public static void printExitingMessage() {
        System.out.println("Exiting...");
    }

    public static void printResult(String result) {
        if (result.equals("Win")) System.out.println("You win!");
        else if (result.equals("Lose")) System.out.println("You lose... :(");
        else System.out.println("It's a draw!");
    }

    public static void printMovePrompt() {
        System.out.println("\nEnter your move: ");
    }

    public static void printHelpTable(String render) {
        System.out.println(render);
    }
}
