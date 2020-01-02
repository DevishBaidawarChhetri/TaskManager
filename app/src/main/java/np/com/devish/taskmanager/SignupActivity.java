package np.com.devish.taskmanager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {

    ImageView imageProfile;
    EditText etFirstName, etLastName, etUsername, etPassword, etConfirmPassword;
    Button btnSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        imageProfile = findViewById(R.id.imgProfile);
        etFirstName = findViewById(R.id.etFirstName);
        etLastName = findViewById(R.id.etLastName);
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        etConfirmPassword = findViewById(R.id.etCOnfirmPassword);
        btnSignup = findViewById(R.id.btnSignup);

        imageProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BrowseImage();
            }
        });

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validation()){
                    Intent intent = new Intent (SignupActivity.this, LoginActivity.class);
                    startActivity(intent);
                    Toast.makeText(SignupActivity.this, "Signup Successful", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void BrowseImage(){
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent,0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK){
            if (data == null){
                Toast.makeText(this, "Please select an image", Toast.LENGTH_SHORT).show();
            }
        }
        Uri uri = data.getData();
        imageProfile.setImageURI(uri);
//        imagePath = getRealPathFromUrl(uri);
    }


    private boolean validation(){
        if(TextUtils.isEmpty(etFirstName.getText())){
            etFirstName.setError("Enter first name.");
            etFirstName.requestFocus();
            return false;
        }else if(TextUtils.isEmpty(etLastName.getText())){
            etLastName.setError("Enter last name.");
            etLastName.requestFocus();
            return false;
        }else if(TextUtils.isEmpty(etUsername.getText())){
            etUsername.setError("Enter username.");
            etUsername.requestFocus();
            return false;
        }else if(TextUtils.isEmpty(etPassword.getText())) {
            etPassword.setError("Enter password");
            etPassword.requestFocus();
            return false;
        }else if(TextUtils.isEmpty(etConfirmPassword.getText())){
            etConfirmPassword.setError("Enter confirm password");
            etConfirmPassword.requestFocus();
            return false;
        }
        return true;
    }
}
