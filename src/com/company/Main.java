package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

            // On déclare un scanner pour lire les entrées de la console
            Scanner sc = new Scanner(System.in);

// On demande le nombre de plat
        System.out.println("Entrez Le nombre de plat : ");
        int nbPlat = sc.nextInt();
        sc.nextLine();

    // On déclare et initialise le nombre total de comande et la variable d'aggrégation
        float totalCommande=0;
        int i=1;
        String listCommande="";

        //on fait la boucle
        while(i<=nbPlat) {

            // On affiche un message pour demander la description de la commande
            System.out.println("Entrez la description de la commande : ");

            // On récupère le prénom de la console
            String description = sc.nextLine();

            // On demande la quantité
            System.out.println("Entrez La quantité : ");
            int quantite = sc.nextInt();
            sc.nextLine();

            // On demande le prix
            System.out.println("Entrez Le prix : ");
            float prix = sc.nextFloat();
            sc.nextLine();
              // on recupere le total de la commande aggrégé avec l'ancien total s'il existe
            totalCommande = totalCommande + (quantite * prix);
            listCommande=description +" "+ listCommande;
            i++;
        }

        // imprimer le ticket à la fin
        System.out.println("Bonjour le total de votre commande " +listCommande+ " est de : " + totalCommande);



            sc.close();
        }

}