package com.company;

import java.awt.*;
import java.util.Arrays;
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
                    exo3_7(9, 12);
                    break;
                }
                case 4: {
                    exo3_8_1();
                    break;
                }
                default: {
                    System.out.println("Ce numéro d'exercice n'existe pas ");
                }

            }
        }
        while (saisi != 0);

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
        // int n = readInt(sc, "Quel est la longueur de la régle"); En commentaire car il attend une entrée pour s'exécuter

        System.out.println(n < 5 ? "[" + "-".repeat(n) + "]" : "[" + "----+".repeat(n / 5) + "-".repeat(n % 5) + "]");
    }


//    private static void 3_3_2(int nbl, int nbc){
//        //3.3.2 2D
//        //Écrire un programme qui affiche un rectangle de taille nColonnes par nLignes.
//        nbl=3;
//        nbc=2;
//    }

    private static void exo3_8_1() {
        //3.8.1
        //Écrire un programme qui permet d'afficher une table, en représentant les lignes et les colonnes, de nColonnes par nLignes.
        int nColonnes = 9;
        int nLignes = 6;



//Solution Bernard
//        private static String emptyGrid(int nRows,int nCols) {
//    String[] linesData = make_array("-", nCols);
//    String[] rowsData = make_array(toString(make_array(" ", nCols)
//                                            , "┃", "┃", "┃\n")
//                                    ,nRows);
//    return toString(rowsData,
//            toString(linesData,"┏","┳","┓\n"),
//            toString(linesData, "┣","╋","┫\n"),
//            toString(linesData,"┗","┻","┛\n"));
//}
//private static String[] make_array(String s, int n) {
//    String[]res= new String[n];
//    //Arrays.fill(res, s);
//    for(int i=0; i != res.length; ++i){
//        res[i]= s;
//    }
//    return res;
//}



        System.out.print(("┏" + "━" + ("┳━").repeat(nColonnes - 1) + "┓" + "\n"));
        for (int i = 0; i < nLignes - 1; i++) {
            System.out.print(("┃ " + "┃ ".repeat(nColonnes) + "\n" +
                    "┣" + "━╋".repeat(nColonnes - 1) + "━┫" + "\n"));
        }

        System.out.println("┃ " + "┃ ".repeat(nColonnes) + "\n" + "┗" + "━" + ("┻━").repeat(nColonnes - 1) + "┛" + "\n");


    }



    //Écrire un programme qui permette d'afficher la table de multiplication jusqu'à n × m. Par exemple :
    private static int[][] exo3_7(int n, int m) {

        //n nombre de ligne
        //m nombre de colonnes
        int[][] tab = new int[n][m];
        // remplissage  de la 1er ligne
        for (int j = 0; j != tab[0].length; ++j) {
            tab[0][j] = j + 1;

        }

        // remplissage  de la 1er colonne
        for (int i = 0; i != tab.length; ++i) {
            tab[i][0] = i + 1;
        }

        // remplissage  de la ligne 1 à n
        for (int l = 1; l != tab.length; ++l) {
            for (int col = 1; col != tab[0].length; ++col) {
                tab[l][col] = tab[l][0] * tab[0][col];
            }
        }

        // ou bien on fait une remplissage  du tableau
        for (int i = 1; i != tab.length; ++i) {
            for (int j = 1; j != tab[i].length; ++j) {
                tab[i][j] = (i + 1) * (j + 1);
            }
        }


        // affifichage du tableau
        String format = "%" + (nbDigits(tab[tab.length - 1][tab[0].length - 1]) + 1) + "d";
        for (int c = 0; c != tab.length; ++c) {

           for (int j = 0; j != tab[1].length; j++) {
               System.out.printf(format, tab[c][j]);
           }
            System.out.println();
        }
        return tab;
    }

    public static int nbDigits(long v) {
        int res = 0;
        long pow10 = (v > 0) ? 1 : -1;
        while (pow10 <= v) {
            ++res;
            pow10 = pow10 * 10; //pow10 *= 10
        }
        return res;
    }


    public static String toString(String[] data, String begin, String separator, String end) {
        String result = begin;
        for (int i = 0; i < data.length; i++) {
            result = result + data[i];
            if (data.length - 1 != i) {
                result = result + separator;
            }
        }
        return result + end;
    }


}

