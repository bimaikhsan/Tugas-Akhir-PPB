package tugasakhirppb.com;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class pesan extends AppCompatActivity {
    ImageButton regis;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesan);
        regis=findViewById(R.id.pesan);
        regis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                masuk();
            }
        });
    }
    public void masuk (){
        Intent intent = new Intent(this, beranda.class);
        startActivity(intent);
    }
}