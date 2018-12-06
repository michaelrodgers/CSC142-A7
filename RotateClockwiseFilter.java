/**
 * Filter that rotates an image clockwise.  Only works on square images.
 * @author Michael Rodgers and Benjamin Elia
 * @version 2018.11.25
 */

public class RotateClockwiseFilter implements Filter {
  
  public void filter (PixelImage theImage){
    
        //Checks if the image is square, if not, it throws and IllegalStateException
        if(theImage.getHeight() != theImage.getWidth()){
          
           throw new IllegalStateException("The image you have provided is not square.");
        }
        
        //2D Pixel array to hold the PixelImage
        Pixel[][] data = theImage.getData();
        
        //2D Pixel Array to hold the rotated image
        Pixel[][] rotateddata = new Pixel[data.length][data[0].length];
         
        //Loop within a loop to process throw every row and column
        for(int i = 0; i < theImage.getHeight(); i++){
            for(int row = 0; row < theImage.getHeight(); row++) {
          
                //Sets the value of the rightmost pixel of the column to the first pixel of the leftmost row
                rotateddata[row][data[0].length -1 -i] = data[i][row];
           
           
           
           
       
         }
         }
  //updates the PixelImage   
  theImage.setData(rotateddata);
  }
}