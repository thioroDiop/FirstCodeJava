package com.company;

import java.awt.*;
import java.awt.desktop.SystemEventListener;
import java.util.Scanner;

public class Exemple {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int saisi = 0;
        do {
            saisi = readInt(sc, "entrer le numero de l'exo, saisissez un entier de 1 à 3?");
            switch (saisi) {
                case 0: {
                    System.out.println("Merci et Au revoir");
                    break;// cas pour sortir du l'execution si on il va toujours attendre qu'on rentre une nouvelle valeur
                    //question est ce qu'une boucle Do-While doit toujours avoir une condition qui stoppe le process?
                }
                case 1:
                    exo1(sc);
                    break;
                case 2:
                    exo2(sc);
                    break;
                case 3: {
                    exo3_3_1(sc);
                    break;
                }
                default: {
                    System.out.println("Ce numéro d'exercice n'existe pas ");
                }

            }
        } while (saisi != 0);

    }

    private static int readInt(Scanner sc, String message) {
        boolean invalid = false;
        int rest = 0;

        do {
            System.out.println(message);
            if (sc.hasNextInt()) {
                invalid = true;
                rest = sc.nextInt();
                sc.nextLine();
            } else {
                System.err.println("Le nombre entré doit etre un entier!!!");
                sc.nextLine();
            }
        } while (!invalid);

        return rest;
    }

    private static void exo2(Scanner sc) {
// déclarer un tauxTVA en entier
        int tauxTVA = 5;

        System.out.println("Entrez Le prix : ");
        int prixHT = sc.nextInt() * 100;
        sc.nextLine();
        int prixTTC = ((prixHT + (prixHT * tauxTVA) / 100));
        System.out.println(prixTTC / 100.0);
    }

    private static void exoFormat() {

        //String.format("%"+nbChars+"s", String.format("%.2f€",price));
        int taille = 10;
        System.out.println(String.format("le nombre est%" + taille + "s", String.format("(%.2f€)", 10.568)));
    }

    private static void exo1(Scanner scan) {

        System.out.println("Entrez le prénom : ");
        String firstName = scan.nextLine();

        System.out.println("Entrez le nom : ");
        String name = scan.nextLine();

        System.out.println("Entrez l'age : ");
        int age = scan.nextInt();
        scan.nextLine();

        System.out.println("Entrez votre Taille : ");
        float height = scan.nextFloat();
        scan.nextLine();

        System.out.println("pourquoi vous rejoignez la formation ? ");
        String formation = scan.nextLine();

        System.out.println("Donner le montant d'un compte bancaire en €");
        int amount = scan.nextInt() * 100;
        scan.nextLine();
        System.out.println("Je m'appelle " + firstName + " " + name + " j'ai " + age + " et je mesure " + height + "\n j'ai fait cette formation car: " + formation + "\n j'ai " + amount + "centime €");


        System.out.println("Entrez une année et on voit dit si elle est bissextile ou non");
        int year = scan.nextInt();
        int rest1 = year % 100;
        int rest2 = year % 400;
        System.out.println((rest2 == 0 && rest1 == 0) ? "cette année est bissextile" : "Cete année n'est pas bissextile");
        scan.nextLine();

        //declarer une couleur
        Color macouleur = Color.RED;

    }

    private static void exo3_3_1(Scanner sc) {
//Écrire un programme qui affiche une règle graduée d'une longueur n, avec des graduations tous les 5 pas
        System.out.println("Quel est la longueur de la régle");
        int n = sc.nextInt();
        sc.nextLine();

        System.out.println(n < 5 ? "[" + "-".repeat(n) + "]" : "[" + "----+".repeat(n / 5) + "-".repeat(n % 5) + "]");
    }

}
