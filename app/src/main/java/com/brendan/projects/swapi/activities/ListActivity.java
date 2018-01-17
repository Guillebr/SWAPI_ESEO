package com.brendan.projects.swapi.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.brendan.projects.swapi.R;
import com.brendan.projects.swapi.models.ElementFilms;
import com.brendan.projects.swapi.models.ElementPeople;
import com.brendan.projects.swapi.models.ElementPlanets;
import com.brendan.projects.swapi.models.ElementSpecies;
import com.brendan.projects.swapi.models.ElementStarships;
import com.brendan.projects.swapi.models.ElementVehicles;
import com.brendan.projects.swapi.utils.ui.ListAdapter;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    ListView listView;

    List<ElementFilms> elementFilmsList;
    List<ElementPeople> elementPeopleList;
    List<ElementPlanets> elementPlanetsList;
    List<ElementSpecies> elementSpeciesList;
    List<ElementStarships> elementStarshipsList;
    List<ElementVehicles> elementVehiclesList;

    boolean isFilm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        Bundle extras = getIntent().getExtras();
        String actionBarTitle = "";
        if (extras != null) {
            actionBarTitle = extras.getString("actionBarTitle");
        }
        setTitle(actionBarTitle);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        final Intent intent = new Intent(ListActivity.this, DetailActivity.class);

        final ArrayList<String[]> values = new ArrayList<>();

        if (actionBarTitle != null) {
            switch (actionBarTitle) {
                case "Films":
                    isFilm = true;
                    values.clear();
                    elementFilmsList = CategoryActivity.getElementFilmsList();
                    for (int i = 0; i < elementFilmsList.get(0).getResults().size(); i++) {
                        values.add(new String[]{
                                elementFilmsList.get(0).getResults().get(i).getTitle(),
                                "Épisode " + toRomanNumber(elementFilmsList.get(0).getResults().get(i).getEpisodeId()),
                                "", "",
                                "", elementFilmsList.get(0).getResults().get(i).getOpeningCrawl(),
                                "", "",
                                "", "",
                                "", "",
                                "", ""
                        });
                    }
                    break;
                case "Personnages":
                    isFilm = false;
                    values.clear();
                    elementPeopleList = CategoryActivity.getElementPeopleList();
                    for (int i = 0; i < elementPeopleList.get(0).getResults().size(); i++) {
                        values.add(new String[]{
                                elementPeopleList.get(0).getResults().get(i).getName(),
                                "",
                                "", "",
                                "Genre", elementPeopleList.get(0).getResults().get(i).getGender(),
                                "Date de naissance", elementPeopleList.get(0).getResults().get(i).getBirthYear(),
                                "Taille ", elementPeopleList.get(0).getResults().get(i).getHeight() + " cm",
                                "Poids ", elementPeopleList.get(0).getResults().get(i).getMass() + " kg",
                                "", ""
                        });
                    }
                    break;
                case "Planètes":
                    isFilm = false;
                    values.clear();
                    elementPlanetsList = CategoryActivity.getElementPlanetsList();
                    for (int i = 0; i < elementPlanetsList.get(0).getResults().size(); i++) {
                        values.add(new String[]{
                                elementPlanetsList.get(0).getResults().get(i).getName(),
                                "",
                                "", "",
                                "Climat", elementPlanetsList.get(0).getResults().get(i).getClimate(),
                                "Population", elementPlanetsList.get(0).getResults().get(i).getPopulation() + " habitants",
                                "Période orbitale", elementPlanetsList.get(0).getResults().get(i).getOrbitalPeriod() + " jours",
                                "Période de rotation", elementPlanetsList.get(0).getResults().get(i).getRotationPeriod() + " h",
                                "Pourcentage d'eau présente sur la planète", elementPlanetsList.get(0).getResults().get(i).getSurfaceWater() + " %"
                        });
                    }
                    break;
                case "Espèces":
                    isFilm = false;
                    values.clear();
                    elementSpeciesList = CategoryActivity.getElementSpeciesList();
                    for (int i = 0; i < elementSpeciesList.get(0).getResults().size(); i++) {
                        values.add(new String[]{
                                elementSpeciesList.get(0).getResults().get(i).getName(),
                                elementSpeciesList.get(0).getResults().get(i).getClassification(),
                                "", "",
                                "Langue parlée", elementSpeciesList.get(0).getResults().get(i).getLanguage(),
                                "Taille moyenne", elementSpeciesList.get(0).getResults().get(i).getAverageHeight() + " cm",
                                "Âge moyen", elementSpeciesList.get(0).getResults().get(i).getAverageLifespan() + " ans",
                                "", "",
                                "", ""
                        });
                    }
                    break;
                case "Vaisseaux Spatiaux":
                    isFilm = false;
                    values.clear();
                    elementStarshipsList = CategoryActivity.getElementStarshipsList();
                    for (int i = 0; i < elementStarshipsList.get(0).getResults().size(); i++) {
                        values.add(new String[]{
                                elementStarshipsList.get(0).getResults().get(i).getName(),
                                elementStarshipsList.get(0).getResults().get(i).getModel(),
                                "Type", elementStarshipsList.get(0).getResults().get(i).getStarshipClass(),
                                "Fabricant", elementStarshipsList.get(0).getResults().get(i).getManufacturer(),
                                "Taille", elementStarshipsList.get(0).getResults().get(i).getLength() + " m",
                                "Peut comporter", elementStarshipsList.get(0).getResults().get(i).getPassengers() + " passagers\n" + elementStarshipsList.get(0).getResults().get(i).getCrew() + " membres d'équipage",
                                "Prix", elementStarshipsList.get(0).getResults().get(i).getCostInCredits() + " crédits",
                                "", ""
                        });
                    }
                    break;
                case "Véhicules":
                    isFilm = false;
                    values.clear();
                    elementVehiclesList = CategoryActivity.getElementVehiclesList();
                    for (int i = 0; i < elementVehiclesList.get(0).getResults().size(); i++) {
                        values.add(new String[]{
                                elementVehiclesList.get(0).getResults().get(i).getName(),
                                elementVehiclesList.get(0).getResults().get(i).getModel(),
                                "Type", elementVehiclesList.get(0).getResults().get(i).getVehicleClass(),
                                "Fabricant", elementVehiclesList.get(0).getResults().get(i).getManufacturer(),
                                "Taille", elementVehiclesList.get(0).getResults().get(i).getLength() + " m",
                                "Peut comporter", elementVehiclesList.get(0).getResults().get(i).getPassengers() + " passagers\n" + elementVehiclesList.get(0).getResults().get(i).getCrew() + " membres d'équipage",
                                "Prix", elementVehiclesList.get(0).getResults().get(i).getCostInCredits() + " crédits",
                                "", ""
                        });
                    }
                    break;
                default:
                    break;
            }
        }

        listView = findViewById(R.id.list_view);

        ListAdapter adapter = new ListAdapter(this, values);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                intent.putExtra("array", values.get(position));
                intent.putExtra("isFilm", isFilm);
                // Get the transition name from the string
                String transitionName = getString(R.string.transition);

                ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(ListActivity.this, view, transitionName);
                ActivityCompat.startActivity(ListActivity.this, intent, options.toBundle());
            }
        });
    }

    private String toRomanNumber(int i) {
        String romanNumber;
        switch (i) {
            case 1:
                romanNumber = "I";
                break;
            case 2:
                romanNumber = "II";
                break;
            case 3:
                romanNumber = "III";
                break;
            case 4:
                romanNumber = "IV";
                break;
            case 5:
                romanNumber = "V";
                break;
            case 6:
                romanNumber = "VI";
                break;
            case 7:
                romanNumber = "VII";
                break;
            default:
                romanNumber = "";
        }
        return romanNumber;
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
