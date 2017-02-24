import java.net.*;
import java.io.*;

public class Server {

  public static void main(String[] args) {
    try {
      while(true) {
        ServerSocket sock = new ServerSocket(6013);
        Socket client = sock.accept();
        PrintWriter pout = new PrintWriter(client.getOutputStream(), true);

        InputStream in = client.getInputStream();
        BufferedReader bin = new BufferedReader(new InputStreamReader(in));

        string line;

        pout println(new java.util.Date().toString());
        System.out.println((client.getInetAddress()));

        System.out.println(bin.readLine());

        client.close();
        sock.close();
      }

    } catch(IOException e) {
        System.out.println("ERROR: COuld not start server");
        e.printStackTrace(System.err);
    }

  }
  
}
