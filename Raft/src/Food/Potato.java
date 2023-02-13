package Food;
import Resources.ResourceGenerate;

/**
 * Potato osztály. A ResourceGenerate osztály gyereke.<br>
 * Célja a krumpli adatainak tárolása.
 */
public class Potato extends ResourceGenerate {
    /**
     * Krumpli neve
     */
    private static final char name = 'O';

    /**
     * Krumpli nevének gettere
     * @return Krumpli neve
     */
    public static char getName() {
        return name;
    }
}
