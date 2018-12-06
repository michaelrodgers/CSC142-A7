
/**
 * Removes red color from image, effectively applying a Blue/Green filter
 * @author Michael Rodgers and Benjamin Elia
 * @version 2018.11.25
 */
public class RedRemoval implements Filter{
    public void filter(PixelImage pi) {
        Pixel[][] data = pi.getData();
         for (int row = 0; row < pi.getHeight(); row++) {
            for (int col = 0; col < pi.getWidth(); col++) {
                Pixel temp = data[row][col];
                temp.red = 0;
            }
        }
         pi.setData(data);
    }
}