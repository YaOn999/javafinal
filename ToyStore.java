import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ToyStore {
    private List<Toy> toys;

    public ToyStore() {
        toys = new ArrayList<>();
    }

    public void addToy(Toy toy) {
        toys.add(toy);
    }

    public void updateWeight(int toyId, int weight) {
        for (Toy toy : toys) {
            if (toy.getId() == toyId) {
                toy.setWeight(weight);
                break;
            }
        }
    }

    public Toy selectPrizeToy() {
        int totalWeight = 0;
        for (Toy toy : toys) {
            totalWeight += toy.getWeight();
        }

        Random random = new Random();
        int randomNumber = random.nextInt(totalWeight);

        int currentWeight = 0;
        for (Toy toy : toys) {
            currentWeight += toy.getWeight();
            if (randomNumber < currentWeight) {
                toy.setQuantity(toy.getQuantity() - 1);
                return toy;
            }
        }

        return null; // No toys available
    }

    public void savePrizeToyToFile(Toy toy) {
        try {
            FileWriter writer = new FileWriter("prize_toys.txt", true);
            writer.write(toy.getName() + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
