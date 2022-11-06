# imagetoterminal
currently a WIP tool to change videos to ansi 256 bit colour codes, by splitting the video into images and then turning the image's pixels into averaged values to match the terminal resolution and then finally outputting the codes into a file
To run: run "python3 split.py"

Credit for the python script I used: https://stackoverflow.com/questions/33311153/python-extracting-and-saving-video-frames
## usage
Look in "/demos/Main.java" to see how to adress the TerminalPlayer script. Custom FPS update will come to this at some point but currently you can edit the fps by looking at lines 68 and 69 of /demos/TerminalPlayer.java

To use this you must run split.py and enter the dimensions of your console window. The dimensions you choose must be a factor (or perfect multiple) of the previous dimensions or the script will fail.

When entering the output folder, make sure it already exisits as the script will not make its own folder, and you would not want to lose frames.

Make sure that you empty the frames folder before usage and make suree you do not copy the "frames" folder as your output, the output will be the folder you entered manually.
