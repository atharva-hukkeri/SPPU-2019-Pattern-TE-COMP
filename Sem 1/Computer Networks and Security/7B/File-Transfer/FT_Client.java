package ffile;

import java.net.*;
import java.io.*;

public class FT_Client {
    public static void main(String[] argv) throws Exception {
        byte b[] = new byte[20002];
        Socket sr = new Socket("localhost", 4999);
        InputStream is = sr.getInputStream();
        FileOutputStream fr = new FileOutputStream("Path where you want you output file");
        is.read(b, 0, b.length);
        fr.write(b, 0, b.length);
    }
}