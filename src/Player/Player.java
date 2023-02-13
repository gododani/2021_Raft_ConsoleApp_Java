package Player;
import Food.*;
import Resources.*;
import World.World;
import java.util.*;

import static Main.Main.*;

/**
 * Player osztály. A World gyerekosztálya.<br>
 * A Player adataiért és cselekvéseiért felelős.
 */
public class Player extends World {
    /**
     * Étel
     */
    private int food;
    /**
     * Víz
     */
    private int water;
    /**
     * Y koordináta
     */
    private int positionY;
    /**
     * Y koordináta
     */
    private int positionX;
    /**
     * 2d tömb amiben az eltárolt dolgok tárolódnak
     */
    public static char[][] builded;
    /**
     * Inventory. Ebben tárolódnak el a player nyersanyagai
     */
    private static List<Character> inventory;
    /**
     * Hiba esetén hibaüzenet
     */
    private String hiba;
    /**
     * Cselekvéssel kapcsolatos kiírás
     */
    private String feedbackPrint;
    /**
     * A tűzhely és a víztisztító koordinátáját tartalmazza, hogy például ha több tűzhely van,
     * akkor ugyan ahhoz a tűzhelyhez kelljen visszamenni a megsült ételért ahova fel lett rakva<br>
     * és ne pedig bármelyik másik tűzhelynél lehessen megenni, ezzel elérve azétel teleportálását.
     */
    private char[][] cookCoordinate;
    /**
     * Egyszerre süthető étel limit
     */
    private int cookLimit;
    /**
     * Vízzel kapcsolatos kiírás
     */
    private String waterPrint;
    /**
     * Víztisztító cooldown
     */
    private int waterCooldown;
    /**
     * Víz X koordináta
     */
    private int waterPosY;
    /**
     * Víz X koordináta
     */
    private int waterPosX;
    /**
     * Víz limit. Ugyan az, mint a cookLimit
     */
    private int waterLimit;
    /**
     * Hal cooldown
     */
    private int fishCooldown;

    /**
     * A Player konstruktora. Player alapadatainak beállítása.
     */
    public Player(){
        food = 100;
        water = 100;
        positionY = 13;
        positionX = 17;
        builded = new char[height][width];
        builded[height/2 - 1][width / 2 - 1] = '0';
        builded[height/2 - 1][width / 2] = '0';
        builded[height/2][width / 2 - 1] = '0';
        builded[height/2][width / 2] = '0';
        inventory = new ArrayList<>();
        hiba = "";
        feedbackPrint = "";
        cookCoordinate = new char[height][width];
        cookLimit = 1;
        waterPrint = "";
        waterCooldown = 25;
        waterLimit = 1;
        fishCooldown = 25;
    }

    /**
     * Étel getter
     * @return Éhezés mértéke
     */
    public int getFood() {
        return food;
    }

    /**
     * Víz getter
     * @return Szomjasság mértéke
     */
    public int getWater() {
        return water;
    }

    /**
     * Player Y koordináta getter
     * @return Player Y koordináta
     */
    public int getPositionY() {
        return positionY;
    }

    /**
     * X koordináta getter
     * @return X koordináta
     */
    public int getPositionX() {
        return positionX;
    }

    /**
     * 2d tömb getter
     * @return 2d tömb
     */
    public char[][] getBuilded() {
        return builded;
    }

    /**
     * Inventory getter
     * @return Lista
     */
    public static List<Character> getInventory() {
        return inventory;
    }

    /**
     * Hiba szöveg getter
     * @return hibaüzenet
     */
    public String getHiba() {
        return hiba;
    }

    /**
     * Cselekvésseé kapcsolatos üzenet getter
     * @return String üzenet
     */
    public String getFeedbackPrint() {
        return feedbackPrint;
    }

    /**
     * 2d tömb getter
     * @return 2d tömb
     */
    public char[][] getCookCoordinate() {
        return cookCoordinate;
    }

    /**
     * Főzés limit getter
     * @return limit
     */
    public int getCookLimit() {
        return cookLimit;
    }

    /**
     * Víztisztító üzenet getter
     * @return String üzenet
     */
    public String getWaterPrint() {
        return waterPrint;
    }

    /**
     * Víztisztító cooldown getter
     * @return cooldown
     */
    public int getWaterCooldown() {
        return waterCooldown;
    }

