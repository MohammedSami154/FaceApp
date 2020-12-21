package com.example.faceapp.ui.main;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.faceapp.data.PostClient;
import com.example.faceapp.pojo.PostModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostViewModel extends ViewModel {
    MutableLiveData<List<PostModel>> listMutableLiveData = new MutableLiveData<>();
    MutableLiveData<String> error = new MutableLiveData<>();

    public void setPostToMutableVariable(){
        PostClient.getINSTANCE().getPost().enqueue(new Callback<List<PostModel>>() {
            @Override
            public void onResponse(Call<List<PostModel>> call, Response<List<PostModel>> response) {
                listMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<PostModel>> call, Throwable t) {
                error.setValue(t.getMessage());
            }
        });
    }
}
