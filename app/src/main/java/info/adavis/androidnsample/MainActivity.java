package info.adavis.androidnsample;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements MyAlertDialogFragment.MyAlertDialogFragmentListener {

    private static final String TAG = MainActivity.class.getSimpleName();

    private EditText nameEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEditText = (EditText) findViewById(R.id.editText);
        final Button submitButton = (Button) findViewById(R.id.button);

        submitButton.setOnClickListener(
                v -> {
                    DialogFragment fragment = MyAlertDialogFragment.newInstance(
                            nameEditText.getText().toString());
                    fragment.show(getSupportFragmentManager(), "dialog");
                }
        );
    }

    @Override
    public void positiveButtonClicked() {
        Log.d(TAG, "the positive button was clicked");
    }

}