    /**
     * Víztisztíto Y koordináta getter
     * @return Y koordináta
     */
    public int getWaterPosY() {
        return waterPosY;
    }

    /**
     * Víztisztíto X koordináta getter
     * @return X koordináta
     */
    public int getWaterPosX() {
        return waterPosX;
    }

    /**
     * Víztisztító limit getter
     * @return limit
     */
    public int getWaterLimit() {
        return waterLimit;
    }

    /**
     * Hal főzés cooldown getter
     * @return cooldown
     */
    public int getFishCooldown() {
        return fishCooldown;
    }

    /**
     * Éhezés setter
     * @param food ehinség beállítása
     */
    public void setFood(int food) {
        this.food = food;
    }

    /**
     * Szomjúság setter
     * @param water Szomjúság beállítása
     */
    public void setWater(int water) {
        this.water = water;
    }

    /**
     * Player Y koordináta setter
     * @param positionY player y koordináza beállítása
     */
    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    /**
     * Player X koordináta setter
     * @param positionX player X koordináza beállítása
     */
    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    /**
     * 2d tömb setter
     * @param builded beállítás
     */
    public void setBuilded(char[][] builded) {
        Player.builded = builded;
    }

    /**
     * Inventory setter
     * @param inventory player inventory
     */
    public void setInventory(List<Character> inventory) {
        Player.inventory = inventory;
    }

    /**
     * Hibaüzenet setter
     * @param hiba hibaüzenet beállítása
     */
    public void setHiba(String hiba) {
        this.hiba = hiba;
    }

    /**
     * Visszajelzés üzenet setter
     * @param feedbackPrint visszajelzés beállítása
     */
    public void setFeedbackPrint(String feedbackPrint) {
        this.feedbackPrint = feedbackPrint;
    }

    /**
     * 2d tömb setter
     * @param cookCoordinate 2d tömb beállítása
     */
    public void setCookCoordinate(char[][] cookCoordinate) {
        this.cookCoordinate = cookCoordinate;
    }

    /**
     * Sütés limit setter
     * @param cookLimit  limit beállítása
     */
    public void setCookLimit(int cookLimit) {
        this.cookLimit = cookLimit;
    }

    /**
     * Víztisztító üzenet setter
     * @param waterPrint üzenet beállítása
     */
    public void setWaterPrint(String waterPrint) {
        this.waterPrint = waterPrint;
    }

    /**
     * Víztisztító cooldown setter
     * @param waterCooldown cooldown beállítása
     */
    public void setWaterCooldown(int waterCooldown) {
        this.waterCooldown = waterCooldown;
    }

    /**
     * Víztisztító Y koordináta setter
     * @param waterPosY Y koordináta beállítása
     */
    public void setWaterPosY(int waterPosY) {
        this.waterPosY = waterPosY;
    }

    /**
     * Víztisztító X koordináta setter
     * @param waterPosX X koordináta beállítása
     */
    public void setWaterPosX(int waterPosX) {
        this.waterPosX = waterPosX;
    }

    /**
     * Víztisztító limit setter
     * @param waterLimit limit beállítása
     */
    public void setWaterLimit(int waterLimit) {
        this.waterLimit = waterLimit;
    }

    /**
     * Hal főzés cooldown setter
     * @param fishCooldown cooldown beállítása
     */
    public void setFishCooldown(int fishCooldown) {
        this.fishCooldown = fishCooldown;
    }

    /**
     * Ez a metódus dönti el, hogy milyen irányba lépjen a 8 lehetséges eset közül<br>
     * Le van kezelve if-ben az az eset, amikor a player kimenne a pályáról.<br>
     * Ebben az esetben hibaüzenetet fog dobni.<br>
     * Ha teljesül a feltétel, azaz léphet rendesen, akkor meghívja a move() metódust és átadja az irányt paraméterben pl.: 1 = fel
     * @param direction Mozgás íránya
     */
    public void moveDirection(int direction){
        switch (direction) {
            case 1 -> {
                if(getPositionY() > 0)
                    move(direction);
                else setHiba("Wrong move");
            }
            case 2 -> {
                if(getPositionX() < 35 && getPositionY() > 0)
                    move(direction);
                else setHiba("Wrong move");
            }
            case 3 -> {
                if(getPositionX() < 35)
                    move(direction);
                else setHiba("Wrong move");
            }
            case 4 -> {
                if(getPositionX() < 35 && getPositionY() < 25)
                    move(direction);
                else setHiba("Wrong move");
            }
            case 5 -> {
                if(getPositionY() < 25)
                    move(direction);
                else setHiba("Wrong move");
            }
            case 6 -> {
                if(getPositionX() > 0 && getPositionY() < 25)
                    move(direction);
                else setHiba("Wrong move");
            }
            case 7 -> {
                if(getPositionX() > 0)
                    move(direction);
                else setHiba("Wrong move");
            }
            case 8 -> {
                if(getPositionX() > 0 && getPositionY() > 0)
                    move(direction);
                else setHiba("Wrong move");
            }
        }
    }

