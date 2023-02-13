package Resources;

/**
 * Plank osztály. A ResourceGenerate osztály gyereke.<br>
 * Célja a deszka adatainak tárolása.
 */
public class Plank extends ResourceGenerate{
    /**
     * Deszka neve
     */
    private static char name = 'P';
    /**
     * X koordináta
     */
    private static int positionX;
    /**
     * Y koordináta
     */
    private static int positionY;

    /**
     * Deszka nevének gettere
     * @return Deszka neve
     */
    public static char getName() {
        return name;
    }

    /**
     * Deszka X koordinátájának gettere
     * @return X koordináta
     */
    public static int getPositionX() {
        return positionX;
    }

    /**
     * Deszka Y koordinátájának gettere
     * @return Y koordináta
     */
    public int getPositionY() {
        return positionY;
    }

    /**
     * Deszka X koordinátájának settere
     * @param positionX beállítja a paraméterben kapott értéket a deszka X koordinátájának
     */
    public void setPositionX(int positionX) {
        Plank.positionX = positionX;
    }

    /**
     * Deszka Y koordinátájának settere
     * @param positionY beállítja a paraméterben kapott értéket a deszka Y koordinátájának
     */
    public void setPositionY(int positionY) {
        Plank.positionY = positionY;
    }
}
