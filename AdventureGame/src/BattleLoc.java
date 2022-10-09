import java.util.Random;

public abstract class BattleLoc extends Location {

    private Obstacle obstacle;
    private String award;
    private int maxObstacle;

    public BattleLoc(Player player, String name, Obstacle obstacle, String award, int maxObstacle) {
        super(player, name);
        this.obstacle = obstacle;
        this.award = award;
        this.maxObstacle = maxObstacle;
    }

    @Override
    public boolean onLocation() {

        int obstacleNumber = this.randomObstacle();
        System.out.println("You are now at " + this.getName());
        System.out.println("Watch out! " + this.randomObstacle() + " " + this.getObstacle().getName() + "s" + " lives here!");
        System.out.println("If you want to fight with them press F. If you don't want to fight with them press R.");
        String selectFightCase = input.nextLine();
        selectFightCase = selectFightCase.toUpperCase();

        if (selectFightCase.equals("F")) {
            System.out.println("You choosed to fight!");
            if (combat(obstacleNumber)) {
                System.out.println("You have beated all " + this.getObstacle().getName() + " at the " + this.getName());
                return true;
            }
        }

        if (this.getPlayer().getHealth() < 0) {
            System.out.println("You DEAD!");
            return false;
        }

        return true;
    }

    public boolean combat(int obstacleNumber) {

        for (int i = 1; i < obstacleNumber; i++) {
            this.getObstacle().setHealth(this.getObstacle().getDefHealth());
            playerStats();
            obstacleStats(i);
            while (this.getPlayer().getHealth() > 0 && this.getObstacle().getHealth() > 0) {
                System.out.println("Ready for Fight with " + getObstacle().getName() + "!");
                System.out.println("Please press H for hit. If you want to run away press A.");
                String selectCombat = input.nextLine();
                if (selectCombat.equals("H")) {
                    System.out.println("You have hit the " + getObstacle().getName());
                    this.getObstacle().setHealth(this.getObstacle().getHealth() - this.getPlayer().getTotalDamage());
                    afterHit();
                    if (this.getObstacle().getHealth() > 0) {
                        System.out.println();
                        System.out.println(this.getObstacle().getName() + " hit you.");
                        int obstacleDamage = this.getObstacle().getDamage() - (this.getPlayer().getInventory().getArmors().getDodge());
                        if (obstacleDamage < 0) {
                            obstacleDamage = 0;
                        }
                        this.getPlayer().setHealth(this.getPlayer().getHealth() - obstacleDamage);
                        afterHit();
                    }
                } else {
                    return false;
                }
            }

            if (this.getObstacle().getHealth() == 0) {
                System.out.println("You have beated the " + i + ". " + this.getObstacle().getName());
                System.out.println("You have earned " + this.getObstacle().getAward() + " coin");
                this.getPlayer().setMoney(this.getPlayer().getMoney()+this.getObstacle().getAward());
                System.out.println("Your current balance : " + this.getPlayer().getMoney());
            }
        }
        return false;
    }

    public void afterHit() {
        System.out.println("Your health : " + getPlayer().getHealth());
        System.out.println(this.getObstacle().getName() + "'s health : " + this.getObstacle().getHealth());

    }

    public void playerStats() {
        System.out.println();
        System.out.println("--------Player Stats--------");
        System.out.println("Your health : " + getPlayer().getHealth());
        System.out.println("Your gun : " + getPlayer().getInventory().getWeapons().getName());
        System.out.println("Your armor : " + getPlayer().getInventory().getArmors().getName());
        System.out.println("Your damage : " + getPlayer().getTotalDamage());
        System.out.println("Your dodge : " + getPlayer().getInventory().getArmors().getDodge());
        System.out.println("Your balance : " + getPlayer().getMoney());
    }

    public void obstacleStats(int i) {
        System.out.println();
        System.out.println(i + "." + this.getObstacle().getName() + " Stats");
        System.out.println(this.getObstacle().getName() + "'s health : " + getObstacle().getHealth());
        System.out.println(this.getObstacle().getName() + "'s damage : " + getObstacle().getDamage());
        System.out.println(this.getObstacle().getName() + "'s award money : " + getObstacle().getAward());
    }

    public int randomObstacle() {
        Random r = new Random();
        return r.nextInt(this.getMaxObstacle()) + 1;// sadece 3 olursa 0 1 ya da 2 olur o yüzden artı 1 ekliyoruz.
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }
}
