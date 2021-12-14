package tugasakhirppb.com;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    Button login, regis;
    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login=findViewById(R.id.login);
        regis=findViewById(R.id.daftar);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myref = database.getReference("user");

        EditText username = findViewById(R.id.username);
        EditText password = findViewById(R.id.password);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Query query =myref.orderByChild("username").equalTo(username.getText().toString());
                query.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (snapshot.exists()){
                            for (DataSnapshot user : snapshot.getChildren()) {
                                String getPassword = user.child("password").getValue(String.class);
                                if (password.getText().toString().equals(getPassword)) {
                                    Toast.makeText(MainActivity.this,"Berhasil login",Toast.LENGTH_SHORT).show();
                                    Login();
                                }else{
                                    password.setError("Password salah");
                                }
                            }
                        }else{
                            username.setError("username tidak ditemukan");
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });
        regis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Daftar();
            }
        });

    }
    public void Login (){
        Intent intent = new Intent(this, beranda.class);
        startActivity(intent);
    }
    public void Daftar (){
        Intent intent = new Intent(this, daftar.class);
        startActivity(intent);
    }
}