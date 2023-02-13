package Resources;

/**
 * Barrel osztály. A ResourceGenerate osztály gyereke.<br>
 * Célja a hordó adatainak tárolása.
 */
public class Barrel extends ResourceGenerate{
    /**
     * Hordó neve
     */
    private static final char name = 'B';
    /**
     * X koordináta
     */
    private static int positionX;
    /**
     * Y koordináta
     */
    private static int positionY;

    /**
     * Hordó nevének gettere
     * @return Hordó neve
     */
    public static char getName() {
        return name;
    }

    /**
     * Hordó X koordinátájának gettere
     * @return X koordináta
     */
    public static int getPositionX() {
        return positionX;
    }

    /**
     * Hordó Y koordinátájának gettere
     * @return Y koordináta
     */
    public static int getPositionY() {
        return positionY;
    }

    /**
     * Hordó X koordinátájának settere
     * @param positionX beállítja a paraméterben kapott értéket a hordó X koordinátájának
     */
    public void setPositionX(int positionX) {
        Barrel.positionX = positionX;
    }

    /**
     * Hordó Y koordinátájának settere
     * @param positionY beállítja a paraméterben kapott értéket a hordó Y koordinátájának
     */
    public void setPositionY(int positionY) {
        Barrel.positionY = positionY;
    }
}
