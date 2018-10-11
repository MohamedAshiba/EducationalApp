package com.example.android.educationalapp;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    // alert dialog to show the final result.
    AlertDialog.Builder resultAlertDialog;

    // variable increasing when chosen the correct answer.
    int examScore;

    // plainText for the name and ID.
    EditText nameEditText, idEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Call method that don't show the keywords when app open.
        requestFocus(nameEditText);

        //Call method that don't show the keywords when app open.
        requestFocus(idEditText);


    }

    /**
     * the finish button clicked when student finish the quiz.
     * @param view
     */
    public void finish_button (View view) {

        additionalQuestion();
        minusQuestion();
        multiQuestion();
        divQuestion();
        smartQuestion();

        nameEditText = (EditText) findViewById(R.id.name_edit_text);
        String name = nameEditText.getText().toString();



        idEditText = (EditText) findViewById(R.id.id_edit_text);
        String id = idEditText.getText().toString();


        // summary of result alert dialog.
        summaryAlertDialog(name, id);



    }

    /**
     * method that don't show the keywords when app open.
     * @param view
     */
    private void requestFocus(View view) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }

    /**
     * the method of correct answer of additional question.
     */
    private void additionalQuestion () {
        RadioButton addRadioButton = (RadioButton) findViewById(R.id.addition_radio_button);
        if (addRadioButton.isChecked()) {
            examScore = examScore + 20;
        }
    }

    /**
     * the method of correct answer of minus question.
     */
    private void minusQuestion () {
        RadioButton minusRadioButton = (RadioButton) findViewById(R.id.minus_radio_button);
        if (minusRadioButton.isChecked()) {
            examScore = examScore + 20;
        }
    }

    /**
     * the method of correct answer of multiplication question.
     */
    private void multiQuestion () {
        RadioButton multiRadioButton = (RadioButton) findViewById(R.id.multi_radio_button);
        if (multiRadioButton.isChecked()) {
            examScore = examScore + 20;
        }
    }

    /**
     * the method of correct answer of division question.
     */
    private void divQuestion () {
        RadioButton divRadioButton = (RadioButton) findViewById(R.id.division_radio_button);
        if (divRadioButton.isChecked()) {
            examScore = examScore + 20;
        }
    }

    /**
     * the method of correct answer of smart question.
     */
    private void smartQuestion () {
        RadioButton smartRadioButton = (RadioButton) findViewById(R.id.smart_radio_button);
        if (smartRadioButton.isChecked()) {
            examScore = examScore + 20;
        }
    }

    /**
     * the method show name, id and result of quiz exam.
     */
    private void summaryAlertDialog (String addName, String addID) {

        resultAlertDialog = new AlertDialog.Builder(this);

        resultAlertDialog.setTitle("Result Math Quiz");
        resultAlertDialog.setPositiveButton("Ok",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Finish activity
                        MainActivity.this.finish();
                    }
                });

        if (examScore > 40) {
            resultAlertDialog.setIcon(R.drawable.happy);
            resultAlertDialog.setMessage("Your name is: " + addName + "\n Your ID is: " + addID + "\n Yor Result is: " + examScore + "%" + "\n Congratulations!!");
        } else {
            resultAlertDialog.setIcon(R.drawable.sad);
            resultAlertDialog.setMessage("Your name is: " + addName + "\n Your ID is: " + addID + "\n Yor Result is: " + examScore + "%" + "\n You Can Try Again");

        }

        resultAlertDialog.create();
        resultAlertDialog.show();
    }


}
