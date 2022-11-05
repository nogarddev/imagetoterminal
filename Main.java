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
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter wanted width:");
        Integer wanted_width = Integer.valueOf(sc.nextLine());
        System.out.println("Enter wanted height:");
        Integer wanted_height = Integer.valueOf(sc.nextLine());
        System.out.println("Enter amount of frames:");
        Integer frames = Integer.valueOf(sc.nextLine());
        Integer currentframe = 0;
        String filename;
        while (currentframe.equals(frames) == false) {
            currentframe++;
            filename = "" + currentframe;
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
            filename = "./frames/" + filename + ".jpg";
            System.out.println("frame " + currentframe + " of frame " + frames);
            System.out.println("");
//            System.out.println(filename);
            try {
                image = ImageIO.read(new File(filename));
            } catch (Exception ex) {
                System.out.println("Image import failed");
            }
            Integer imagewidth = image.getWidth();
            Integer imageheight = image.getHeight();
            String[][] frame = new String[wanted_width][wanted_height];
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
                    frame[(x) / x_factor][(y) / y_factor] = "[48;2;" + average_r + ";" + average_g + ";" + average_b + "m ";
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
//            System.out.print("[38;2;255;0;0m");
            System.out.print("[1A");
            System.out.print("[2K");
            System.out.print("[1A");
            System.out.print("[2K");
            x = 0;
            y = 0;
            frameout = new String[frame.length];
            while (y < frame.length) {
                frameout[y] = "System.out.println(\"";
                while (x < frame[y].length) {
                    frameout[y] = frameout[y] + frame[y][x++];
                }
                System.out.println(frameout[y]);
                frameout[y] = frameout[y] + "\");";
                y++;
                x = 0;
            }
            try {
                File myObj = new File("out.txt");
                if (myObj.createNewFile()) {
                    skip = 1;
                }
            } catch (IOException ex) {
                //blank
            }
            try {
                FileWriter fw = new FileWriter("out.txt", true);
                i = 0;
                fw.write("Sleep(\"17\");\n");
                while (i.equals(frameout.length) == false) {
                    fw.write(frameout[i++] + "\n");
                }
                fw.write("\n");
                fw.close();
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }          
        }
    }
    static File out;
    static Integer skip;
    static Integer i;
    static Integer x;
    static Integer y;
    static String[][] frame;
    static String[] frameout;
    public static void setpixel(Integer x, Integer y, Integer r, Integer g, Integer b) {
        int col = (r << 16) | (g << 8) | b;
        preview.setRGB(x, y, col);
//        String[] args = new String[] {"/bin/bash", "-c", "", "with", "args"};
//        try {
//            Process proc = new ProcessBuilder(args).start();
//        } catch (Exception ex) {
//            //blank
//        }
    }
}