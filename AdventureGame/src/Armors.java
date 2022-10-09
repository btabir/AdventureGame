public class Armors {

    private String name;
    private int id;
    private int dodge;
    private int price;

    public Armors(String name, int id, int dodge, int price) {
        this.name = name;
        this.id = id;
        this.dodge = dodge;
        this.price = price;
    }

    public static Armors [] armors (){

        Armors [] armorList = new Armors[3];
        armorList[0] = new Armors("Light",1,1,10);
        armorList[1] = new Armors("Medium",2,2,15);
        armorList[2] = new Armors("Heavy",3,3,25);

        return armorList;
    }

    public static Armors getArmorsObjByID (int id){
        for (Armors a :Armors.armors()){
            if (a.getId() == id){
                return a;
            }
        }
        return null;
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

    public int getDodge() {
        return dodge;
    }

    public void setDodge(int dodge) {
        this.dodge = dodge;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
