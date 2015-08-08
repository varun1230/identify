
import java.io.File;

import org.openimaj.image.DisplayUtilities;
import org.openimaj.image.ImageUtilities;
import org.openimaj.image.MBFImage;
import org.openimaj.image.processing.edges.CannyEdgeDetector;

public class Sample {

	
	public static void main(String args[]){
		try {
			
//			VideoCapture videoCapture = new VideoCapture(320, 240);
//			VideoDisplay<MBFImage> vd = VideoDisplay.createVideoDisplay(videoCapture);
//			
//			vd.addVideoListener(new VideoDisplayListener<MBFImage>() {
//				
//				MBFImage lastimage;
//				@Override
//				public void beforeUpdate(MBFImage frame) {
//					// TODO Auto-generated method stub
//					if(lastimage != null){
//						MBFImage tmp = frame.clone();
//						frame.subtractInplace(lastimage).abs();
//						lastimage = tmp;
//					}else{
//						lastimage = frame.clone();
//					}
//				}
//				
//				@Override
//				public void afterUpdate(VideoDisplay<MBFImage> display) {
//					// TODO Auto-generated method stub
//					
//					
//					
//				}
//			});
			
//			
//			File file = new File("file.jpg");
//			if(file.exists()){
//				System.out.println("File exists");
//			}else{
//				System.out.println("File Doesn't exist");
//			}
//			
			MBFImage image = ImageUtilities.readMBF(new File("file.jpg"));
//			MBFImage image = ImageUtilities.readMBF(new URL("http://dl.dropbox.com/u/8705593/sinaface.jpg"));
			System.out.println(image.colourSpace);
			
//			DisplayUtilities.display(image);
//			DisplayUtilities.display(image.getBand(0), "Red Channel");

			
			MBFImage clone = image.clone();
			for (int y=0; y<image.getHeight(); y++) {
			    for(int x=0; x<image.getWidth(); x++) {
			        clone.getBand(1).pixels[y][x] = 0;
			        clone.getBand(2).pixels[y][x] = 0;
			    }
			}
//			DisplayUtilities.display(clone);
			
			
			clone.getBand(1).fill(0f);
			clone.getBand(2).fill(0f);
			
			image.processInplace(new CannyEdgeDetector());
			
			DisplayUtilities.display(image);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
