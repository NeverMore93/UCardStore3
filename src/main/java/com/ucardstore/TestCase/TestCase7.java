package com.ucardstore.TestCase;

import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;

/**
 * Created by YUAN on 2016/9/27.
 */
public class TestCase7 {
    public static void main(String[] args) throws IOException {
        File file1 = new File("1.txt");

        InputStream inputStream = new FileInputStream(file1);
        String str =  IOUtils.toString(inputStream);
        System.out.print(str);
        File file = new File("wang.png");
        Path path = file.toPath();
        Files.write(path, Base64.getDecoder().decode(str));
    }
}
