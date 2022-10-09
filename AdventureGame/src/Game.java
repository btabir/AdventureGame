import java.util.Scanner;

public class Game {

    private Scanner input = new Scanner(System.in);

        public void start () {
            System.out.println("Welcome to the Adventure Game!");
            System.out.print("Please enter a name : ");
            String playerName = input.next();
            Player player = new Player(playerName);
            System.out.println("Welcome to the Island " + playerName);
            player.selectChar();

            Location location  = null;
            while (true){
                player.printInfo();
                System.out.println();
                System.out.println("Please choose a area :" +
                        " \t 1- Safe House" +
                        "\t\t 2- Store " +
                        "\t\t 3 - Cave -  Award : Food" +
                        "\t\t 4 - Forest -  Award : Wood" +
                        "\t\t 5 - River -  Award : Water" +
                        "\t\t 0 - Exit" );
                int selectLoc = input.nextInt();
                switch (selectLoc){
                    case 0 :
                        location = null;
                    case 1:
                        location = new SafeHouse(player);
                        break;
                    case 2:
                        location = new ToolStore(player);
                        break;
                    case 3:
                        location = new Cave(player);

                        break;
                    case 4 :
                        location = new Forest(player);
                        break;
                    case 5 :
                        location = new River(player);
                        break;
                    default:
                        location = new SafeHouse(player);
                }

                if (location == null) {
                    System.out.println("Game over.See you soon.");
                    break;
                }

                if(!location.onLocation()){
                    System.out.println("Game Over!");
                    break;
                }
            }


        }
}
