package com.ucardstore.TestCase;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

/**
 * Created by YUAN on 2016/9/26.
 */
public class TestCase6 {
    public static void main(String[] args) throws IOException {
        File file   = new File("wang1.png");
        Path path  = file.toPath();
       String baseString =  Base64.getEncoder().encodeToString(Files.readAllBytes(path));
        System.out.println(baseString);
        File file1 = new File("wang.png");
        Path path1 = file1.toPath();
        Files.write(path1, Base64.getDecoder().decode(baseString));

    }
}
