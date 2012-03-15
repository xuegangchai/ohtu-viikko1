/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author chai
 */

//Version 2

import java.util.Scanner;
import java.util.Arrays;

public class Anagrammit {

    public static Scanner lukija = new Scanner(System.in);

    public static boolean anagrammit(String sana1, String sana2) {
        String ekasana = sana1.trim();
        ekasana = ekasana.toLowerCase();
        String tokasana = sana2.trim();
        tokasana = tokasana.toLowerCase();
        char[] eka = ekasana.toCharArray();
        char[] toka = tokasana.toCharArray();
        Arrays.sort(eka);
        Arrays.sort(toka);
        return Arrays.equals(eka, toka);
    }

    public static void main(String[] args) {
        System.out.print("Anna 1. sana: ");
        String sana1 = lukija.nextLine();
        System.out.print("Anna 2. sana: ");
        String sana2 = lukija.nextLine();

        if (anagrammit(sana1, sana2)) {
            System.out.print("Annoit anagrammit.");
        } else {
            System.out.println("Et antanut anagrammeja.");
        }
    }
}
