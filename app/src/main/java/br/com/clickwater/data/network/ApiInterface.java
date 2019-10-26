package br.com.clickwater.data.network;

import br.com.clickwater.data.model.Address;
import br.com.clickwater.data.model.AddressList;
import br.com.clickwater.data.model.DepositHome;
import br.com.clickwater.data.model.Login;
import br.com.clickwater.data.model.RequestLogin;
import br.com.clickwater.data.model.RequestUser;
import br.com.clickwater.data.model.Seller;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiInterface {

    @POST("login")
    @Headers({"Content-Type:application/json"})
    Call<Login> requestLogin(@Body RequestLogin body);

    @GET("seller/popular")
    @Headers("Content-Type:application/json")
    Call<DepositHome> requestPopular(@Header("Bearer") String token);

    @GET("seller/offers")
    @Headers("Content-Type:application/json")
    Call<DepositHome> requestOffers(@Header("Bearer") String token);

    @GET("seller/news")
    @Headers("Content-Type:application/json")
    Call<DepositHome> requestNews(@Header("Bearer") String token);

    @GET("seller/news")
    @Headers("Content-Type:application/json")
    Call<Seller> requestSeller(@Header("Bearer") String token);

    @GET("seller/popular")
    @Headers("Content-Type:application/json")
    Call<AddressList> requestAddress(@Header("Bearer") String token);

    @POST("address")
    @Headers({"Content-Type:application/json"})
    Call<Address> requestNewAddress(@Body Address address);

    @POST("users")
    @Headers({"Content-Type:application/json"})
    Call<RequestUser> requestCreateUsers(@Body RequestUser address);
}
