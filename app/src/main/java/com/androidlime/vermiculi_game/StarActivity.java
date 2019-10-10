package com.androidlime.vermiculi_game;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;

public class StarActivity extends AppCompatActivity {
    ImageButton play, more, shop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_star);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        play = (ImageButton) findViewById(R.id.play);
        more = (ImageButton) findViewById(R.id.more);
        shop = (ImageButton) findViewById(R.id.shop);


        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
            }
        });

        shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StarActivity.this, ShopActivity.class));
                finish();
            }
        });

        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final PopupMenu popupMenu = new PopupMenu(StarActivity.this, more);
                popupMenu.getMenuInflater().inflate(R.menu.pop_menu, popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        int id = menuItem.getItemId();

                        if  (id == R.id.share){
                            Intent i =new Intent(Intent.ACTION_SEND);
                            i.setType("text/plain");
                            String subject=" Gaming  Apps";
                            String body="Flying Game ";
                            i.putExtra(Intent.EXTRA_SUBJECT,subject);
                            i.putExtra(Intent.EXTRA_TEXT,body);
                            startActivity(Intent.createChooser(i,"share Via"));
                        }
                        if (id == R.id.about) {

                            Intent intent=new Intent(StarActivity.this,AboutActivity.class);
                            startActivity(intent);

                        }


                        return true;
                    }
                });
                popupMenu.show();
            }
        });
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {

        if (event.getAction() == KeyEvent.ACTION_DOWN){
            switch (event.getKeyCode()){
                case  KeyEvent.KEYCODE_BACK:
                    return true;
            }
        }
        return  super.dispatchKeyEvent(event);
    }
}
