import javax.imageio.*;
import java.awt.image.*;
import java.awt.Color;
import java.lang.*;
import java.io.*;
import java.util.*;
public class Main {
    public static BufferedImage image;
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
        Color current_pixel;
        selected_x = x;
        selected_y = y;
        selected_pixels = 0;
        while (x1 < x_factor) {
            y1 = 0;
            while (y1 < y_factor) {
                selected_pixels++;
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
        x = x + x_factor;
        y = y + y_factor;
        average_r = total_r / selected_pixels;
        average_g = total_g / selected_pixels;
        average_b = total_b / selected_pixels;
        System.out.println("average_r = " + average_r);
        System.out.println("average_g = " + average_g);
        System.out.println("average_b = " + average_b);
    }
}