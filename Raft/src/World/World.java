package World;
import Enemy.Shark;
import Player.Player;
import Resources.*;

/**
 * World osztály. Célja a pálya kiírása consolra
 */
public class World {
    /**
     * Pálya méretének szélessége
     */
    public static final int width = 36;
    /**
     * Pálya méretének magassága
     */
    public static final int height = 26;
    /**
     * A mapot tároló 2d tömb
     */
    char[][] map;

    /**
     * A World konstruktora. Pálya méretének beállítása.
     */
    public World(){
        map = new char[height][width];
    }

    /**
     * Ez a függvény felelős a konzolon megjelenített pálya helyes kiírásáért. <br>
     * Végig megy a pálya tömbön és más osztályok tömbjeit nézi, hogy hol vannak.<br>
     * Keresi a cápát, a playert, az épített elemeket, magát a tutajt, és a nyersanyagokat.<br>
     * Ha az adott koordinátán talál az előbbiekből valamit, akkor azt beállítja magának és kiírja.<br>
     * Ha nem talál az adott koordinátára semmit, akkor tudja, hogy ott víz van, ezért azt menti el és azt írja ki.
     * @param player Player
     * @param shark Cápa
     */
    public void printWorld(Player player, Shark shark){
        for (int i = 0; i < height; i++){
            for (int j = 0; j < width; j++){
                if(i == shark.getPositionY() && j == shark.getPositionX()){
                    map[i][j] = shark.getName();
                    System.out.print(map[i][j] + "  ");
                }else if(i == player.getPositionY() && j == player.getPositionX()){
                    map[i][j] = '1';
                    System.out.print(map[i][j] + "  ");
                } else if(player.getBuilded()[i][j] == 'C'){
                    map[i][j] = 'C';
                    System.out.print(map[i][j] + "  ");
                } else if(player.getBuilded()[i][j] == 'W'){
                    map[i][j] = 'W';
                    System.out.print(map[i][j] + "  ");
                } else if(player.getBuilded()[i][j] == 'X'){
                    map[i][j] = 'X';
                    System.out.print(map[i][j] + "  ");
                } else if(player.getBuilded()[i][j] == '0'){
                    map[i][j] = '0';
                    System.out.print(map[i][j] + "  ");
                } else if(ResourceGenerate.resources[i][j] == Plank.getName()) {
                    System.out.print(ResourceGenerate.resources[i][j]+"  ");
                } else if(ResourceGenerate.resources[i][j] == Leaf.getName()) {
                    System.out.print(ResourceGenerate.resources[i][j]+"  ");
                } else if(ResourceGenerate.resources[i][j] == Junk.getName()) {
                    System.out.print(ResourceGenerate.resources[i][j]+"  ");
                } else if(ResourceGenerate.resources[i][j] == Barrel.getName()) {
                    System.out.print(ResourceGenerate.resources[i][j]+"  ");
                } else{
                    map[i][j] = '-';
                    System.out.print(map[i][j]+"  ");
                }
            }
            System.out.println();
        }
    }
}