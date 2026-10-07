class Solution {

    public String convert(String s, int numRows) {

        if (numRows <= 1) return s;

        int box_width = numRows - 1;
        int quan_boxes = (s.length() / box_width) + 1;

        String[][] matrix = new String[numRows][quan_boxes * box_width];

        int i = 0;
        int col = 0;
        int row = 0;

        while (i < s.length() && col < matrix[0].length) {

            // Fill vertical column
            while (row < numRows && i < s.length()) {
                matrix[row][col] = s.charAt(i) + "";
                row++;
                i++;
            }

            // Move to diagonal starting point
            row -= 2;
            col++;

            // Fill diagonal upward
            while (row > 0 && col < matrix[0].length && i < s.length()) {
                matrix[row][col] = s.charAt(i) + "";
                i++;
                row--;
                col++;
            }

            // Prepare next vertical column
            row = 0;
        }

        StringBuilder sb = new StringBuilder();

        for (row = 0; row < matrix.length; row++) {
            for (col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col] != null) {
                    sb.append(matrix[row][col]);
                }
            }
        }

        return sb.toString();
    }
}