    /**
     * A 8 lehetséges lépés közül paraméterben kapott értéktől függ, hogy melyik eset hajtódik végre.<br>
     * A lépéstől függően a player koordinátáit állítja be.
     * @param direction moveDirection() metódusból kapott érték. Az irányt határozza meg
     */
    public void move(int direction){
        if (direction == 1) {//UP
            setPositionY(getPositionY() - 1);
        } else if (direction == 2) {//UP-Right
            setPositionY(getPositionY() - 1);
            setPositionX(getPositionX() + 1);
        } else if (direction == 3) {//Right
            setPositionX(getPositionX() + 1);
        } else if (direction == 4) {//Down-Right
            setPositionY(getPositionY() + 1);
            setPositionX(getPositionX() + 1);
        } else if (direction == 5) {//Down
            setPositionY(getPositionY() + 1);
        } else if (direction == 6) {//Down-Left
            setPositionY(getPositionY() + 1);
            setPositionX(getPositionX() - 1);
        } else if (direction == 7) {//Left
            setPositionX(getPositionX() - 1);
        } else if (direction == 8) {//UP-Left
            setPositionY(getPositionY() - 1);
            setPositionX(getPositionX() - 1);
        }
    }

    /**
     * Célja megvizsgálni, hogy van e elegendő nyersanyaga a playernek ahhoz amit szeretne (2 nyersanyagos változat)
     * @param haveOne Első nyersanyagból mennyi van
     * @param haveTwo Második nyersanyagból mennyi van
     * @param requiredOne Első nyersanyagból mennyi kell
     * @param requiredTwo Második nyersanyagból mennyi kell
     * @return True, ha van elég nyersanyag. False, ha nincs
     */
    public boolean buildable(int haveOne, int haveTwo, int requiredOne, int requiredTwo){
        return haveOne >= requiredOne && haveTwo >= requiredTwo;
    }

    /**
     * Célja megvizsgálni, hogy van e elegendő nyersanyaga a playernek ahhoz amit szeretne (3 nyersanyagos változat)
     * @param haveOne Első nyersanyagból mennyi van
     * @param haveTwo Második nyersanyagból mennyi van
     * @param  haveThree Harmadik nyersanyagból mennyi van
     * @param requiredOne Első nyersanyagból mennyi kell
     * @param requiredTwo Második nyersanyagból mennyi kell
     * @param requiredThree Harmadik nyersanyagból mennyi kell
     * @return True, ha van elég nyersanyag. False, ha nincs
     */
    public boolean buildable(int haveOne, int haveTwo, int haveThree, int requiredOne, int requiredTwo, int requiredThree){
        return haveOne >= requiredOne && haveTwo >= requiredTwo && haveThree >= requiredThree;
    }

    /**
     * Célja a paraméterben kapott értékek alapján a megfelelő tárgyat építeni a megfelelő koordinátára
     * @param item player által választott tárgy
     * @param coordinateY Y koordinátája a célhelynek
     * @param coordinateX X koordinátája a célhelynek
     */
    public void buildToDirection(int item, int coordinateY, int coordinateX){
        if (item == 1)
            buildPlatform(coordinateY,coordinateX);
        else if(item == 2)
            buildString(coordinateY,coordinateX);
        else if(item == 3)
            buildCooker(coordinateY,coordinateX);
        else if(item == 4)
            buildWaterPurifier(coordinateY,coordinateX);
    }

