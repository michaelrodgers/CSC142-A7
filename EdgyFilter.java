/**
 * Filter that highlights the edges in the image
 * @author Michael Rodgers and Benjamin Elia
 * @version 2018.11.25
 */
public class EdgyFilter implements Filter {

	public void filter(PixelImage pi){
		
		int[][] weights = {{-1, -1,-1}, 
				   		   {-1, 9, -1}, 
				   		   {-1, -1, -1}};
		Pixel[][] data = pi.weightedAverages(pi, weights, false);
		
		pi.setData(data);
	}

}