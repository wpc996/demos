package com.wpc;

import java.io.File;
import java.util.*;

/**
 * @author wangpeican
 * @date 2022/3/25 21:48
 */

public class Scan {
    private Map<String, Long> files = new HashMap<String, Long>();

    public String maxFileName;

    public Long maxFileSize = 0L;

    public Map<String, Long> allScan(File f) {
        // 将传入的File对象变成File数组
        File[] lf = f.listFiles();
        // 如果为空则结束这次方法。避免空指针异常
        if (lf == null) {
            return files;
        }
        // 循环遍历lf中的每个File对象
        for (File f1 : lf) {
            // 如果当前遍历到的这个File对象是文件夹
            if (f1.isDirectory()) {
                // 得到当前文件夹的路径
                String path = f1.getAbsolutePath();
                // 重新调用当前方法，并传入刚刚遍历到的文件夹对象进去
                files.putAll(allScan(new File(path)));
                // 如果当前File对象是一个文件
            } else {
                if (f1.length() > 100000000) {
                    files.put(f1.getAbsolutePath(), f1.length());
                }
            }
        }
        return files;
    }
}
