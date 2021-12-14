package tugasakhirppb.com;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class beranda extends AppCompatActivity {
    ImageButton pesan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beranda);
        pesan=findViewById(R.id.daftar);
        pesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                order();
            }
        });
    }
    public void order (){
        Intent intent = new Intent(this, daftar.class);
        startActivity(intent);
    }
}