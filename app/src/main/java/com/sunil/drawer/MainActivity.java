package com.sunil.drawer;

import android.annotation.TargetApi;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView mDrawerList;
    private ArrayAdapter<String> mAdapter;
    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;
    private String mActivityTitle;
    TextView Jtv;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

     //   Jtv = (TextView)findViewById(R.id.tv);
        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        mActivityTitle = getTitle().toString();
        mDrawerList = (ListView) findViewById(R.id.navList);

        ///////////////////////////////////////////////////////////////////////////////////////



        /////////////////////////////////////////////////////////////////////////////////////
        addDrawerItem();
        setupDrawer();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        ///////////////////////////////////////////////////////////////////////////////////////////

    }

    private void addDrawerItem(){
         final String[] osArray = {"Android","iOS","Windows","OS X","Linux"};
        mAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,osArray);
        mDrawerList.setAdapter(mAdapter);


        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "GOOD TIMES!!", Toast.LENGTH_SHORT).show();
                switch (position){
                    case 0:
                      //  Jtv.setText("Zeroth Item");
                        getWindow().setNavigationBarColor(Color.RED);
                        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.RED));

                        //  ActionBar bar = getActionBar();
                     //   bar.setBackgroundDrawable(new ColorDrawable(Color.RED));
                        break;
                    case 1:
                     //   Jtv.setText("first item");
                        getWindow().setNavigationBarColor(Color.BLUE);
                        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.BLUE));


                        break;
                    case 2:
                    //    Jtv.setText("second item");
                        getWindow().setNavigationBarColor(Color.GREEN);
                        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.GREEN));


                        break;
                    case 3:
                     //   Jtv.setText("third");
                        getWindow().setNavigationBarColor(Color.YELLOW);
                        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.YELLOW));


                        break;
                    case 4:
                    //    Jtv.setText("fourth case");
                        getWindow().setNavigationBarColor(Color.MAGENTA);
                        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.MAGENTA));


                        break;
                    default:
                        getWindow().setNavigationBarColor(Color.BLACK);
                        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.BLACK));
                        break;

                }
            }
        });
    }

    private void setupDrawer(){
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.drawer_open, R.string.drawer_close){
            public void onDrawerOpened(View drawerView){
                super.onDrawerOpened(drawerView);
                getSupportActionBar().setTitle("Navigation!");
                invalidateOptionsMenu();

            }
            public void onDrawerClosed(View view){
                super.onDrawerClosed(view);
                getSupportActionBar().setTitle(mActivityTitle);
                invalidateOptionsMenu();
            }

        };

        mDrawerToggle.setDrawerIndicatorEnabled(true);
        mDrawerLayout.setDrawerListener(mDrawerToggle);


    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig){
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

        if (mDrawerToggle.onOptionsItemSelected(item)){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }





}
