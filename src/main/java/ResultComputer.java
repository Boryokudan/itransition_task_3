public class ResultComputer {
    public static String compute(int playersMove, int pcMove, String[] moves) {
        int totalMoves = moves.length;
        int halfMoves = totalMoves / 2;

        if (playersMove == pcMove) {
            return "Draw";
        } else if ((pcMove - playersMove + totalMoves) % totalMoves <= halfMoves) {
            return "Lose";
        } else {
            return "Win";
        }
    }
}
