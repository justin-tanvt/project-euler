package net.projecteuler.questions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Q067 {
    private static final String INPUT_FILEPATH = "src/main/resources/0067_triangle.txt";

    private static String getQuestionString() {
        StringBuilder sb = new StringBuilder();
        try(Stream<String> lines = Files.lines(Paths.get(INPUT_FILEPATH))) {
            lines.forEachOrdered(line -> {
                sb.append(line);
                sb.append("\n");
            });
        } catch (IOException x) {
            System.out.println("Error reading file, exception is:");
            x.printStackTrace();
        }
        return sb.toString();
    }

    public static int[][] getQuestionData() {
        return Q018.formatInto2DIntArray(getQuestionString());
    }
}
