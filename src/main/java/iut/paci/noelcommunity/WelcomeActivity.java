package iut.paci.noelcommunity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {
    private TextView login;
    private TextView password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        Intent intent = getIntent();
        Bundle extra = intent.getExtras();

        login = (TextView) findViewById(R.id.login);
        password = (TextView) findViewById(R.id.password);

        String s_login = extra.getString("login");
        String s_password = extra.getString("password");

        login.setText(s_login);
        password.setText(s_password);
    }
}