    /**
     * Ez a metódus hasonlóan működik, mint a moveDirection() annyi különbséggel, hogy paraméterben megkapja, hogy mit szeretne a player építeni és ezt átadja a buildToDirection() metódusnak
     * @param direction Építés iránya
     * @param item Építeni kívánt dolog
     */
    public void buildDirection(int direction, int item){
        switch (direction) {
            case 1 -> {
                if(getPositionY() > 0){
                    buildToDirection(item,getPositionY()-1,getPositionX());
                }else setHiba("You cannot build there!");
            }
            case 2 -> {
                if(getPositionX() < 35 && getPositionY() > 0){
                    buildToDirection(item,getPositionY() - 1, getPositionX() + 1);
                }else setHiba("You cannot build there!");
            }
            case 3 -> {
                if(getPositionX() < 35){
                    buildToDirection(item, getPositionY(),getPositionX() + 1);
                }else setHiba("You cannot build there!");
            }
            case 4 -> {
                if(getPositionX() < 35 && getPositionY() < 25){
                    buildToDirection(item, getPositionY() + 1, getPositionX() + 1);
                }else setHiba("You cannot build there!");
            }
            case 5 -> {
                if(getPositionY() < 25){
                    buildToDirection(item,getPositionY() + 1,getPositionX());
                }else setHiba("NYou cannot build there!");
            }
            case 6 -> {
                if(getPositionX() > 0 && getPositionY() < 25){
                    buildToDirection(item, getPositionY() + 1, getPositionX() - 1);
                }else setHiba("You cannot build there!");
            }
            case 7 -> {
                if(getPositionX() > 0){
                    buildToDirection(item, getPositionY(),getPositionX() - 1);
                }else setHiba("You cannot build there!");
            }
            case 8 -> {
                if(getPositionX() > 0 && getPositionY() > 0){
                    buildToDirection(item, getPositionY() - 1, getPositionX() - 1);
                }else setHiba("You cannot build there!");
            }
        }
    }

    /**
     * Platformot szeretne építeni a player. Ehhez megkapja a buildDirection() metódusból az X és Y koordinátát, hogy hova szeretné építeni.<br>
     * inventorySearch() metódussal megnézi a szükséges nyersanyagokat, hogy mennyi van belőlük.<br>
     * Ezután megnézi, hogy elég e az építéshez, ha nem, akkor hibaüzenettel kilép.<br>
     * Ha elég az építéshez, akkor megnézi, hogy üres e a paraméterben kapott koordinátán a hely, ha nem, akkor hibaüzenettel kilép.<br>
     * Ha üres, akkor  a builded tömbbe beleírjuk a paraméterben kapott koordinátára a platform nevét és jelezzük a playernek, hogy sikeres volt  az építés.<br>
     * Vegül meg kitöröljük az inventoryból a nyersanyagokat a deleteFromInventory() metódussal aminek átadjuk az inventoryt, a nyersanyag nevét, egy számlálót és, a számot, hogy mennyit kell törölni.
     * @param width Y koordináta
     * @param height X koordináta
     */
    public void buildPlatform(int width, int height){
        int plankHave = Inventory.inventorySearch(getInventory(),Plank.getName());
        int leafHave = Inventory.inventorySearch(getInventory(),Leaf.getName());
        if(!buildable(plankHave,leafHave,2,2))
            setHiba("Not enough resources!");
        else{
            if (builded[width][height] == '\u0000'){
                builded[width][height] = '0';
                setFeedbackPrint("Building succesful!");
                int plankCounter = 0,leafCounter = 0;
                Inventory.deleteFromInventory(getInventory(),Plank.getName(),plankCounter,2);
                Inventory.deleteFromInventory(getInventory(),Leaf.getName(),leafCounter,2);
            }else setHiba("You cannot build there!");
        }
    }

    /**
     * Hasonló a buildPlatform() metódushoz csak 3 nyersanyag van és nem azt vizsgáljuk, hogy üres e az a koordináta ahova építeni szeretne a palyer, hanem azt, hogy van e ott platform.
     * @param width Y koordináta
     * @param height X koordináta
     */
    public void buildCooker(int width, int height) {
        int plankHave = Inventory.inventorySearch(getInventory(),Plank.getName());
        int leafHave = Inventory.inventorySearch(getInventory(),Leaf.getName());
        int junkHave = Inventory.inventorySearch(getInventory(),Junk.getName());
        if(!buildable(plankHave,leafHave,junkHave,2,4,3))
            setHiba("Not enough resources!");
        else{
            if (builded[width][height] == '0'){
                builded[width][height] = 'C';
                setFeedbackPrint("Building succesful!");
                int plankCounter = 0,leafCounter = 0, junkCounter = 0;
                Inventory.deleteFromInventory(getInventory(),Plank.getName(),plankCounter,2);
                Inventory.deleteFromInventory(getInventory(),Leaf.getName(),leafCounter,4);
                Inventory.deleteFromInventory(getInventory(),Junk.getName(),junkCounter,3);
            }
            else setHiba("You cannot build there!");
        }
    }

