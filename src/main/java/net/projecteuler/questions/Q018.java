package net.projecteuler.questions;

public class Q018 {

    private static final String ROW_DELIMITER = "\n";
    private static final String COL_DELIMITER = " ";

    private static final String TEST =
            "3\n" +
            "7 4\n" +
            "2 4 6\n" +
            "8 5 9 3";

    private static final String INPUT =
            "75\n" +
            "95 64\n" +
            "17 47 82\n" +
            "18 35 87 10\n" +
            "20 04 82 47 65\n" +
            "19 01 23 75 03 34\n" +
            "88 02 77 73 07 63 67\n" +
            "99 65 04 28 06 16 70 92\n" +
            "41 41 26 56 83 40 80 70 33\n" +
            "41 48 72 33 47 32 37 16 94 29\n" +
            "53 71 44 65 25 43 91 52 97 51 14\n" +
            "70 11 33 28 77 73 17 78 39 68 17 57\n" +
            "91 71 52 38 17 14 91 43 58 50 27 29 48\n" +
            "63 66 04 68 89 53 67 30 73 16 69 87 40 31\n" +
            "04 62 98 27 23 09 70 98 73 93 38 53 60 04 23";

    public static int[][] formatInto2DIntArray(String input) {
        String[] rows = input.split(ROW_DELIMITER);
        int maxElementsPerRow = rows[rows.length - 1].split(COL_DELIMITER).length;

        int[][] data = new int[rows.length][maxElementsPerRow];
        for (int r = 0; r < rows.length; r++) {
            String line = rows[r];
            String[] rowElements = line.split(COL_DELIMITER);
            for (int c = 0; c < rowElements.length; c++) {
                String element = rowElements[c];
                data[r][c] = Integer.parseInt(element);
            }
        }

        return data;
    }

    public static int[][] getQuestionData() {
        return formatInto2DIntArray(INPUT);
    }

    public static int[][] getTestData() {
        return formatInto2DIntArray(TEST);
    }
}
