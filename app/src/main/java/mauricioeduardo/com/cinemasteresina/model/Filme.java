package mauricioeduardo.com.cinemasteresina.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by mauricioedu on 26/12/17.
 */

public class Filme {

    @SerializedName("cartaz")
    @Expose
    private String cartaz;
    @SerializedName("titulo")
    @Expose
    private String titulo;

    public String getCartaz() {
        return cartaz;
    }

    public void setCartaz(String cartaz) {
        this.cartaz = cartaz;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
