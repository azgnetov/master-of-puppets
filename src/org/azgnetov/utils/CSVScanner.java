package org.azgnetov.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class CSVScanner {
  private static final String FILENAME = "/cfg/Food.csv";
  private static final String HEADER = "Существо";

  public static int scan(String attacker, String defender) {
    String line = "";
    String splitBy = ",";
    int position = 0;
    int probability = 0;

    try {
      BufferedReader br = Files.newBufferedReader(Path.of(System.getProperty("user.dir"), FILENAME));
      String[] parsedLine;
      while ((line = br.readLine()) != null) {
        parsedLine = line.split(splitBy);
        if (parsedLine[0].equals(HEADER)) {
          position = Arrays.asList(parsedLine).indexOf(defender);
        } else if (parsedLine[0].equals(attacker)) {
          probability = Integer.parseInt(Arrays.asList(parsedLine).get(position));
        }
      }
    } catch (IOException | NumberFormatException e) {
      e.printStackTrace();
    }

    return probability;
  }
}