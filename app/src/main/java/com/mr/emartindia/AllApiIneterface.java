package com.mr.emartindia;

import com.mr.emartindia.addressPOJO.addressBean;
import com.mr.emartindia.cartPOJO.cartBean;
import com.mr.emartindia.checkPromoPOJO.checkPromoBean;
import com.mr.emartindia.checkoutPOJO.checkoutBean;
import com.mr.emartindia.homePOJO.homeBean;
import com.mr.emartindia.orderDetailsPOJO.orderDetailsBean;
import com.mr.emartindia.ordersPOJO.ordersBean;
import com.mr.emartindia.productsPOJO.productsBean;
import com.mr.emartindia.searchPOJO.searchBean;
import com.mr.emartindia.seingleProductPOJO.singleProductBean;
import com.mr.emartindia.subCat1POJO.subCat1Bean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface AllApiIneterface {


    @GET("emartindia/api/getHome.php")
    Call<homeBean> getHome();

    @Multipart
    @POST("emartindia/api/getSubCat1.php")
    Call<subCat1Bean> getSubCat1(
            @Part("cat") String cat
    );

    @Multipart
    @POST("emartindia/api/getSubCat2.php")
    Call<subCat1Bean> getSubCat2(
            @Part("subcat1") String cat
    );

    @Multipart
    @POST("emartindia/api/getProducts.php")
    Call<productsBean> getProducts(
            @Part("subcat2") String cat
    );

    @Multipart
    @POST("emartindia/api/getProductById.php")
    Call<singleProductBean> getProductById(
            @Part("id") String cat
    );

    @Multipart
    @POST("emartindia/api/search.php")
    Call<searchBean> search(
            @Part("query") String query
    );

    @Multipart
    @POST("emartindia/api/login.php")
    Call<loginBean> login(
            @Part("phone") String phone,
            @Part("token") String token
    );

    @Multipart
    @POST("emartindia/api/verify.php")
    Call<loginBean> verify(
            @Part("phone") String phone,
            @Part("otp") String otp
    );

    @Multipart
    @POST("emartindia/api/addCart.php")
    Call<singleProductBean> addCart(
            @Part("user_id") String user_id,
            @Part("product_id") String product_id,
            @Part("quantity") String quantity,
            @Part("unit_price") String unit_price,
            @Part("version") String version
    );

    @Multipart
    @POST("emartindia/api/updateCart.php")
    Call<singleProductBean> updateCart(
            @Part("id") String id,
            @Part("quantity") String quantity,
            @Part("unit_price") String unit_price
    );

    @Multipart
    @POST("emartindia/api/deleteCart.php")
    Call<singleProductBean> deleteCart(
            @Part("id") String id
    );

    @Multipart
    @POST("emartindia/api/getRew.php")
    Call<String> getRew(
            @Part("user_id") String user_id
    );

    @Multipart
    @POST("emartindia/api/clearCart.php")
    Call<singleProductBean> clearCart(
            @Part("user_id") String user_id
    );

    @Multipart
    @POST("emartindia/api/getOrderDetails.php")
    Call<orderDetailsBean> getOrderDetails(
            @Part("order_id") String order_id
    );

    @Multipart
    @POST("emartindia/api/getCart.php")
    Call<cartBean> getCart(
            @Part("user_id") String user_id
    );

    @Multipart
    @POST("emartindia/api/getOrders.php")
    Call<ordersBean> getOrders(
            @Part("user_id") String user_id
    );

    @Multipart
    @POST("emartindia/api/getAddress.php")
    Call<addressBean> getAddress(
            @Part("user_id") String user_id
    );

    @Multipart
    @POST("emartindia/api/deleteAddress.php")
    Call<addressBean> deleteAddress(
            @Part("id") String id
    );

    @Multipart
    @POST("emartindia/api/checkPromo.php")
    Call<checkPromoBean> checkPromo(
            @Part("promo") String promo,
            @Part("user_id") String user_id
    );

    @Multipart
    @POST("emartindia/api/buyVouchers.php")
    Call<checkoutBean> buyVouchers(
            @Part("user_id") String user_id,
            @Part("amount") String amount,
            @Part("txn") String txn,
            @Part("name") String name,
            @Part("address") String address,
            @Part("pay_mode") String pay_mode,
            @Part("slot") String slot,
            @Part("date") String date,
            @Part("promo") String promo,
            @Part("house") String house,
            @Part("area") String area,
            @Part("city") String city,
            @Part("pin") String pin,
            @Part("isnew") String isnew
    );
}
