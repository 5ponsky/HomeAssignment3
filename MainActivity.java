package *;

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
  }
}
