package com.example.e_select;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class AssessmentForm extends AppCompatActivity {

    private TableLayout assessmentTable;
    private TextView averageTextView;
    private TextView commentTextView;
    private EditText commentsEditText;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assessment_form);

        assessmentTable = findViewById(R.id.assessmentTable);
        averageTextView = findViewById(R.id.averageTextView);
        commentTextView = findViewById(R.id.commentTextView);
        commentsEditText = findViewById(R.id.commentsEditText);
        submitButton = findViewById(R.id.submitBtn);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitForm();
            }
        });
    }

    private void submitForm() {
        // Calculate the average
        double average = calculateAverage();

        // Set the average in the averageTextView
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        averageTextView.setText(decimalFormat.format(average));

        // Generate the comment based on the average
        String comment = generateComment(average);
        commentTextView.setText(comment);

        // Get other form data if needed
        String name = ((EditText) findViewById(R.id.nameEditText)).getText().toString();
        String email = ((EditText) findViewById(R.id.emailEditText)).getText().toString();
        String phone = ((EditText) findViewById(R.id.phoneEditText)).getText().toString();
        String additionalComments = commentsEditText.getText().toString();

        // Save the data to the real-time database or perform any desired action
        // ...
    }

    private double calculateAverage() {
        double totalMarks = 0.0;
        int rowCount = assessmentTable.getChildCount();
        int marksCount = 0;

        for (int i = 1; i < rowCount - 2; i++) {
            TableRow row = (TableRow) assessmentTable.getChildAt(i);
            EditText editText = (EditText) row.getChildAt(1);
            String marksStr = editText.getText().toString();

            if (!marksStr.isEmpty()) {
                double marks = Double.parseDouble(marksStr);
                totalMarks += marks;
                marksCount++;
            }
        }

        return (marksCount > 0) ? totalMarks / marksCount : 0.0;
    }

    private String generateComment(double average) {
        if (average >= 60) {
            return "Promoted";
        } else {
            return "Trail Again";
        }
    }
}
