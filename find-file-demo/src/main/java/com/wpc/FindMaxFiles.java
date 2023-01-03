package com.wpc;

import org.junit.Test;

import java.io.File;
import java.util.Map;
import java.util.Scanner;

/**
 * @author wangpeican
 * @date 2022/3/25 21:49
 */


public class FindMaxFiles {
    @org.junit.Test
    public void Main() {
        Scan scan = new Scan();
        Map<String, Long> files = scan.allScan(new File("c:/"));
        for (String str : files.keySet()) {
            System.out.println(str);
        }
        System.out.println();
        System.out.println("扫描结束");
    }
}
