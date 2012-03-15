/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author chai
 */
import java.util.Scanner;

public class Kertoma {
    public static int kertoma(int luku) {

        int tulos = 1;

        for (int i = 1; i <= luku; i++) {
            tulos *= i;
        }

        return tulos;
    }

    public static Scanner lukija = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Anna luku: ");
        int luku = Integer.parseInt(lukija.nextLine());

        int vastaus = kertoma(luku);

        System.out.println("Kertoma: " + vastaus);
    }
}