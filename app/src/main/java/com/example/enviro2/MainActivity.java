package com.example.enviro2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {
     Button resendcode,changebutton;
     TextView verifyMsg,fullname,email,phone;
     FirebaseAuth fAuth;
     FirebaseFirestore fStore;
     String userId;
     ImageView profilepic;
     StorageReference storageReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resendcode = findViewById(R.id.resendcode);
        verifyMsg  = findViewById(R.id.verifyMsg);
        fullname = findViewById(R.id.profileName);
        email = findViewById(R.id.profileEmail);
        phone = findViewById(R.id.profilePhone);
        profilepic = findViewById(R.id.profilepic);
        changebutton = findViewById(R.id.changebutton);
        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        Log.d("tag", "onCreate:" + fAuth.getCurrentUser().getEmail() + fAuth.getCurrentUser().getDisplayName());
        userId = fAuth.getCurrentUser().getUid();
        final FirebaseUser user = fAuth.getCurrentUser();

        storageReference = FirebaseStorage.getInstance().getReference();
        StorageReference profileRef = storageReference.child("users/"+fAuth.getCurrentUser().getUid()+"/profile.jpg");
        profileRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Picasso.get().load(uri).into(profilepic);
            }
        });




     if (!user.isEmailVerified()){
         verifyMsg.setVisibility(View.VISIBLE);
         resendcode.setVisibility(View.VISIBLE);

         resendcode.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(final View v) {

                 user.sendEmailVerification().addOnSuccessListener(new OnSuccessListener<Void>() {
                     @Override
                     public void onSuccess(Void aVoid) {
                         Toast.makeText(v.getContext(),"Verification Email Has been Sent.", Toast.LENGTH_SHORT);
                     }
                 }).addOnFailureListener(new OnFailureListener() {
                     @Override
                     public void onFailure(@NonNull Exception e) {
                         Log.d("tag","OnFailure:Email not sent"+e.getMessage());
                     }
                 });
             }
         });

     }

     DocumentReference documentReference = fStore.collection("users").document(userId);
     documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
         @Override
         public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
             if (documentSnapshot.exists()) {
                 phone.setText(documentSnapshot.getString("phone"));
                 fullname.setText(documentSnapshot.getString("fname"));
                 email.setText(documentSnapshot.getString("email"));

             }else{
                     Log.d("tag","onEvent: Document do not exists");
                 }
             }
     });



     changebutton.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             // open gallery
        Intent i = new Intent(v.getContext(),EditProfile.class);
        i.putExtra("fullname",fullname.getText().toString());
        i.putExtra("email",email.getText().toString());
        i.putExtra("phone",phone.getText().toString());
        startActivity(i);
        //
         }
     });




    }


    public void logout(final View view){
  FirebaseAuth.getInstance().signOut();
        GoogleSignIn.getClient(this,new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).build()).signOut().addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                startActivity(new Intent (view.getContext(),login.class));
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(MainActivity.this,"Signout Failed",Toast.LENGTH_SHORT).show();
            }
        });
    finish();
    }
}

