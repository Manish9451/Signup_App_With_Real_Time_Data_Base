package com.example.realtimedatabase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.realtimedatabase.databinding.ActivityMainBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    String firstName, lastName, email, phoneNumber;
    FirebaseDatabase db;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstName= binding.fname.getText().toString();
                lastName=binding.lname.getText().toString();
                email=binding.email.getText().toString();
                phoneNumber=binding.pnumber.toString();
                if(!firstName.isEmpty() && !lastName.isEmpty() && !email.isEmpty() && !phoneNumber.isEmpty()){

                    User user=new User(firstName,lastName,email,phoneNumber);
                    db =FirebaseDatabase.getInstance();
                    reference =db.getReference("User");
                    reference.child(firstName).setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            binding.fname.setText("");
                            binding.lname.setText("");
                            binding.email.setText("");
                            binding.pnumber.setText("");
                            Toast.makeText(MainActivity.this, "Successfully Updated", Toast.LENGTH_SHORT).show();

                            Intent intent=new Intent(MainActivity.this,WelocmeActivity.class);
                            startActivity(intent);
                            finish();





                        }
                    });
                }
                if(firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || phoneNumber.isEmpty()) {

                    Toast.makeText(MainActivity.this, "Please Fill All Detail First Then Click On Register", Toast.LENGTH_SHORT).show();
                }


            }
        });
    }
}