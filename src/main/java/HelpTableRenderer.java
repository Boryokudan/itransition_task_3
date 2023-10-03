import com.github.freva.asciitable.AsciiTable;

public class HelpTableRenderer {

    public static String render(String[] moves) {
        int n = moves.length;
        String[] headers = new String[n + 1];
        headers[0] = "v PC\\\\User >";
        System.arraycopy(moves, 0, headers, 1, n);

        String[][] body = new String[n][n + 1];
        for (int i = 0; i < n; i++) {
            body[i][0] = moves[i];
            for (int j = 1; j < n + 1; j++) {
                body[i][j] = ResultComputer.compute(j - 1, i, moves);
            }
        }

        String[][] table = new String[n + 1][n + 1];
        table[0] = headers;
        System.arraycopy(body, 0, table, 1, n);

        return AsciiTable.getTable(headers, body);
    }
}
