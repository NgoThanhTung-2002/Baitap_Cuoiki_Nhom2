package NhomTTPTT.example.BaiTapCuoiKi.menu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.otpverification.R;

public class ActivityShare extends AppCompatActivity {
    Button btnShare;
    EditText txtShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);
        btnShare =(Button) findViewById(R.id.btnShare);
        txtShare =(EditText) findViewById(R.id.txt_share);
        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.setType("text/plain");
                sendIntent.putExtra(Intent.EXTRA_TEXT,txtShare.getText().toString()+" :\n\n https://play.google.com/store/apps/details?id=com.netflix.mediaclient");
                startActivity(Intent.createChooser(sendIntent,"Choose one"));
            }
        });
    }
}