import java.util.*;

public class Commande {
    Scanner sc = new Scanner(System.in);
    private final String description;
    private final double price;
    private int quantity;

    //    public Commande( String description,int quantity, double price) {
//        this.description= description;
//        this.quantity= quantity;
//        this.price= price;
//    }
    public Commande(String description, double price) {
        this.description = description;
        this.price = price;
        this.quantity = 0;
    }

    //On déclare les ascesseurs
    public double getUnitPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalPrice() {
        return quantity * price;
    }

    public void setQuantity(int quantite) {
        this.quantity = quantite;
    }

    public void addQuantity(int quantite) {
        this.quantity = this.quantity + quantite;
    }

    public String getName() {
        return description;
    }


}

public class WithClassCommande {
    public static void main(String[] args) {

        // On déclare un scanner pour lire les entrées de la console
        Scanner sc = new Scanner(System.in);
        // On déclare un scanner la map
        Map<String, Commande> articleToItem = new HashMap<String, Commande>();

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
                if (articleToItem.containsKey(description)) {
                    Commande commande = articleToItem.get(description);
                    double price = commande.getUnitPrice();
                    System.out.println("prix unitaire: " + price);

                    System.out.println("Entrez La quantité : ");
                    int quantite = sc.nextInt();
                    sc.nextLine();

                    commande.addQuantity(quantite);// je prend l'ancienne qunatité + la nouvelle recupéree
                    //  commande = new Commande(description, price, quantite);

                    // je met à jour la map avec la nouvelle quantité
                } else {

                    System.out.println("entrez le prix unitaire: ");
                    double price = sc.nextFloat();
                    sc.nextLine();
                    //descriptToPrice.put(description, price);
                    Commande commande = new Commande(description, price);
                    articleToItem.put(description, commande);
                    System.out.println("Entrez La quantité : ");
                    int quantite = sc.nextInt();
                    sc.nextLine();
                    commande.addQuantity(quantite);// cette commande met aussi à jour la Map car c'est un objet identique

                }

            }
        }print(articleToItem);

    }

    private static void print(Map<String, Commande> articleToItem) {
        double totalPrice = 0;
        for (Commande commande : articleToItem.values()) { // boucle nouvelle génération
            // Calcul du prix de chaque ligne de la facture
            double linePrice = commande.getTotalPrice();
            // Affichage de chaque article avec le prix
            System.out.println(commande.getName() + " x " + commande.getQuantity() +
                    "(" + commande.getUnitPrice() + ") = " + linePrice + " €");
            totalPrice = totalPrice + linePrice; // ou totalPrice+=linePrice;
        }
        System.out.println("Montant total = " + totalPrice);
    }

}

