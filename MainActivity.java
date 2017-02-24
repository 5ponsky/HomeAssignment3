// package *;

import android.os.AsyncTask;
import android.support.*;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.content.Intent;

import java.io.*;
import java.net.*;

public class MainActivity extends AppCompatActivity {
  String message;
  String ip_address;
  String port;

  @override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
  }

  public void onButtonClick(View v) {
    EditText ip_input = (EditText) findViewById(R.id.ip_input);
    EditText port_input = (EditText) findViewById(R.id.port_input);
    EditText input_msg = (EditText) findViewById(R.id.input_msg);

    message = input_msg.getText().toString();
    ip_address = ip_input.getText().toString();
    port = port_input.getText().toString();

    Messages socketListener = new Messages(ip_address, port, message);
    socketListener.execute();
    input_msg.setText("");
    Log.v("Socket status ", socketListener.getStatus().toString());
  }
}

class Messages extends AsyncTask<Void, Void, Void> {
  String msg;
  String ip_string;
  String port_string;

  public Messages(String _ip, String _port, String _message) {
    msg = _message;
    ip_string = _ip;
    port_string = _port;
    Log.v("msg", msg);
  }

  @override
  protected Void doInBackground(Void...voids) {
    Log.v("doInBackground", "works")

    try {
      // Convert the input IP from string -> InetAddr
      InetAddress ip = InetAddress.getByName(ip_string);

      //Create a new socket connection
      Socket sock = new Socket(ip, Integer.parseInt(port_string));

      // Get the inpurt stream from the Socket
      InputStream in = sock.getInputStream();

      // print out and read in info
      PrintWriter pout = new PrintWriter(sock.getOutputStream(), true);
      BufferedReader bin = new BufferedReader(new InputStreamReader(in));

      String line;

      pout.println(msg);
      while((line = bind.readLine()) != null) {
        Log.v("Received Message", line);
      }

      sock.close();
    } catch(IOException e) {
      Log.e("getFromServer", "Server not connected");
    }
    
    return null;
  }
}
