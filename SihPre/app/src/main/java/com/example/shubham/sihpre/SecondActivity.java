package com.example.shubham.sihpre;

/**
 * Created by shubham on 15/3/18.
 */

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
public class SecondActivity extends AppCompatActivity {
    Button cButton, cSavaBtn;
    ImageView ivCamera;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);
        cButton = (Button) findViewById(R.id.button);
        cSavaBtn = (Button) findViewById(R.id.buttonSave);
        ivCamera = (ImageView) findViewById(R.id.imageView);
        cButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplication(), "Camera Clicked", Toast.LENGTH_LONG);
                Intent cIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cIntent, 0);

            }
        });

        cSavaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplication(), "Save btn Clicked", Toast.LENGTH_LONG);
                AfterSaveClick();
            }
        });

    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data ){
        super.onActivityResult(requestCode,resultCode,data);
        Bitmap bm = (Bitmap) data.getExtras().get("data");
        ivCamera.setImageBitmap(bm);

    }
    public void AfterSaveClick() {

        ivCamera.buildDrawingCache();
        Bitmap bm = ivCamera.getDrawingCache();


        OutputStream fOut = null;

        try {
            Toast.makeText(this, "Correct now",
                    Toast.LENGTH_SHORT).show();
            File root = new File(Environment.getExternalStorageDirectory()
                    + File.separator + "sharathFolder" + File.separator);
            root.mkdirs();
            File sdImageMainDirectory = new File(root, "myPicName.jpg");
            fOut = new FileOutputStream(sdImageMainDirectory);

            Toast.makeText(this, "Correct end now",
                    Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            Toast.makeText(this, "Error occured. Please try again later.",
                    Toast.LENGTH_SHORT).show();
        }

        try {
            bm.compress(Bitmap.CompressFormat.PNG, 100, fOut);
            fOut.flush();
            fOut.close();
        } catch (Exception e) {
            Toast.makeText(this, "Exception.",
                    Toast.LENGTH_SHORT).show();
        }
    }
}