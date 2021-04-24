package pkg23;


import java.util.ArrayList;
import java.util.Scanner;

public class FruitManager extends ArrayList<Fruit> {

    Scanner sc = new Scanner(System.in);

    public void addFruit() {

        String id, name, origin, userChoice;
        long price;
        int quantity;
        boolean isExist;
        do {
            do {
                System.out.println("Enter ID:");
                id = Inputter.checkInputString();
                isExist = Inputter.isExistFruitId(id, this);
            } while (isExist);
            System.out.println("Enter name fruit:");
            name = Inputter.checkInputString();
            System.out.println("Enter price:");
            price = Inputter.checkInputInt();
            System.out.println("Enter quantity: ");
            quantity = Inputter.checkInputInt();
            System.out.println("Enter origin:");
            origin = Inputter.checkInputString();

            Fruit fruit = new Fruit(id, name, price, quantity, origin);
            this.add(fruit);
            System.out.println("Do you want continue: ");
            if(!Inputter.checkInputYN()){
                return;
            }
        } while (true);
    }


    public Fruit findFruit(String id) {
        for (Fruit x : this) {
            if (x.getId().equalsIgnoreCase(id)) {
                return x;
            }
        }
        return null;
    }

     public ArrayList<Fruit> displayForCustomer() {
	ArrayList<Fruit> listTemp = new ArrayList<>();
	//neu danh sach fruit hien tai trong thi tra ve list tam empty
	if (this.isEmpty()) {
	    return listTemp;
	} else {
	    System.out.println("|ID        |Name        |Origin    |Quantity|    Price    |");
	    //set ID for list
	    int item = 1;
	    for (int i = 0; i < this.size(); i++) {
		Fruit tmp = this.get(i);
		//kt xem trong list co san pham vao co so luong > 0 de them vao list
		if (tmp.getQuantity() > 0) {
		    listTemp.add(tmp);
		    System.out.printf("|%-10s|%-12s|%-10s|%-8d|%10dVND|\n",
			    item++, tmp.getName(),tmp.getOrigin(), tmp.getQuantity(), tmp.getPrice());
		}
	    }
	}
	return listTemp;
    }

    public void initData() {
        this.add(new Fruit("1", "Coconut", 1000, 100, "Vietnam"));
        this.add(new Fruit("2", "Orange", 3000, 150, "US"));
        this.add(new Fruit("3", "Apple", 1500, 80, "Thailand"));
        this.add(new Fruit("4", "Grape", 4200, 20, "France"));
    }


}
