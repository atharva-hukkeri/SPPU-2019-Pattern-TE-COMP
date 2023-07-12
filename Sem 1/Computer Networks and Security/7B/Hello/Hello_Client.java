import java.net.*;
import java.io.*;

public class Hello_Client {
    public static void main(String[] args)
            throws IOException {
        Socket s = new Socket("localhost", 4999);
        DataInputStream din = new DataInputStream(s.getInputStream());
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "", str2 = "";
        while (!str.equals("stop")) {
            System.out.print("Enter Message For server: ");

            str = br.readLine();
            dout.writeUTF(str);
            dout.flush();
            str2 = din.readUTF();
            System.out.println("Message From server: " + str2);
        }
        dout.close();
        s.close();
    }
}