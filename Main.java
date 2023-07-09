import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ToyStore toyStore = new ToyStore();

        // Adding toys to the store
        Toy toy1 = new Toy(1, "ball", 10, 30);
        Toy toy2 = new Toy(2, "Doll", 15, 20);
        Toy toy3 = new Toy(3, "Car", 20, 50);

        toyStore.addToy(toy1);
        toyStore.addToy(toy2);
        toyStore.addToy(toy3);

        // Updating weight of a toy
        toyStore.updateWeight(1, 40);

        // Selecting a prize toy
        Toy prizeToy = toyStore.selectPrizeToy();
        if (prizeToy != null) {
            // Saving the prize toy to a file
            toyStore.savePrizeToyToFile(prizeToy);
        } else {
            System.out.println("No toys available for prize.");
        }
    }
}
