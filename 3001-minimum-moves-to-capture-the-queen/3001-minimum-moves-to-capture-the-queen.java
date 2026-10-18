
class Solution {
    public int minMovesToCaptureTheQueen(int a, int b, int c, int d, int e, int f) {

        // Queen in path of rook
        if (a == e || b == f) {

            // Bishop blocking rook
            if ((a == c && c == e &&
                 ((b < d && d < f) || (f < d && d < b))) ||
                (b == d && d == f &&
                 ((a < c && c < e) || (e < c && c < a)))) {
                // Rook is blocked
            } else {
                return 1;
            }
        }

        // Queen in path of bishop
        if (Math.abs(c - e) == Math.abs(d - f)) {

            // Rook blocking bishop
            if (Math.abs(a - c) == Math.abs(b - d) &&
                ((c < a && a < e) || (e < a && a < c)) &&
                ((d < b && b < f) || (f < b && b < d))) {
                return 2;
            } else {
                return 1;
            }
        }

        return 2;
    }
}
