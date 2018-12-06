/**
 * Filter that converts an image to black & white
 * @author Michael Rodgers and Benjamin Elia
 * @version 2018.11.25
 */
public class BlackWhite implements Filter {
	public void filter(PixelImage pi) {
		Pixel[][] data = pi.getData();
		for (int x = 0;x < 2;x++)
		for (int i = 0;i<pi.getHeight();i++){
			for(int j = 0; j<pi.getWidth();j++){
				// set the rgb in the same value
				data[i][j].red = (data[i][j].red+data[i][j].green+data[i][j].blue)/3;
				data[i][j].green = (data[i][j].red+data[i][j].green+data[i][j].blue)/3;
				data[i][j].blue = (data[i][j].red+data[i][j].green+data[i][j].blue)/3;
			}
		}
		pi.setData(data);
	}

}