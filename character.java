import java.util.Scanner;

class character {
    public void status(String playername) {
        double health = 100;
        double attack = 10;
        int level = 1;
        double def = 5;
        System.out.println("Name   : " + playername);
        System.out.println("Level  : " + level);
        System.out.println("Hp     : " + health);
        System.out.println("Attack : " + attack);
        System.out.println("Def    : " + def);
    }

    // overloading
    public void status(String playername, int level, String classname, double health, double attack, double def) {
        System.out.println("Name   : " + playername);
        System.out.println("Level  : " + level);
        System.out.println("Class  : " + classname);
        System.out.println("Hp     : " + health);
        System.out.println("Attack : " + attack);
        System.out.println("Def    : " + def);
    }

    public void status(String playername, int level, String classname, double health, double attack, double def,
            double mana) {
        System.out.println("Name   : " + playername);
        System.out.println("Level  : " + level);
        System.out.println("Class  : " + classname);
        System.out.println("Hp     : " + health);
        System.out.println("Mana   : " + mana);
        System.out.println("Attack : " + attack);
        System.out.println("Def    : " + def);
    }
}

// inheritance
class playerclass extends character {
    private String Pclass; // private is used

    public void chosenclass(String playername, String playerclass) {
        Scanner input = new Scanner(System.in);
        System.out.println("Cynthia: Now, " + playername + ", choose your class");
        System.out.println("1: Warrior - A class with high defense but low attack");
        System.out.println("2: Mage    - A class which you can cast spells");
        System.out.println("3: Archer  - A class which you have high attack but low defense");
        System.out.print(">");
        playerclass = input.nextLine();
        if (playerclass.equals("1")) {
            playerclass = "warrior";

        } else if (playerclass.equals("2")) {
            playerclass = "mage";

        } else if (playerclass.equals("3")) {
            playerclass = "archer";

        } else {
            System.out.println("Cynthia: Why you dont choose a class...");
            System.out.println("Cynthia: I am very disappointed with you...");
            System.out.println(
                    "The adventure ended and all the villager are angry with you, you got kicked out from the world.");
            System.out.println("GamE OveR!");
            playerclass = "Loser";
        }

        this.Pclass = playerclass;
    }

    public String getPclass() {
        return Pclass;
    }

}

class warrior extends playerclass {

    double health;
    double attack;
    double def;

    @Override
    public void status(String playername, int level, String classname, double health, double attack, double def) {
        attack = attack * 0.75;
        def = def * 2.5;

        System.out.println("Name   : " + playername);
        System.out.println("Level  : " + level);
        System.out.println("Class  : " + classname);
        System.out.println("Hp     : " + health);
        System.out.println("Attack : " + attack);
        System.out.println("Def    : " + def);

        this.health = health;
        this.attack = attack;
        this.def = def;
    }

    public double getHealth() {
        return health;
    }

    public double getAttack() {
        return attack;
    }

    public double getDef() {
        return def;
    }

}

class mage extends playerclass {
    double health;
    double attack;
    double def;
    double mana = 20;

    // overriding implement
    @Override
    public void status(String playername, int level, String classname, double health, double attack, double def) {
        attack = attack * 1.5;
        def = def / 2;

        System.out.println("Name   : " + playername);
        System.out.println("Level  : " + level);
        System.out.println("Class  : " + classname);
        System.out.println("Hp     : " + health);
        System.out.println("Mana   : " + mana);
        System.out.println("Attack : " + attack);
        System.out.println("Def    : " + def);

        this.health = health;
        this.attack = attack;
        this.def = def;

    }

    public double getHealth() {
        return health;
    }

    public double getAttack() {
        return attack;
    }

    public double getDef() {
        return def;
    }

    public double getMana() {
        return 20;
    }

}

class archer extends playerclass {
    double health;
    double attack;
    double def;

    @Override
    public void status(String playername, int level, String classname, double health, double attack, double def) {
        attack = attack * 2.5;
        def = def / 4;

        System.out.println("Name   : " + playername);
        System.out.println("Level  : " + level);
        System.out.println("Class  : " + classname);
        System.out.println("Hp     : " + health);
        System.out.println("Attack : " + attack);
        System.out.println("Def    : " + def);

        this.health = health;
        this.attack = attack;
        this.def = def;
    }

    public double getHealth() {
        return health;
    }

    public double getAttack() {
        return attack;
    }

    public double getDef() {
        return def;
    }
}