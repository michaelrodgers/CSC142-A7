/**
 * Creates a sepia effect to an image
 * @author Michael Rodgers and Benjamin Elia
 * @version 2018.11.25
 */
public class NewFilter implements Filter{
    public void filter(PixelImage pi) {
        Pixel[][] data = pi.getData();
        int tempg = 0;
        int tempb = 0;
        int tempr = 0;

        for (int row = 0; row < pi.getHeight(); row++) {
            for (int col = 0; col < pi.getWidth(); col++) {
                Pixel temp = data[row][col];
                tempg =(int) ((0.349*temp.red) + (0.686*temp.green) + (0.168*temp.blue));
                tempb =(int) ((0.272*temp.red) + (0.534*temp.green) + (0.131*temp.blue));
                tempr =(int) ((0.393*temp.red) + (0.769*temp.green) + (0.189*temp.blue));
                if (tempg>=255) {
                	temp.green = 255;
                } else {
                temp.green = tempg;
                }
                if (tempb>=255) {
                	temp.blue = 255;
                } else {
                temp.blue = tempb;
                }
                if (tempr>=255) {
                	temp.red = 255;
                } else {
                temp.red = tempr;
                }
                
            }
        }

        pi.setData(data);
    }
}
