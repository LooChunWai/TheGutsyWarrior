
import java.util.Scanner;
import java.util.Random;

class battle {
    choice player_1 = new choice();
    int playlv;
    double playhealth;
    double damage;
    private static double dragonHealth = 600;
    private static double dragonAttack = 25;
    private static double dragonFireBall = 30;
    public int chosennumber;

    public void fight(String playername, double health, int level, double attack, double def, double mana) {
        Random randnum = new Random();
        int monsterspawn = randnum.nextInt(3);
        String[] monster = { "Skeleton", "Slime", "Goblin" };
        // atk, def, health
        double[][] monsterstatus = { { 12, 2, 50 }, { 5, 3, 30 }, { 20, 0, 20 } };
        System.out.println("\nA " + monster[monsterspawn] + " has spawned!");
        while (monsterstatus[monsterspawn][2] > 0) {
            System.out.println("Figthing A " + monster[monsterspawn] + "\n==========================");
            System.out.println("Player \t\t\t Status \t Monster Status");
            System.out.printf("Health: \t\t%.2f\t\t%.2f\n", health, monsterstatus[monsterspawn][2]);
            System.out.println("Level : \t\t" + level + "\t\t" + "");
            System.out.printf("Attack: \t\t%.2f\t\t%.2f\n", attack, monsterstatus[monsterspawn][0]);
            System.out.printf("Def   : \t\t%.2f\t\t%.2f\n", def, monsterstatus[monsterspawn][1]);
            System.out.printf("Mana  : \t\t%.2f\n", mana);
            player_1.playeraction1();
            player_1.playerinput();
            chosennumber = player_1.getNumber();

            // 1. Attack\n 2. Cast a spell\n 3. Run
            if (chosennumber == 1) {

                monsterstatus[monsterspawn][2] -= (attack - monsterstatus[monsterspawn][1]);

                if (def < monsterstatus[monsterspawn][0]) {
                    damage = monsterstatus[monsterspawn][0] + def;
                    health = health - damage;
                } else {
                    damage = 0;
                    System.out.println("Your defense is high.");

                }
                System.out.println(playername + " deals " + attack + " damage and received " + damage + " damage");
                System.out.println("=====================================================================");

            } else if (chosennumber == 2) {
                if (mana >= 10) {
                    if (def > monsterstatus[monsterspawn][0]) {
                        System.out.println("Your defense is high.");
                        damage = 0;
                    } else {
                        monsterstatus[monsterspawn][0] -= def;
                    }

                    health = health - damage;
                    monsterstatus[monsterspawn][2] -= (attack * 1.5 - monsterstatus[monsterspawn][1]);
                    mana -= 10;
                    System.out.println(playername + " casted a fire ball and...");
                    System.out.println("deal damage " + (attack * 1.5) + " and received " + damage + " damage");
                    System.out.println("=====================================================================");
                } else {
                    System.out.println("You dont have enough mana to do so");
                }

            } else if (chosennumber == 3) {
                System.out.println(playername + " run away...");
                break;
            } else {
                health -= monsterstatus[monsterspawn][0];
                System.out.println("You missed your attack");
                System.out.println("You received damage," + monsterstatus[monsterspawn][0]);
            }

            if (monsterstatus[monsterspawn][2] <= 0) {
                System.out.println("You killed the " + monster[monsterspawn] + "...Level Up!");
                level += 1;

                // max level is 5
                if (level >= 5) {
                    level = 5;
                }
                System.out.println("Player Status");
                System.out.println("Health: " + health);
                System.out.println("Level : " + level);
                System.out.println("Attack: " + attack);
                System.out.println("Def   : " + def);
                System.out.println("Mana  : " + mana);
                System.out.println("=====================================================================");
            }
        }
        this.playhealth = health;
        this.playlv = level;

    }

    public void fight(String playername, double health, int level) {

        System.out.println("You meet The Bear Bear...");
        System.out.println("want to challange The Bear Bear ?");
        System.out.println("1. YES");
        System.out.println("2. NO");
        player_1.playerinput();
        chosennumber = player_1.getNumber();
        if (chosennumber == 1) {
            System.out.println("The Bear Bear ! You are too weak for me !!!");
            System.out.println("You gonna die !!!");
            health = 0;

        } else if (chosennumber == 2) {
            System.out.println("The Bear Bear says: Let me treat you with some honey ~");
            System.out.println("Ate the The Bear Bear's honey....leveled up 1 levels");
            level = level + 1;

            // max level is 5
            if (level >= 5) {
                level = 5;
            }
            System.out.println("Your level now is " + level + "\n====================");

        } else {

        }
        this.playhealth = health;
        this.playlv = level;
    }

