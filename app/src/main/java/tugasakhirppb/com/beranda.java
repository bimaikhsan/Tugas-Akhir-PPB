package tugasakhirppb.com;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class beranda extends AppCompatActivity {
    ImageButton pesan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beranda);
        pesan=findViewById(R.id.daftar);
        ImageButton keluar =findViewById(R.id.logout);
        ImageButton jadwal =findViewById(R.id.jadwal);
        ImageButton tentang =findViewById(R.id.info);
        ImageButton berita =findViewById(R.id.berita);
        SharedPreferences sharedPreferences = getSharedPreferences("Login", MODE_PRIVATE);
        String mUser = sharedPreferences.getString("username","");
        TextView username = findViewById(R.id.username);
        username.setText(mUser);
        berita.setOnClickListener(view -> {
            Intent intent2 = new Intent(this, berita.class);
            startActivity(intent2);
        });
        tentang.setOnClickListener(view -> {
            Intent intent2 = new Intent(this, TentangActivity.class);
            startActivity(intent2);
        });
        jadwal.setOnClickListener(view -> {
            Intent intent2 = new Intent(this, JadwalActivity.class);
            startActivity(intent2);
        });
        keluar.setOnClickListener(view -> {
            Intent intent2 = new Intent(this, MainActivity.class);
            startActivity(intent2);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.clear();
            editor.apply();
            finish();

        });
        pesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                order();
            }
        });
    }
    public void order (){
        Intent intent = new Intent(this, pesan.class);
        startActivity(intent);

    }
}