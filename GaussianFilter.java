/**
 * Filter that creates a Gaussian blur over the image
 * @author Michael Rodgers and Benjamin Elia
 * @version 2018.11.25
 */
public class GaussianFilter implements Filter {

	@Override
	public void filter(PixelImage theImage) {
		int[][] weights = {{1, 2,1}, 
				   {2, 4, 2}, 
				   {1, 2, 1}};
		
		Pixel[][] data = theImage.weightedAverages(theImage, weights, true);

		theImage.setData(data);
	}

}