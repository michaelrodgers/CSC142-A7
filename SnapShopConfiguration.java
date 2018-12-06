/* This is a photo editor program that applies different filters to change the image uploaded by the user. 
 * Added a filter: "Red Removal" that rather simply changes the red temp to zero which changes the color of the image
 * Added a filter: "Almost Sepia" that produces an effect similar to sepia. While it produces a similar effect,
 * for colors too close to white there is some distortion in the sepia style
 */

/**
 * A class to configure the SnapShop application
 * 
 * @author Michael Rodgers and Benjamin Elia
 * @version 2018.11.25
 */
public class SnapShopConfiguration
{
  /**
   * Method to configure the SnapShop.  Call methods like addFilter
   * and setDefaultFilename here.
   * @param theShop A pointer to the application
   */
  public static void configure(SnapShop theShop)
  {

    theShop.setDefaultFilename("c:/hw5/billg.jpg");
		theShop.addFilter(new FlipHorizontalFilter(), "Flip Horizontal");
		// add your other filters below
		theShop.addFilter(new FlipVerticalFilter(), "Flip Vertical");
		theShop.addFilter(new NegativeFilter(), "Negative Filter");
		theShop.addFilter(new LaplacianFilter(), "LaplacianFilter");
		theShop.addFilter(new GaussianFilter(), "Gaussian Filter");
		theShop.addFilter(new UnsharpMask(), "Unsharp Mask");
		theShop.addFilter(new EdgyFilter(), "Edgy");
	  	theShop.addFilter(new RedRemoval(), "Red Removal");
	  	theShop.addFilter(new AlmostSepia(), "Almost Sepia");
	}
}
