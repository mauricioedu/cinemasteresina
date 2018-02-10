package mauricioeduardo.com.cinemasteresina;

import android.app.Activity;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Configuration;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;


import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import mauricioeduardo.com.cinemasteresina.adapter.MeuCinemaAdapter;
import mauricioeduardo.com.cinemasteresina.api.ApiService;
import mauricioeduardo.com.cinemasteresina.api.RetroClient;
import mauricioeduardo.com.cinemasteresina.model.Filme;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Filme> filmes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        if (getActivity().getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        } else {
            recyclerView.setLayoutManager(new GridLayoutManager(this, 4));
        }

        loadJSON();

    }

    public Activity getActivity(){
        Context context = this;
        while (context instanceof ContextWrapper){
            if (context instanceof Activity){
                return (Activity) context;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        return null;

    }

    private void loadJSON(){

        ApiService serviceAPI = RetroClient.getClient();
        Call<JsonArray> loadFilmeCall = serviceAPI.readFilmeArray();

        loadFilmeCall.enqueue(new Callback<JsonArray>() {
            @Override
            public void onResponse(Call<JsonArray> call, Response<JsonArray> response) {

                try {

                    String teamString = response.body().toString();

                    Type listType = new TypeToken<List<Filme>>() {}.getType();
                    filmes = getTeamListFromJson(teamString, listType);

                    recyclerView.setItemAnimator(new DefaultItemAnimator());
                    recyclerView.setAdapter(new MeuCinemaAdapter(getApplicationContext(), filmes));

                    //sorting recipe in alphabetical order which UI test was done upon
                    // Collections.sort(recipes, Recipe.BY_NAME_ALPHABETICAL);


                } catch (Exception e) {
                    Log.d("onResponse", "There is an error");
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call<JsonArray> call, Throwable t) {

                Log.d("onFailure", t.toString());

            }


        });
    }

    public static <T> List<T> getTeamListFromJson(String jsonString, Type type) {
        if (!isValid(jsonString)) {
            return null;
        }
        return new Gson().fromJson(jsonString, type);
    }

    public static boolean isValid(String json) {
        try {
            new JsonParser().parse(json);
            return true;
        } catch (JsonSyntaxException jse) {
            return false;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

        loadJSON();
    }
}