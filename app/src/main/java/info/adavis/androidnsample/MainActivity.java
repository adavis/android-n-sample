package info.adavis.androidnsample;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements MyAlertDialogFragment.MyAlertDialogFragmentListener {

    private static final String TAG = MainActivity.class.getSimpleName();

    private EditText firstNameText;
    private EditText lastNameText;

    private UserService userService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userService = new UserServiceImpl();

        firstNameText = (EditText) findViewById(R.id.firstNameEditText);
        lastNameText = (EditText) findViewById(R.id.lastNameEditText);
        final Button submitButton = (Button) findViewById(R.id.button);

        submitButton.setOnClickListener(
                v -> {
                    DialogFragment fragment = MyAlertDialogFragment.newInstance(
                            firstNameText.getText().toString());
                    fragment.show(getSupportFragmentManager(), "dialog");
                }
        );
    }

    @Override
    public void positiveButtonClicked() {
        User user = new User(firstNameText.getText().toString(), lastNameText.getText().toString());
        userService.saveUser(user);

        Log.d(TAG, "the positive button was clicked by this user: " + UserService.getUserFullName(user));
    }

}
