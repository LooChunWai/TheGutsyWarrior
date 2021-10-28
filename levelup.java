
class levelup {
    private double Health;
    private double Attack;
    private double Defense;
    private double Mana;

    public void statusupdate(String name, String playclass, int level, double health, double atk, double def,
            double mana) {
        health = 100 + 50 * level;
        if (playclass.equals("warrior")) {
            atk = 10 * 0.75 + 2 * level;
            def = 5 * 2.5 + 2 * level;

        } else if (playclass.equals("archer")) {
            atk = 10 * 2.5 + 2.5 * level;
            def = 5 / 4 + 0.5 * level;
        } else if (playclass.equals("mage")) {
            atk = 10 * 1.5 + 1.5 * level;
            def = 5 / 2 + 1 * level;
            mana = 20 + 5 * level;
        }

        System.out.println("Status had been upgraded based on level(no increment if there is not change in level)");
        System.out.println(name + ", You updated your status (maximum lavel = 5)");
        System.out.println("=============Your current status==================");
        System.out.println("Class : " + playclass);
        System.out.println("Health: " + health);
        System.out.println("Level : " + level);
        System.out.println("Attack: " + atk);
        System.out.println("Def   : " + def);
        System.out.println("Mana  : " + mana);
        System.out.println("=============Your current status==================");
        this.Attack = atk;
        this.Defense = def;
        this.Health = health;
        this.Mana = mana;
    }

    public double getAttack() {
        return Attack;
    }

    public double getDefense() {
        return Defense;
    }

    public double getHealth() {
        return Health;
    }

    public double getMana() {
        return Mana;
    }
}
