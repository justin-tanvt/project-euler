package net.projecteuler.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class FileUtils {

    public static List<String> getContents(String filepath, String delimiter, String removeAll) {
        List<String> data = new ArrayList<>();
        try(Stream<String> lines = Files.lines(Paths.get(filepath))) {
            lines.forEachOrdered(line -> {
                String[] elements = line.split(delimiter);
                for (String element : elements) {
                    element = element.strip();
                    element = element.replaceAll(removeAll, "");
                    data.add(element);
                }
            });
        } catch (IOException x) {
            x.printStackTrace();
            throw new RuntimeException("File read failed.");
        }
        return data;
    }

}
