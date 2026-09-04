import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class AquariumApp {

    public static void main(String[] args) {

        SeaCreature[] tank;
        
        // Two starter creatures.
        try {
            File file = creaturesFile();
            Scanner scanner = new Scanner(file);
            tank = new SeaCreature[scanner.nextInt()];
            scanner.close();
        }
        catch (FileNotFoundException e) {
            tank = new SeaCreature[6];
            System.out.println("An error has occured while reading the creatures file.\n" + e.getMessage());
            return;
        }
        try {
            File file = creaturesFile();
            Scanner scanner = new Scanner(file);
            scanner.useDelimiter(", ?|\\r?\\n");
            tank = new SeaCreature[scanner.nextInt()];
            for(int i = 0; i < tank.length; i++){
                String animalType = scanner.next();
                if(animalType.equals("Fish")){
                    tank[i] = new Fish(scanner.next(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.next());
                }
                else if(animalType.equals("Shark")){
                    tank[i] = new Shark(scanner.next(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.next());
                }
                else if(animalType.equals("Turtle")){
                    tank[i] = new Turtle(scanner.next(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.next());
                }
                else if(animalType.equals("Prop")){
                    tank[i] = new Prop(scanner.next(), scanner.nextInt(), scanner.next());
                }
                else if(animalType.equals("AnimatedProp")){
                    tank[i] = new AnimatedProp(scanner.next(), scanner.nextInt(), scanner.next(), scanner.next());
                }
            }
            /*
            tank[0] = new Fish("Nemo", 4, 3, 1, "><>");
            tank[1] = new Fish("Dory", 30, 2, -1, "><((('>");
            tank[2] = new Shark("Tod", 14, 1, -1, "<('-')>");
            tank[3] = new Turtle("Speedster", 7, 4, -1, "<(^v^v^v)' )");
            tank[4] = new Prop("Bubbles", 15, "o.*   .*o");
            tank[5] = new AnimatedProp("Grassy", 2, " //", "\\\\ "); */
            scanner.close();

        } 
        catch (FileNotFoundException e) {
            System.out.println("An error has occured while reading the creatures file.\n" + e.getMessage());
            return;
        }
        catch (InvalidCreatureException e) {
            System.out.println("An error has occured while creating a creature.\n" + e.getMessage());
        }
        // =====================================================
        // STUDENT TO DO
        // =====================================================
        // 1. Create at least TWO additional SeaCreature subclasses.
        // 2. Add objects from those subclasses to this array.
        // 3. Make their movement behavior meaningfully different.
        //
        // Example once you create the class:
        // tank[2] = new Shark(...);
        // tank[3] = new Turtle(...);

        Aquarium aquarium = new Aquarium(tank);
        Scanner input = new Scanner(System.in);

        boolean running = true;

        System.out.println("====================================");
        System.out.println("        JAVA TERMINAL AQUARIUM");
        System.out.println("====================================");

        while (running) {
            printMenu();
            System.out.print("Choose an option: ");
            String choice = input.nextLine().trim();

            switch (choice) {
                case "1":
                    aquarium.display();
                    break;

                case "2":
                    aquarium.advanceTurn();
                    aquarium.display();
                    break;

                case "3":
                    aquarium.listCreatureDetails();
                    break;

                case "4":
                    running = false;
                    System.out.println("Self destruct sequence initiated.");
                    try {
                        Thread.sleep(1000);
                        System.out.println("3...");
                        Thread.sleep(1000);
                        System.out.println("2...");
                        Thread.sleep(1000);
                        System.out.println("1...");
                        Thread.sleep(1000);
                        File file2 = new File("explosionImage.txt");
                        Scanner scanner = new Scanner(file2);
                        while (scanner.hasNextLine()) {
                            System.out.println(scanner.nextLine());
                        }
                        scanner.close();
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                default:
                    aquarium.advanceTurn();
                    aquarium.display();
                    break;
            }
        }

        input.close();
    }

    private static void printMenu() {
        System.out.println();
        System.out.println("1. View Aquarium");
        System.out.println("2. Advance One Turn");
        System.out.println("3. View Creature Details");
        System.out.println("4. Quit");
    }

    private static File creaturesFile() {
        File file = new File("creatures.txt");
        if (!file.exists()) {
            file = new File("AquariumEthan-main/AquariumEthan-main/creatures.txt");
        }
        return file;
    }
}
