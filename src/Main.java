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
            for (int i = 0; i < count; i++){

                cartContents[i] = shoppingCart[i].getName();
            }
            System.out.println(Arrays.toString(cartContents));

            System.out.println("What do you want to do?");
            System.out.println("1. Add items");
            System.out.println("2. Remove items");
            System.out.println("3. Inspect item");
            System.out.println("4. Get item total");
            System.out.println("ENTER ANYTHING TO QUIT");

            String response = getInput();

            if (response.equals("1")){
                addItems();
            }
            else if (response.equals("2")){
                if (count == 0){
                    System.out.println("No items yet! Please add something to your cart");
                } else {
                    removeItems();
                }

            }
            else if (response.equals("3")){


                if (count == 0){
                    System.out.println("No items yet! Please add something to your cart");
                } else {
                    inspectItem();
                }


            }
            else if (response.equals("4")){


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

        if (count == 0){
            shoppingCart[count] = new Item(itemName, itemCost, itemCount);
            count++;
        } else {
            for (int i = 0; i < count; i++) {
                Item x = shoppingCart[i];
                if ((itemName.equals(x.getName())) && (itemCost == x.getPrice())) {
                    shoppingCart[i].quantity += itemCount;
                } else {
                    shoppingCart[count] = new Item(itemName, itemCost, itemCount);
                    count++;

                }
                break;


            }
        }
    }

    public static void removeItems(){
        System.out.println("Which item would you like to remove?");
        String select = getInput();
        Item[] temp = new Item[count];
        int tempInt = 0;

        // looks for item that matches
        for (int i = 0; i < count; i++) {
            Item x = shoppingCart[i];
            if (select.equals(x.getName())){
                tempInt = i;
            }
        }

        // remove the said item
        int k = 0; // tells pc which space to put it in - needs its own int because i will be one larger than our new array
        for (int i = 0; i < count; i++){
            if (!(i == tempInt)){
                temp[k] = shoppingCart[i];
                k++;
            }
        }
        count--;
        shoppingCart = temp;
    }

    public static void inspectItem(){
        System.out.println("Which item would you like to inspect?");
        String select = getInput();
        boolean found = false;
        for (int i = 0; i < count; i++){
            Item x = shoppingCart[i];
            if (select.equals(x.getName())){
                System.out.println("Match #" + (i+1));
                System.out.println("Item = " + x.getName());
                System.out.println("Cost = $" + x.getPrice());
                System.out.println("Quantity = " + x.getQuantity());
                System.out.println();

                found = true;
            }
        }
        if (!found){
            System.out.println("No matches found!");
            System.out.println();

        }

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