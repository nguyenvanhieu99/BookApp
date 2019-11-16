package jar;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import java.awt.Image;

class ImageUtils{
    public static Image getImage(String path, int width, int height){
        Image img = null;
        try {
            img = ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return img.getScaledInstance(width, height, Image.SCALE_DEFAULT);
    }
}