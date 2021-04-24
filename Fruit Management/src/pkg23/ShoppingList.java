package pkg23;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class ShoppingList extends Hashtable {

    Inputter ip = new Inputter();

    ListOrder listOrder = new ListOrder();

    public void addOrder(FruitManager fruitList) {
        List<List<Order>> shoppingList = new ArrayList();
        List<Order> f = new ArrayList<>();
        String name;
        boolean next = true;
        Scanner sc = new Scanner(System.in);
        int choice;
        int quantity;
        String YN;
        do {
            List<Fruit> listFruitAvailable = fruitList.displayForCustomer();
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

            int pos = listOrder.findFruitById(fruit.getId());
            if (pos > -1) { //if this fruit exist in the list => update the quantity
                Order fruitExisted = f.get(pos);
                fruitExisted.setQuantity(fruitExisted.getQuantity() + quantity);
            } else { //add this fruit to list
                f.add(new Order(fruit.getName(), quantity, fruit.getPrice()));
            }
            shoppingList.add(f);
            next = false;

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

        listOrder.displayOrder(f);

        System.out.println("Enter name zzzzzzzz:");
        name = ip.checkInputString();
        Enumeration customer;
        customer = this.keys();
        while (customer.hasMoreElements()) {
            String customerName = (String) customer.nextElement();
            // if it found out the custormer, then add a new order 
            if (customerName.equals(name)) {
                List<List<Order>> itemList2 = new ArrayList();
                itemList2 = (List<List<Order>>) this.get(customerName);
                itemList2.add(f);
                this.put(name, itemList2);
                next = true;
            }
        }
        if (next == false) {
            this.put(name, shoppingList);
        }
        System.out.println("Thanks for buying!!");
    }

    public void printAllOrder() {
        if (this.isEmpty()) {
            System.out.println("The Order List is empty!!");
            return;
        }
        Enumeration name;
        name = this.keys();
        String customer;
        while (name.hasMoreElements()) {
            customer = (String) name.nextElement();
            List<List<Order>> order1 = (List<List<Order>>) this.get(customer);
            for (int i = 0; i < order1.size(); i++) {
                System.out.println("Customer: " + customer);
                listOrder.displayOrder(order1.get(i));
                System.out.println("");
            }

        }
    }
}
