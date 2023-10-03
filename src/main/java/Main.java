import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = args.length;
        boolean isInsufficient = n < 3;
        boolean isEven = n % 2 != 1;
        boolean hasDuplicates = hasDuplicates(args);

        if (isInsufficient) {
            ConsolePrinter.printInsufficientArgumentsWarning(n);
        } else if (isEven) {
            ConsolePrinter.printEvenArgumentsWarning(n);
        }
        else if (hasDuplicates) {
            ConsolePrinter.printDuplicatesFoundWarning(args);
        } else {
            byte[] key = HMACGenerator.generateRandomKey();
            int pcMove = makeMove(args);
            byte[] moveData = args[pcMove].getBytes();
            byte[] hmac = HMACGenerator.computeHMAC(key, moveData);
            ConsolePrinter.printHMAC(hmac);

            ConsolePrinter.printAvailableMoves(args);

            boolean isValid = false;
            String option = "";

            while(!isValid) {
                try {
                    ConsolePrinter.printMovePrompt();
                    option = scanner.nextLine();
                    int playersMove = Integer.parseInt(option);
                    if (playersMove > 0 && playersMove <= args.length) {
                        isValid = true;
                        playersMove--;
                        ConsolePrinter.printPlayersMove(playersMove, args);
                        ConsolePrinter.printPCsMove(pcMove, args);
                        String result = ResultComputer.compute(playersMove, pcMove, args);
                        ConsolePrinter.printResult(result);
                        ConsolePrinter.printHMACkey(key);
                    } else if (playersMove == 0) {
                        isValid = true;
                        ConsolePrinter.printExitingMessage();
                    } else System.out.println("Please select a valid move within a given range.");

                } catch (NumberFormatException e) {
                    if (option.equals("?")) ConsolePrinter.printHelpTable(HelpTableRenderer.render(args));
                    else System.out.println("Invalid input. Please enter a valid integer within a given range.");
                }
            }
            scanner.close();
        }
    }

    private static boolean hasDuplicates(String[] args) {
        HashSet<String> uniqueStrings = new HashSet<>();

        for (String str : args) {
            if (!uniqueStrings.add(str)) {
                return true;
            }
        }
        return false;
    }

    private static int makeMove(String[] args) {
        Random random = new Random();
        return random.nextInt(args.length);
    }
}
