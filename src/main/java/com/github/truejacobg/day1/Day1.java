package com.github.truejacobg.day1;

import com.github.truejacobg.FileReader;
import com.github.truejacobg.Runnable;

import java.util.List;

public class Day1 implements Runnable {
    @Override
    public void run() {
//        part1();
        part2();
    }

    private void part2() {
        List<String> lines = FileReader.getAllLinesFromFile("day1/input2.txt");

        int result = lines.stream().mapToInt(line -> {
            StringBuilder lineNumber = new StringBuilder();

            String newLine = convertNumbers(line);
            System.out.println(newLine);

            for (char c : newLine.toCharArray()) {
                if (Character.isDigit(c)) {
                    lineNumber.append(c);
                    break;
                }
            }

            String reverseLine = new StringBuilder(newLine).reverse().toString();

            for (char c : reverseLine.toCharArray()) {
                if (Character.isDigit(c)) {
                    lineNumber.append(c);
                    break;
                }
            }

            return Integer.parseInt(lineNumber.toString());
        }).sum();

        System.out.printf("Result part 2: %d %n", result);
    }

    private String convertNumbers(String line) {
        return line
                .replace("one", "1")
                .replace("two", "2")
                .replace("three", "3")
                .replace("four", "4")
                .replace("five", "5")
                .replace("six", "6")
                .replace("seven", "7")
                .replace("eight", "8")
                .replace("nine", "9");
    }

    private void part1(){
        List<String> lines = FileReader.getAllLinesFromFile("day1/input.txt");

        int result = lines.stream().mapToInt(line -> {
            StringBuilder lineNumber = new StringBuilder();

            for (char c : line.toCharArray()) {
                if (Character.isDigit(c)) {
                    lineNumber.append(c);
                    break;
                }
            }

            String reverseLine = new StringBuilder(line).reverse().toString();

            for (char c : reverseLine.toCharArray()) {
                if (Character.isDigit(c)) {
                    lineNumber.append(c);
                    break;
                }
            }

            return Integer.parseInt(lineNumber.toString());
        }).sum();

        System.out.printf("Result: %d %n", result);
    }
}
