package mauricioeduardo.com.cinemasteresina;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by mauricioedu on 26/12/17.
 */

public class Filme {

    @SerializedName("id")
    @Expose
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getSemana() {
        return semana;
    }

    public void setSemana(String semana) {
        this.semana = semana;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    public String getCartaz() {
        return cartaz;
    }

    public void setCartaz(String cartaz) {
        this.cartaz = cartaz;
    }

    @SerializedName("titulo")
    @Expose
    private String titulo;

    @SerializedName("genero")
    @Expose
    private String genero;

    @SerializedName("semana")
    @Expose
    private String semana;

    @SerializedName("classificacao")
    @Expose
    private String classificacao;

    @SerializedName("cartaz")
    @Expose
    private String cartaz;

}
