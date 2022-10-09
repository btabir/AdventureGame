public class SafeHouse extends NormalLoc{
    public SafeHouse(Player player) {
        super(player, "Safe House");
    }

    public boolean onLocation (){
        System.out.println("You are in the safe house.Your health is full now.");
        this.getPlayer().setHealth(getPlayer().getDefHealth());
        return true;
    }
}
