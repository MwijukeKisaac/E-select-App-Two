package com.example.e_select;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class StudentData extends AppCompatActivity {

    private TextInputLayout nameTextInputLayout, educationLevelTextInputLayout, subjectsOfInterestTextInputLayout,
            homeAddressTextInputLayout, parentsNamesTextInputLayout, religionTextInputLayout, siblingsTextInputLayout;
    private TextInputEditText nameEditText, educationLevelAutoCompleteTextView, subjectsOfInterestAutoCompleteTextView,
            homeAddressEditText, parentsNamesEditText, religionEditText, siblingsEditText;
    private Button viewFaceButton, captureFaceButton, calculateAgeButton, submitButton;
    private RadioGroup sexRadioGroup, tuitionSourceRadioGroup, parentStatusRadioGroup;
    private RadioButton maleRadioButton, femaleRadioButton, parentsRadioButton, guardianRadioButton,
            scholarshipRadioButton, othersRadioButton, bothAliveRadioButton, oneDeceasedRadioButton,
            divorcedRadioButton, togetherRadioButton;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_data);

        nameTextInputLayout = findViewById(R.id.nameTextInputLayout);
        educationLevelTextInputLayout = findViewById(R.id.educationLevelTextInputLayout);
        subjectsOfInterestTextInputLayout = findViewById(R.id.subjectsOfInterestTextInputLayout);
        homeAddressTextInputLayout = findViewById(R.id.homeAddressTextInputLayout);
        parentsNamesTextInputLayout = findViewById(R.id.parentsNamesTextInputLayout);
        religionTextInputLayout = findViewById(R.id.religionTextInputLayout);
        siblingsTextInputLayout = findViewById(R.id.siblingsTextInputLayout);
        nameEditText = findViewById(R.id.nameEditText);
        educationLevelAutoCompleteTextView = findViewById(R.id.educationLevelAutoCompleteTextView);
        subjectsOfInterestAutoCompleteTextView = findViewById(R.id.subjectsOfInterestAutoCompleteTextView);
        homeAddressEditText = findViewById(R.id.homeAddressEditText);
        parentsNamesEditText = findViewById(R.id.parentsNamesEditText);
        religionEditText = findViewById(R.id.religionEditText);
        siblingsEditText = findViewById(R.id.siblingsEditText);
        viewFaceButton = findViewById(R.id.viewFaceButton);
        captureFaceButton = findViewById(R.id.captureFaceButton);
        calculateAgeButton = findViewById(R.id.calculateAgeButton);
        submitButton = findViewById(R.id.submitButton);
        sexRadioGroup = findViewById(R.id.sexRadioGroup);
        tuitionSourceRadioGroup = findViewById(R.id.tuitionSourceRadioGroup);
        parentStatusRadioGroup = findViewById(R.id.parentStatusRadioGroup);
        maleRadioButton = findViewById(R.id.maleRadioButton);
        femaleRadioButton = findViewById(R.id.femaleRadioButton);
        parentsRadioButton = findViewById(R.id.parentsRadioButton);
        guardianRadioButton = findViewById(R.id.guardianRadioButton);
        scholarshipRadioButton = findViewById(R.id.scholarshipRadioButton);
        othersRadioButton = findViewById(R.id.othersRadioButton);
        bothAliveRadioButton = findViewById(R.id.bothAliveRadioButton);
        oneDeceasedRadioButton = findViewById(R.id.oneDeceasedRadioButton);
        divorcedRadioButton = findViewById(R.id.divorcedRadioButton);
        togetherRadioButton = findViewById(R.id.togetherRadioButton);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitForm();
            }
        });
    }

    private void submitForm() {
        String name = nameEditText.getText().toString();
        String educationLevel = educationLevelAutoCompleteTextView.getText().toString();
        String subjectsOfInterest = subjectsOfInterestAutoCompleteTextView.getText().toString();
        String homeAddress = homeAddressEditText.getText().toString();
        String parentsNames = parentsNamesEditText.getText().toString();
        String religion = religionEditText.getText().toString();
        String siblingsString = siblingsEditText.getText().toString();
        String sex = "";

        int selectedSexRadioButtonId = sexRadioGroup.getCheckedRadioButtonId();
        if (selectedSexRadioButtonId != -1) {
            RadioButton selectedSexRadioButton = findViewById(selectedSexRadioButtonId);
            sex = selectedSexRadioButton.getText().toString();
        }

        String tuitionSource = "";

        int selectedTuitionSourceRadioButtonId = tuitionSourceRadioGroup.getCheckedRadioButtonId();
        if (selectedTuitionSourceRadioButtonId != -1) {
            RadioButton selectedTuitionSourceRadioButton = findViewById(selectedTuitionSourceRadioButtonId);
            tuitionSource = selectedTuitionSourceRadioButton.getText().toString();
        }

        String parentStatus = "";

        int selectedParentStatusRadioButtonId = parentStatusRadioGroup.getCheckedRadioButtonId();
        if (selectedParentStatusRadioButtonId != -1) {
            RadioButton selectedParentStatusRadioButton = findViewById(selectedParentStatusRadioButtonId);
            parentStatus = selectedParentStatusRadioButton.getText().toString();
        }

        int siblings = 0;
        if (!siblingsString.isEmpty()) {
            siblings = Integer.parseInt(siblingsString);
        }

        if (name.isEmpty() || educationLevel.isEmpty() || subjectsOfInterest.isEmpty() || homeAddress.isEmpty()
                || parentsNames.isEmpty() || religion.isEmpty() || siblingsString.isEmpty()
                || selectedSexRadioButtonId == -1 || selectedTuitionSourceRadioButtonId == -1
                || selectedParentStatusRadioButtonId == -1) {
            Toast.makeText(this, "Please fill in all fields.", Toast.LENGTH_SHORT).show();
        } else {
            // Save learner's information to the Realtime Database
            // Here you can write the code to send the data to the Realtime Database

            Toast.makeText(this, "Learner information submitted.", Toast.LENGTH_SHORT).show();
        }
    }
}
