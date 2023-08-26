package com.noyon.pdfadvance;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.github.barteksc.pdfviewer.PDFView;

import java.net.Inet4Address;

public class DashBoard extends AppCompatActivity {

    LinearLayout book1,book2,book3,book4;
    MediaPlayer mp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        book1=findViewById(R.id.book1);
        book2=findViewById(R.id.book2);
        book3=findViewById(R.id.book3);
        book4=findViewById(R.id.book4);


// book 1 sett on click event
        book1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(mp!=null){
                    mp.release();
                }
                 mp=MediaPlayer.create(DashBoard.this,R.raw.touch2);
                mp.start();
                


               MainActivity.path="alibaba_chor.pdf";  //set the path of mainActivity

               //creat a method that do intent pass then call it
                intentPass();



            }
        });

        //book 2 set on click event

        book2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(mp!=null){
                    mp.release();
                }
                mp=MediaPlayer.create(DashBoard.this,R.raw.touch2);
                mp.start();

                MainActivity.path="spoken_english.pdf"; //set  the path

                intentPass();
            }
        });

        //book3 set on click event
        book3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(mp!=null){
                    mp.release();
                }
                mp=MediaPlayer.create(DashBoard.this,R.raw.touch2);
                mp.start();


                MainActivity.path="twisted_hate.pdf";
                Intent myInent=new Intent(DashBoard.this,MainActivity.class);
                startActivity(myInent);

            }
        });

        //book 4 set on click event

        book4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

        //if mp playing then release
                if(mp!=null){
                    mp.release();
                }

               mp=MediaPlayer.create(DashBoard.this,R.raw.touch2);
                mp.start();

                //set book link
                MainActivity.path="araby_rajani.pdf";


                Intent myIntent =new Intent(DashBoard.this,MainActivity.class);
                startActivity(myIntent);

            }
        });




    }
    //----------------oncreat method end---------

  //-------- user defined method
    public  void intentPass(){

        Intent myInent=new Intent(DashBoard.this,MainActivity.class);
        startActivity(myInent);
    }



    // back press method


    @Override
    public void onBackPressed() {
       // super.onBackPressed();

        AlertDialog.Builder aleart = new AlertDialog.Builder(DashBoard.this);

         aleart.setTitle("Confirm Exit!!")
                 .setMessage("Do you Want To Exit ?")
                 .setIcon(R.drawable.exit)
                 .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                     @Override
                     public void onClick(DialogInterface dialogInterface, int i) {
                         dialogInterface.dismiss();
                         finishAndRemoveTask();
                     }
                 })
                 .setNegativeButton("No", new DialogInterface.OnClickListener() {
                     @Override
                     public void onClick(DialogInterface dialogInterface, int i) {
                         dialogInterface.dismiss();

                     }
                 })
                 .show();




    }
}