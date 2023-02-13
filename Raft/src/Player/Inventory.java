package Player;
import java.util.Iterator;
import java.util.List;

/**
 *  Inventory osztály. A Player gyerekosztálya.<br>
 *  Célja a player inventory menedzselése.
 */
public class Inventory extends Player{

    /**
     * Egy keresett karaktert számol egy listában, ami jelen esetben a player inventory
     * @param inventory Player inventory
     * @param searched A keresett karakter
     * @return Hány darab található az inventoryban
     */
    public static int inventorySearch(List<Character> inventory, char searched){
        int db = 0;
        for (Character character : inventory) {
            if (character == searched)
                db++;
        }
        return db;
    }

    /**
     * Iterátor segítségével végig megy a listán, ami jelen esetben az inventory és ha talál keresett nyersanyagot és még kell törölni, akkor kitörli
     * @param inventory Player inventory
     * @param resource A keresett karakter
     * @param counter Hányat töröltünk eddig
     * @param number Hány darabot szeretnénk törölni
     */
    public static void deleteFromInventory(List<Character> inventory, char resource, int counter, int number){
        Iterator<Character> iterator = inventory.iterator();
        while(iterator.hasNext()) {
            char elem = iterator.next();
            if(elem == resource && counter < number){
                iterator.remove();
                counter++;
            }
        }
    }
}
