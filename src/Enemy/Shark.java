package Enemy;
import Player.Player;
import World.World;

/**
 * Shark osztály. A World gyerekosztálya.<br>
 * A cápa mozgásáért felelős.
 */
public class Shark extends World {
    /**
     * Cápa neve karakterben
     */
    private final char name = 'S';
    /**
     * X koordináta
     */
    private int positionX;
    /**
     * Y koordináta
     */
    private int positionY;
    /**
     * Irány
     */
    int direction;
    /**
     * Számláló
     */
    private int counter;
    /**
     * Cápa koordinátát tartalmazó 2d tömb
     */
    private char[][] sharkPosition;

    /**
     * A shark konstruktora. Alapadatainak beállítása.
     */
    public Shark() {
        positionX = 11;
        positionY = 20;
        direction = 1;
        counter = 1;
        sharkPosition = new char[height][width];
        sharkPosition[positionY][positionX] = getName();
    }

    /**
     * Név gettere
     * @return name
     */
    public char getName() {
        return name;
    }

    /**
     * X pozíció gettere
     * @return X koordináta
     */
    public int getPositionX() {
        return positionX;
    }

    /**
     * Y pozíció gettere
     * @return Y koordináta
     */
    public int getPositionY() {
        return positionY;
    }

    /**
     * Counter gettere
     * @return counter
     */
    public int getCounter() {
        return counter;
    }

    /**
     * A cápa pozícíóját tárolja
     * @return char[][]
     */
    public char[][] getSharkPosition() {
        return sharkPosition;
    }

    /**
     * Az X pozíciót beállítja a paraméterben kapott értékre
     * @param positionX X koordináta
     */
    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    /**
     * Az Y pozíció beállítja a paraméterben kapott értékre
     * @param positionY Y koordináta
     */
    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    /**
     * Counter értéként beállítja a paraméterben kapott értékre
     * @param counter counter
     */
    public void setCounter(int counter) {
        this.counter = counter;
    }

    /**
     * sharkPosition tömböt beállítja a paraméterben kapottra
     * @param sharkPosition 2d tömb ami tartalmazza a cápa adott koordinátáját
     */
    public void setSharkPosition(char[][] sharkPosition) {
        this.sharkPosition = sharkPosition;
    }

    /**
     * Ez a metódus dönti el, hogy milyen irányba lépjen a 8 lehetséges eset közül<br>
     * Alapból a counter és a direction 1-től indul ami azt jelenti, hogy felfele fog menni addig, amíg a counter nem osztható 4-el.<br>
     * Ha osztható 4-el, akkor generál random egy új irányt és addig lép abba az irányba, amíg újra nem lesz osztható 4-el a counter.<br>
     * Le van kezelve if-ben az az eset, amikor a cápa kimenne a pályáról vagy ha neki ütközne a tutajnak.<br>
     * Ebben az esetben az ellenkezőjét fogja lépni pl.: balra lépne,de  kimenne a pályáról, akkor helyette jobbra fog lépni.<br>
     * Ha teljesül a feltétel, azaz léphet rendesen, akkor meghívja a move() metódust és átadja az irányt paraméterben pl.: 1 = fel
     */
    public void moveDirection(){
        if(counter % 4 == 0)
            direction = (int)Math.floor(Math.random()*(8)+1);
        switch (direction) {
            case 1 -> {
                if(getPositionY() > 0 && Player.builded[getPositionY()-1][getPositionX()] == '\u0000'){
                    move(direction);
                    counter++;
                }else {
                    move(5);
                    counter = 4;
                }
            }
            case 2 -> {
                if(getPositionX() < 35 && getPositionY() > 0 && Player.builded[getPositionY()-1][getPositionX()+1] == '\u0000'){
                    move(direction);
                    counter++;
                }else {
                    move(5);
                    counter = 4;
                }
            }
            case 3 -> {
                if(getPositionX() < 35 && Player.builded[getPositionY()][getPositionX()+1] == '\u0000'){
                    move(direction);
                    counter++;
                }else {
                    move(7);
                    counter = 4;
                }
            }
            case 4 -> {
                if(getPositionX() < 35 && getPositionY() < 25 && Player.builded[getPositionY()+1][getPositionX()+1] == '\u0000'){
                    move(direction);
                    counter++;
                }else {
                    move(8);
                    counter = 4;
                }
            }
            case 5 -> {
                if(getPositionY() < 25 && Player.builded[getPositionY()+1][getPositionX()] == '\u0000'){
                    move(direction);
                    counter++;
                }else {
                    move(1);
                    counter = 4;
                }
            }
            case 6 -> {
                if(getPositionX() > 0 && getPositionY() < 25 && Player.builded[getPositionY()+1][getPositionX()-1] == '\u0000'){
                    move(direction);
                    counter++;
                }else {
                    move(2);
                    counter = 4;
                }
            }
            case 7 -> {
                if(getPositionX() > 0 && Player.builded[getPositionY()][getPositionX()-1] == '\u0000'){
                    move(direction);
                    counter++;
                }else {
                    move(3);
                    counter = 4;
                }
            }
            case 8 -> {
                if(getPositionX() > 0 && getPositionY() > 0 && Player.builded[getPositionY()-1][getPositionX()-1] == '\u0000'){
                    move(direction);
                    counter++;
                }else {
                    move(4);
                    counter = 4;
                }
            }
        }
    }

    /**
     * A 8 lehetséges lépés közül paraméterben kapott értéktől függ, hogy melyik eset hajtódik végre.<br>
     * A lépéstől függően a cápa koordinátáit állítja be.
     * @param direction moveDirection() metódusból kapott érték. Az irányt határozza meg
     */
    public void move(int direction){
        if (direction == 1) {//UP
            setPositionY(getPositionY() - 1);
        } else if (direction == 2) {//Right-UP
            setPositionY(getPositionY() - 1);
            setPositionX(getPositionX() + 1);
        } else if (direction == 3) {//Right
            setPositionX(getPositionX() + 1);
        } else if (direction == 4) {//Right-Down
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
}