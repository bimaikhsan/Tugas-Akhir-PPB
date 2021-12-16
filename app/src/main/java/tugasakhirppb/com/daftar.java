package tugasakhirppb.com;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class daftar extends AppCompatActivity {
    ImageButton daftar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);
        daftar=findViewById(R.id.daftar);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myref = database.getReference("user");

        EditText username = findViewById(R.id.username);
        EditText email = findViewById(R.id.email);
        EditText nohp = findViewById(R.id.nomorHP);
        EditText pass = findViewById(R.id.password);

        daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (username.getText().toString().length() == 0){
                    username.setError("username tidak boleh kosong");
                }else if(email.getText().toString().length() == 0){
                    email.setError("Email tidak boleh kosong");
                }else if(nohp.getText().toString().length() == 0){
                    nohp.setError("nohp tidak boleh kosong");
                }else if(pass.getText().toString().length() == 0){
                    pass.setError("password tidak boleh kosong");
                }else{
                    myref.child(username.getText().toString()).child("username").setValue(username.getText().toString());
                    myref.child(username.getText().toString()).child("email").setValue(email.getText().toString());
                    myref.child(username.getText().toString()).child("nomor").setValue(nohp.getText().toString());
                    myref.child(username.getText().toString()).child("password").setValue(pass.getText().toString());
                    masuk();
                }
            }
        });
    }
    public void masuk (){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();

    }
}