    /**
     * Hasonló az eddigi építésekhez, de itt azt vizsgáljuk, hogy üres e az a koordináta ahova építeni szeretne a palyer, hanem úgy, mint a buildCooker() metódusban, hogy van e ott platform.<br>
     * Ha sikeres az építés, hasonlóan a buildPlatform() és a buildCooker() metódushoz, töröljük a nyersanyagokat és kiírja az akutálís időt amíg lesz elég víz az iváshoz.
     * @param width Y koordináta
     * @param height X koordináta
     */
    public void buildWaterPurifier(int width, int height){
        int leafHave = Inventory.inventorySearch(getInventory(),Leaf.getName());
        int junkHave = Inventory.inventorySearch(getInventory(),Junk.getName());
        if(!buildable(leafHave,junkHave,2,4))
            setHiba("Not enough resources!");
        else
        if (builded[width][height] == '0'){
            builded[width][height] = 'W';
            setFeedbackPrint("Building succesful!");
            setWaterPosY(width);
            setWaterPosX(height);
            setWaterPrint("Rounds until enough water to collect: "+getWaterCooldown());
            waterStarter = 1;
            int leafCounter = 0, junkCounter = 0;
            Inventory.deleteFromInventory(getInventory(),Leaf.getName(),leafCounter,2);
            Inventory.deleteFromInventory(getInventory(),Junk.getName(),junkCounter,4);
        }else setHiba("You cannot build there!");
    }

    /**
     * Hasonló az eddigi építésekhez, de itt azt vizsgáljuk, hogy ahova építeni oda nincs építve semmi és hogy van e a szomszédos mezőkben platform ('0') vagy víztisztító ('W') vagy tűzhely ('C')
     * @param width Y koordináta
     * @param height X koordináta
     */
    public void buildString(int width, int height){
        int plankHave = Inventory.inventorySearch(getInventory(),Plank.getName());
        int leafHave = Inventory.inventorySearch(getInventory(),Leaf.getName());
        if(!buildable(plankHave,leafHave,2,6))
            setHiba("Not enough resources!");
        else
            if(     builded[width][height] == '\u0000' && (builded[width-1][height]   == '0' || builded[width-1][height]   == 'W' || builded[width-1][height]   == 'C') ||
                    builded[width][height] == '\u0000' && (builded[width][height+1]   == '0' || builded[width][height+1]   == 'W' || builded[width][height+1]   == 'C') ||
                    builded[width][height] == '\u0000' && (builded[width+1][height]   == '0' || builded[width+1][height]   == 'W' || builded[width+1][height]   == 'C') ||
                    builded[width][height] == '\u0000' && (builded[width][height-1]   == '0' || builded[width][height-1]   == 'W' || builded[width][height-1]   == 'C')){

                builded[width][height] = 'X';
                setFeedbackPrint("Building succesful!");
                int plankCounter = 0, leafCounter = 0;
                Inventory.deleteFromInventory(getInventory(),Plank.getName(),plankCounter,2);
                Inventory.deleteFromInventory(getInventory(),Leaf.getName(),leafCounter,6);
            }
            else setHiba("You cannot build there!");
    }

