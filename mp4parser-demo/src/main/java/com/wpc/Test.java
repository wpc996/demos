package com.wpc;

import org.mp4parser.Box;
import org.mp4parser.IsoFile;
import org.mp4parser.boxes.iso14496.part12.MovieBox;
import org.mp4parser.boxes.iso14496.part12.TrackBox;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 * @author wangpeican
 * @date 2022/11/24 1:03
 */
public class Test {
    public static void main(String[] args) throws IOException {
        String videoFilePath = "D:\\ChromeDownload\\Butterfly_480p.mp4";
        File videoFile = new File(videoFilePath);
        IsoFile isoFile = new IsoFile(new FileInputStream(videoFile).getChannel());

        if (!videoFile.exists()) {
            throw new FileNotFoundException("File " + videoFilePath + " not exists");
        }

        if (!videoFile.canRead()) {
            throw new IllegalStateException("No read permissions to file " + videoFilePath);
        }

        MovieBox movieBox = org.mp4parser.tools.Path.getPath(isoFile, "moov");
        // 可以打印这个 movieBox  toString 看看里面有啥
        List<Box> boxes = movieBox.getBoxes();
        // 宽高时长获取
        long duration = movieBox.getMovieHeaderBox().getDuration();
        System.out.println(duration);
        int width = 0;
        int height = 0;
        for (Box box : boxes) {
            if (box instanceof TrackBox) {
                TrackBox tBbx = (TrackBox) box;
                width = (int) tBbx.getTrackHeaderBox().getWidth();
                height = (int) tBbx.getTrackHeaderBox().getHeight();
                System.out.println(width);
                System.out.println(height);
                break;
            }
        }
        isoFile.close();
    }
}
