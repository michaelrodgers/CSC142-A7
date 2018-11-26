
/**
 * Created by Aaron Hand on 6/1/16.
 * Project: CSC142_ProjectV
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