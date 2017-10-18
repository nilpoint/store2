package cn.topca.store2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

public class StoreActivity extends AppCompatActivity {
    // 1.Declare some ui elements
    private EditText mUIKeyEdit, mUIValueEdit;

    // 3. Declare two buttons
    private Button mUIGetButton, mUISetButton;

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);

        // 2.Initializes text components.
        mUIKeyEdit = (EditText) findViewById(R.id.uiKeyEdit);
        mUIValueEdit = (EditText) findViewById(R.id.uiValueEdit);

        // 4.Add the buttons' event handlers
        mUIGetButton = (Button) findViewById(R.id.uiGetValueButton);
        mUIGetButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View pView) {
                displayMessage("GetButton Clicked");
            }
        });
        mUISetButton = (Button) findViewById(R.id.uiSetValueButton);
        mUISetButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View pView) {
                displayMessage("SetButton Clicked");
            }
        });
    }

    // 5. Display a message
    private void displayMessage(String pMessage) {
        Toast.makeText(this, pMessage, Toast.LENGTH_LONG).show();
    }
}
