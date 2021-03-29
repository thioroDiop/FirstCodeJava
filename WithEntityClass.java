public class WithArray {
    package co.simplon;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

    class Item {
        private final String name;
        private final double unitPrice;
        private final int quantity;
        public Item(String name, double unitPrice, int quantity){
            this.name= name;
            this.unitPrice= unitPrice;
            this.quantity= quantity;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Item item = (Item) o;
            return Double.compare(item.unitPrice, unitPrice) == 0 &&
                    quantity == item.quantity &&
                    name.equals(item.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, unitPrice, quantity);
        }

        @Override
        public String toString() {
            return "Item{" +
                    "name='" + name + '\'' +
                    ", unitPrice=" + unitPrice +
                    ", quantity=" + quantity +
                    '}';
        }

        public double getUnitPrice() {
            return unitPrice;
        }
        public int getQuantity() {
            return quantity;
        }
        public double getTotalPrice(){
            return quantity*unitPrice;
        }
        public String getName() {
            return name;
        }
    }
    public class WithEntityClass {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            // Faire une boucle sur les articles tant que le serveur en rentre
            List<Item> items = new ArrayList<Item>();

            String article = "";
            do {
                System.out.print("Plat #" + (items.size()+1) + " : ");
                article = sc.nextLine();

                if (!article.isEmpty()) {
                    System.out.print("Quantité : ");
                    int quantity= sc.nextInt();

                    System.out.print("Prix unitaire : ");
                    double price=sc.nextDouble();
                    // On nettoie la ligne
                    sc.nextLine();
                    items.add(new Item(article, price, quantity));
                }
            }
            while (!article.isEmpty());

            System.out.println();
            System.out.println("------------------- Facture -------------------");
            double totalPrice = 0.;
            for(Item item : items){
                System.out.printf("%2sx %-20s (%5.2f€) %12.2f€",
                        item.getQuantity(), item.getName(), item.getUnitPrice(), item.getTotalPrice());
                System.out.println();
                totalPrice+= item.getTotalPrice();
            }
            System.out.println();
            System.out.printf("Prix total : %33.2f€", totalPrice);
            System.out.println();
            System.out.println("----------------- Fin Facture -----------------");
        }

    }
© 2021 GitHub, Inc.
}
