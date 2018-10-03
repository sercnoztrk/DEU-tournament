package com.example.sercan.deutournament;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.ListFragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, OnFragmentInteractionListener {

    private boolean mToolBarNavigationListenerIsRegistered = false;
    public static final int FOOTBALL = 0;
    public static final int BASKETBALL = 1;
    public static final int VOLLEYBALL = 2;
    public static final int TENNIS = 3;
    public static final int ESPORTS = 4;

    Tournament footballTournament = new Tournament(FOOTBALL);
    Tournament basketballTournament = new Tournament(BASKETBALL);
    Tournament volleyballTournament = new Tournament(VOLLEYBALL);
    Tournament tennisTournament = new Tournament(TENNIS);
    Tournament esportsTournament = new Tournament(ESPORTS);

    private boolean isFirstClickOnFootball = true,      footballTournamentSimulated = false;
    private boolean isFirstClickOnBasketball = true,    basketballTournamentSimulated = false;
    private boolean isFirstClickOnVolleyball = true,    volleyballTournamentSimulated = false;
    private boolean isFirstClickOnTennis = true,        tennisTournamentSimulated = false;
    private boolean isFirstClickOnEsports = true,       lolTournamentSimulated = false;

    ArrayList<String> round1 = new ArrayList<>();
    ArrayList<String> round2 = new ArrayList<>();
    ArrayList<String> round3 = new ArrayList<>();
    ArrayList<String> round4 = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        footballTournament.tournamentTeams = footballTournament.createTeams();
        basketballTournament.tournamentTeams = basketballTournament.createTeams();
        volleyballTournament.tournamentTeams = volleyballTournament.createTeams();
        tennisTournament.tournamentTeams = tennisTournament.createTeams();
        esportsTournament.tournamentTeams = esportsTournament.createTeams();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setVisibility(View.INVISIBLE);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ///
        ///homeFragment();
        ///
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } ///
        else if (getFragmentManager().getBackStackEntryCount() > 0){
            getFragmentManager().popBackStack();
        }///
        else {
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
            Intent i=new Intent(this, MainActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(i);
            Toast.makeText(MainActivity.this, "All tournaments resetted!", Toast.LENGTH_LONG).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        final int id = item.getItemId();
        Fragment fragment;
        Class fragmentClass = null;
        Bundle args = new Bundle();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setVisibility(View.VISIBLE);
        ImageView backgroundLogo = findViewById(R.id.background_logo);
        backgroundLogo.setAlpha(30);
        fab.setOnClickListener(new View.OnClickListener() {
            Bundle args = new Bundle();
            Fragment fragment;
            @Override
            public void onClick(View view) {
                if(id == R.id.nav_football) {
                    if (!footballTournamentSimulated) {
                        footballTournament.simulateTournament(footballTournament.tournamentTeams);
                        addSimulatedTeamsToArray(footballTournament);
                        footballTournamentSimulated = true;
                        loadBundle(args);
                        Snackbar.make(view, "Football tournament has simulated...", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                    }
                } else if (id == R.id.nav_basketball) {
                    if (!basketballTournamentSimulated) {
                        basketballTournament.simulateTournament(basketballTournament.tournamentTeams);
                        addSimulatedTeamsToArray(basketballTournament);
                        basketballTournamentSimulated = true;
                        loadBundle(args);
                        Snackbar.make(view, "Basketball tournament has simulated...", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                    }
                } else if (id == R.id.nav_volleyball) {
                    if (!volleyballTournamentSimulated) {
                        volleyballTournament.simulateTournament(volleyballTournament.tournamentTeams);
                        addSimulatedTeamsToArray(volleyballTournament);
                        volleyballTournamentSimulated = true;
                        loadBundle(args);
                        Snackbar.make(view, "Volleyball tournament has simulated...", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                    }
                } else if (id == R.id.nav_tennis) {
                    if (!tennisTournamentSimulated) {
                        tennisTournament.simulateTournament(tennisTournament.tournamentTeams);
                        addSimulatedTeamsToArray(tennisTournament);
                        tennisTournamentSimulated = true;
                        loadBundle(args);
                        Snackbar.make(view, "Tennis tournament has simulated...", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                    }
                } else if (id == R.id.nav_esports) {
                    if (!lolTournamentSimulated)
                    esportsTournament.simulateTournament(esportsTournament.tournamentTeams);
                    addSimulatedTeamsToArray(esportsTournament);
                    loadBundle(args);
                    Snackbar.make(view, "LoL tournament has simulated...", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                }
                fragment = (Fragment) FragmentA.newInstance();
                fragment.setArguments(args);
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.fragment_layout_for_activity_navigation, fragment).addToBackStack(null).commit();
            }
        });


        ///
        if (id == R.id.nav_football) {
            if (isFirstClickOnFootball) {
                footballTournament.tournamentTeams = footballTournament.seedTeams(footballTournament.tournamentTeams);
                Toast.makeText(MainActivity.this, "Football teams seeded...", Toast.LENGTH_LONG).show();
                isFirstClickOnFootball = false;
            }
            if (!footballTournamentSimulated)
                addTeamsToArray(footballTournament.tournamentTeams);
            else
                addSimulatedTeamsToArray(footballTournament);
            fragmentClass = FragmentA.class;
            loadBundle(args);
        } else if (id == R.id.nav_basketball) {
            if (isFirstClickOnBasketball) {
                basketballTournament.tournamentTeams = basketballTournament.seedTeams(basketballTournament.tournamentTeams);
                Toast.makeText(MainActivity.this, "Basketball teams seeded...", Toast.LENGTH_LONG).show();
                isFirstClickOnBasketball = false;
            }
            if (!basketballTournamentSimulated)
                addTeamsToArray(basketballTournament.tournamentTeams);
            else
                addSimulatedTeamsToArray(basketballTournament);
            fragmentClass = FragmentA.class;
            loadBundle(args);
        } else if (id == R.id.nav_volleyball) {
            if (isFirstClickOnVolleyball) {
                volleyballTournament.tournamentTeams = volleyballTournament.seedTeams(volleyballTournament.tournamentTeams);
                Toast.makeText(MainActivity.this, "Volleyball Teams Seeded...", Toast.LENGTH_LONG).show();
                isFirstClickOnVolleyball = false;
            }
            if (!basketballTournamentSimulated)
                addTeamsToArray(volleyballTournament.tournamentTeams);
            else
                addSimulatedTeamsToArray(volleyballTournament);
            fragmentClass = FragmentA.class;
            loadBundle(args);
        } else if (id == R.id.nav_tennis) {
            if (isFirstClickOnTennis) {
                tennisTournament.tournamentTeams = tennisTournament.seedTeams(tennisTournament.tournamentTeams);
                Toast.makeText(MainActivity.this, "Tennis Teams Seeded...", Toast.LENGTH_LONG).show();
                isFirstClickOnTennis = false;
            }
            if (!tennisTournamentSimulated)
                addTeamsToArray(tennisTournament.tournamentTeams);
            else
                addSimulatedTeamsToArray(tennisTournament);
            fragmentClass = FragmentA.class;
            loadBundle(args);
        } else if (id == R.id.nav_esports) {
            if (isFirstClickOnEsports) {
                esportsTournament.tournamentTeams = basketballTournament.seedTeams(esportsTournament.tournamentTeams);
                Toast.makeText(MainActivity.this, "Esports teams seeded...", Toast.LENGTH_LONG).show();
                isFirstClickOnEsports = false;
            }
            if (!lolTournamentSimulated)
                addTeamsToArray(esportsTournament.tournamentTeams);
            else
                addSimulatedTeamsToArray(esportsTournament);
            fragmentClass = FragmentA.class;
            loadBundle(args);
        } /*else if (id == R.id.nav_share) {
            fragmentClass = FragmentC.class;
            args.putString(Constants.FRAG_C,"Share");
        } else if (id == R.id.nav_send) {
            fragmentClass = FragmentC.class;
            args.putString(Constants.FRAG_C,"Send");
        } /// */
        try {
            assert fragmentClass != null;
            fragment = (Fragment) fragmentClass.newInstance();
            fragment.setArguments(args);
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.fragment_layout_for_activity_navigation, fragment).addToBackStack(null).commit();
        } catch (Exception e) {
            e.printStackTrace();
        } ///

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void loadBundle(Bundle args){
        args.putStringArrayList(Constants.FRAG_A1, round1);
        args.putStringArrayList(Constants.FRAG_A2, round2);
        args.putStringArrayList(Constants.FRAG_A3, round3);
        args.putStringArrayList(Constants.FRAG_A4, round4);
    }

    ///
    @Override
    public void onFragmentMessage(int TAG, String data) {

    }

    public void addTeamsToArray(Team[] tournamentTeams){
        round1.clear();

        round1.add("#" + tournamentTeams[7].getTeamId() + " " + tournamentTeams[7].getName());
        round1.add("#" + tournamentTeams[8].getTeamId() + " " + tournamentTeams[8].getName());
        round1.add("");
        round1.add("#" + tournamentTeams[6].getTeamId() + " " + tournamentTeams[6].getName());
        round1.add("#" + tournamentTeams[9].getTeamId() + " " + tournamentTeams[9].getName());
        round1.add("");
        round1.add("#" + tournamentTeams[5].getTeamId() + " " + tournamentTeams[5].getName());
        round1.add("#" + tournamentTeams[10].getTeamId() + " " + tournamentTeams[10].getName());

        round2.clear();
        round2.add("#" + tournamentTeams[0].getTeamId() + " " + tournamentTeams[0].getName());
        round2.add("Winner of Round 1 Match 1");
        round2.add("");
        round2.add("#" + tournamentTeams[3].getTeamId() + " " + tournamentTeams[3].getName());
        round2.add("#" + tournamentTeams[4].getTeamId() + " " + tournamentTeams[4].getName());
        round2.add("");
        round2.add("#" + tournamentTeams[1].getTeamId() + " " + tournamentTeams[1].getName());
        round2.add("Winner of Round 1 Match 2");
        round2.add("");
        round2.add("#" + tournamentTeams[2].getTeamId() + " " + tournamentTeams[2].getName());
        round2.add("Winner of Round 1 Match 3");

        round3.clear();
        round3.add("Winner of Round 2 Match 1");
        round3.add("Winner of Round 2 Match 2");
        round3.add("");
        round3.add("Winner of Round 2 Match 3");
        round3.add("Winner of Round 2 Match 4");

        round4.clear();
        round4.add("Winner of Round 3 Match 1");
        round4.add("Winner of Round 3 Match 2");
    }


    public void addSimulatedTeamsToArray(Tournament tournament){
        round1.clear();
        round1.add("#" + tournament.round1.get(0).getTeam1().getTeamId() + "            " + tournament.round1.get(0).getTeam1().getName() + " : " + tournament.round1.get(0).getTeam1Score());
        round1.add("#" + tournament.round1.get(0).getTeam2().getTeamId() + "            " + tournament.round1.get(0).getTeam2().getName() + " : " + tournament.round1.get(0).getTeam2Score());
        round1.add("");
        round1.add("#" + tournament.round1.get(1).getTeam1().getTeamId() + "            " + tournament.round1.get(1).getTeam1().getName() + " : " + tournament.round1.get(1).getTeam1Score());
        round1.add("#" + tournament.round1.get(1).getTeam2().getTeamId() + "            " + tournament.round1.get(1).getTeam2().getName() + " : " + tournament.round1.get(1).getTeam2Score());
        round1.add("");
        round1.add("#" + tournament.round1.get(2).getTeam1().getTeamId() + "            " + tournament.round1.get(2).getTeam1().getName() + " : " + tournament.round1.get(2).getTeam1Score());
        round1.add("#" + tournament.round1.get(2).getTeam2().getTeamId() + "            " + tournament.round1.get(2).getTeam2().getName() + " : " + tournament.round1.get(2).getTeam2Score());

        round2.clear();
        round2.add("#" + tournament.round2.get(0).getTeam1().getTeamId() + "            " + tournament.round2.get(0).getTeam1().getName() + " : " + tournament.round2.get(0).getTeam1Score());
        round2.add("#" + tournament.round2.get(0).getTeam2().getTeamId() + "            " + tournament.round2.get(0).getTeam2().getName() + " : " + tournament.round2.get(0).getTeam2Score());
        round2.add("");
        round2.add("#" + tournament.round2.get(1).getTeam1().getTeamId() + "            " + tournament.round2.get(1).getTeam1().getName() + " : " + tournament.round2.get(1).getTeam1Score());
        round2.add("#" + tournament.round2.get(1).getTeam2().getTeamId() + "            " + tournament.round2.get(1).getTeam2().getName() + " : " + tournament.round2.get(1).getTeam2Score());
        round2.add("");
        round2.add("#" + tournament.round2.get(2).getTeam1().getTeamId() + "            " + tournament.round2.get(2).getTeam1().getName() + " : " + tournament.round2.get(2).getTeam1Score());
        round2.add("#" + tournament.round2.get(2).getTeam2().getTeamId() + "            " + tournament.round2.get(2).getTeam2().getName() + " : " + tournament.round2.get(2).getTeam2Score());
        round2.add("");
        round2.add("#" + tournament.round2.get(3).getTeam1().getTeamId() + "            " + tournament.round2.get(3).getTeam1().getName() + " : " + tournament.round2.get(3).getTeam1Score());
        round2.add("#" + tournament.round2.get(3).getTeam2().getTeamId() + "            " + tournament.round2.get(3).getTeam2().getName() + " : " + tournament.round2.get(3).getTeam2Score());

        round3.clear();
        round3.add("#" + tournament.round3.get(0).getTeam1().getTeamId() + "            " + tournament.round3.get(0).getTeam1().getName() + " : " + tournament.round3.get(0).getTeam1Score());
        round3.add("#" + tournament.round3.get(0).getTeam2().getTeamId() + "            " + tournament.round3.get(0).getTeam2().getName() + " : " + tournament.round3.get(0).getTeam2Score());
        round3.add("");
        round3.add("#" + tournament.round3.get(1).getTeam1().getTeamId() + "            " + tournament.round3.get(1).getTeam1().getName() + " : " + tournament.round3.get(1).getTeam1Score());
        round3.add("#" + tournament.round3.get(1).getTeam2().getTeamId() + "            " + tournament.round3.get(1).getTeam2().getName() + " : " + tournament.round3.get(1).getTeam2Score());

        round4.clear();
        round4.add("#" + tournament.round4.get(0).getTeam1().getTeamId() + "            " + tournament.round4.get(0).getTeam1().getName() + " : " + tournament.round4.get(0).getTeam1Score());
        round4.add("#" + tournament.round4.get(0).getTeam2().getTeamId() + "            " + tournament.round4.get(0).getTeam2().getName() + " : " + tournament.round4.get(0).getTeam2Score());

    }

    public void homeFragment(){
        try {
            Bundle args = new Bundle();
            Class fragmentClass =FragmentC.class;
            args.putString(Constants.FRAG_C,"Welcome");

            Fragment fragment = (Fragment) fragmentClass.newInstance();
            fragment.setArguments(args);

            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.fragment_layout_for_activity_navigation, fragment).commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }
}
