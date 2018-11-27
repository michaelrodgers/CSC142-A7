/**
 * Filter that creates a Laplacian Filter over the image
 * @author Michael Rodgers and Benjamin Elia
 * @version 2018.11.25
 */
public class LaplacianFilter implements Filter{
    public void filter(PixelImage theImage) {

        int[][] weights = {
                {-1, -1,-1},
                {-1, 8, -1},
                {-1, -1, -1}};
        Pixel[][] data = theImage.computeWeightedAverages(theImage, weights, true);

        theImage.setData(data);

    }
}