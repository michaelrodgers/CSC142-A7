// Write your short report here (-2 if there is no report)
/*
 * 
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
	}
}