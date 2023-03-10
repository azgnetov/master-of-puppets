package org.azgnetov.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class CSVScanner {
  private static final String FILENAME = "/src/resources/Food.csv";
  private static final String HEADER = "Существо";

  public static int scan(BufferedReader bufferedReader, String attacker, String defender) {
    String line = "";
    String splitBy = ",";
    int position = 0;
    int probability = 0;

    try {
      String[] parsedLine;
      while ((line = bufferedReader.readLine()) != null) {
        parsedLine = line.split(splitBy);
        if (parsedLine[0].equals(HEADER)) {
          position = Arrays.asList(parsedLine).indexOf(defender);
        } else if (parsedLine[0].equals(attacker)) {
          probability = Integer.parseInt(Arrays.asList(parsedLine).get(position));
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    return probability;
  }

  public static BufferedReader read() {
    BufferedReader bufferedReader = null;
    try {
      bufferedReader = Files.newBufferedReader(Path.of(System.getProperty("user.dir"), FILENAME));
    } catch (IOException e) {
      e.printStackTrace();
    }
    return bufferedReader;
  }
}