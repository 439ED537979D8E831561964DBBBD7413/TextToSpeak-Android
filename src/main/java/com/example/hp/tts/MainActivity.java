package com.example.hp.tts;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {
    TextToSpeech tts;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         editText=(EditText)findViewById(R.id.edit);
         tts=new TextToSpeech(this,this);
    }

    public void btn(View view) {
        tts.speak(editText.getText().toString(),TextToSpeech.QUEUE_FLUSH,null);
    }

    @Override
    public void onInit(int i)
    {
        if(i==TextToSpeech.SUCCESS){
            Locale locale=tts.getLanguage();
            int r=tts.setLanguage(locale);
            if(r==TextToSpeech.LANG_MISSING_DATA||r==TextToSpeech.LANG_NOT_SUPPORTED){
                Toast.makeText(MainActivity.this, "This phone not supported the language", Toast.LENGTH_SHORT).show();
            }
        }

    }
}
