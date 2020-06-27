package com.example.enviro2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.GithubAuthProvider;
import com.google.firebase.auth.GoogleAuthProvider;

public class login extends AppCompatActivity {
    public static final int GOOGLE_SIGN_IN_CODE = 10005;
    EditText memail,mpass;
    Button mloginBtn;
    TextView mcreateBtn,forgotpasslink;
    ProgressBar progressbar;
    FirebaseAuth fAuth;
    SignInButton signGoogle;
    GoogleSignInOptions gso;
    GoogleSignInClient signInClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        memail = findViewById(R.id.email);
        mpass  = findViewById(R.id.pass);
        progressbar = findViewById(R.id.progressBar2);
        fAuth = FirebaseAuth.getInstance();
        mloginBtn = findViewById(R.id.loginBtn);
        mcreateBtn = findViewById(R.id.createBtn);
        forgotpasslink = findViewById(R.id.forgotpass);
        signGoogle = findViewById(R.id.signGoogle);


        mloginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = memail.getText().toString().trim();
                String pass  = mpass.getText().toString().trim();
                if (TextUtils.isEmpty(email)){
                    memail.setError("Email is required");
                    return;
                }
                if(TextUtils.isEmpty(pass)){
                    mpass.setError("Password is required");
                    return;
                }
                if (pass.length()<6){
                    mpass.setError("Password must be >= 6 Character");
                    return;
                }

                progressbar.setVisibility(View.VISIBLE);

                //authentication the user

                fAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(login.this, "Logged in Successfully.", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),Home.class));
                            finish();
                        }else {
                            Toast.makeText(login.this, "Error !"+ task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            progressbar.setVisibility(View.GONE);
                        }
                    }
                });
            }
        });


        mcreateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),register.class));

            }
        });

        forgotpasslink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText resetMail = new EditText(v.getContext());
                AlertDialog.Builder passwordResetDialog = new AlertDialog.Builder(v.getContext());
                passwordResetDialog.setTitle("Reset Password ?");
                passwordResetDialog.setMessage("Enter Your Email To Recieve Reset Link");
                passwordResetDialog.setView(resetMail);

                passwordResetDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //extract the email and send reset link
                        String  mail = resetMail.getText().toString();
                        fAuth.sendPasswordResetEmail(mail).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(login.this, "Reset Link To Your Email",Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(login.this, "Error! Reset Link is not Sent "+e. getMessage(),Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });
                passwordResetDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //close the Dialog
                    }
                });
                passwordResetDialog.create().show();

            }

        });

        //google sign in

        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken("1094785241962-pcm43mim1upbrt7sgfltofpve2bmfshb.apps.googleusercontent.com")
                .requestEmail()
                .build();
        signInClient = GoogleSignIn.getClient(this,gso);

        GoogleSignInAccount signInAccount = GoogleSignIn.getLastSignedInAccount(this);

        if (signInAccount != null || fAuth.getCurrentUser() != null){
            startActivity(new Intent(this,Home.class));
            finish();
        }

        signGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sign = signInClient.getSignInIntent();
                startActivityForResult(sign,GOOGLE_SIGN_IN_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
       if(requestCode == GOOGLE_SIGN_IN_CODE) {
           Task<GoogleSignInAccount> signInTask = GoogleSignIn.getSignedInAccountFromIntent(data);

           try {
               GoogleSignInAccount signInAccount = signInTask.getResult(ApiException.class);

               AuthCredential authCredential = GoogleAuthProvider.getCredential(signInAccount.getIdToken(),null);
               fAuth.signInWithCredential(authCredential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                   @Override
                   public void onComplete(@NonNull Task<AuthResult> task) {
                       Toast.makeText(getApplicationContext(),"Your Google Account is Connected to Our Application",Toast.LENGTH_SHORT).show();
                       startActivity(new Intent(getApplicationContext(),Home.class));
                   }
               });


         Toast.makeText(this,"Your Google Account is Connected to Our Application",Toast.LENGTH_SHORT).show();
               startActivity(new Intent(this,Home.class));
           } catch (ApiException e) {
               e.printStackTrace();
           }
       }
    }

}
