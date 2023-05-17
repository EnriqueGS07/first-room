package org.adaschool.retrofit;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import com.bumptech.glide.Glide;
import org.adaschool.retrofit.databinding.ActivityMainBinding;
import org.adaschool.retrofit.RetrofitInstance;
import org.adaschool.retrofit.BreedsListDto;
import org.adaschool.retrofit.DogApiService;

import java.util.List;
import java.util.Map;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        DogApiService dogApiService = RetrofitInstance.getRetrofitInstance().create(DogApiService.class);

//        Call<BreedsListDto> call = dogApiService.getAllBreeds();
//        call.enqueue(new Callback<BreedsListDto>() {
//            @Override
//            public void onResponse(Call<BreedsListDto> call, Response<BreedsListDto> response) {
//                if (response.isSuccessful()) {
//                    Map<String, String[]> breeds = response.body().getMessage();
//                    for (Map.Entry<String, String[]> entry : breeds.entrySet()) {
//                        Log.d(TAG, "Raza: " + entry.getKey());
//                        for (String subRaza : entry.getValue()) {
//                            Log.d(TAG, "Subraza: " + subRaza);
//                        }
//                    }
//                } else {
//                    Log.e(TAG, "Error en la respuesta de la API");
//                }
//            }
//
//            @Override
//            public void onFailure(Call<BreedsListDto> call, Throwable t) {
//                Log.e(TAG, "Error al llamar a la API", t);
//            }
//        });
        loadDogInfo();
    }

    private void loadDogInfo() {
        MainActivity view = this;
        String breed = "african";
        DogApiService dogApiService = RetrofitInstance.getRetrofitInstance().create(DogApiService.class);
        Call<BreedsListDto> call = dogApiService.getAllImages(breed);
        call.enqueue(new Callback<BreedsListDto>() {

            @Override
            public void onResponse(Call<BreedsListDto> call, Response<BreedsListDto> response) {

                if(response.isSuccessful()){
                    assert response.body() != null;
                    List<String> breeds = response.body().getMessage();
                    String dogImageUrl = breeds.get(0);
                    String dogName = breed;
                    binding.textView.setText(dogName);
                    Glide.with(view)
                        .load(dogImageUrl)
                        .into(binding.imageView);

                }
            }

            @Override
            public void onFailure(Call<BreedsListDto> call, Throwable t) {
                Log.e(TAG, "Error al llamar a la API", t);
            }
        });
//
    }


}
