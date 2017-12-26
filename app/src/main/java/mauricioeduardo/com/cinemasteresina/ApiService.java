package mauricioeduardo.com.cinemasteresina;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by mauricioedu on 26/12/17.
 */

public interface ApiService {

    @GET("/filmes.json")
    Call<CinemaList> getMyJSON();

}
