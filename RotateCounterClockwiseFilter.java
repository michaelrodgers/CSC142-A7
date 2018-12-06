/**
 Filter that rotates an image counter clockwise.  Only works on square images.
 * @author Michael Rodgers and Benjamin Elia
 * @version 2018.11.25
 */
public class RotateCounterClockwiseFilter implements Filter {
  
  public void filter (PixelImage theImage){
       
        //Checks if the image is square, if not, it throws and IllegalStateException 
        if(theImage.getHeight() != theImage.getWidth()){
           throw new IllegalStateException("The image you have provided is not square.");
        }
        
        // get the data from the image
        Pixel[][] data = theImage.getData();
        Pixel[][] rotateddata = new Pixel[data.length][data[0].length];
         
        for(int i = 0; i < theImage.getHeight(); i++){
            for(int row = 0; row < theImage.getHeight(); row++) {
          
                //Sets the value of the rightmost pixel of the row to the first pixel of the leftmost column
                 rotateddata[data[0].length -1 -row][i] = data[i][row];
          
           
       
        }
        }
  //updates the image     
  theImage.setData(rotateddata);
   
           
  }
}