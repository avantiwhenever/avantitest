package msft;

import javafx.util.Pair;

//https://leetcode.com/discuss/interview-question/654921/

public class AlladeenCheckersGame {

    /*
    This is the most verbose question I ever seen. I'm sorry for you...
On the other hand, once that you get the main point of the question,
 the solution is quite straightforward:
 you need to invent some tree exploration with the additional
  constrain that you need to jump over an Aladdin piece.
   also to keep in mind that only two moves are allowed,
    not the classical 4 or 8 moves that you would expect
    in a grid exploration problem.
The solution can be achieved using DFS in O(N).
A possible C++ solution:
     */
    // only two directions are allowed, in the direction of top row
    private static int[][] dirs = new int[][]{{-2, 2}, {-2, -2}};

    // check if coordinates are inside the check limits
    private static boolean isValid(String[][] check, int r, int c) {
        int rows = check.length;
        int cols = check[0][0].length();
        return r >= 0 && r < rows && c >= 0 && c < cols;
    }

    // recursively get the max allowed moves
    private static int getMaxMoves(String[][] check, int r, int c) {
        int ret = 0;

        for (int[] d : dirs) {
            // next move coordinates
            int r2 = r + d[0];
            int c2 = c + d[1];
            // coordinates to check for Aladdin piece
            int r1 = r + d[0] / 2;
            int c1 = c + d[1] / 2;

            if (isValid(check, r2, c2)
                    && check[r2][0].charAt(c2) == '.'
                    && check[r1][0].charAt(c1) == 'X') {
                // eat the Aladdin piece, to avoid to see it again in the recursive branch
                System.out.println("Before Eating alladin : " + check[r1][0]);
                StringBuilder sb = new StringBuilder(check[r1][0]);
                sb.setCharAt(c1, '.');
                check[r1][0] = sb.toString();
                System.out.println("After Eating alladin : " + check[r1][0]);

                ret = Math.max(ret, 1 + getMaxMoves(check, r2, c2));

                System.out.println("count " + ret);
                // backtrack the change
                System.out.println("Before spitting alladin : " + check[r1][0]);
                StringBuilder sb2 = new StringBuilder(check[r1][0]);
                sb2.setCharAt(c1, 'X');
                check[r1][0] = sb2.toString();
                System.out.println("After spitting alladin : " + check[r1][0]);
            }
        }
        System.out.println("count : " + ret);
        return ret;
    }

    // find the Jafar piece, return at the first one found
    private static Pair<Integer, Integer> findJafar(String[][] check) {
        int rows = check.length;
        int col = check[0][0].length();
        for (int r = 0; r < rows; ++r) {
            for (int c = 0; c < check[r][0].length(); ++c) {
                if (check[r][0].charAt(c) == 'O')
                    return new Pair<>(r, c);
            }
        }
        return new Pair<>(-1, -1);
    }

    public static void main(String args[]) {
        String[][] b =
                {
                {"..X..."},
                {"......"},
                {"....X."},
                {".X...."},
                {"..X.X."},
                {"...O.."}
        };

        Pair<Integer, Integer> p = findJafar(b);

        if (p.getKey() == -1)
            System.out.println("Jafar not found");
        else
            System.out.println("key "  + p.getKey() + " value " + p.getValue());
        System.out.println("Moves: " + getMaxMoves(b, p.getKey(), p.getValue()));
    }
}