    /**
     * Ha még nem sül semmi (cooklimit == 1), van a player inventoryban hal és a koordináta egy tűzhely,
     * akkor hozzá adja a cookCoordinate tömbhöz, hogy csak ott lehessen megenni és ne pedig akár másik tűzhelyen.<br>
     * Kitörli a halat az inventoryból, növeli a cooklimitet,
     * hogy ne lehessen többet főzni és tájékoztatja a playert, hogy hány kör van még a hal megsüléséig.<br>
     * Ha úgy lép rá, hogy már sül a hal, akkor ha van hiba, azt kiírja, ha nincs, akkor ha a jelenlegi sülési idő-1 kisebb, mint 1 azaz kész, akkor tájékoztatja a playert.<br>
     * a jelenlegi sülési idő-1 nagyobb, mint 0 azaz még nincs kész, akkor csökkenti a sülési időt és tájékoztatja a playert az aktuális sülési időről.<br>
     * Ezután ha a tájékoztató üzenet "Megsült a hal" és rajta áll a player a sütőn,
     * akkor meghívja az eat() metódust és reseteli a változókat.
     */
    public void cook(){
        if(cookLimit == 1  && inventory.contains(Fish.getName()) && builded[getPositionY()][getPositionX()] == 'C'){
            cookCoordinate[getPositionY()][getPositionX()] = Fish.getName();
            Inventory.deleteFromInventory(getInventory(),Fish.getName(),0,1);
            setCookLimit(getCookLimit()+1);
            setFeedbackPrint("Rounds until the fish is cooked: "+ getFishCooldown());
        }else if(getCookLimit() > 1){
            if(!getHiba().equals(""))
                setFeedbackPrint(getFeedbackPrint());
            else {
                if(getFishCooldown()-1 < 1)
                    setFeedbackPrint("The fish is cooked!");
                else{
                    if(getFishCooldown()-1 > 0){
                        setFishCooldown(getFishCooldown()-1);
                        setFeedbackPrint("Rounds until the fish is cooked: "+ getFishCooldown());
                    }
                }
            }
        }
        if(getFeedbackPrint().equals("The fish is cooked!") && cookCoordinate[getPositionY()][getPositionX()] == Fish.getName()){
            eat();
            cookCoordinate[getPositionY()][getPositionX()] = '0';
            setFeedbackPrint("");
            setCookLimit(1);
            setFishCooldown(25);
            roundNumber = 0;
        }
    }

    /**
     * Hasonlóan működik a cook() metódushoz csak nem kell hozzá nyersanyag, mert autómatikusan termelődik
     */
    public void waterPurifier(){
        if(waterLimit == 1 && builded[waterPosY][waterPosX] == 'W'){
            cookCoordinate[waterPosY][waterPosX] = 'W';
            setWaterLimit(getWaterLimit()+1);
            setWaterPrint("Rounds until enough water to collect: "+getWaterCooldown());
        }else if(getWaterLimit() > 1){
            if(!getHiba().equals(""))
                setWaterPrint(getWaterPrint());
            else{
                if(getWaterCooldown()-1 < 1)
                    setWaterPrint("You can collect water!");
                else{
                    if(getWaterCooldown()-1 > 0){
                        setWaterCooldown(getWaterCooldown()-1);
                        setWaterPrint("Rounds until enough water to collect: "+getWaterCooldown());
                    }
                }
            }
        }
        if(getWaterPrint().equals("You can collect water!") && cookCoordinate[getPositionY()][getPositionX()] == 'W'){
            drink();
            setWaterPrint("");
            setWaterLimit(1);
            setWaterCooldown(25);
            roundNumber = 0;
        }
    }

    /**
     * Ha a player éhezése kisebb, mint 40, akkor hozzá ad 60-at.<br>
     * Ha a player éhezése nagyobb, mint 40, akkor 100-ra állítja
     */
    public void eat(){
        if(getFood() <= 40)
            setFood(getFood() + 60);
        else
            setFood(100);
    }

    /**
     * Ha a player szomjúsága kisebb, mint 60, akkor hozzá ad 40-et<br>
     * Ha a player szomjúsága nagyobb, mint 60, akkor 100-ra állítja
     */
    public void drink(){
        if(getWater() <= 60)
            setWater(getWater() + 40);
        else
            setWater(100);
    }

    /**
     * Ha a player nem üres helyen áll azaz nem vízben van, akkor hibaüzenettel kilép.<br>
     * Ha Vízben van azaz üres helyen, akkor generál egy számot 1-100 között és ha ez a szám 1-25 közözött van,
     * akkor hozzáad a player inventoryhoz 1 halat és tájékoztatja a playert.<br>
     * Ha a szám nagyobb, mint 25, akkor tájékoztatja a playert, hogy nem sikerült halat fogni.
     * @param positionY player Y koordinátája
     * @param positionX player X koordinátája
     */
    public void fishing(int positionY, int positionX){
        if(builded[positionY][positionX] == '\u0000'){
            int chance = (int)(Math.random() * (100)+1);
            if(chance < 26){
                inventory.add(Fish.getName());
                setFeedbackPrint("You caught a fish!");
            }else setFeedbackPrint("Bad luck. You did not catch any fish!");
        }else setHiba("You cannot do fishing here!");
    }

