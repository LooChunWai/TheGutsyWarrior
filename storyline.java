import java.util.Scanner;

class storyline extends game {
    private String Playername;

    public void chapter1() {
        Scanner input = new Scanner(System.in);
        System.out.println("You have been waken up by a light shining toward your eyes....(press enter to continue)");
        input.nextLine();
        System.out.println("??: Hello human, are you awake? ..*poke* ..*poke*... (press enter to continue)");
        input.nextLine();
    }

    public void chapter2(String playername) {
        Scanner input = new Scanner(System.in);
        System.out.println(
                "The scorching hot sun outside effulges the whole land ... It was a hot summer afternoon after all ...(press enter to continue) ");
        input.nextLine();

        System.out.println(
                "You are rushing back to your cozy home and it seems like you are crossing the road without even looking at the traffic! ...(press enter to continue)");
        input.nextLine();

        System.out.println("You saw a lorry heading towards you at a high speed! ...(press enter to continue)");
        input.nextLine();

        System.out.println("_______________________________________________________________\n");
        System.out.println("You woke up. It seems like your head is heavy, you are very dizzy.");
        System.out.println("");
        System.out.println("Looking gloomy, you saw a fairy-like elf fluttered upon you.");
        System.out.println(
                "The beautiful fairy elf, wearing a big grin on her face, whispers to your ear ...(press enter to continue)");
        input.nextLine();

        System.out.println("\n\n??: Who are you?...");
        System.out.print("Enter your name: ");
        playername = input.nextLine();
        this.Playername = playername;

        System.out.println("??: Hi, " + playername + " Nice to meet you! ...(press enter to continue)");
        input.nextLine();

        System.out.println(playername + ": Who are you ?? Where am I ?!! ...(press enter to continue) ");
        input.nextLine();

        System.out.println(
                "??: Hello! My name is Cynthia... You seem to be out of place here... Maybe you do not belong to here. ...(press enter to continue)");
        input.nextLine();

        System.out.println(
                "You looked around the surrondings and, indeed it seemed totally out of place... Everything looks different, the people, the surroundings.. they look totally different! The ornaments and even the building designs look like as if it came from Victorian Era... But why? ...(press enter to continue)");
        input.nextLine();

        System.out.println("Cynthia: What\'s wrong?");
        System.out.println(
                "It was at this moment, you found out that you were reincarnated to another dimension ...(press enter to continue)");
        input.nextLine();

        System.out.println(playername + ": Oh, nn.. n... nothing... ...(press enter to continue)");
        input.nextLine();

        System.out.println("Cynthia: Let\'s start the adventure then!");
        System.out.println(playername + ": Oo.. ok, wwait... what adventure?");
        input.nextLine();
    }

    public String getPlayername() {
        return Playername;
    }

    // System.out.println("");

    public void lastchapter() {
        Scanner input = new Scanner(System.in);
        int endingdecision = 0;
        do {
            System.out.println("Now is your chance to decide to kill the dragon or not...");
            System.out.println("1. kill it | 2. not to kill it\n");
            System.out.print(">Enter your decision: ");
            endingdecision = input.nextInt();
            System.out.println("");

            if (endingdecision == 2) {
                System.out.println("You decided not to kill the dragon at the last moment...");
                System.out.println("");
                System.out.println("G-Dragon and you have become very good friends!");
            } else if (endingdecision == 1) {
                System.out.println("You gave a final blow to the dragon! Yeahhh!");
                System.out.println("The dragon spit out its very last breath.");
                System.out.println("Congratulations! You have become the hero of the town!");
            } else {
                System.out.println("Come on, try again!");
                endingdecision = 0;
            }

        } while (endingdecision == 0);
        System.out.println("________________________________________________");
        System.out.println("That\'s all folks!");
        System.out.println("");
        System.out.println("-----=====THE END=====-----");
    }
}