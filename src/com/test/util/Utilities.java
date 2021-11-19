package com.test.util;

import java.io.IOException;
import java.util.Scanner;

public class Utilities {
  public static void clearScreen() throws InterruptedException, IOException {
    String operatingSystem = System.getProperty("os.name");
    if(operatingSystem.contains("Windows"))
      new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    else new ProcessBuilder("clear").inheritIO().start().waitFor();
  }

  public static void pauseScreen(Scanner scanner) {
    scanner.nextLine();
  }
}
