package br.com.clickwater.data.network;

import br.com.clickwater.data.model.Address;
import br.com.clickwater.data.model.AddressList;
import br.com.clickwater.data.model.CreditCard;
import br.com.clickwater.data.model.CreditCardList;
import br.com.clickwater.data.model.DepositHome;
import br.com.clickwater.data.model.ListProduct;
import br.com.clickwater.data.model.Login;
import br.com.clickwater.data.model.RequestLogin;
import br.com.clickwater.data.model.RequestSeller;
import br.com.clickwater.data.model.RequestUser;
import br.com.clickwater.data.model.Seller;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {

    @POST("login")
    @Headers({"Content-Type:application/json"})
    Call<Login> requestLogin(@Body RequestLogin body);

    @GET("seller/popular")
    @Headers("Content-Type:application/json")
    Call<DepositHome> requestPopular(@Header("Authorization") String token);

    @GET("seller/offers")
    @Headers("Content-Type:application/json")
    Call<DepositHome> requestOffers(@Header("Authorization") String token);

    @GET("seller/news")
    @Headers("Content-Type:application/json")
    Call<DepositHome> requestNews(@Header("Authorization") String token);

    @GET("seller/{sellerId}")
    @Headers("Content-Type:application/json")
    Call<RequestSeller> requestSeller(@Header("Authorization") String token, @Path("sellerId") int sellerId);

    @GET("address")
    @Headers("Content-Type:application/json")
    Call<AddressList> requestAddress(@Header("Authorization") String token);

    @GET("payments")
    @Headers("Content-Type:application/json")
    Call<CreditCardList> requestPayments(@Header("Authorization") String token);

    @POST("address")
    @Headers({"Content-Type:application/json"})
    Call<Address> requestNewAddress(@Header("Authorization") String token, @Body Address address);

    @POST("payments")
    @Headers({"Content-Type:application/json"})
    Call<CreditCard> requestNewCreditCard(@Header("Authorization") String token, @Body CreditCard card);

    @POST("users")
    @Headers({"Content-Type:application/json"})
    Call<RequestUser> requestCreateUsers(@Body RequestUser address);

    @GET("product/seller/{sellerId}")
    @Headers("Content-Type:application/json")
    Call<ListProduct> requestProducts(@Header("Authorization") String token, @Path("sellerId") int sellerId);
}
