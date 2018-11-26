package com.thinkbiganalytics.uob;

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Main {

    public static void main(String[] args) throws IOException {

        // jvm -verbose:gc -Xmx64m -Xms64m
        // use G1GC(?)
        MessageDigest md;
        FileInputStream fis;
        int numread;

        try {

            md = MessageDigest.getInstance("MD5");
            byte[] md5BytesArr = md.digest();
            byte[] dataBytesArr = new byte[1024];

            StringBuilder sb = new StringBuilder();

            fis = new FileInputStream("/Users/sm186140/Dev/Codes/Others/SplitCombineMD5/scripts/mybigfile.txt");


            while ((numread = fis.read(dataBytesArr)) != -1) md.update(dataBytesArr, 0, numread);

            for (byte mdbyte: md5BytesArr) sb.append(Integer.toString((mdbyte & 0xff) + 0x100, 16).substring(1));

            System.out.println("MD5 Hex Digest: " + sb.toString());

        } catch (NoSuchAlgorithmException | FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}