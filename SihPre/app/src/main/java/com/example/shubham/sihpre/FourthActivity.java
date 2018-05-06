package com.example.shubham.sihpre;

/**
 * Created by shubham on 30/3/18.
 */

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

//import com.example.shubham.texttospeech.R;



public class FourthActivity extends AppCompatActivity {

    TextToSpeech toSpeech;
    int result;
    EditText editText;
    String text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fourth_layout);
        editText=(EditText) findViewById(R.id.editText);
        toSpeech=new TextToSpeech(FourthActivity.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status==TextToSpeech.SUCCESS){
                    result=toSpeech.setLanguage(Locale.ENGLISH);

                }
                else{
                    Toast.makeText(getApplicationContext(),"Feature not supported in device ",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    public void TTS(View view)
    {
        switch(view.getId())
        {
            case R.id.bspeak:
                if(result==TextToSpeech.LANG_MISSING_DATA || result==TextToSpeech.LANG_NOT_SUPPORTED  )
                {
                    Toast.makeText(getApplicationContext(),"Feature not supported in device ",Toast.LENGTH_SHORT).show();
                }
                else{
                    text=editText.getText().toString();
                    toSpeech.speak(text,TextToSpeech.QUEUE_FLUSH,null);
                }
                break;
            case R.id.bstop:
                if(toSpeech!=null)
                {
                    toSpeech.stop();

                }
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(toSpeech!=null)
        {
            toSpeech.stop();
            toSpeech.shutdown();

        }
    }
}
