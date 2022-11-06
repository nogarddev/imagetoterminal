import javax.imageio.*;
import java.awt.image.*;
import java.awt.Color;
import java.lang.*;
import java.io.*;
import java.util.*;
class TerminalPlayer {
    static Integer currentframe;
    static String filename;
    static Integer image_width;
    static Integer image_height;
    static Integer x;
    static Integer y;
    static Integer i;
    static Color current_pixel;
    static String[] frame;
    public static BufferedImage image;
    public static void playvideo(String foldername, Integer frames) {
        currentframe = 0;
        while ((currentframe > frames) == false) {
            currentframe++;
            filename = String.valueOf(currentframe);
            if (currentframe < 10000) {
                if (currentframe < 1000) {
                    if (currentframe < 100) {
                        if (currentframe < 10) {
                            filename = "0" + filename;
                        }
                        filename = "0" + filename;
                    }
                    filename = "0" + filename;
                }
                filename = "0" + filename;
            }
//            File frame = new File("./" + foldername + "/" + filename + ".png");
//            System.out.println("./" + foldername + "/" + filename + ".png");
            try {
                image = ImageIO.read(new File("./" + foldername + "/" + filename + ".png"));
            } catch (Exception ex) {
                System.out.println("Image import failed");
                System.out.println("./" + foldername + "/" + filename + ".png");
            }
            image_width = image.getWidth();
            image_height = image.getHeight();
            String[] frame = new String[image_height];
            y = 0;
            x = 0;
            i = 0;
            while (y.equals(image_height) == false) {
                x = 0;
                current_pixel = new Color(image.getRGB(x, y));
                frame[y] = "[48;2;" + current_pixel.getRed() + ";" + current_pixel.getGreen() + ";" + current_pixel.getBlue() + "m ";
                x++;
                while (x.equals(image_width) == false) {
                    current_pixel = new Color(image.getRGB(x, y));
                    frame[y] = frame[y] + "[48;2;" + current_pixel.getRed() + ";" + current_pixel.getGreen() + ";" + current_pixel.getBlue() + "m ";
                    x++;
                }
                y++;
            }
            System.out.print("[H");
//            System.out.print("[2J");
            while (i.equals(frame.length) == false) {
                System.out.println(frame[i++]);
            }
//            System.out.println(currentframe);
            currentframe++;
            Sleep("57");//60fps
//            Sleep("114");//30fps
        }
    }
    public static void Sleep(String ms) {
        try {
            timeout1(ms);
        } catch (Exception x) {
            //blank
        }
    }
    public static void timeout1(String ms)
    throws InterruptedException {
        long ms_long = Long.parseLong(ms);
        Thread.sleep(ms_long);
    }
}
