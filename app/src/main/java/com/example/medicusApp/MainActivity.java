package com.example.medicusApp;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import Fragments.CommunicationFragment;
import Fragments.ListFragment;
import Fragments.StartFragment;
import Fragments.ViertesFragment;
import SupportClasses.Data;

import com.github.wrdlbrnft.sortedlistadapter.SortedListAdapter;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, ViertesFragment.OnFragmentInteractionListener, StartFragment.OnFragmentInteractionListener, SearchView.OnQueryTextListener, SortedListAdapter.Callback {

    private static int SPLASH_TIME_OUT = 4000;

//    private static final Comparator<Data> ALPHABETICAL_COMPARATOR = new Comparator<Data>() {
//        @Override
//        public int compare(Data a, Data b) {
//            return a.getText().compareTo(b.getText());
//        }
//    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Etwas hinzugefügt", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        StartFragment startFragment = new StartFragment();


        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(
                R.id.constraintlayout_for_fragment,
                startFragment,
                startFragment.getTag()
        ).commit();



    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        StartFragment startFragment = new StartFragment();
        FragmentManager manager = this.getSupportFragmentManager();

        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();

//            manager.beginTransaction()
//                    .setCustomAnimations(R.anim.slide_in_right,R.anim.slide_in_left)
//                    .replace(R.id.constraintlayout_for_fragment, startFragment)
//                    .commit();



        }
    }







    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);

        final MenuItem searchItem = menu.findItem(R.id.action_search);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setOnQueryTextListener(this);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_search) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_list) {
            //Toast.makeText(this, "Liste geöffnet", Toast.LENGTH_SHORT).show();
            ListFragment listFragment = new ListFragment();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction()
                    .setCustomAnimations(R.anim.enter,R.anim.exit,R.anim.pop_enter,R.anim.pop_exit)
                    .replace(
                    R.id.constraintlayout_for_fragment,
                    listFragment,
                    listFragment.getTag())
                    .addToBackStack(null)
                    .commit();



        } else if (id == R.id.nav_communication) {
            CommunicationFragment communicationFragment = new CommunicationFragment();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction()
                    .setCustomAnimations(R.anim.enter,R.anim.exit,R.anim.pop_enter,R.anim.pop_exit)
                    .replace(
                    R.id.constraintlayout_for_fragment,
                    communicationFragment,
                    communicationFragment.getTag())
                    .addToBackStack(null)
                    .commit();


        } else if (id == R.id.nav_Viertes) {

            ViertesFragment slideShowFragment = ViertesFragment.newInstance(5);
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction()
                    .setCustomAnimations(R.anim.enter,R.anim.exit,R.anim.pop_enter,R.anim.pop_exit)
                    .replace(
                    R.id.constraintlayout_for_fragment,
                    slideShowFragment,
                    slideShowFragment.getTag())
                    .addToBackStack(null)
                    .commit();


        } else if (id == R.id.nav_start) {
           // DoctorFragment doctorFragment = new DoctorFragment("Dr. Max Mustermann");
            StartFragment startFragment = new StartFragment();
            //ViertesFragment viertesFragment = new ViertesFragment();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction()
                    .setCustomAnimations(R.anim.enter,R.anim.exit,R.anim.pop_enter,R.anim.pop_exit)
                    .replace(
                    R.id.constraintlayout_for_fragment,
                    startFragment,
                    startFragment.getTag())
                    .addToBackStack(null)
                    .commit();



        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(String data) {
        //Toast.makeText(this,data, Toast.LENGTH_SHORT).show();

        //Toast.makeText(this, "Callback vom vierten Listener: " + data, Toast.LENGTH_SHORT).show();
    }


    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String query) {

        FragmentManager fm = getSupportFragmentManager();

        ListFragment fragment = (ListFragment)fm.findFragmentById(R.id.constraintlayout_for_fragment);
        //List<Data>=

        final List<Data> filteredModelList = filter(fragment.data, query);
        //fragment.data
        fragment.adapter.replaceAll(filteredModelList);
        //fragment.adapter.notifyDataSetChanged();
        fragment.recyclerView.scrollToPosition(0);

        return true;
    }

    private static List<Data> filter(List<Data> models, String query) {
        final String lowerCaseQuery = query.toLowerCase();

        final List<Data> filteredModelList = new ArrayList<>();
        for (Data model : models) {
            final String text = model.getText().toLowerCase();
            if (text.contains(lowerCaseQuery)) {
                filteredModelList.add(model);
            }
        }
        return filteredModelList;
    }

    @Override
    public void onEditStarted() {

    }

    @Override
    public void onEditFinished() {

    }
}
