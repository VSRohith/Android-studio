package com.example.newapp;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
public class MainActivity extends AppCompatActivity {
    RadioGroup radioGroup;
    RadioButton newbutton;
    Button button;
    CheckBox c1,c2,c3,c4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText nameEditText=findViewById(R.id.edit_text_name);
        final EditText emailEditText=findViewById(R.id.edit_text_email);
        final EditText phoneEditText=findViewById(R.id.edit_text_phone);
        final EditText passwordEditText=findViewById(R.id.edit_text_password);
        button = (Button) findViewById(R.id.button);
        radioGroup = (RadioGroup) findViewById(R.id.Gender);
        c1 = (CheckBox) findViewById(R.id.readingbooks);
        c2 = (CheckBox) findViewById(R.id.writing);
        c3 = (CheckBox) findViewById(R.id.Outdoor);
        c4 = (CheckBox) findViewById(R.id.singing);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=nameEditText.getText().toString();
                String email=emailEditText.getText().toString();
                String phone=phoneEditText.getText().toString();
                String password=passwordEditText.getText().toString();
                newbutton=(RadioButton)findViewById(radioGroup.getCheckedRadioButtonId());
                String userselection=newbutton.getText().toString();
                String checkBoxChoices = "";
                if (c1.isChecked()) {
                    checkBoxChoices += c1.getText().toString() + ":YES\n";
                }
                else{
                    checkBoxChoices += c1.getText().toString() + ":NO\n";
                }

                if (c2.isChecked()) {
                    checkBoxChoices += c2.getText().toString() + ":YES\n";
                }
                else{
                    checkBoxChoices += c2.getText().toString() + ":NO\n";
                }

                if (c3.isChecked()) {
                    checkBoxChoices += c3.getText().toString() + ":YES\n";
                }
                else{
                    checkBoxChoices += c3.getText().toString() + ":NO\n";
                }

                if (c4.isChecked()) {
                    checkBoxChoices += c4.getText().toString() + ":YES\n";
                }
                else{
                    checkBoxChoices += c4.getText().toString() + ":NO\n";
                }
                String message="Name:" + name +"\nEmail:" + email +"\nPhone" + phone + "\npassword" +password;
                Toast.makeText(MainActivity.this, "Selected Radio Button is:" + userselection  + "\n CheckBox Choices: \n"+ checkBoxChoices  , Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("NAME", name);
                intent.putExtra("EMAIL", email);
                intent.putExtra("PHONE", phone);
                intent.putExtra("PASSWORD", password);
                intent.putExtra("GENDER", userselection);
                intent.putExtra("HOBBIES", checkBoxChoices);
                startActivity(intent);

            }
 ;       });
    }
}
