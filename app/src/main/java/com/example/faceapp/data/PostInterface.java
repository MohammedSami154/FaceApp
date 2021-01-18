package com.example.faceapp.data;

import com.example.faceapp.pojo.PostModel;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;

public interface PostInterface {
    @GET("posts")
    public Observable<List<PostModel>> getPost();
}
