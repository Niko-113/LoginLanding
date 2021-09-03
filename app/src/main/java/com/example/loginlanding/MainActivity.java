package com.example.loginlanding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.loginlanding.db.AppDatabase;
import com.example.loginlanding.db.UserDAO;

import java.util.List;


public class MainActivity extends AppCompatActivity {

    Button loginButton;
    EditText usernameText;
    EditText passwordText;

    UserDAO userDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginButton = findViewById(R.id.loginButton);
        usernameText = findViewById(R.id.usernameEdit);
        passwordText = findViewById(R.id.passwordEdit);

        userDAO = Room.databaseBuilder(this, AppDatabase.class, AppDatabase.DB_NAME)
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build().getUserDAO();

    }

    // Called when the Login button is clicked
    public void login(View view){
        String username = usernameText.getText().toString();
        String password = passwordText.getText().toString();

        if (verify(username, password)) {
            Intent intent = LandingActivity.getIntent(getApplicationContext(), "Welcome user!");
            intent.putExtra("username", username);
            intent.putExtra("userID", userDAO.getUserByUsername(username).getUserID());
            startActivity(intent);
        }
    }

    public boolean verify(String username, String password){
        User user = userDAO.getUserByUsername(username);
        if (user == null){
            Toast.makeText(this, "Username does not exist", Toast.LENGTH_SHORT).show();
            usernameText.requestFocus();
            return false;
        }
        else if (!password.equals(user.getPassword())){
            Toast.makeText(this, "Incorrect password for " + username, Toast.LENGTH_SHORT).show();
            passwordText.requestFocus();
            return false;
        }

        return true;
    }
}