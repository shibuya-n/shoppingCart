//Design and implement a Java program that simulates a simple shopping cart. Allow users to add and remove items from their cart, view the contents of the cart, and calculate the total cost of the items.
// combine items if they're the same +4


import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static Item[] shoppingCart = new Item[365];
    static int count = 0;
    public static void main(String[] args) {


        boolean done = false;
        while (!done) {
            String[] cartContents = new String[count];

            System.out.println("Current Shopping Cart:");
            for(int i = 0; i < count; i++){

                cartContents[i] = shoppingCart[i].getName();
            }
            System.out.println(Arrays.toString(cartContents));

            System.out.println("What do you want to do?");
            System.out.println("1. Add items");
            System.out.println("2. Remove items");
            System.out.println("3. Get item total");
            System.out.println("ENTER ANYTHING TO QUIT");

            String response = getInput();

            if (response.equals("1")){
                addItems();
            }
            else if (response.equals("2")){
                removeItems();
            }
            else if (response.equals("3")){


                System.out.println("Total = $" + itemTotal());
            }

            else {
                done = true;
                System.out.println("Thank you for shopping with us!");
            }
        }
    }


    public static void addItems() {
        System.out.println("What item do you want to add?");
        String itemName = getInput();
        System.out.println("How many of that item are you adding?");
        int itemCount = Integer.parseInt(getInput());
        System.out.println("How much does this item cost?");
        double itemCost = Double.parseDouble(getInput());

        for (int i = 0; i < count; i++) {
            Item x = shoppingCart[i];
            if ((itemName.equals(x.getName())) && (itemCost == x.getPrice())) {
                shoppingCart[i].quantity += itemCount;
                break;
            }
            else {
                shoppingCart[count] = new Item(itemName, itemCost, itemCount);
                count++;

            }


        }
    }

    public static void removeItems(){

    }
    public static double itemTotal(){


        double total = 0;
        for (int i = 0; i < count; i++){
            Item x = shoppingCart[i];
            total += (x.getQuantity() * x.getPrice());
        }
        return total;

    }
    public static String getInput(){
        Scanner obj = new Scanner(System.in);
        return obj.nextLine().strip().toLowerCase();
    }
}