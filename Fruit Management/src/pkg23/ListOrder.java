package pkg23;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListOrder extends ArrayList<Fruit> {

    public void addOrder(FruitManager fruitList) {
        int choice;
        int quantity;
        String YN;

        Scanner sc = new Scanner(System.in);
        do {
            ArrayList<Fruit> listFruitAvailable = fruitList.displayForCustomer();
            if (listFruitAvailable.isEmpty()) {
                System.out.println("Out of fruits!!");
                return;
            }

            System.out.println("Enter fruit :");
            choice = Inputter.checkInputIntLimit(1, listFruitAvailable.size());

            Fruit fruit = listFruitAvailable.get(choice - 1);
            System.out.println("Your selected: " + fruit.getName());

            System.out.println("Enter quantity:");
            quantity = Inputter.checkInputIntLimit(0, fruit.getQuantity());

            int pos = findFruitById(fruit.getId());
            if (pos > -1) { //if this fruit exist in the list => update the quantity
                Fruit fruitExisted = this.get(pos);
                fruitExisted.setQuantity(fruitExisted.getQuantity() + quantity);
            } else { //add this fruit to list
                this.add(new Fruit(fruit.getId(), fruit.getName(), fruit.getPrice(), quantity, fruit.getOrigin()));
            }
            Fruit fruitTmp = fruitList.findFruit(fruit.getId());
            fruitTmp.setQuantity(fruitTmp.getQuantity() - quantity);

            do {
                System.out.println("Do you want continue zzzzzzz: ");
                YN = sc.nextLine().trim();
                if (!YN.equalsIgnoreCase("Y") && !YN.equalsIgnoreCase("N")) {
                    System.out.println("Y or N");
                }
            } while (!YN.equalsIgnoreCase("Y") && !YN.equalsIgnoreCase("N"));

        } while (YN.equalsIgnoreCase("Y"));

    }

    public void displayOrder(List<Order> f) {
        long total = 0;
        System.out.println("|Name      |Quantity|    Price    |     Amount     |");

        //tong gia tien = tich gia tung san pham cong lai
        for (int i = 0; i < f.size(); i++) {
            total += f.get(i).quantity * f.get(i).price;
            System.out.printf("|%-10s|%8d|%10dVND|%13dVND|\n",
                    f.get(i).product, f.get(i).quantity, f.get(i).price, f.get(i).quantity* f.get(i).price);

        }

        System.out.println("Total: " + total + "VND");
    }

    public int findFruitById(String id) {
        if (this.isEmpty()) {
            return -1;
        }
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }
}
