package np.com.devish.taskmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText etLoginUsername, etLoginPassword;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etLoginUsername = findViewById(R.id.etLoginUsername);
        etLoginPassword = findViewById(R.id.etLoginPassword);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validation()){

                }else{
                    Toast.makeText(LoginActivity.this, "Username or password incorrect.", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private boolean validation(){
        if (TextUtils.isEmpty(etLoginUsername.getText())){
            etLoginUsername.setError("Enter username");
            etLoginUsername.requestFocus();
            return false;
        }else if(TextUtils.isEmpty(etLoginPassword.getText())){
            etLoginPassword.setError("Enter password");
            etLoginPassword.requestFocus();
            return false;
        }
        return true;
    }
}
