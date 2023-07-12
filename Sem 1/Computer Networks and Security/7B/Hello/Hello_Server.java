import java.net.*;
import java.io.*;

public class Hello_Server {
    public static void main(String[] args)
            throws IOException {
        ServerSocket ss = new ServerSocket(4999);
        System.out.println("Waitning For Client: ");
        Socket s = ss.accept();
        DataInputStream din = new DataInputStream(s.getInputStream());
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "", str2 = "";
        while (!str.equals("stop")) {
            str = din.readUTF();
            System.out.println("Message From Client: " + str);

            System.out.print("Enter Message for Client: ");

            str2 = br.readLine();
            dout.writeUTF(str2);
            dout.flush();
        }
        din.close();
        s.close();
        ss.close();
    }
}