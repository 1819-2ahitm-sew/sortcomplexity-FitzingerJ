package at.htl;

import java.util.Scanner;

public class SortComplexity {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int length;
        int amount;
        long average = 0;

        System.out.print("Anzahl der zu sortierenden Arrays: ");
        amount = scanner.nextInt();
        System.out.print("Größe der Arrays: ");
        length = scanner.nextInt();
        System.out.println();
        for (int i = 0; i < amount; i++) {
            if (i + 1 < 10) {
                System.out.println("Laufzaeit zur Sortierung des  " + (i + 1) + ". Array: " + sortRandomArray(length) + " ms");
            } else{
                System.out.println("Laufzaeit zur Sortierung des " + (i + 1) + ". Array: " + sortRandomArray(length) + " ms");
            }
            average += sortRandomArray(length);
        }
        average /= amount;
        System.out.println();
        System.out.print("Durchschnittliche Laufzeit: "+average+" ms");
    }

    // Sorts an array of random numbers and returns the sorting run time in ms
    public static long sortRandomArray(int length) {
        long time = 0;

        long help = System.currentTimeMillis();
        sort(generateRandomArray(length));
        time = System.currentTimeMillis();
        time -= help;

        return time;
    }

    // Returns an array of random numbers
    public static int[] generateRandomArray(int length) {
        int[] randArray = new int[length];

        for (int i = 0; i < randArray.length; i++) {
            randArray[i] = (int)(Math.random() * 10);
        }

        return randArray;
    }

    // Sorts an array of numbers in ascending order
    public static void sort(int[] array) {
        boolean getauscht = false;
         int i = array.length - 1;

         do{
             getauscht = false;
             for (int j = 0; j < i; j++) {
                 if(array[j] > array[j+1]){
                     swap(array, i, j);
                     getauscht = true;
                 }
             }
             i--;
         } while(getauscht || (i>=0));

    }

    // Swaps the array elements with index i and j
    public static void swap(int[] array, int i, int j) {
        int hilf = array[j];
        array[j] = array[j+1];
        array[j+1] = hilf;
    }
}
