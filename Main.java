import javax.imageio.*;
import java.awt.image.*;
import java.awt.Color;
import java.lang.*;
import java.io.*;
import java.util.*;
public class Main {
    public static BufferedImage image;
    public static BufferedImage preview;
    public static void main(String args[]) {
        System.out.println("\".\\" + args[0] + "\"");
        try {
            image = ImageIO.read(new File("./" + args[0]));
        } catch (Exception ex) {
            System.out.println("Image import failed");
        }
        Integer imagewidth = image.getWidth();
        Integer imageheight = image.getHeight();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter wanted width:");
        Integer wanted_width = Integer.valueOf(sc.nextLine());
        System.out.println("Enter wanted height:");
        Integer wanted_height = Integer.valueOf(sc.nextLine());
        Integer x = 0;
        Integer y = 0;
        Integer x_factor = imagewidth / wanted_width;
        Integer y_factor = imageheight / wanted_height;
        Integer x1 = 0;
        Integer y1 = 0;
        Integer selected_x = 0;
        Integer selected_y = 0;
        Integer selected_pixels = 0;
        Integer total_r = 0;
        Integer total_g = 0;
        Integer total_b = 0;
        Integer average_r = 0;
        Integer average_g = 0;
        Integer average_b = 0;
        Integer finished_segments = 0;
        Integer total_segments = wanted_width * wanted_height;
        preview = new BufferedImage(wanted_width, wanted_height, BufferedImage.TYPE_INT_RGB);
        Color current_pixel;
        while ((finished_segments.equals(total_segments)) == false) {
//            System.out.println("passed44");
            while ((x.equals(imagewidth)) == false) {
//                System.out.println("(selected_x) == imagewidth) = " + ((x) == imagewidth));
//                System.out.println(x + ".equals(" + imagewidth + ") = " + (x.equals(imagewidth)));
//                System.out.println("(x) / x_factor) + 1 = " + (x) / x_factor + 1);
//                System.out.println("imagewidth = " + imagewidth);
//                System.out.println("y = " + y);
//                System.out.println("x = " + x);
                total_r = 0;
                total_g = 0;
                total_b = 0;
                average_r = 0;
                average_g = 0;
                average_b = 0;
                selected_pixels = 0;
                selected_x = x;
                selected_y = y;
                x1 = 0;
                while (x1 < x_factor) {
                    y1 = 0;
                    selected_y = y;
                    while (y1 < y_factor) {
                        selected_pixels++;
//                        System.out.println("selected_x = " + selected_x);
//                        System.out.println("selected_y = " + selected_y);
                        current_pixel = new Color(image.getRGB(selected_x, selected_y));
                        total_r = total_r + current_pixel.getRed();
                        total_g = total_g + current_pixel.getGreen();
                        total_b = total_b + current_pixel.getBlue();                
                        y1++;
                        selected_y++;
                    }
                    x1++;
                    selected_x++;
                }
                finished_segments++;
                average_r = total_r / selected_pixels;
                average_g = total_g / selected_pixels;
                average_b = total_b / selected_pixels;
                setpixel((x) / x_factor, (y) / y_factor, average_r, average_g, average_b);
                x = x + x_factor;
//                System.out.println("average_r = " + average_r);
//                System.out.println("average_g = " + average_g);
//                System.out.println("average_b = " + average_b);
        System.out.print("[1A");
        System.out.print("[2K");
        System.out.println(finished_segments + " segments done out of " + total_segments + " segments");
            }
            x = 0;
            y = y + y_factor;
        }
        File output = new File("preview.png");
        try {
            ImageIO.write(preview, "png", output);
        } catch (Exception ex) {
            //blank
        }
    }
    public static void setpixel(Integer x, Integer y, Integer r, Integer g, Integer b) {
        int col = (r << 16) | (g << 8) | b;
        preview.setRGB(x, y, col);
    }
}