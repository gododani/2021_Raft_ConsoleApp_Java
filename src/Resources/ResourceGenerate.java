package Resources;
import Food.Potato;
import Player.Player;
import World.World;
import java.util.List;

/**
 * ResourceGenerate osztály. A World gyereke.<br>
 * Célja A nyersanyagok legenerálása és azok mozgatása.
 */
public class ResourceGenerate extends World {
    /**
     * Nyersanyagokat tároló 2d tömb
     */
    public static char[][]resources;

    /**
     * A ResourceGenerate konstruktora. Tömb méretének beállítása.
     */
    public ResourceGenerate(){
        resources = new char[height][width];
    }

    /**
     * Ez a metódus felelős azért, hogy hány nyersanyag legyen legenerálva.<br>
     * Generál 1 számot 1-3 között és elmenti a db változóban. Ez felel majd azért, hogy hány nyersanyag legyen az adott körben generálva.<br>
     * resourceGenerator() - Generál 3 nyersanyagot. Minden nyersanyag egy 1-100 közötti szám.<br>
     * positionGenerator() - Generál 3 koordinátát. Mivel mindig az első sorban generálódnak, ezért csak az Y koordinátát kell generálni 0-35 (pálya szélesség) között.
     *
     */
    public void generateRandomResource(){
        int db = (int)Math.floor(Math.random()*(3)+1);
        int firstResource = resourceGenerator();
        int secondResource = resourceGenerator();
        int thirdResource = resourceGenerator();
        int firstPosition = positionGenerator();
        int secondPosition = positionGenerator();
        int thirdPosition = positionGenerator();
        switch(db){
            case 1 -> resourceOneGenerator(firstResource,firstPosition);
            case 2 -> resourceTwoGenerator(firstResource,firstPosition,secondResource,secondPosition);
            case 3 -> resourceThreeGenerator(firstResource,firstPosition,secondResource,secondPosition,thirdResource,thirdPosition);
        }
    }

    /**
     * Random generál 1 számot
     * @return 1-100 közötti szám
     */
    public int resourceGenerator(){
        return (int)Math.floor(Math.random()*(100)+1);
    }

    /**
     * Random generál 1 számot
     * @return 0-35 (pálya szélesség) közötti szám
     */
    public int positionGenerator(){
        return (int)Math.floor(Math.random()*(35)+0);
    }

    /**
     * Ha db 1-re lett generálva, akkor ez a metódus fut le és megkapja a nyersanyagot és a pozíciót.<br>
     * Ezután a nyersanyag értéke alapján besorolja, hogy deszka (32%), levél (32%), hulladék (32%) vagy hordó (4%).
     * Végül ha megtörtént a besorolás, akkor hozzá adja a resources tömbhöz a megfelelő koordinátára a megfelelő nyersanyag nevét.
     * @param resource Nyersanyag (1-100 közötti szám)
     * @param position Nyersanyag koordinátája (0-35 közötti szám)
     */
    public void resourceOneGenerator(int resource, int position){
        addResourceToMap(resource,position);
    }

    /**
     * Ugyan az, mint a resourceOneGenerator() csak 2 nyersanyag lesz legenerálva és 2 nyersaynagot ad a tömbhöz.
     * @param resourceOne Első nyersanyag (1-100 közötti szám)
     * @param positionOne Első nyersanyag koordinátája (0-35 közötti szám)
     * @param resourceTwo Második nyersanyag (1-100 közötti szám)
     * @param positionTwo Második nyersanyag koordinátája
     */
    public void resourceTwoGenerator(int resourceOne,int positionOne, int resourceTwo, int positionTwo){
        do {
            positionTwo = positionGenerator();
        }while(positionOne == positionTwo);
        addResourceToMap(resourceOne,positionOne);
        addResourceToMap(resourceTwo,positionTwo);
    }

    /**
     * Ugyan az, mint a resourceOneGenerator() és resourceTwoGenerator() csak 3 nyersanyag lesz legenerálva és 3 nyersaynagot ad a tömbhöz.
     * @param resourceOne Első nyersanyag (1-100 közötti szám)
     * @param positionOne Első nyersanyag koordinátája (0-35 közötti szám)
     * @param resourceTwo Második nyersanyag (1-100 közötti szám)
     * @param positionTwo Második nyersanyag koordinátája
     * @param resourceThree Harmadik nyersanyag (1-100 közötti szám)
     * @param positionThree Harmdaik nyersanyag koordinátája
     */
    public void resourceThreeGenerator(int resourceOne,int positionOne, int resourceTwo, int positionTwo, int resourceThree, int positionThree){
        do {
            positionTwo = positionGenerator();
            positionThree = positionGenerator();
        }while(positionOne == positionTwo || positionOne == positionThree || positionTwo == positionThree);
        addResourceToMap(resourceOne,positionOne);
        addResourceToMap(resourceTwo,positionTwo);
        addResourceToMap(resourceThree,positionThree);
    }

    /**
     * Hozzáadja a megfelelő nyersanyagot a térképhez
     * @param resource Nyersanyag amit hozzáad
     * @param position Koordináta ahova hozzáadja
     */
    public static void addResourceToMap(int resource, int position){
        if(resource < 33)
            resources[Plank.getPositionX()][position] = Plank.getName();
        else if(resource > 32 && resource < 65)
            resources[Leaf.getPositionX()][position] = Leaf.getName();
        else if(resource > 64 && resource < 97)
            resources[Junk.getPositionX()][position] = Junk.getName();
        else
            resources[Barrel.getPositionY()][position] = Barrel.getName();
    }

