package mauricioeduardo.com.cinemasteresina;

import android.graphics.Movie;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by mauricioedu on 26/12/17.
 */

public class CinemaList {

    @Expose
    private ArrayList<Filme> filmes = new ArrayList<>();

    /**
     * @return The contacts
     */
    public ArrayList<Filme> getFilmes() {
        return filmes;
    }


    public void setFilmes(ArrayList<Filme> filmes) {
        this.filmes = filmes;
    }
}
