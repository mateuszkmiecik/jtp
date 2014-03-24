package jtp;

import java.util.Scanner;

public class Zadanie {
  static class Spiral {
    private int tab[][];
    private int size;

    public Spiral(int r) {
      size = r;
      tab = new int[r][r];

      prepare();
    }

    private void prepare() {
      int p = 1;
      for(int i = 0; i < size; i++){
        for(int j = 0; j < size; j++){
          tab[i][j] = p++;
        }
      }
    }

    public void printSpiral(){
      for(int i = 0; i < size; i++){
        System.out.print(tab[0][i] + " ");
      }

      int x, y, dx, dy, tmp;
      x = size-1; y = 0;
      dx = 0; dy = 1;

      for(int s = size-1; s > 0; s--){
        for(int i = s; i > 0; i--){
          x += dx; y += dy;
          System.out.print(tab[y][x] + " ");

        }
        tmp = dy; dy = dx; dx = -1*tmp;

        for(int i = s; i > 0; i--){
          x += dx; y += dy;
          System.out.print(tab[y][x] + " ");

        }
        tmp = dy; dy = dx; dx = -1*tmp;
      }

      System.out.println();
    }

    public void print() {
      System.out.printf("\n Przygotowana macierz:\n");
      for(int i = 0; i < size; i++){
        for(int j = 0; j < size; j++){
          System.out.printf("%3d ", tab[i][j]);
        }
        System.out.println();
      }

      for(int i = size; i >= 0; i--){
        System.out.print("---");
      }
      System.out.println();
    }
    
  }

  static class DataLoader {
    private class LessThanOneException extends Exception {
      public String toString() {
        return "Podaj liczbę większą lub równą jeden.";
      }
    }

    private class NotNumberException extends Exception {
      public String toString() {
        return "Podaj poprawną liczbę.";
      }
    }

    private int readNumber() throws NotNumberException {
      int width;
      String widthInput;

      Scanner userInput = new Scanner(System.in);

      System.out.println("Podaj szerokosc macierzy: ");
      widthInput = userInput.next();

      try {
        width = Integer.parseInt(widthInput);
      } catch (NumberFormatException e) {
        throw new NotNumberException();
      }
      return width;
    }

    public int getNumber() {
      int width;

      while(true){
        try {
          width = readNumber();

          if(width < 1) throw new LessThanOneException();

          break;
        } catch (Exception e){
          System.out.println(e);
        }

      }

      return width;
    }
  }

  public static void main(String[] argv) {
    DataLoader dl = new DataLoader();
    int width = dl.getNumber();

    Spiral spiral = new Spiral(width);
    spiral.print();
    spiral.printSpiral();
  }
}