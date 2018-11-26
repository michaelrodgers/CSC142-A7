

public class FlipVerticalFilter implements Filter {

	@Override
	public void filter(PixelImage theImage) {
		Pixel[][] data = theImage.getData();

		for (int col = 0; col < theImage.getWidth(); col++) {
			for (int row = 0; row < theImage.getHeight() / 2; row++) {
				Pixel temp = data[row][col];
				data[row][col] = data[theImage.getHeight() - row - 1][col];
				data[theImage.getHeight() - row - 1][col] = temp;
			}
		}

		theImage.setData(data);

	}

}