package com.example.ube;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.os.Vibrator;
import android.widget.Button;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{

    MediaPlayer mp1, mp2;
    Button Google;
    Button Facebook;
    Button GoogleC;
    Button FacebookC;
    boolean fragmentSeleccionado=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        Google= findViewById(R.id.Bgoogle);
        Facebook=findViewById(R.id.bfacebook);
        FacebookC=findViewById(R.id.bfacebookC);
        GoogleC=findViewById(R.id.BgoogleC);

        mp1 = MediaPlayer.create(this,R.raw.sonido1);
        mp2 = MediaPlayer.create(this,R.raw.sonido2);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        Fragment miFragment=null;

        if (id == R.id.nav_iniciar) {
            Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            // Vibrate for 400 milliseconds
            v.vibrate(50);
            miFragment=new IniciarFragment();
            fragmentSeleccionado=true;
        } else if (id == R.id.nav_registrar) {
            Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            // Vibrate for 400 milliseconds
            v.vibrate(50);
            miFragment=new RegistrarFragment();
            fragmentSeleccionado=true;
        } else if (id == R.id.nav_create) {
            Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            // Vibrate for 400 milliseconds
            v.vibrate(50);
            miFragment=new CreateFragment();
            fragmentSeleccionado=true;
        } else if (id == R.id.nav_tutorial) {
            Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            // Vibrate for 400 milliseconds
            v.vibrate(50);
            miFragment=new TutorialFragment();
            fragmentSeleccionado=true;
        } else if (id == R.id.nav_opciones) {
            Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            // Vibrate for 400 milliseconds
            v.vibrate(50);
            miFragment=new OpcionesFragment();
            fragmentSeleccionado=true;
        } else if (id == R.id.nav_sugerencias) {
            Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            // Vibrate for 400 milliseconds
            v.vibrate(50);
            miFragment=new SugerenciasFragment();
            fragmentSeleccionado=true;
        }else if(id== R.id.nav_info){
            Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            // Vibrate for 400 milliseconds
            v.vibrate(50);
            miFragment=new InformacionFragment();
            fragmentSeleccionado=true;
        }else if(id==R.id.nav_menu){
            Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            v.vibrate(50);
            setContentView(R.layout.activity_main);
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);

            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                    this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
            drawer.addDrawerListener(toggle);
            toggle.syncState();


            NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
            navigationView.setNavigationItemSelectedListener(this);
        }

        if (fragmentSeleccionado==true){
            getSupportFragmentManager().beginTransaction().replace(R.id.context_main,miFragment).commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void G(View vista){
        mp1.start();
    }
    public void F (View vista){mp1.start();}

    public void activar(View vista){
        Fragment miFragment=null;
        miFragment=new IniciarFragmentCeguera();
        fragmentSeleccionado=true;
        if (fragmentSeleccionado==true){
            getSupportFragmentManager().beginTransaction().replace(R.id.context_main,miFragment).commit();
        }
    }
    public void desactivar(View vista){
        Fragment miFragment=null;
        miFragment=new IniciarFragment();
        fragmentSeleccionado=true;
        if (fragmentSeleccionado==true){
            getSupportFragmentManager().beginTransaction().replace(R.id.context_main,miFragment).commit();
        }
    }



}
