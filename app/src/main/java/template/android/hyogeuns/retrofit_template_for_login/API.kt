package template.android.hyogeuns.retrofit_template_for_login


import retrofit2.Call
import retrofit2.http.*


interface API {

    @POST("/user/signin")  //로그인
    @FormUrlEncoded
    fun logIn(@Field("id") id : String, @Field("pw") pw : String) :  Call<Void>

    @POST("/user/signup") //회원가임
    @FormUrlEncoded
    fun logUp(@Field("name") name : String, @Field("id") id : String, @Field("pw") pw : String) :  Call<Void>
}