    /**
     * Meghívja a takeAtPosition() metódust és átadja a 8 lehetséges irány és a palyer koordinátáit paraméterben
     */
    public void takeResource(){
        //Standing
        takeAtPosition(getPositionY(),getPositionX());
        //Up
        takeAtPosition(getPositionY()-1,getPositionX());
        //Up-Right
        takeAtPosition(getPositionY()-1,getPositionX()+1);
        //Right
        takeAtPosition(getPositionY(),getPositionX()+1);
        //Right-Down
        takeAtPosition(getPositionY()+1,getPositionX()+1);
        //Down
        takeAtPosition(getPositionY()+1,getPositionX());
        //Left-Down
        takeAtPosition(getPositionY()+1,getPositionX()-1);
        //Left
        takeAtPosition(getPositionY(),getPositionX()-1);
        //Up-Left
        takeAtPosition(getPositionY()-1,getPositionX()-1);
    }

    /**
     * Megkapja a takeResource() metódusból az X és Y koordinátákat, majd megnézi, hogy hordó e, ha igen<br>
     * Akkor meghívja a barrelResourceGenerator() metódust és átadja paraméterben az inventoryt és kinullázza a hordót a nyersanyagok tömbből<br>
     * Ha nem Hordó, akkor megnézi az összes nyersanyagot, hogy valamelyik előfordul e az adott koordinátán, ha igen, <br>
     * akkor hozzá adja azt a nyersanyagot az inventoryhoz és kinullázza a helyét
     * @param positionY Y koordináta
     * @param positionX X koordináta
     */
    public static void takeAtPosition(int positionY, int positionX){
        if(ResourceGenerate.resources[positionY][positionX] == 'B'){
            ResourceGenerate.barrelResourceGenerator(getInventory());
            ResourceGenerate.resources[positionY][positionX] = '\u0000';
        } else if(ResourceGenerate.resources[positionY][positionX] == 'P' || ResourceGenerate.resources[positionY][positionX] == 'L' || ResourceGenerate.resources[positionY][positionX] == 'J'){
            getInventory().add(ResourceGenerate.resources[positionY][positionX]);
            ResourceGenerate.resources[positionY][positionX] = '\u0000';
        }
    }

    /**
     * Ha már sül hal, akkor megnézi, hogy kész van e, ha igen, akkor jelzi a playernek, hogy készen van<br>
     * Ha még nincs kész, akkor csökkenti és kiírja az aktuális sütési időt. Kiíratás után nullázza a szöveget.
     * @param player player
     */
    public void cookPrint(Player player){
        if (getCookLimit() > 1){
            if(player.getFishCooldown()-1 < 1){
                player.setFeedbackPrint("The fish is cooked!");
                System.out.println(player.getFeedbackPrint());
            }else {
                player.setFishCooldown(player.getFishCooldown()-1);
                System.out.println("Rounds until the fish is cooked: "+ player.getFishCooldown());
            }
        }
        player.setFeedbackPrint("");
    }

    /**
     * Ha már gyűlik a víz, akkor megnézi, hogy kész van e, ha igen, akkor jelzi a playernek, hogy készen van<br>
     * Ha még nincs kész, akkor csökkenti és kiírja az aktuális várakozási időt. Kiíratás után nullázza a szöveget.
     * @param player player
     */
    public void waterPrint(Player player) {
        if(getWaterLimit() > 1){
            if(getWaterCooldown()-1 < 1){
                setWaterPrint("You can collect water!");
                System.out.println(getWaterPrint());
            }else {
                setWaterCooldown(getWaterCooldown()-1);
                System.out.println("Rounds until enough water to collect: "+getWaterCooldown());
            }
        }
        setWaterPrint("");
    }

    /**
     * Kiiratási formátum amiben kiírodik az éhség, szomjúság és az inventory
     * @return Formázott String
     */
    @Override
    public String toString() {
        return "Food: " + getFood() + "\n"+
                "Drink: " + getWater() + "\n"+
                "Inventory: " + Inventory.inventorySearch(getInventory(), Plank.getName()) + " plank, " + Inventory.inventorySearch(getInventory(), Leaf.getName()) + " leaf, " + Inventory.inventorySearch(getInventory(), Junk.getName()) + " junk, " + Inventory.inventorySearch(getInventory(), Fish.getName()) + " fish, " + Inventory.inventorySearch(getInventory(), Potato.getName()) + " potato.";
    }
}