package com.example.thiagomelo.teste;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;


public class splash extends ActionBarActivity {

    public static final int segundos = 0;
    public static final int milisegundos = segundos * 1000;
    public static final int delay=2;
    private ProgressBar pbprogresso;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        pbprogresso = (ProgressBar) findViewById(R.id.pbprogresso);
        pbprogresso.setMax(maximo_progresso());
        animacaosplash();
    }

    public void animacaosplash()

    {
        new CountDownTimer(milisegundos, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                pbprogresso.setProgress(estabelecer_progresso(millisUntilFinished));

            }

            @Override
            public void onFinish(){
                Intent invocatela=new Intent(splash.this,MainActivity.class);
                startActivity(invocatela);
                finish();
            }
        }.start();

    }


    public int estabelecer_progresso(long miliseconds)
    {

        return (int)((milisegundos-miliseconds)/1000);

    }

    public int maximo_progresso()
    {
        return segundos-delay;
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_splash, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
