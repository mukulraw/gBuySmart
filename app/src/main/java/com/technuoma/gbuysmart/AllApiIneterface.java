package com.technuoma.gbuysmart;

import com.technuoma.gbuysmart.addressPOJO.addressBean;
import com.technuoma.gbuysmart.cartPOJO.cartBean;
import com.technuoma.gbuysmart.checkPromoPOJO.checkPromoBean;
import com.technuoma.gbuysmart.checkoutPOJO.checkoutBean;
import com.technuoma.gbuysmart.homePOJO.homeBean;
import com.technuoma.gbuysmart.orderDetailsPOJO.orderDetailsBean;
import com.technuoma.gbuysmart.ordersPOJO.ordersBean;
import com.technuoma.gbuysmart.productsPOJO.productsBean;
import com.technuoma.gbuysmart.searchPOJO.searchBean;
import com.technuoma.gbuysmart.seingleProductPOJO.singleProductBean;
import com.technuoma.gbuysmart.subCat1POJO.subCat1Bean;

import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface AllApiIneterface {

    @Multipart
    @POST("gbuysmart/api/getHome2.php")
    Call<homeBean> getHome(
            @Part("lat") String lat,
            @Part("lng") String lng
    );

    @Multipart
    @POST("gbuysmart/api/getSubCat1.php")
    Call<subCat1Bean> getSubCat1(
            @Part("cat") String cat
    );

    @Multipart
    @POST("gbuysmart/api/getSubCat2.php")
    Call<subCat1Bean> getSubCat2(
            @Part("subcat1") String cat
    );

    @Multipart
    @POST("gbuysmart/api/getProducts.php")
    Call<productsBean> getProducts(
            @Part("subcat2") String cat,
            @Part("location_id") String location_id
    );

    @Multipart
    @POST("gbuysmart/api/getProductById.php")
    Call<singleProductBean> getProductById(
            @Part("id") String cat
    );

    @Multipart
    @POST("gbuysmart/api/search.php")
    Call<searchBean> search(
            @Part("query") String query,
            @Part("location_id") String location_id
    );

    @Multipart
    @POST("gbuysmart/api/login.php")
    Call<loginBean> login(
            @Part("phone") String phone,
            @Part("token") String token,
            @Part("referrer") String referrer
    );

    @Multipart
    @POST("gbuysmart/api/verify.php")
    Call<loginBean> verify(
            @Part("phone") String phone,
            @Part("otp") String otp
    );

    @Multipart
    @POST("gbuysmart/api/addCart.php")
    Call<singleProductBean> addCart(
            @Part("user_id") String user_id,
            @Part("product_id") String product_id,
            @Part("quantity") String quantity,
            @Part("unit_price") String unit_price,
            @Part("version") String version
    );

    @Multipart
    @POST("gbuysmart/api/updateCart.php")
    Call<singleProductBean> updateCart(
            @Part("id") String id,
            @Part("quantity") String quantity,
            @Part("unit_price") String unit_price
    );

    @Multipart
    @POST("gbuysmart/api/deleteCart.php")
    Call<singleProductBean> deleteCart(
            @Part("id") String id
    );

    @Multipart
    @POST("gbuysmart/api/getRew.php")
    Call<String> getRew(
            @Part("user_id") String user_id
    );

    @Multipart
    @POST("gbuysmart/api/clearCart.php")
    Call<singleProductBean> clearCart(
            @Part("user_id") String user_id
    );

    @Multipart
    @POST("gbuysmart/api/getOrderDetails.php")
    Call<orderDetailsBean> getOrderDetails(
            @Part("order_id") String order_id
    );

    @Multipart
    @POST("gbuysmart/api/getCart.php")
    Call<cartBean> getCart(
            @Part("user_id") String user_id
    );

    @Multipart
    @POST("gbuysmart/api/getOrders.php")
    Call<ordersBean> getOrders(
            @Part("user_id") String user_id
    );

    @Multipart
    @POST("gbuysmart/api/getAddress.php")
    Call<addressBean> getAddress(
            @Part("user_id") String user_id
    );

    @Multipart
    @POST("gbuysmart/api/deleteAddress.php")
    Call<addressBean> deleteAddress(
            @Part("id") String id
    );

    @Multipart
    @POST("gbuysmart/api/checkPromo.php")
    Call<checkPromoBean> checkPromo(
            @Part("promo") String promo,
            @Part("user_id") String user_id
    );

    @Multipart
    @POST("gbuysmart/api/getOrderId.php")
    Call<payBean> getOrderId(
            @Part("amount") String amount,
            @Part("receipt") String receipt
    );

    @Multipart
    @POST("gbuysmart/api/buyVouchers.php")
    Call<checkoutBean> buyVouchers(
            @Part("user_id") String user_id,
            @Part("lat") String lat,
            @Part("lng") String lng,
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

    @Multipart
    @POST("gbuysmart/api/getMembership.php")
    Call<getMembershipBean> getMembership(
            @Part("user_id") String user_id
    );

    @Multipart
    @POST("gbuysmart/api/buyMembership.php")
    Call<checkoutBean> buyMembership(
            @Part("user_id") String user_id,
            @Part("membership") String membership,
            @Part("payment_id") String payment_id
    );

}
