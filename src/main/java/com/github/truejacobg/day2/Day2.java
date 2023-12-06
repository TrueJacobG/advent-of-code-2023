package com.github.truejacobg.day2;

import com.github.truejacobg.FileReader;
import com.github.truejacobg.Runnable;

import java.util.List;

public class Day2 implements Runnable {
    @Override
    public void run() {
//        part1();
        part2();
    }

    private void part2() {
        List<String> lines = FileReader.getAllLinesFromFile("day2/input2.txt");

        int result = 0;

        for (String line : lines) {
            // game
            String clearLine = line.substring(line.indexOf(" ", 5) + 1);
            String[] sets = clearLine.split("; ");

            int green = -1;
            int red = -1;
            int blue = -1;

            for (String set : sets) {
                String[] colors = set.split(", ");

                for (String color : colors) {
                    if (color.contains("green")) {
                        green = Math.max(getNumberFromString(color), green);
                    } else if (color.contains("red")) {
                        red = Math.max(getNumberFromString(color), red);
                    } else if (color.contains("blue")) {
                        blue = Math.max(getNumberFromString(color), blue);
                    } else {
                        System.out.println("ERROR");
                        System.out.println(color);
                        System.out.println("ERROR");
                    }
                }
            }

            result += green * red * blue;
        }

        System.out.printf("Result part 2: %d %n", result);
    }

    private void part1() {
        List<String> lines = FileReader.getAllLinesFromFile("day2/input.txt");

        int maxRed = 12;
        int maxGreen = 13;
        int maxBlue = 14;

        int result = 0;

        for (String line : lines) {
            // game
            int idOfGame = Integer.parseInt(line.substring(line.indexOf(" ") + 1, line.indexOf(":")));
            String clearLine = line.substring(line.indexOf(" ", 5) + 1);
            String[] sets = clearLine.split("; ");

            boolean isGamePossible = true;

            for (String set : sets) {
                int green = 0;
                int red = 0;
                int blue = 0;

                String[] colors = set.split(", ");

                for (String color : colors) {
                    if (color.contains("green")) {
                        green += getNumberFromString(color);
                    } else if (color.contains("red")) {
                        red += getNumberFromString(color);
                    } else if (color.contains("blue")) {
                        blue += getNumberFromString(color);
                    } else {
                        System.out.println("ERROR");
                        System.out.println(color);
                        System.out.println("ERROR");
                    }
                }

                if (green > maxGreen || red > maxRed || blue > maxBlue) {
                    isGamePossible = false;
                }
            }

            if (isGamePossible) {
                result += idOfGame;

            }
        }

        System.out.printf("Result: %d %n", result);
    }

    private int getNumberFromString(String color) {
        return Integer.parseInt(color.substring(0, color.indexOf(" ")));
    }
}
