public class ToolStore extends NormalLoc {
    public ToolStore(Player player) {
        super(player, "Store");
    }

    @Override
    public boolean onLocation() {
        System.out.println("Welcome to the store.What are you looking for ?");
        boolean showMenu = true;
        while (showMenu) {
            System.out.println("Please make your choice ! ");
            System.out.println();
            System.out.println("1- Weapons \t 2- Armors \t 3- Exit");
            int selectOpt = input.nextInt();

            while (selectOpt < 1 || selectOpt > 3) {
                System.out.println("You have entered an incorrect number.Please choose again.");
                selectOpt = input.nextInt();
            }

            switch (selectOpt) {
                case 1:
                    printWeapon();
                    buyWeapon();
                    break;
                case 2:
                    printArmors();
                    buyArmor();
                    break;
                case 3:
                    System.out.println("You have been returned to store");
                    System.out.println();
                    showMenu = false;
                    break;
            }
            return true;
        }

        return true;
    }

    public void printWeapon() {
        System.out.println("--- Weapons ---");
        System.out.println();
        System.out.print("Please choose a weapon with id for buy : ");
        System.out.println();
        for (Weapons w : Weapons.weapons()) {
            System.out.println("Id : " + w.getId() + "\t\t" + w.getName() + "\t" + "\t Price : " + w.getPrice() + "\t Damage : " + w.getDamage());
        }
        System.out.println();
        System.out.println("0 - Exit");
    }

    public void printArmors() {
        System.out.println("--- Armors ---");
        System.out.println();
        System.out.println("Please choose a armor with id for buy : ");
        System.out.println();
        for (Armors a : Armors.armors()) {
            System.out.println("Id : " + a.getId() + "\t\t" + a.getName() + " Armor " + "\t Price : " + a.getPrice() + "\t Dodge : " + a.getDodge());
        }
        System.out.println();
        System.out.println("0 - Exit");
    }


    //Satın alma
    public void buyWeapon() {

        int selectWeapon = input.nextInt();
        while (selectWeapon < 0 || selectWeapon > Weapons.weapons().length) {
            System.out.println("You have entered an incorrect number.Please choose again.");
            selectWeapon = input.nextInt();
        }
        if (selectWeapon != 0) {
            Weapons selectedWeapon = Weapons.getWeaponObjById(selectWeapon);
            if (selectedWeapon != null) {
                if (selectedWeapon.getPrice() > this.getPlayer().getMoney()) {
                    System.out.println("You don't have enough money.");
                } else {
                    int balance = this.getPlayer().getMoney() - selectedWeapon.getPrice();
                    System.out.println("You bought a " + selectedWeapon.getName());
                    System.out.println();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Your new balance is : " + this.getPlayer().getMoney());
                    System.out.println();
                    System.out.println("Your previous weapon : " + this.getPlayer().getInventory().getWeapons().getName());

                    this.getPlayer().getInventory().setWeapons(selectedWeapon);
                    System.out.println();
                    System.out.println("Your new weapon : " + this.getPlayer().getInventory().getWeapons().getName());
                    System.out.println();
                }
            }
        }

    }

    public void buyArmor() {

        int selectArmor = input.nextInt();
        while (selectArmor < 0 || selectArmor > Armors.armors().length) {
            System.out.println("You have entered an incorrect number.Please choose again.");
            selectArmor = input.nextInt();
        }

        if (selectArmor != 0) {
            Armors selectedArmor = Armors.getArmorsObjByID(selectArmor);
            if (selectedArmor != null) {
                if (selectedArmor.getPrice() > this.getPlayer().getMoney()) {
                    System.out.println("You don't have enough money");
                } else {
                    int balance = this.getPlayer().getMoney() - selectedArmor.getPrice();
                    System.out.println("You bought a " + selectedArmor.getName() + " armor.");
                    System.out.println();
                    this.getPlayer().setMoney(balance);

                    System.out.println("Your new balance is : " + this.getPlayer().getMoney());
                    System.out.println();
                    System.out.println("Your previous armor is: " + this.getPlayer().getInventory().getArmors().getName());

                    this.getPlayer().getInventory().setArmors(selectedArmor);
                    System.out.println();
                    System.out.println("Your new armor is: " + selectedArmor.getName() + " armor.");
                    System.out.println();
                }
            }
        }
    }
}

