package info.adavis.androidnsample;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;

/**
 * @author Annyce Davis
 */
public class MyAlertDialogFragment extends DialogFragment {

    private static final String TAG = MyAlertDialogFragment.class.getSimpleName();

    public interface MyAlertDialogFragmentListener {
        void positiveButtonClicked();

        default void negativeButtonClicked() {
            Log.d(TAG, "the negative button was clicked");
        }
    }

    public static MyAlertDialogFragment newInstance(String name) {
        MyAlertDialogFragment frag = new MyAlertDialogFragment();
        Bundle args = new Bundle();
        args.putString("name", name);
        frag.setArguments(args);
        return frag;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        String name = getArguments().getString("name");

        return new AlertDialog.Builder(getActivity())
                .setTitle(String.format("Welcome to N, %s!", name))
                .setPositiveButton(R.string.alert_dialog_ok,
                        (dialog, whichButton) -> {
                            ((MyAlertDialogFragmentListener) getActivity()).positiveButtonClicked();
                        }
                )
                .setNegativeButton(R.string.alert_dialog_cancel,
                        (dialog, whichButton) -> {
                            ((MyAlertDialogFragmentListener) getActivity()).negativeButtonClicked();
                        }
                )
                .create();
    }
}
