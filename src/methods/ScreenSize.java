package methods;

import java.awt.Dimension;
import java.awt.Toolkit;

public class ScreenSize {
	
	public static int getScreenWidth(){
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = screenSize.getWidth();
		int i = (int) width;
		return i;
	}
	
	public static int getScreenHeight(){
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double height = screenSize.getHeight();
		int i = (int) height;
		return i;
	}

}
