/**
 * Creates a similar effect to a sepia image
 * @author Michael Rodgers and Benjamin Elia
 * @version 2018.11.25
 */
public class AlmostSepia implements Filter{
    public void filter(PixelImage pi) {
        Pixel[][] data = pi.getData();
        int tempg = 0;
        int tempb = 0;
        int tempr = 0;

        for (int row = 0; row < pi.getHeight(); row++) {
            for (int col = 0; col < pi.getWidth(); col++) {
                Pixel temp = data[row][col];
                if (temp.green>=140) {
                	tempg=temp.green;
                } else {
                tempg =(int) ((0.349*temp.red) + (0.6867*temp.green) + (0.168*temp.blue));
                }
                if (temp.blue>=140) {
                	tempb=temp.blue;
                } else {
                tempb =(int) ((0.272*temp.red) + (0.534*temp.green) + (0.131*temp.blue));
                }
                if (temp.red>=140) {
                	tempr=temp.red;
                } else {
                tempr =(int) ((0.393*temp.red) + (0.769*temp.green) + (0.189*temp.blue));
                }
                temp.green = tempg;
                temp.blue = tempb;
                temp.red = tempr;
                
            }
        }

        pi.setData(data);
    }
}