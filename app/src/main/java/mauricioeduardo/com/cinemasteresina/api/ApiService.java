package mauricioeduardo.com.cinemasteresina.api;

import com.google.gson.JsonArray;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by mauricioedu on 26/12/17.
 */

public interface ApiService {


    @GET("/filmes.json")
    Call<JsonArray> readFilmeArray();

}
