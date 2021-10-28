import java.util.Scanner;
import java.util.Random;

class game {
    protected String playername;
    protected String playerclass;
    private static int level = 1;
    double health = 100, attack = 10, def = 5, mana = 0;

    public void sgame() {
        Scanner input = new Scanner(System.in);
        storyline mystory = new storyline();
        character p = new character();
        playerclass playclass = new playerclass();
        Exit exit = new Exit();
        battle newb = new battle();
        levelup Upup = new levelup();

        mystory.chapter1();

        mystory.chapter2(playername);

        playername = mystory.getPlayername();

        System.out.println("=============Your current status==================");
        p.status(playername);
        System.out.println("-----------------------------");

        playclass.chosenclass(playername, " ");

        System.out.println(playername + ", you are a " + playclass.getPclass());
        playerclass = playclass.getPclass();

        System.out.println("-----------------------------");

        if (playerclass.equals("warrior")) {
            warrior player1 = new warrior();
            System.out.println("Your new status");
            player1.status(playername, level, playerclass, health, attack, def);
            health = player1.getHealth();
            attack = player1.getAttack();
            def = player1.getDef();

        } else if (playerclass.equals("mage")) {
            mage player1 = new mage();
            System.out.println("Your new status");
            player1.status(playername, level, playerclass, health, attack, def);
            health = player1.getHealth();
            attack = player1.getAttack();
            def = player1.getDef();
            mana = player1.getMana();

        } else if (playerclass.equals("archer")) {
            archer player1 = new archer();
            System.out.println("Your new status");
            player1.status(playername, level, playerclass, health, attack, def);
            health = player1.getHealth();
            attack = player1.getAttack();
            def = player1.getDef();

        } else if (playerclass.equals("Loser")) {
            exit.exit();
            return;

        }

        int location = 1;
        System.out.println("---------------------------------");
        System.out.println("Cynthia: Now, lets shart the adventure choose your way to go! ");
        System.out.println("Now you are in town.\n");
        while (health > 0) {
            System.out.println("Where you want to go?");
            System.out.println("1. Head to the town");
            System.out.println("2. Head to the forest");
            System.out.println("3. Rest and show status");
            System.out.println("4. Head to the Dungeon (The Dragon\'s lair)");
            System.out.println("5. Go to upgrade field(where to level up)");
            System.out.println("6. End your Adventure.");
            System.out.print("Enter your input: ");
            int num = input.nextInt();
            System.out.println("");

            if (num == location) {
                System.out.println("---------------------------------");
                System.out.println("You are in the current selected location\nSelect another way!\n");

            } else if (num == 1) {
                System.out.println("Go back to town!");
                location = 1;
            } else if (num == 2) {
                location = 2;
                boolean forest = true;
                while (health > 0 && forest) {
                    System.out.println("\nCynthia: Lets go to the forest~");
                    System.out.println("1. Move forward   2. Leave");
                    System.out.print(">");
                    int nextmove = input.nextInt();
                    System.out.println("");

                    if (nextmove == 1) {
                        Random rannum = new Random();
                        int randnum = rannum.nextInt(4);

                        if (randnum == 1) {
                            newb.fight(playername, health, level, attack, def, mana);
                            level = newb.getPlaylv();
                            health = newb.getPlayhealth();

                        } else if (randnum == 2) {
                            newb.fight(playername, health, level);
                            level = newb.getPlaylv();
                            health = newb.getPlayhealth();

                        } else if (randnum == 3) {
                            newb.fight(playername, health);
                            health = newb.getPlayhealth();

                        } else {
                            System.out.println("Nothing happen....");
                            System.out.println("============================");
                        }

                    } else {
                        System.out.println("You left the forest~");
                        forest = false;
                        break;
                    }
                    if (health <= 0) {
                        System.out.println("\nYou are out of health~\n");
                        forest = false;
                        System.out.println("GamE OveR");
                        exit.exit();
                        break;
                    }

                }

            } else if (num == 3) {
                location = 3;
                System.out.println("-----------------------------\nHave a nice sleep... Sleep tight!");
                System.out.println("\n=============Your current status==================");
                health = health + 50 * level;
                if (playerclass.equals("mage")) {
                    mana = 20 + 5 * level;
                }

                if (health >= (100 + 50 * level)) {
                    health = 100 + 50 * level;
                }

                p.status(playername, level, playerclass, health, attack, def, mana);
                System.out.println("-----------------------------");

            } else if (num == 4) {
                System.out.println("You go to the dunguen");
                newb.finalbattle(health, attack, level, def, mana, playerclass);

                health = newb.getPlayhealth();

                if (health <= 0) {

                    exit.exit();
                    break;

                } else {
                    // dragon chapter storyline
                    mystory.lastchapter();
                    exit.exit();
                    break;

                }

            } else if (num == 5) {
                location = 5;
                Upup.statusupdate(playername, playerclass, level, health, attack, def, mana);
                attack = Upup.getAttack();
                def = Upup.getDefense();
                health = Upup.getHealth();
                mana = Upup.getMana();

            } else if (num == 6) {
                System.out.println("Cynthia: Why you want to leave...\nGamE OveR");
                exit.exit();
                break;
            }

        }

    }
}