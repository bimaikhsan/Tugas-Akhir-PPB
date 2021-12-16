package tugasakhirppb.com;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class pesan extends AppCompatActivity {
    ImageButton regis;
    Integer jumlah = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesan);
        SharedPreferences sharedPreferences = getSharedPreferences("Login", MODE_PRIVATE);
        String mUser = sharedPreferences.getString("username","");
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myref = database.getReference("pesan");
        regis=findViewById(R.id.pesan);
        EditText tanggal = findViewById(R.id.tanggal);
        EditText lapangan = findViewById(R.id.lapangan);
        EditText jam = findViewById(R.id.jam);
        regis.setOnClickListener(v -> {
            if (tanggal.getText().toString() == ""){
                tanggal.setError("Tanggal Tidak Boleh Kosong");
            }else if(lapangan.getText().toString() == ""){
                lapangan.setError("Lapangan Tidak Boleh Kosong");
            }else if(jam.getText().toString() == ""){
                jam.setError("Jam Tidak Boleh Kosong");
            }else{
                myref.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        for (DataSnapshot data : snapshot.child(mUser).getChildren()){
                            jumlah = data.child("id").getValue(Integer.class)+1;
                        }
                        String nama = mUser;
                        myref.child(nama).child(jumlah.toString()).child("id").setValue(jumlah);
                        myref.child(nama).child(jumlah.toString()).child("tanggal").setValue(tanggal.getText().toString());
                        myref.child(nama).child(jumlah.toString()).child("lapangan").setValue(lapangan.getText().toString());
                        myref.child(nama).child(jumlah.toString()).child("jam").setValue(jam.getText().toString());
                        Toast.makeText(pesan.this,"Berhasil menambahkan",Toast.LENGTH_SHORT).show();
                        masuk();
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });
    }
    public void masuk (){
        Intent intent = new Intent(this, beranda.class);
        startActivity(intent);
        finish();
    }
}