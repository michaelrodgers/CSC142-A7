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
		// New array for manipulated photo
		Pixel[][] newData = pi.getData();
		
		// iterate through pixels  //ensure we stay within bounds of array
		for (int row = 1; row < pi.getHeight()-1; row++) {
		       for (int col = 1; col < pi.getWidth()-1; col++) {
					// Assign each pixel into a 3x3 matrix
					Pixel[][] pixelsBox= {
							{data[row-1][col-1], data[row-1][col], data[row-1][col+1]},
							{data[row][col-1], data[row][col], data[row][col+1]},
							{data[row+1][col-1], data[row+1][col], data[row+1][col+1]}};
					
					// Stores Stores 3 values corresponding to red, green, and blue
				    int[] newRGB = new int[3];
					//loops through each rgb color
					for (int x = 0; x < 3; x++) {
						// sum holds a weighted value for a color
						int sum = 0;
						//loops through pixel and weight matrixes multiplying the corresponding values
						for (int y = 0; y < 3; y++){
							for (int z = 0; z < 3; z++){
								//finds sum for red color value
								if (x == 0) {
						        	  sum += pixelsBox[y][z].red * weights[y][z];
						        }
								//finds sum for green color value
						        if (x == 1) {
						        	  sum += pixelsBox[y][z].green * weights[y][z];
						        }
						        //finds sum for blue color value
						        if (x == 2) {
						        	  sum += pixelsBox[y][z].blue * weights[y][z];
						        }
							}
						}
						// divide by 16 if specified
						if (divide16){
							sum /= 16;
						}
						// correct any out of bounds
						if (sum > 255){
							sum = 255;
						}
						if (sum < 0){
							sum = 0;
						}
						// Assign a color value
						newRGB[x] = sum;
						}
						// Create and return the new pixel
				    	Pixel temp = new Pixel(newRGB[0], newRGB[1], newRGB[2]);
						// assign our new pixel data
						newData[row][col] = temp;
		       }
			}
		//Return the new pixel
		return newData;
		}
}