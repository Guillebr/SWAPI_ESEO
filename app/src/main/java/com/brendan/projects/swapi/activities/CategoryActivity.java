package com.brendan.projects.swapi.activities;

import android.app.ActionBar;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.brendan.projects.swapi.R;
import com.brendan.projects.swapi.models.ElementFilms;
import com.brendan.projects.swapi.models.ElementPeople;
import com.brendan.projects.swapi.models.ElementPlanets;
import com.brendan.projects.swapi.models.ElementSpecies;
import com.brendan.projects.swapi.models.ElementStarships;
import com.brendan.projects.swapi.models.ElementVehicles;
import com.brendan.projects.swapi.utils.retrofit.ApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryActivity extends AppCompatActivity implements OnClickListener {

    public static final String TAG = CategoryActivity.class.getSimpleName();

    CardView cardViewFilms, cardViewPeople, cardViewPlanets, cardViewSpecies, cardViewStarships, cardViewVehicles;
    TextView textViewFilms, textViewPeople, textViewPlanets, textViewSpecies, textViewStarships, textViewVehicles;

    private final ApiService apiService = ApiService.Builder.getInstance();

    public static List<ElementFilms> elementFilmsList;
    public static List<ElementPeople> elementPeopleList;
    public static List<ElementPlanets> elementPlanetsList;
    public static List<ElementSpecies> elementSpeciesList;
    public static List<ElementStarships> elementStarshipsList;
    public static List<ElementVehicles> elementVehiclesList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        final TextView actionBarTextView = new TextView(getApplicationContext());
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);
        actionBarTextView.setLayoutParams(lp);
        actionBarTextView.setText("swapi");
        actionBarTextView.setTextSize(20);
        actionBarTextView.setGravity(Gravity.CENTER);
        actionBarTextView.setTextColor(getResources().getColor(R.color.colorAccent));
        Typeface tf = Typeface.createFromAsset(getApplicationContext().getAssets(), "Starjhol.ttf");
        actionBarTextView.setTypeface(tf);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(actionBarTextView);

        cardViewFilms = findViewById(R.id.card_view_films);
        cardViewPeople = findViewById(R.id.card_view_people);
        cardViewPlanets = findViewById(R.id.card_view_planets);
        cardViewSpecies = findViewById(R.id.card_view_species);
        cardViewStarships = findViewById(R.id.card_view_starships);
        cardViewVehicles = findViewById(R.id.card_view_vehicles);

        cardViewFilms.setOnClickListener(this);
        cardViewPeople.setOnClickListener(this);
        cardViewPlanets.setOnClickListener(this);
        cardViewSpecies.setOnClickListener(this);
        cardViewStarships.setOnClickListener(this);
        cardViewVehicles.setOnClickListener(this);

        textViewFilms = findViewById(R.id.text_view_films);
        textViewPeople = findViewById(R.id.text_view_people);
        textViewPlanets = findViewById(R.id.text_view_planets);
        textViewSpecies = findViewById(R.id.text_view_species);
        textViewStarships = findViewById(R.id.text_view_starship);
        textViewVehicles = findViewById(R.id.text_view_vehicles);

        Typeface tf2 = Typeface.createFromAsset(getApplicationContext().getAssets(), "Roboto-Light.ttf");

        textViewFilms.setTypeface(tf2);
        textViewPeople.setTypeface(tf2);
        textViewPlanets.setTypeface(tf2);
        textViewSpecies.setTypeface(tf2);
        textViewStarships.setTypeface(tf2);
        textViewVehicles.setTypeface(tf2);

        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Information");
        alertDialog.setMessage("Pour chaque catégorie, les éléments affichés ne représentent qu'une partie des informations que nous peut offrir SWAPI.\nProfitez-en bien !");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }

    public void onClick(View v) {
        final Intent listActivity = new Intent(getApplicationContext(), ListActivity.class);
        final ProgressDialog dialog = ProgressDialog.show(CategoryActivity.this, "Chargement",
                "Récupération des informations demandées...", true);

        switch (v.getId()) {
            case (R.id.card_view_films):
                listActivity.putExtra("actionBarTitle", "Films");

                apiService.getFilms().enqueue(new Callback<List<ElementFilms>>() {
                    @Override
                    public void onResponse(Call<List<ElementFilms>> call, Response<List<ElementFilms>> response) {
                        setElementFilmsList(response.body());
                        dialog.dismiss();
                        startActivity(listActivity);
                    }

                    @Override
                    public void onFailure(Call<List<ElementFilms>> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Un problème avec le serveur est arrivé...\nVeuillez réessayer plus tard", Toast.LENGTH_SHORT).show();
                        Log.e(TAG, t.getMessage());
                        dialog.dismiss();

                    }
                });

                break;
            case (R.id.card_view_people):
                listActivity.putExtra("actionBarTitle", "Personnages");

                apiService.getPeople().enqueue(new Callback<List<ElementPeople>>() {
                    @Override
                    public void onResponse(Call<List<ElementPeople>> call, Response<List<ElementPeople>> response) {
                        setElementPeopleList(response.body());
                        dialog.dismiss();
                        startActivity(listActivity);
                    }

                    @Override
                    public void onFailure(Call<List<ElementPeople>> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Un problème avec le serveur est arrivé...\nVeuillez réessayer plus tard", Toast.LENGTH_SHORT).show();
                        Log.e(TAG, t.getMessage());
                        dialog.dismiss();

                    }
                });
                break;
            case (R.id.card_view_planets):
                listActivity.putExtra("actionBarTitle", "Planètes");
                apiService.getPlanets().enqueue(new Callback<List<ElementPlanets>>() {
                    @Override
                    public void onResponse(Call<List<ElementPlanets>> call, Response<List<ElementPlanets>> response) {
                        setElementPlanetsList(response.body());
                        dialog.dismiss();
                        startActivity(listActivity);
                    }

                    @Override
                    public void onFailure(Call<List<ElementPlanets>> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Un problème avec le serveur est arrivé...\nVeuillez réessayer plus tard", Toast.LENGTH_SHORT).show();
                        Log.e(TAG, t.getMessage());
                        dialog.dismiss();

                    }
                });
                break;
            case (R.id.card_view_species):
                listActivity.putExtra("actionBarTitle", "Espèces");
                apiService.getSpecies().enqueue(new Callback<List<ElementSpecies>>() {
                    @Override
                    public void onResponse(Call<List<ElementSpecies>> call, Response<List<ElementSpecies>> response) {
                        setElementSpeciesList(response.body());
                        dialog.dismiss();
                        startActivity(listActivity);
                    }

                    @Override
                    public void onFailure(Call<List<ElementSpecies>> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Un problème avec le serveur est arrivé...\nVeuillez réessayer plus tard", Toast.LENGTH_SHORT).show();
                        Log.e(TAG, t.getMessage());
                        dialog.dismiss();

                    }
                });
                break;
            case (R.id.card_view_starships):
                listActivity.putExtra("actionBarTitle", "Vaisseaux Spatiaux");
                apiService.getStarships().enqueue(new Callback<List<ElementStarships>>() {
                    @Override
                    public void onResponse(Call<List<ElementStarships>> call, Response<List<ElementStarships>> response) {
                        setElementStarshipsList(response.body());
                        dialog.dismiss();
                        startActivity(listActivity);
                    }

                    @Override
                    public void onFailure(Call<List<ElementStarships>> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Un problème avec le serveur est arrivé...\nVeuillez réessayer plus tard", Toast.LENGTH_SHORT).show();
                        Log.e(TAG, t.getMessage());
                        dialog.dismiss();

                    }
                });
                break;
            case (R.id.card_view_vehicles):
                listActivity.putExtra("actionBarTitle", "Véhicules");
                apiService.getVehicles().enqueue(new Callback<List<ElementVehicles>>() {
                    @Override
                    public void onResponse(Call<List<ElementVehicles>> call, Response<List<ElementVehicles>> response) {
                        setElementVehiclesList(response.body());
                        dialog.dismiss();
                        startActivity(listActivity);
                    }

                    @Override
                    public void onFailure(Call<List<ElementVehicles>> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Un problème avec le serveur est arrivé...\nVeuillez réessayer plus tard", Toast.LENGTH_SHORT).show();
                        Log.e(TAG, t.getMessage());
                        dialog.dismiss();
                    }
                });
                break;
            default:
                break;
        }
    }


    //Getter and Setter to get each list in ListActivity

    public static List<ElementFilms> getElementFilmsList() {
        return elementFilmsList;
    }

    public static void setElementFilmsList(List<ElementFilms> elementFilmsList) {
        CategoryActivity.elementFilmsList = elementFilmsList;
    }

    public static List<ElementPeople> getElementPeopleList() {
        return elementPeopleList;
    }

    public static void setElementPeopleList(List<ElementPeople> elementPeopleList) {
        CategoryActivity.elementPeopleList = elementPeopleList;
    }

    public static List<ElementPlanets> getElementPlanetsList() {
        return elementPlanetsList;
    }

    public static void setElementPlanetsList(List<ElementPlanets> elementPlanetsList) {
        CategoryActivity.elementPlanetsList = elementPlanetsList;
    }

    public static List<ElementSpecies> getElementSpeciesList() {
        return elementSpeciesList;
    }

    public static void setElementSpeciesList(List<ElementSpecies> elementSpeciesList) {
        CategoryActivity.elementSpeciesList = elementSpeciesList;
    }

    public static List<ElementStarships> getElementStarshipsList() {
        return elementStarshipsList;
    }

    public static void setElementStarshipsList(List<ElementStarships> elementStarshipsList) {
        CategoryActivity.elementStarshipsList = elementStarshipsList;
    }

    public static List<ElementVehicles> getElementVehiclesList() {
        return elementVehiclesList;
    }

    public static void setElementVehiclesList(List<ElementVehicles> list) {
        elementVehiclesList = list;
    }
}
