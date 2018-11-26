

/**
 * GaussianFilter
 * 
 * A Filter that computes a Gaussian blur on the image.
 * 
 * @author huiyingcao
 *
 */
public class GaussianFilter implements Filter {

	@Override
	public void filter(PixelImage theImage) {
		int[][] weights = {{1, 2,1}, 
				   {2, 4, 2}, 
				   {1, 2, 1}};
		
		Pixel[][] data = theImage.computeWeightedAverages(theImage, weights, true);

		theImage.setData(data);
	}

}