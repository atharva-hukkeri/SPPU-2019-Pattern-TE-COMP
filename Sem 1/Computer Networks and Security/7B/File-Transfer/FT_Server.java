package ffile;

import java.net.*;
import java.io.*;

public class FT_Server {
    public static void main(String[] argv) throws Exception {

        ServerSocket s = new ServerSocket(4999);
        Socket sr = s.accept();
        DataInputStream dis = new DataInputStream(sr.getInputStream());
        String input = dis.readUTF();
        if (input.equals(dis)) {
            FileInputStream fr = new FileInputStream("Your file path" + dis);
            byte b[] = new byte[2002];
            fr.read(b, 0, b.length);
            OutputStream os = sr.getOutputStream();
            os.write(b, 0, b.length);
        } else {
            System.out.println("No such file exists ");
        }
        s.close();
        sr.close();
        dis.close();
    }
}