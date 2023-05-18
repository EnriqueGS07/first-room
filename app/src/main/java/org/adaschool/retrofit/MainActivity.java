package org.adaschool.retrofit;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;

import org.adaschool.retrofit.databinding.ActivityMainBinding;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        AppDataBase db = Room.databaseBuilder(getApplicationContext(),
                AppDataBase.class, "database-name").allowMainThreadQueries().build();
        UserDao userDao = db.userDao();
        userDao.inserOne(new User());
        System.out.println(userDao.getAll());

    }

}
