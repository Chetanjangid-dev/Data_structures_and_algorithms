class Solution {
    public void setZeroes(int[][] matrix) {

        boolean firstRowZero = false;
        boolean firstColZero = false;

        // Check whether first row / first column originally contain 0
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {

                if (matrix[row][col] == 0) {

                    if (row == 0) {
                        firstRowZero = true;
                    }

                    if (col == 0) {
                        firstColZero = true;
                    }

                    // Create markers
                    matrix[row][0] = 0;
                    matrix[0][col] = 0;
                }
            }
        }

        // Use row markers
        for (int row = 1; row < matrix.length; row++) {

            if (matrix[row][0] == 0) {

                for (int col = 1; col < matrix[0].length; col++) {
                    matrix[row][col] = 0;
                }
            }
        }

        // Use column markers
        for (int col = 1; col < matrix[0].length; col++) {

            if (matrix[0][col] == 0) {

                for (int row = 1; row < matrix.length; row++) {
                    matrix[row][col] = 0;
                }
            }
        }

        // Finally zero the first row
        if (firstRowZero) {

            for (int col = 0; col < matrix[0].length; col++) {
                matrix[0][col] = 0;
            }
        }

        // Finally zero the first column
        if (firstColZero) {

            for (int row = 0; row < matrix.length; row++) {
                matrix[row][0] = 0;
            }
        }
    }
}