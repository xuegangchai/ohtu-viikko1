/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;

/**
 *
 * @author chai
 */
public class LaskeMerkit {

    private static Scanner lukija = new Scanner(System.in);

    public static void main(String[] args) {

        int lkm = 0;
        while (lukija.hasNextLine()) {
            String jono = lukija.nextLine();
            lkm += jono.length();
        }
        System.out.println(lkm);
    }
}
