package cn.topca.store2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
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

    // 6. Declare a spinner element
    private Spinner mUITypeSpinner;

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

        // 7. Fill the spinner
        ArrayAdapter<StoreType> adapter =
                new ArrayAdapter<StoreType>(this,
                        android.R.layout.simple_spinner_item,
                        StoreType.values());
        adapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        mUITypeSpinner = (Spinner) findViewById(
                R.id.uiTypeSpinner);
        mUITypeSpinner.setAdapter(adapter);
    }

    // 5. Display a message
    private void displayMessage(String pMessage) {
        Toast.makeText(this, pMessage, Toast.LENGTH_LONG).show();
    }

    // 8. Declare store interface from C
    public native String getString(String pKey);
    public native void setString(String pKey, String pString);
}
