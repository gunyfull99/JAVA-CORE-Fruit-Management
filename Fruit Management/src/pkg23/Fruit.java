package pkg23;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public class Fruit {
     String id;
     String name;
     long price;
     int quantity;
     String origin;

    public Fruit(String id, String name, long price, int quantity, String origin) {
	this.id = id;
	this.name = name;
	this.price = price;
	this.quantity = quantity;
	this.origin = origin;
    }

    public String getId() {
	return id;
    }

    public void setId(String id) {
	this.id = id;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public long getPrice() {
	return price;
    }

    public void setPrice(long price) {
	this.price = price;
    }

    public int getQuantity() {
	return quantity;
    }

    public void setQuantity(int quantity) {
	this.quantity = quantity;
    }

    public String getOrigin() {
	return origin;
    }

    public void setOrigin(String origin) {
	this.origin = origin;
    }
}
