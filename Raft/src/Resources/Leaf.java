package Resources;

/**
 * Leaf osztály. A ResourceGenerate osztály gyereke.<br>
 * Célja a levél adatainak tárolása
 */
public class Leaf extends ResourceGenerate{
    /**
     * Levél neve
     */
    private static char name = 'L';
    /**
     * X koordináta
     */
    private static int positionX;
    /**
     * Y koordináta
     */
    private static int positionY;

    /**
     * Levél nevének gettere
     * @return Levél neve
     */
    public static char getName() {
        return name;
    }

    /**
     * Levél X koordinátájának gettere
     * @return X koordináta
     */
    public static int getPositionX() {
        return positionX;
    }

    /**
     * Levél Y koordinátájának gettere
     * @return Y koordináta
     */
    public int getPositionY() {
        return positionY;
    }

    /**
     * Levél X koordinátájának settere
     * @param positionX beállítja a paraméterben kapott értéket a levél X koordinátájának
     */
    public void setPositionX(int positionX) {
        Leaf.positionX = positionX;
    }

    /**
     * Levél Y koordinátájának settere
     * @param positionY beállítja a paraméterben kapott értéket a levél Y koordinátájának
     */
    public void setPositionY(int positionY) {
        Leaf.positionY = positionY;
    }
}
