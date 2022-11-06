# ImageToTerminal
ImageToTerminal is a tool to change videos to ansi 24 bit colour codes, by splitting the video into images and then turning the image's pixels into averaged values to match the terminal resolution and then finally outputting the codes into frame files.
TerminalPlayer is a tool to interpret the output of ImageToTerminal and display it in the terminal.
To run: run "python3 split.py"

Credit for the python script I used and modified to extract the frames from the video: https://stackoverflow.com/questions/33311153/python-extracting-and-saving-video-frames
## usage
Look in "/demos/Main.java" to see how to adress the TerminalPlayer script. The options are in the order {directory of the folder of files for usage (the output of ImageToTerminal},{the amount of frames to be played},{the fps to play them at} 

To use this you must run split.py and enter the dimensions of your console window. The dimensions you choose must be a factor (or perfect multiple) of the previous dimensions or the script will fail.

When entering the output folder, make sure it already exisits as the script will not make its own folder, and you would not want to lose frames.

Make sure that you empty the frames folder before usage and make suree you do not copy the "frames" folder as your output, the output will be the folder you entered manually.

## Running the demo
To run the demo, clone the files provided and in the root directory make the folder "/outputdir/" then, run "python3 split.py", enter the file name as bad_apple.mp4, then wait for it to split the video, then enter in the width and height of your console using the rules stated in usage earlier, for example, width: 160 and height: 36. Enter the number 6571 as the number of frames and wait for it to process. Once done, cut the folder "/outputdir" to the "/demos/" folder, cd to the "/demos/" folder and run the command "java Main" to be able to see the demo. Splitting the video may take some time but be assured it is not frozen despite the first section's lack of a progress bar.
