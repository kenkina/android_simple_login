package com.company.simplelogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText emailEditText, passwordEditText;
    Button loginButton;
    TextView messageTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailEditText = (EditText) findViewById(R.id.emailEditText);
        passwordEditText = (EditText) findViewById(R.id.passwordEditText);
        loginButton = (Button) findViewById(R.id.loginButton);
        messageTextView = (TextView) findViewById(R.id.messageTextView);
        messageTextView.setText("");

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                messageTextView.setText("");

                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

                String message = "";
                boolean isValid = true;

                String emailStr = emailEditText.getText().toString().trim();
                String passStr = passwordEditText.getText().toString();

                if (emailStr.isEmpty()) {
                    isValid = false;
                    message += "El campo email está vacío.\n";
                } else {
                    if (!emailStr.matches(emailPattern)) {
                        isValid = false;
                        message += "El formato email es incorrecto.\n";
                    }
                }

                if (passStr.isEmpty()) {
                    isValid = false;
                    message += "El campo password está vacío.\n";
                }


                if (isValid) {
                    if ("admin@upc.com".equals(emailStr)
                            && "admin".equals(passStr)) {

                        emailEditText.setText("");
                        passwordEditText.setText("");
                        messageTextView.setText("");

                        startActivity(
                                new Intent(getApplicationContext(),
                                        ManageProductsActivity.class));
                    }
                    message = "Correo o contraseña incorrecta";
                }

                messageTextView.setText(message);
            }
        });

    }
}