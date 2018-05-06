package com.example.shubham.sihpre;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

/**
 * Created by shubham on 20/3/18.
 */

public class MainActivity2 extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button btnPwd = (Button) findViewById(R.id.btnPwd);
        Button btnSigntoText=(Button)findViewById(R.id.btnSigntoText);
        Button btnTexttoSign=(Button)findViewById(R.id.btnTexttoSign);

        //findViewById(R.id.btnNext).setOnClickListener(MainActivity.this);

        btnPwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MainActivity2.this, SecondActivity.class);
                startActivity(intent1);
            }
        });
        btnSigntoText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(MainActivity2.this, ThirdActivity.class);
                startActivity(intent2);
            }
        });
        btnTexttoSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(MainActivity2.this, FourthActivity.class);
                startActivity(intent3);
            }
        });


    }

    /*public void showGreetings(View view)
    {
        String button_text;
        button_text = ((Button)view).getText().toString();
        if(button_text.equals("PwD"))
        {
            Intent intent =new Intent(this,SecondActivity.class);
            startActivity(intent);
        }
        else if(button_text.equals("Nonpwd"))
        {
            Intent intent = new Intent (this,ThirdActivity.class);
            startActivity(intent);
        }
    }*/

}

