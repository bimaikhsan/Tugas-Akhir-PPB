package tugasakhirppb.com;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;

public class JadwalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jadwal);
        SharedPreferences sharedPreferences = getSharedPreferences("Login", MODE_PRIVATE);
        String mUser = sharedPreferences.getString("username","");
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myref = database.getReference("pesan");

//        myref.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                jadwalArrayList.clear();
//                if (mUser.equals(snapshot.child(mUser).getKey())){
//                    for (DataSnapshot data : snapshot.child(mUser).getChildren()){
//                        jadwalArrayList.add(new JadwalHelper(data.child("id").getValue(Integer.class),data.child("tanggal").getValue(String.class), data.child("lapangan").getValue(String.class),data.child("jam").getValue(String.class)));
//                    }
//                }
//            }

//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });
    }
}