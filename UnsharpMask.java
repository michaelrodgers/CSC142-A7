/**
 * Filter that creates a blur over the image
 * @author Michael Rodgers and Benjamin Elia
 * @version 2018.11.25
 */
public class UnsharpMask implements Filter {

	public void filter(PixelImage pi){
		
		int[][] weights = {{-1, -2,-1}, 
						   {-2, 28, -2}, 
						   {-1, -2, -1}};
		Pixel[][] data = pi.weightedAverages(pi, weights, true);
		
		pi.setData(data);
	}

}