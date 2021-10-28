import java.util.Scanner;

public class TheGutsyWarriorRPG {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("---Welcome to The Gutsy Warrior RPG  Games---");
        System.out.println("----Please Enter 1 to start and 2 to exit----");

        while (true) {
            System.out.print("Enter your input: ");
            int start = input.nextInt();

            if (start == 1) {
                System.out.println("Game Start!\n");
                game gamestarting = new game();
                gamestarting.sgame();
                break;
            } else if (start == 2) {
                Exit exit = new Exit();
                exit.exit();
                break;
            } else {
                System.out.println("Wrong input!\n");
            }
        }
    }
}

class Exit {
    public void exit() {
        System.out.println("Thanks for playing the game!");

        System.out.println("\nThis game was Created by \n\nBu Zhen Hui\nChan Chun Lim\nLoo Chun Wai\n");
    }

}