    /**
     * A Hordó egy speciális nyersanyag.<br>
     * Minden hordó 5 random nyersanyagot tartalmaz, ezért generál 5 random számot 1-4 között és ezeket átadja a barrelResourceToInventory() metódusnak.<br>
     * Ezeken kívül átad még egy listát, ami jelen esetben az inventory, 1 számot ami a nyersanyag kódját jelenti és végül magát a nyersanyag nevét<br>
     * @param inventory Player inventory amiben el lesznek tárolva a nyersanyagok
     */
    public static void barrelResourceGenerator(List<Character>inventory){
        int first = (int)Math.floor(Math.random()*(4)+1);
        int second = (int)Math.floor(Math.random()*(4)+1);
        int third = (int)Math.floor(Math.random()*(4)+1);
        int fourth = (int)Math.floor(Math.random()*(4)+1);
        int fifth = (int)Math.floor(Math.random()*(4)+1);
        barrelResourceToInventory(inventory,first,second,third,fourth,fifth,1,Plank.getName());
        barrelResourceToInventory(inventory,first,second,third,fourth,fifth,2,Leaf.getName());
        barrelResourceToInventory(inventory,first,second,third,fourth,fifth,3,Junk.getName());
        barrelResourceToInventory(inventory,first,second,third,fourth,fifth,4, Potato.getName());
    }

    /**
     * Megkap a barrelResourceGenerator() metódusból minden adatot amire szükség van ahhoz, hogy belekerüljenek az inventoryba a nyersanyagok.
     * @param inventory Player inventory
     * @param first Első nyersanyag. 1-4 közötti szám
     * @param second Második nyersanyag. 1-4 közötti szám
     * @param third Harmadik nyersanyag. 1-4 közötti szám
     * @param fourth Negyedik nyersanyag. 1-4 közötti szám
     * @param fifth Ötödik nyersanyag. 1-4 közötti szám
     * @param resourceCode Nyersanyag kód 1: Deszka, 2: Levél, 3: Hulldaék, 4: Krumpli
     * @param name Nyersanyag neve
     */
    public static void barrelResourceToInventory(List<Character> inventory, int first,  int second, int third, int fourth, int fifth, int resourceCode, char name){
        if(first == resourceCode) inventory.add(name);
        if(second == resourceCode) inventory.add(name);
        if(third == resourceCode) inventory.add(name);
        if(fourth == resourceCode) inventory.add(name);
        if(fifth == resourceCode) inventory.add(name);
    }

    /**
     * Célja a nyersanyagok mozgatása. Ehhez végig megy a resources 2d tömbön VISSZAFELE.<br>
     * Azért visszafele, mert ha csak rendesen végig mennénk rajta, akkor minden sorban 1-el lejjebb tolná a nyersanyagot ami aztjelenti, hogy az első sorból az utolsó sorba kerülnének 1 kör alatt amit nem szeretnénk.<br>
     * Minden koordinátán megnézi, hogy található e ott valamelyik nyersanyag neve.<br>
     * Ha igen, akkor az aktuális sort kinullázza és az egyel alatta lévő sorba bekerül.<br>
     * Első vizsgálatban (198.sor) azok a nyersanyagokat törli, akik végig mentek a pályán és az aljára kerültek, mivel fix a méret, így ha nem törölnénk, akkor tömb túlindexelés miatt errort dobna.
     * Második vizsgálatban (201.sor) a nyersanyagok autómatikus eltárolása történik, ha az adott koordinátán van építve háló.
     */
    public void moveResources(){
        for (int i = height-1; i >= 0; i--){
            for (int j = width-1; j >= 0; j--){
                if(resources[height-1][j] == Plank.getName() || resources[height-1][j] == Leaf.getName() || resources[height-1][j] == Junk.getName() || resources[height-1][j] == Barrel.getName()){
                    resources[height-1][j] = '\u0000';
                }else{
                    if(Player.builded[i][j] == 'X' && resources[i-1][j] == Plank.getName() || Player.builded[i][j] == 'X' && resources[i-1][j] == Leaf.getName() || Player.builded[i][j] == 'X' && resources[i-1][j] == Junk.getName() || Player.builded[i][j] == 'X' && resources[i-1][j] == Barrel.getName()){
                        Player.takeAtPosition(i-1,j);
                    }
                    else if(resources[i][j] == Plank.getName()){
                        resources[i][j] = '\u0000';
                        resources[i+1][j] = Plank.getName();
                    }else if(resources[i][j] == Leaf.getName()){
                        resources[i][j] = '\u0000';
                        resources[i+1][j] = Leaf.getName();
                    }else if(resources[i][j] == Junk.getName()){
                        resources[i][j] = '\u0000';
                        resources[i+1][j] = Junk.getName();
                    }else if(resources[i][j] == Barrel.getName()){
                        resources[i][j] = '\u0000';
                        resources[i+1][j] = Barrel.getName();
                    }
                }
            }
        }
    }
}