/**
 * A filter to sharpen the image
 * 
 * @author Thunder Tiger Ninjas
 * @version 0.0.9
 */
public class UnsharpFilter implements Filter {

	public void filter(PixelImage pi){
		
		int[][] weights = {{-1, -2,-1}, 
						   {-2, 28, -2}, 
						   {-1, -2, -1}};
		Pixel[][] data = pi.computeWeightedAverages(pi, weights, true);
		
		pi.setData(data);
	}

}