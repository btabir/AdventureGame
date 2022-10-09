public class Obstacle {
    private String name;
    private int id;
    private int damage;
    private int health;
    private int award;
    private int defHealth;


    public Obstacle(String name, int id, int damage, int health,int award) {
        this.name = name;
        this.id = id;
        this.damage = damage;
        this.health = health;
        this.defHealth = health;
        this.award = award;

    }

    public Obstacle() {

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
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


    public int getAward() {
        return award;
    }

    public void setAward(int money) {
        this.award = money;
    }

    public int getDefHealth() {
        return defHealth;
    }

    public void setDefHealth(int defHealth) {
        this.defHealth = defHealth;
    }
}


