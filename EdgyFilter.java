/**
 * A filter to highlight edges in the image
 * 
 * @author Thunder Tiger Ninjas
 * @version 0.0.9
 */
public class EdgyFilter implements Filter {

	public void filter(PixelImage pi){
		
		int[][] weights = {{-1, -1,-1}, 
						   {-1, 9, -1}, 
						   {-1, -1, -1}};
		Pixel[][] data = pi.computeWeightedAverages(pi, weights, false);
		
		pi.setData(data);
	}

}