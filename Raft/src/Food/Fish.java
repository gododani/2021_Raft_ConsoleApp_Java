package Food;
import Resources.ResourceGenerate;

/**
 * Fish osztály. A ResourceGenerate osztály gyereke.<br>
 * Célja a hal adatainak tárolása.
 */
public class Fish extends ResourceGenerate {
    /**
     * Hal neve
     */
    private static final char name = 'H';

    /**
     * Hal nevének gettere
     * @return Krumpli neve
     */
    public static char getName() {
        return name;
    }
}
