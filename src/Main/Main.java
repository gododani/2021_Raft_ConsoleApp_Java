package Main;
import Enemy.Shark;
import Resources.ResourceGenerate;
import World.World;
import Player.Player;
import java.util.Scanner;
public class Main{
    /**
     * Ez alapján vannak kiíratások például, ha meghal a felhasználó, akkor -1-re állítódik és kilép a forból.<br>
     * Van egy if() a végén ami pont azért van, hogy ha úgy lépett ki a for-ból, hogy nem ment végig, <br>
     * akkor ne írja ki, hogy győzött a player. A waterstarter a víztisztító építésénél fontos, a kiírásban van szerepe.<br>
     * Ezen kívül a Main tartalma: <br>
     *     Első fele: Nyersanyagok mozgatása és újak generálása, map kiírás, cápa mozgás, hiba üzenet esetén hiba kiírás, egyéb üzenetek kiírása például sikeres építkezés jelzése, halál vizsgálat<br>
     *     Második fele: Játékmenettel kapcsolatos kiírások, input vizsgálatok, mozgás, cselekvés metódusok meghívása
     */
    public static int roundNumber = 1;
    public static int waterStarter = 0;
    public static void main(String[] args) {
        ResourceGenerate r = new ResourceGenerate();
        Player player = new Player();
        Shark shark = new Shark();
        World map = new World();
        Scanner be = new Scanner(System.in);
        int segedHiba = 0, lepes = 0;
        for (int i = 1; i <= 1000; i++){
            r.moveResources();
            r.generateRandomResource();
            map.printWorld(player,shark);
            shark.moveDirection();
            if(!player.getHiba().equals("")){
                System.out.println(player.getHiba());
                i--;
                segedHiba++;
            }
            System.out.println("Round: " + i);
            System.out.println();
            if(roundNumber > 1 && segedHiba == 0){
                player.setWater(player.getWater()-1);
                player.setFood(player.getFood()-1);
            }
            if(!player.getFeedbackPrint().equals(""))
                System.out.println(player.getFeedbackPrint());
            if(waterStarter == 1){
                System.out.println("Rounds until enough water to collect: "+player.getWaterCooldown());
                player.setWaterCooldown(player.getWaterCooldown()-1);
                waterStarter = 0;
            }
            if(player.getFeedbackPrint().equals("Building was succesful!") || player.getFeedbackPrint().equals("Bad luck. You did not catch any fish!") || player.getFeedbackPrint().equals("You caught a fish!"))
                player.waterPrint(player);
            else if(!player.getWaterPrint().equals(""))
                System.out.println(player.getWaterPrint());
            if(player.getFeedbackPrint().equals("Building was succesful!") || player.getFeedbackPrint().equals("Bad luck. You did not catch any fish!") || player.getFeedbackPrint().equals("You caught a fish!"))
                player.cookPrint(player);
            player.setHiba("");
            segedHiba = 0;
            if(player.getWater() <= 0 || player.getFood() <= 0){
                System.out.println("You died!");
                roundNumber = -1;
                break;
            }
            System.out.println(player);
            System.out.println("What is your next move?");
            System.out.println("1 -> Moving, 2 -> Action");
            lepes = doWhile(lepes,be,1,2);
            if(lepes == 1){
                lepes = directionPrint(be);
                player.moveDirection(lepes);
                player.waterPurifier();
                player.cook();
            }else{
                System.out.println("1 -> Building, 2 -> Fishing, 3 -> Pick up resource");
                lepes = doWhile(lepes,be,1,3);
                if (lepes == 1) {
                    System.out.println("1 -> Platform, 2 -> Fishing net, 3 -> Cooker, 4 -> Water purifier, 5 -> Spear");
                    lepes = doWhile(lepes, be, 1, 5);
                    if (lepes == 1)
                        player.buildDirection(buildPrint(be), 1);
                    else if (lepes == 2)
                        player.buildDirection(buildPrint(be), 2);
                    else if (lepes == 3)
                        player.buildDirection(buildPrint(be), 3);
                    else if (lepes == 4)
                        player.buildDirection(buildPrint(be), 4);
                    else if (lepes == 5)
                        player.buildDirection(buildPrint(be), 5);
                } else if (lepes == 2)
                    player.fishing(player.getPositionY(), player.getPositionX());
                else if (lepes == 3)
                    player.takeResource();
            }
            roundNumber++;
        }
        if(roundNumber > 0) System.out.println("Congratulation, You won!");
    }

    /**
     * Célja az inputok ellenörzése, hogy csak a megfelő értékeket lehessen beírni
     * @param lepes Változó amiben elmentődik a player által beírt szám
     * @param be Player gépelése
     * @param counterMin Minimum
     * @param counterMax Maximum
     * @return lépés
     */
    public static int doWhile(int lepes, Scanner be, int counterMin, int counterMax){
        do {
            while (!be.hasNextInt()){
                be.next();
            }
            lepes = be.nextInt();
        }while (lepes < counterMin || lepes > counterMax);
        return lepes;
    }

    /**
     * Célja lerövidíteni a sok kiírástés.<br>
     * Megkérdezi a playert, hogy hova akar építeni és várja a választ
     * @param be Amit a player beír
     * @return Beírt érték
     */
    public static int buildPrint(Scanner be){
        System.out.println("Where do you want to build?");
        return directionPrint(be);
    }

    /**
     * Célja lerövidíteni a sok kiírástés<br>
     * Kiírja az irány lehetőségeket és várja a választ<br>
     * Meghívja a doWhile() metódust és paraméterben megadja a minimumot és maximumot amit a player beírhat
     * @param be Amit a player beír
     * @return Beírt érték
     */
    public static int directionPrint(Scanner be){
        System.out.println("1 -> Up, 2 -> Up to the right, 3 -> Right, 4 -> Down to the right, 5 -> Down, 6 -> Down to the left, 7 -> Left, 8 -> Up to the left");
        int lepes = 0;
        return doWhile(lepes,be,1,8);
    }
}