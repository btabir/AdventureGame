import java.util.Scanner;

public class Player {

    private String name;
    private int damage;
    private int dodge;
    private int health;
    private int money;
    private String charName;
    private Inventory inventory;
    private int defHealth;

    Scanner input = new Scanner(System.in);


    public Player(String name) {
        this.name = name;
        this.inventory = new Inventory();
        //this.damage = damage;
        //this.health = health;
        //this.money = money;
        //this.charName = charName;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int getTotalDamage (){
        return damage + this.getInventory().getWeapons().getDamage();
    }
    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getDodge() {
        return dodge + this.getInventory().getArmors().getDodge();
    }

    public void setDodge(int dodge) {
        this.dodge = dodge;
    }

    public int getHealth() {
        if (this.health<0){
            health = 0;
        }
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getDefHealth() {

        return defHealth;
    }

    public void setDefHealth(int defHealth) {
        this.defHealth = defHealth;
    }

    public void selectChar() {

        GameChar[] charList = {new Samurai(), new Archer(), new Knight()};
        System.out.println();
        for (GameChar gameChar : charList) {
            System.out.println("Character : " + gameChar.getName() + "\t Id : " + gameChar.getId() + "\t Damage : " + gameChar.getDamage() +
                    "\t Heal : " + gameChar.getHealth() + "\t Money : " + gameChar.getMoney());
        }
        System.out.println();
        System.out.print("Please choose a character as enter Id : ");
        System.out.println();
        int selectChar = input.nextInt();
        switch (selectChar) {
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Archer());
                break;
            case 3:
                initPlayer(new Knight());
                break;
            default:
                initPlayer(new Samurai());
        }
        /*System.out.println("Choosen character : " + this.getName() + "\t Damage : " + this.getDamage() + "\t Heal : "
                + this.getHealth() + "\t Money : " + this.getMoney());
        System.out.println();

         */

    }

    public void initPlayer(GameChar gameChar) {
        this.setDamage(gameChar.getDamage());
        this.setHealth(gameChar.getHealth());
        this.setDefHealth(gameChar.getHealth());
        this.setMoney(gameChar.getMoney());
        this.setName(gameChar.getName());
    }

    public void printInfo() {
        System.out.println(
                "Your Heal : " + this.getHealth() +
                        "\t Your Gun : " + this.getInventory().getWeapons().getName() +
                        "\t Your Damage : " + this.getTotalDamage() +
                        "\t Your Armor : " + this.getInventory().getArmors().getName() +
                        "\t Your Dodge : " + this.getDodge() +
                        "\t Your Balance : " + this.getMoney());

    }



}
