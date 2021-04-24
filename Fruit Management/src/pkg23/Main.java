package pkg23;





public class Main {
    
    public static void main(String[] args) {
	int choice;
	FruitManager fruitList = new FruitManager();
	ShoppingList shoppingList = new ShoppingList();
	fruitList.initData();
	do {	    
	    System.out.println("\n====== FRUIT SHOP SYSTEM ======");
            System.out.println("1. Create Fruit");
            System.out.println("2. View orders");
            System.out.println("3. Shopping (for buyer)");
            System.out.println("4. Exit");
	    choice = Inputter.checkInputIntLimit(1,4);
	    switch(choice) {
		case 1:
		    fruitList.addFruit();
		    break;
		case 2:
		    shoppingList.printAllOrder();
		    break;
		case 3:
		    shoppingList.addOrder(fruitList);
		    break;
		case 4:
		    System.out.println("Good bye!!");
		    break;
	    }
	} while (choice != 4);
    }
}
