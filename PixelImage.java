import java.awt.image.*;

/**
 * Provides an interface to a picture as an array of Pixels
 */
public class PixelImage
{
  private BufferedImage myImage;
  private int width;
  private int height;

  /**
   * Map this PixelImage to a real image
   * @param bi The image
   */
  public PixelImage(BufferedImage bi)
  {
    // initialise instance variables
    this.myImage = bi;
    this.width = bi.getWidth();
    this.height = bi.getHeight();
  }

  /**
   * Return the width of the image
   */
  public int getWidth()
  {
    return this.width;
  }

  /**
   * Return the height of the image
   */
  public int getHeight()
  {
    return this.height;
  }

  /**
   * Return the BufferedImage of this PixelImage
   */
  public BufferedImage getImage()
  {
    return this.myImage;
  }

  /**
   * Return the image's pixel data as an array of Pixels.  The
   * first coordinate is the x-coordinate, so the size of the
   * array is [width][height], where width and height are the
   * dimensions of the array
   * @return The array of pixels
   */
  public Pixel[][] getData()
  {
    Raster r = this.myImage.getRaster();
    Pixel[][] data = new Pixel[r.getHeight()][r.getWidth()];
    int[] samples = new int[3];

    for (int row = 0; row < r.getHeight(); row++)
    {
      for (int col = 0; col < r.getWidth(); col++)
      {
        samples = r.getPixel(col, row, samples);
        Pixel newPixel = new Pixel(samples[0], samples[1], samples[2]);
        data[row][col] = newPixel;
      }
    }

    return data;
  }

  /**
   * Set the image's pixel data from an array.  This array matches
   * that returned by getData().  It is an error to pass in an
   * array that does not match the image's dimensions or that
   * has pixels with invalid values (not 0-255)
   * @param data The array to pull from
   */
  public void setData(Pixel[][] data)
  {
    int[] pixelValues = new int[3];     // a temporary array to hold r,g,b values
    WritableRaster wr = this.myImage.getRaster();

    if (data.length != wr.getHeight())
    {
      throw new IllegalArgumentException("Array size does not match");
    }
    else if (data[0].length != wr.getWidth())
    {
      throw new IllegalArgumentException("Array size does not match");
    }

    for (int row = 0; row < wr.getHeight(); row++)
    {
      for (int col = 0; col < wr.getWidth(); col++)
      {
        pixelValues[0] = data[row][col].red;
        pixelValues[1] = data[row][col].green;
        pixelValues[2] = data[row][col].blue;
        wr.setPixel(col, row, pixelValues);
      }
    }
  }

	// add a method to compute a new image given weighted averages
	public Pixel[][] weightedAverages(PixelImage pi, int[][] weights, boolean divide16){
		Pixel[][] data = pi.getData();
		Pixel[][] newData = data;
		
		// iterate through pixels
		for (int row = 0; row < pi.getHeight(); row++) {
			for (int col = 0; col < pi.getWidth(); col++) {
				// store current pixel
				Pixel temp = data[row][col];
				// for computing averages
				int red = 0, green = 0, blue = 0;
				// iterate through weights and adjacent pixels
				for (int i = 0; i < 3; i++){
					for (int j = 0; j < 3; j++){
						// need to ensure we stay within bounds of array
						if ((row-1+i) >= 0 && 
							(col-1+j) >= 0 && 
							(row-1+i) < pi.getHeight() && 
							(col-1+j) < pi.getWidth()){
								// add each adjacent pixel, multiplied by its corresponding weight
								red += data[(row-1+i)][(col-1+j)].red * weights[i][j];
								green += data[(row-1+i)][(col-1+j)].green * weights[i][j];
								blue += data[(row-1+i)][(col-1+j)].blue * weights[i][j];
						}
					}
				}
				// passed in if pixels will need divided by 16
				if (divide16){
					temp.red = red / 16;
					temp.green = green / 16;
					temp.blue = blue / 16;
				} else {
					temp.red = red;
					temp.green = green;
					temp.blue = blue;
				}
				// correct any out of bounds
				if (temp.red > 255){
					temp.red = 255;
				}
				if (temp.green > 255){
					temp.green = 255;
				}
				if (temp.blue > 255){
					temp.blue = 255;
				}
				if (temp.red < 0){
					temp.red = 0;
				}
				if (temp.green < 0){
					temp.green = 0;
				}
				if (temp.blue < 0){
					temp.blue = 0;
				}
				// assign our new pixel data
				newData[row][col] = temp;
			}
		}
		return newData;
	}
}