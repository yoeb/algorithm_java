package com.jmeter;

import java.io.*;

/**
 * @author yangbin
 * @date 2020-08-26 15:02
 */
public class generateMobile {

    public static void main(String[] args) throws IOException {
        File file = new File("phone300w.text");
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        for (int i = 100 * 10000; i < 500 * 10000; i++) {
            writer.write("1300" + i);
            writer.newLine();
        }
        writer.close();
    }

}
