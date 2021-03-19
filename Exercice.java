
package com.company;
cd
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;


public class Exercice {

    public static void main(String[] args) {

        // On déclare un scanner pour lire les entrées de la console
        Scanner sc = new Scanner(System.in);

        // On déclare et initialise le nombre total de comande et la variable d'aggrégation


        //declaration de hashMap

        Map<String, Integer> descriptToQuantite = new HashMap<String, Integer>();
        Map<String, Float> descriptToPrice = new HashMap<String, Float>();


        String description = "bonjour";

        //on fait la boucle

        while (!description.isEmpty()) {
            // On affiche un message pour demander la description de la commande
            System.out.println("Entrez la description de la commande : ");

            // On récupère le la description de la console
            description = sc.nextLine();

            //si la description est vide on arrête là, par compte s'il ya une entrée on pose les questions suivantes
            if (!description.isEmpty()) {
                // on verifie sur le plat existe déja
                if (descriptToQuantite.containsKey(description)) {
                    Float price = descriptToPrice.get(description);
                    System.out.println("prix unitaire: " + price);

                    System.out.println("Entrez La quantité : ");
                    int quantite = sc.nextInt();
                    sc.nextLine();
                    quantite = descriptToQuantite.get(description) + quantite;// je prend l'ancienne qunatité + la nouvelle recupéree
                    descriptToQuantite.put(description, quantite);// je met à jour la map avec la nouvelle quantité
                } else {

                    System.out.println("entrez le prix unitaire: ");
                    float price = sc.nextFloat();
                    sc.nextLine();
                    descriptToPrice.put(description, price);


                    System.out.println("Entrez La quantité : ");
                    int quantite = sc.nextInt();
                    sc.nextLine();
                    descriptToQuantite.put(description, quantite);
                }

            }
        }
        print(descriptToQuantite,descriptToPrice);
        }

    ///affichage
    private static void print(Map<String, Integer> articleToQuantity, Map < String, Float > articleToPrice){
        float totalPrice=0;
        for (String article: articleToQuantity.keySet()) {//on parcourt chacune des keys de l'ensemble articleToQuantity
            float linePrice= articleToPrice.get(article)*articleToQuantity.get(article);

            System.out.println(article+"*"+ articleToQuantity.get(article) +
                    " ( "+ articleToPrice.get(article)+" ) = "+ linePrice + " €");
            totalPrice+=linePrice;
        }
        System.out.println("Montant total = " + totalPrice);
    }

    }




