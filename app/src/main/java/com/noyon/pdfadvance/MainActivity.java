package com.noyon.pdfadvance;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;

import com.airbnb.lottie.LottieAnimationView;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;

public class MainActivity extends AppCompatActivity {

    PDFView pdf;
    LottieAnimationView animationView;

    public static String path;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pdf=findViewById(R.id.pdf);
        animationView=findViewById(R.id.animationView);




  // this path will accessable from the dashboard

         pdf.fromAsset(path)

                 //pdf load hoba por ja hobe
                 .onLoad(new OnLoadCompleteListener() {
                     @Override
                     public void loadComplete(int nbPages) {

                         pdf.setVisibility(View.VISIBLE);
                         animationView.setVisibility(View.GONE);


                     }
                 })
                 .swipeHorizontal(true)

                 .pageSnap(true)
                 .autoSpacing(true)
                 .pageFling(true)





                 .load();



    }

 //-----------backpress method-----------------------
    @Override
    public void onBackPressed() {
       // super.onBackPressed();

        AlertDialog.Builder aleart=new AlertDialog.Builder(MainActivity.this);
        aleart.setTitle("Are you Leaving!!")
                .setIcon(R.drawable.exit)
                .setMessage("Do you want to  continue reading ?")
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        dialogInterface.dismiss();
                        finish();
                    }
                })
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();

                    }
                })

                .show();

    }




}