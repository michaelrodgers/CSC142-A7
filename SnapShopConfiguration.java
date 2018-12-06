// This is a photo editor program that applies different filters to change the image uploaded by the user.
/* 	We have two class (RotateClockwise and RotateCounterClockwise) included in the .java file,
 * but left off of theShop Configuration list. These classes work, but only with perfect square images.
 *  We also have AlmostSepia that runs but did not handle the white pixels as intended.
 * 	This project was greatly simplified by the use of sample code found on GitHub from students in previous quarters.  
 * However, to ensure we understood the code and were not simply copying other students work, we both added additional filters to the project.
 * These filters are the BlackWhite, Darken, RedRemoval filters as well as the Rotate Filters mentioned above.
 * 	Because the code provided by Professor Francois and the GitHub resource, the effort put into this project focused less on
 * how to creatively make filters work, and more on interpreting other people's code and being able to adapt it.
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

    theShop.setDefaultFilename("C:/Users/Michael/Desktop/billg.jpg");
		theShop.addFilter(new FlipHorizontalFilter(), "Flip Horizontal");
		// add your other filters below
		theShop.addFilter(new FlipVerticalFilter(), "Flip Vertical");
		theShop.addFilter(new NegativeFilter(), "Negative Filter");
		theShop.addFilter(new LaplacianFilter(), "LaplacianFilter");
		theShop.addFilter(new GaussianFilter(), "Gaussian Filter");
		theShop.addFilter(new UnsharpMask(), "Unsharp Mask");
		theShop.addFilter(new EdgyFilter(), "Edgy");
		theShop.addFilter(new BlackWhite(), "Black & White");
		theShop.addFilter(new Darken(), "Darken");
		theShop.addFilter(new RedRemoval(), "Red Removal");
        
	}
}