package info.adavis.androidnsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText nameEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEditText = (EditText) findViewById(R.id.editText);
        final Button submitButton = (Button) findViewById(R.id.button);

        submitButton.setOnClickListener(
                view -> Toast.makeText(this, String.format("Welcome to N, %s!",
                            nameEditText.getText().toString()), Toast.LENGTH_LONG).show()
        );
    }

}
