// Item Class: Create a class to represent items that can be added to the shopping cart. Include attributes: item name, price, and quantity. (We will do this in class)
//        Shopping Cart Array: Create an array to store items in the shopping cart. Allow users to add items to the cart and specify the quantity. Array Access and Modification:
//        Implement methods to add items to the cart array. Allow users to remove items from the cart.
//        Array Iteration: Implement a method to calculate and display the total cost of the items in the cart.
//
public class Item {

    String name;
    double price;
    int quantity;

    public Item (String n, double p, int q){
        name = n;
        price = p;
        quantity = q;
    }

    // getters and setters
    public String getName(){
        return name;
    }
    public void setName(){
        System.out.println("What item is this?");
        name = Main.getInput();
    }

    public double getPrice(){
        return price;
    }

    public void setPrice(){
        System.out.println("How much does this item cost?");
        price = Integer.parseInt(Main.getInput());
    }

    public int getQuantity(){
        return quantity;
    }

    public void setQuantity(){
        System.out.println("How many of this item?");
        quantity = Integer.parseInt(Main.getInput());
    }






}
