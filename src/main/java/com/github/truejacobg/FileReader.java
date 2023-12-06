package com.github.truejacobg;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileReader {
    public static List<String> getAllLinesFromFile(String filename) {
        List<String> result = null;

        try {
            result = Files.readAllLines(Paths.get("src/main/java/com/github/truejacobg/" + filename).toAbsolutePath(), StandardCharsets.UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}
