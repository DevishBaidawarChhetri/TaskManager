package np.com.devish.taskmanager.api;

import np.com.devish.taskmanager.model.Users;
import np.com.devish.taskmanager.serverresponse.ImageResponse;
import np.com.devish.taskmanager.serverresponse.SignupResponse;
import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface UsersAPI {
    @POST("users/signup")
    Call<SignupResponse> registerUser(@Body Users users);

    @FormUrlEncoded
    @POST("users/login")
    Call<SignupResponse> checkUser(@Field("username") String username, @Field("password") String password);

    @Multipart
    @POST("upload")
    Call<ImageResponse> uploadImage(@Part MultipartBody.Part img);
}
