package octopos.com.octopos_android.Network.Retrofit;

import com.jedi.navigationdrawerwithfragments.Puntuacione;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface APIService {

    @POST("/puntuacions")
    Call<Puntuacione> createPuntuacio(@Body Puntuacione puntuacio);

    @GET("/puntuacions")
    Call<Puntuacione> getPuntuacions();
}

