package Resources;

/**
 * Junk osztály. A ResourceGenerate osztály gyereke.<br>
 * Célja a hulladék adatainak tárolása
 */
public class Junk extends ResourceGenerate{
    /**
     * Hulladék neve
     */
    private static final char name = 'J';
    /**
     * X koordináta
     */
    private static int positionX;
    /**
     * Y koordináta
     */
    private static int positionY;

    /**
     * Hulladék nevének gettere
     * @return Hulladék neve
     */
    public static char getName() {
        return name;
    }

    /**
     * Hulladék X koordinátájának gettere
     * @return X koordináta
     */
    public static int getPositionX() {
        return positionX;
    }

    /**
     * Hulladék Y koordinátájának gettere
     * @return Y koordináta
     */
    public int getPositionY() {
        return positionY;
    }

    /**
     * Hulladék X koordinátájának settere
     * @param positionX beállítja a paraméterben kapott értéket a hordó X koordinátájának
     */
    public void setPositionX(int positionX) {
        Junk.positionX = positionX;
    }

    /**
     * Hulladék Y koordinátájának settere
     * @param positionY beállítja a paraméterben kapott értéket a hordó Y koordinátájának
     */
    public void setPositionY(int positionY) {
        Junk.positionY = positionY;
    }
}