    public void fight(String playername, double health) {
        System.out.println("You find a very kawaii white rabbit, it looks very tasty, how bout lets cook it ?...");
        System.out.println("Would you like to catch and eat it?");
        System.out.println("1.YES");
        System.out.println("2.NO");
        player_1.playerinput();
        chosennumber = player_1.getNumber();

        if (chosennumber == 1) {
            System.out.println("Rabbit is very kawaii(cute)，why you want to eat it... ");
            System.out.println("Cursed you!! You gonna die!");
            System.out.println("You\'ve been killed by a meteorite....");
            health = 0;
        } else if (chosennumber == 2) {
            System.out.println("Bunnie! Bunnie! Bunny Rabbbit!!");
            System.out.println("The Rabbit seems to like you :) ....health + 25");
            if (health < 200) {
                health += 25;
            } else {
                System.out.println("You are not injured, healing is not effective...");
            }

            System.out.println("Your current health is " + health + "\n=================================");
        }

        this.playhealth = health;

    }

    public void finalbattle(double health, double attack, int level, double def, double mana, String playclass) {
        Random randnum = new Random();

        System.out.println("\n==========The Dungeon==========");
        System.out.println("You met the boss! The G-Dragon!");

        while (dragonHealth > 0) {

            System.out.println("Player \t\t\t Status \t Monster Status");
            System.out.printf("Health: \t\t%.2f\t\t%.2f\n", health, dragonHealth);
            System.out.println("Level : \t\t" + level + "\t\t");
            System.out.printf("Attack: \t\t%.2f\t\t%.2f\n", attack, dragonAttack);
            System.out.printf("Def   : \t\t%.2f\n", def);
            System.out.printf("Mana  : \t\t%.2f\n", mana);
            System.out.println("=====================================================================");
            player_1.playeraction1();
            player_1.playerinput();
            int action = player_1.getNumber();
            int dragonMove = randnum.nextInt(100);

            if (action == 1) {
                dragonHealth = dragonHealth - attack;

                if (dragonMove >= 90) {
                    System.out.println("The Dragon Missed the attack");
                    System.out.println(
                            "You deal " + attack + " damage to the dragon and receive 0 damage due to the battle");
                    System.out.println("=====================================================================");
                } else if (dragonMove <= 90 && dragonMove >= 20) {
                    health = health - dragonAttack + def;
                    System.out.println("You deal " + attack + " damage to the dragon and receive " + dragonAttack
                            + " damage due to the battle");
                    System.out.println("=====================================================================");

                } else if (dragonMove <= 20) {
                    System.out.println("The dragon cast a fireball!");
                    health = health - dragonFireBall + def;
                    System.out.println("You deal " + attack + " damage to the dragon and receive " + dragonFireBall
                            + " damage due to the battle");
                    System.out.println("=====================================================================");

                }

            } else if (action == 2) {
                if (mana >= 10) {
                    mana -= 10;
                    dragonHealth = dragonHealth - attack * 1.5;
                    System.out.println("You cast a fire ball and...");
                    System.out.println("deal " + (attack * 1.5) + " damage to the dragon.");

                } else {
                    System.out.println("You dont have enough mana to do so...\n");
                }
            } else if (action == 3) {
                System.out.println("You run away... \n Dragon: What a shame...");
                System.out.println(
                        "You ended up hit by Dragon \n Dragon: You know the rule and so do I... Once you in, you cant out without you life!");
                health = 0;
                break;
            } else {
                System.out.println("Wrong Input, You missed your attack");
            }

            if (health <= 0) {
                System.out.println("You get killed by the dragon! \nDragon: What a shame...\nGamE Over");
                break;

            } else if (dragonHealth <= 0) {
                System.out.println("You defeated the dragon!");

            }

        }
        this.playhealth = health;

    }

    public int getPlaylv() {
        return playlv;
    }

    public double getPlayhealth() {
        return playhealth;
    }

}

class choice {
    private int number;

    public void playeraction1() {
        System.out.println("Enter the text to perform an action");
        System.out.println(" 1. Attack\n 2. Cast a spell\n 3. Run");

    }

    public void playerinput() {
        System.out.print(">");
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

}