package Masyvas;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int length = 10;
        int[] A = enterIntArray(length);
        System.out.println("Masyvas:");
        printArray(A);
        if (countEven(A) > 0) System.out.println("Masyvo lyginiu elementu vidurkis: " + averageEven(A));
        else System.out.println("Masyve lyginių elementų nera");
        swap(A, getIndexMin(A), getIndexMax(A));
        System.out.println("Masyvas po didziausio ir maziausio sukeitimo elementu:");
        printArray(A);
        getLowestMin(A);
    }

    /**
     *Paklausti varotojaus kad suvestu skaicius
     * @param length masyvo ilgis
     * @return masyvas uzpildytas vartotjo ivestomis vertemis
     */
    private static int [] enterIntArray(int length) {
        int [] array = new int[length];

        System.out.println("Iveskite " + length + " sveikų skaiciu.");
        for (int i = 0; i < length; i++) {
            while (true) {
                Scanner s = new Scanner(System.in);
                try {
                    System.out.print("Iveskite " + (i + 1) + " skaiciu: ");
                    array[i] = s.nextInt();
                    break;
                }
                catch (Exception e) {
                    System.out.println("Įvestas ne sveikas skaicius! Pakartokite įvedimą.");
                }
            }
        }
        return array;
    }

    /**
     * Atspausdina
     * @param array masyvas spausdinti
     */
    private static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    /**
     *Prideda lygias masyvo reiksmes ir grazina rezultata
     * @param array kurios lygios vertes bus pridetos
     * @return suma lygiu
     */
    private static int addEven(int[] array) {
        int sum = 0;
        for (int value : array) {
            if (value % 2 == 0) sum += value;
        }
        return sum;
    }

    /**
     * Grazina masyvo lyginiu skaiciu
     * @param array masyvas , kurio lygios vertes bus suskaiciuotos.
     * @return skaicius lygiu sumu
     */
    private static int countEven(int[] array) {
        int count = 0;
        for (int value : array) {
            if (value != 0 && value % 2 == 0) count++;
        }
        return count;
    }

    /**
     * Pateikia masyvo lyginiu skaiciu vidurki
     * @param array masyvas , kurio lygios vertes bus vidutines
     * @return vidurkis lygiu sumu
     */
    private static double averageEven(int[] array) {
        return (double) addEven(array) / countEven(array);
    }

    /**
     * Sukeicia didziausias reiksmes turincius masyvus vietomis.
     * @param array masyvas kurio didziausiu verciu indeksas bus grazintas
     * @return didziausios vertes indeksas , arba -1 jei mysvas tuscias
     */
    private static int getIndexMax(int[] array) {
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > array[index]) index = i;
        }
        return index;
    }

    /**
     * Sukeicia maziausias reiksmes turincius masyvus vietomis.
     * @param array bus grazintas zemiausias skaiciu indeksas
     * @return maziausios vertes indeksas, arba -1 jei masyvas tuscias
     */
    private static int getIndexMin(int[] array) {
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < array[index]) index = i;
        }
        return index;
    }

    /**
     * Funkcija kuri spousdina po ir pries masyvo pakeitimus
     * @param array masyvas kurio reiksme bus pakeista
     * @param index1 pirmosios vertes indeksas
     * @param index2 antrosiso vertes indeksas
     */
    private static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
    /**
     * Funkcija kuri suranda maziausia skaiciu tarp lyginiu neigamu masyvo elementu
     *
     */
    public static void getLowestMin(int[] array) {
        int neig = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                if (array[i] < neig) {
                    neig = array[i];
                }
            }
        }
        System.out.println("Maziausias lyginis neigamas skaicius:" + neig);
    }
}
