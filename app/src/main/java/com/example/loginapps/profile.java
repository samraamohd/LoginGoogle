package com.example.loginapps;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.squareup.picasso.Picasso;

public class profile extends AppCompatActivity {
    ImageView img;
    TextView name,email;
    Button out;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        img=findViewById(R.id.img);
        name=findViewById(R.id.name);
        email=findViewById(R.id.email);
        out=findViewById(R.id.signout);

        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
        if (acct!=null) {
            String personName = acct.getDisplayName();
            String personEmail = acct.getEmail();
            Uri personPhoto = acct.getPhotoUrl();
            name.setText(personName);
            email.setText(personEmail);
            Picasso.with(this).load(personPhoto).into(img);
        }
    }
}
