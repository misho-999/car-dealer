package com.angelov.cardealer.util;


import java.io.*;

public class FileUtilImpl implements FileUtil {


    @Override
    public String readFile(String path) throws IOException {
        File file = new File(path);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));

        StringBuilder sb = new StringBuilder();

        String line;

        while ((line = bufferedReader.readLine()) != null) {
            sb.append(line).append(System.lineSeparator());
        }

        return sb.toString();
    }
}
