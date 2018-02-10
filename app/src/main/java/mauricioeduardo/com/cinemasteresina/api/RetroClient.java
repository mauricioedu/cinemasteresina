package mauricioeduardo.com.cinemasteresina.api;



import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by mauricioedu on 26/12/17.
 */

public class RetroClient {
    private static ApiService service;

    public static ApiService getClient() {
        if (service == null) {
            Gson gson = new GsonBuilder()
                    .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                    .create();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://www.cinemasteresina.com.br")
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();

            service = retrofit.create(ApiService.class);
        }
        return service;
    }

}
