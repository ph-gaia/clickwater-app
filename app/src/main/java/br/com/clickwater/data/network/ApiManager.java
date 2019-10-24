package br.com.clickwater.data.network;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiManager {

    private static ApiInterface REST_CLIENT;

    private static final String API_URL = "http://192.168.0.7:3333/api/v1/";

    static {
        setupRestClient();
    }

    private ApiManager() {}

    public static ApiInterface get() {
        return REST_CLIENT;
    }

    private static void setupRestClient() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();

        REST_CLIENT = retrofit.create(ApiInterface.class);
    }
}
