package iut.paci.noelcommunity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private EditText login;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void tryAuth(View v)
    {
        Intent intent = new Intent(this,DistrictActivity.class);
        Bundle extra = new Bundle();
        login = (EditText)findViewById(R.id.login_title);
        password = (EditText)findViewById(R.id.password_title);

        String s_login = login.getText().toString();
        String s_password = password.getText().toString();

        if (!s_login.equals("John")) {
            Toast.makeText(getApplicationContext(), "Le login est incorrect.", Toast.LENGTH_SHORT)
                    .show();
            return;
        }

        if (!s_password.equals("test")) {
            Toast.makeText(getApplicationContext(), "Le mdp est incorrect.", Toast.LENGTH_SHORT)
                    .show();
            return;
        }

        extra.putString("login",s_login);
        extra.putString("password",s_password);
        intent.putExtras(extra);
        startActivity(intent);
    }
}
