package com.company;


import java.util.Scanner;

public class SalleCinema {

    public static void main(String[] args) {
        // les attributs

        char placePrise = 'X';
        int nbRang = 7; // nombre de rangées
        int nbPlace = 9; // nombre de palces
        char[][] salle = new char[nbRang][nbPlace];
        Scanner sc = new Scanner(System.in);

        int placeLibre;

        // initiatlisation des place vides des la salle
        for (int l = 0; l != salle.length; ++l) {
            for (int c = 0; c != salle[l].length; ++c) {
                salle[l][c] = '-';
            }
        }

//la rangée choisie et le nombre de places spécifiés


        do {
            placeLibre = 0;
            int compteur = 0;
            int row = isRange(sc, nbRang);// le numero de la rangée choisie
            int places = FreePlace(salle, row);/// nombre de place restante sur la rangée

            System.out.println("combien de places souhaitez vous:");
            int nbPlaces = sc.nextInt();
            sc.nextLine();

            if (nbPlaces > places) {// on verifie s'il ya assez de places
                System.out.println("il n'y a plus de place sur la rangée");
            } else {

                // attibution de places //on cherche la 1er place libre

                System.out.println("nblaces= " + nbPlaces);


                for (int j = 0; j < salle[row].length && compteur != nbPlaces; j++) {
                    if (salle[row][j] == '-') {// je cherche une place vide
                        salle[row][j] = 'X';// j'aloue la place
                        compteur = compteur + 1;
                    }
                }
                System.out.println("comteur= " + compteur);


                  // afficher le tableau
                for (int l = 0; l != salle.length; ++l) {
                   // System.out.print("[");
                    for (int c = 0; c != salle[l].length; ++c) {

                        System.out.print("["+ salle[l][c] + "] ");
                    }
                    System.out.println();
                }


                //nombre total de places libre

                for (int p = 0; p != nbRang; p++) {
                    for (int j = 0; j != salle[0].length; j++) {
                        if (salle[p][j] == '-') {
                            placeLibre = placeLibre + 1;
                        }


                    }

                }
                System.out.println("nombre de place restante est de : " + placeLibre);


            }

        } while (placeLibre != 0);

    }


    //fonction sui retourne le nombre de place libre sur la rangée choisie
    private static int FreePlace(char[][] salle, int numRang) {
        int res = 0;
        for (int j = 0; j != salle[numRang].length; j++) {
            res = ((salle[numRang][j] == '-') ? ++res : res);
        }
        return res;
    }


    //fonction pour verifier si le numero de rangé existe et renvoie le num de ligne (la rangée)
    private static int isRange(Scanner sc, int nbRang) {
        boolean isvalid = false;
        int res = 0;

        do {
            System.out.println("veuillez choisir la rangée de 0 à 6:");
            int row = sc.nextInt();
            sc.nextLine();
            if (row > nbRang - 1) { // on verifie si la rangé saisie est plus que le nombre total de rangées
                System.err.println("le numero saisie est incorrect!");

            } else {
                isvalid = true;
                res = row;

            }
        } while (!isvalid);

        return res;
    }


}


