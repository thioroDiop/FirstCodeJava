package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // On déclare un scanner pour lire les entrées de la console
        Scanner sc = new Scanner(System.in);


        // On déclare et initialise le nombre total de comande et la variable d'aggrégation
        float totalCommande = 0;

        String listCommande = "";
        String description = "bonjour";

        //on fait la boucle

        while (!description.isEmpty()) {
            // On affiche un message pour demander la description de la commande
            System.out.println("Entrez la description de la commande : ");

            // On récupère le la description de la console
            description = sc.nextLine();

            //si la description est vide on arrête là, par compte s'il ya une entrée on pose les questions suivantes
            if (!description.isEmpty()) {
                // On demande la quantité
                System.out.println("Entrez La quantité : ");
                int quantite = sc.nextInt();
                sc.nextLine();

                // On demande le prix
                System.out.println("Entrez Le prix : ");
                float prix = sc.nextFloat();
                sc.nextLine();
                float commandeU = quantite * prix;
                // on recupere le total de la commande aggrégé avec l'ancien total s'il existe
                totalCommande = totalCommande + commandeU;
                // on concaténe l'ensemble des descriptions dans une récap (listCommande) avec la quantité, le prix unitaire et le total par commande en affichant la devise
                //listCommande=  listCommande+"\n"+quantite+"* "+description +  "  ( "+prix+ "€)    "+ commandeU +"€";
                listCommande = String.format("%s%n %d*%-17s  (%.1f€)  %.1f€", listCommande, quantite, description, prix, commandeU);

                //prochain Etape mettre en forme dans un tableau et mettre la liste
            }


        }

        // imprimer le ticket à la fin dans une mise en forme et la recap des commandes
        /
        System.out.println("----------------Facture-------------\nCommande             | Prix | total\n------------------------------------");

        System.out.printf(" %s%n%n", listCommande);

        System.out.printf("---------------Total de: %.1f€--------", totalCommande);


        sc.close();
    }

}
