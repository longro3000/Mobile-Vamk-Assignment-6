package com.example.assignment_6;

import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;

import android.view.View;
import android.view.View.OnClickListener;

import android.view.ViewGroup;

import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;




public class MainActivity extends AppCompatActivity {

    EditText FirstNameEditText = null, LastNameEditText, PhoneNumberEditText, EducationEditText, HobbiesEditText, SearchEditText;
    TextView summaryTextView = null, searchTextView = null;
    LayoutParams viewLayoutParams = null;
    Button SubmitButton, SearchButton;
    // Here we create the layout
    LinearLayout linearLayout;

    ArrayList<Contact> phoneCatalog = new ArrayList<Contact>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // initial Some data

        Contact newContact1 = new Contact("Nguyen", "Bui", "0469540115", "Bachelor", "dálkdhasfkljsaf");
        Contact newContact2 = new Contact("Hyeok", "Lee Sang", "2013151620", "HighSchool", "Win Worlds");
        Contact newContact3 = new Contact("abc", "def", "0123456789", "Master", "abcdefghijklmnobq");
        Contact newContact4 = new Contact("Luan", "Hoang", "20132020", "Bachelor", "Pelu");

        phoneCatalog.add(newContact1);
        phoneCatalog.add(newContact2);
        phoneCatalog.add(newContact3);
        phoneCatalog.add(newContact4);
// Here we define parameters for views
        viewLayoutParams = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        viewLayoutParams.leftMargin = 40;
        viewLayoutParams.rightMargin = 40;
        viewLayoutParams.topMargin = 10;
        viewLayoutParams.bottomMargin = 10;
        linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
// Here we define a text view
        TextView FirstNameTextView = new TextView(this);
        FirstNameTextView.setText("First Name");
        FirstNameTextView.setLayoutParams(viewLayoutParams);
        linearLayout.addView(FirstNameTextView);
// Here we define the edit text
        FirstNameEditText = new EditText(this);
        FirstNameEditText.setLayoutParams(viewLayoutParams);


        linearLayout.addView(FirstNameEditText);
        // Here we define a text view
        TextView LastNameTextView = new TextView(this);
        LastNameTextView.setText("Last Name");
        LastNameTextView.setLayoutParams(viewLayoutParams);
        linearLayout.addView(LastNameTextView);
// Here we define the edit text
        LastNameEditText = new EditText(this);
        LastNameEditText.setLayoutParams(viewLayoutParams);


        linearLayout.addView(LastNameEditText);
        // Here we define a text view
        TextView PhoneNumberTextView = new TextView(this);
        PhoneNumberTextView.setText("Phone Number");
        PhoneNumberTextView.setLayoutParams(viewLayoutParams);
        linearLayout.addView(PhoneNumberTextView);
// Here we define the edit text
        PhoneNumberEditText = new EditText(this);
        PhoneNumberEditText.setInputType(InputType.TYPE_CLASS_PHONE);
        PhoneNumberEditText.setLayoutParams(viewLayoutParams);


        linearLayout.addView(PhoneNumberEditText);
        // Here we define a text view
        TextView EducationTextView = new TextView(this);
        EducationTextView.setText("Education Level");
        EducationTextView.setLayoutParams(viewLayoutParams);
        linearLayout.addView(EducationTextView);
// Here we define the edit text
        EducationEditText = new EditText(this);
        EducationEditText.setLayoutParams(viewLayoutParams);


        linearLayout.addView(EducationEditText);
        // Here we define a text view
        TextView HobbiesTextView = new TextView(this);
        HobbiesTextView.setText("Hobbies");
        HobbiesTextView.setLayoutParams(viewLayoutParams);
        linearLayout.addView(HobbiesTextView);
// Here we define the edit text
        HobbiesEditText = new EditText(this);
        HobbiesEditText.setLayoutParams(viewLayoutParams);


        linearLayout.addView(HobbiesEditText);

//Submit Button

        SubmitButton = new Button(this);
        SubmitButton.setText("Submit");
        SubmitButton.setLayoutParams(viewLayoutParams);
        SubmitButton.setOnClickListener(buttonSubmitOnClick);
        linearLayout.addView(SubmitButton);


// Here we define a text view
        summaryTextView = new TextView(this);
        summaryTextView.setLayoutParams(viewLayoutParams);
        linearLayout.addView(summaryTextView);

        TextView SearchTextView = new TextView(this);
        SearchTextView.setText("Search");
        SearchTextView.setLayoutParams(viewLayoutParams);
        linearLayout.addView(SearchTextView);
        // Here we define the edit text
        SearchEditText = new EditText(this);
        SearchEditText.setLayoutParams(viewLayoutParams);
        linearLayout.addView(SearchEditText);

//Search Button

        SearchButton = new Button(this);
        SearchButton.setText("Search");
        SearchButton.setLayoutParams(viewLayoutParams);
        SearchButton.setOnClickListener(buttonSearchOnClick);
        linearLayout.addView(SearchButton);

// Here we define a text view
        searchTextView = new TextView(this);
        searchTextView.setLayoutParams(viewLayoutParams);
        linearLayout.addView(searchTextView);
        ScrollView scrollView = new ScrollView(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        scrollView.setLayoutParams(layoutParams);

        LinearLayout.LayoutParams linearLayoutParams = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT);

        scrollView.addView(linearLayout);
        this.addContentView(scrollView, layoutParams);
    }

    private OnClickListener buttonSubmitOnClick = new OnClickListener() {
        @Override
        public void onClick(View v) {
                boolean feedback = false;
                if (FirstNameEditText.getText().length() == 0) {
                    FirstNameEditText.setBackgroundColor(Color.rgb(254, 150, 150));
                    feedback = true;
                }
                if (LastNameEditText.getText().length() == 0) {
                    LastNameEditText.setBackgroundColor(Color.rgb(254, 150, 150));
                    feedback = true;
                }
                if (PhoneNumberEditText.getText().length() == 0) {
                    PhoneNumberEditText.setBackgroundColor(Color.rgb(254, 150, 150));
                    feedback = true;
                }
                if (EducationEditText.getText().length() == 0) {
                    EducationEditText.setBackgroundColor(Color.rgb(254, 150, 150));
                    feedback = true;
                }
                if (HobbiesEditText.getText().length() == 0) {
                    HobbiesEditText.setBackgroundColor(Color.rgb(254, 150, 150));
                    feedback = true;
                }
                if (feedback)
                    Toast.makeText(getBaseContext(), "Missing data!", Toast.LENGTH_SHORT).show();
                else {
                    Contact newContact = new Contact(FirstNameEditText.getText().toString(),
                                                        LastNameEditText.getText().toString(),
                                                        PhoneNumberEditText.getText().toString(),
                                                        EducationEditText.getText().toString(),
                                                        HobbiesEditText.getText().toString());

                    phoneCatalog.add(newContact);
                    String summaryString ="";

                    for (Contact e : phoneCatalog) {
                        summaryString += e.toString() + "\n";
                    }
                    summaryTextView.setText(summaryString);


            };
        };
    };
    private OnClickListener buttonSearchOnClick = new OnClickListener(){
        @Override
        public void onClick(View v) {
            if (SearchEditText.getText().length() == 0) {
                SearchEditText.setBackgroundColor(Color.rgb(254, 150, 150));
            } else {
                String searchString = "";
                for (Contact e : phoneCatalog) {
                    if (e.Search(SearchEditText.getText().toString())) {
                        searchString += e.toString() + "\n";
                    }
                }
                if (searchString.length() >0) searchTextView.setText(searchString); else
                    searchTextView.setText("Not Found !!!");
            }
        }
    };
}
