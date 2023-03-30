package com.example.spotrkom.viewModel;

import android.app.Application;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.spotrkom.data.user.AppDatabase;
import com.example.spotrkom.pojo.UserModel;

import java.util.List;


public class UserViewModel extends AndroidViewModel {

    private static AppDatabase database;
    private LiveData<List<UserModel>> users;

    public UserViewModel(@NonNull Application application) {
        super(application);
        database = AppDatabase.getInstance(getApplication());
        users = database.userDao().getAllUsers();
    }

    public LiveData<List<UserModel>> getUsers() {
        return users;
    }

    public void insertUser(UserModel user){
        new InsertUserTask().execute(user);
    }

    public void updateUser(UserModel user){
        new UpdateUserTask().execute(user);
    }

    public void deleteUser(UserModel user){
        new DeleteUserTask().execute(user);
    }

    private static class InsertUserTask extends AsyncTask<UserModel, Void, Void>{

        @Override
        protected Void doInBackground(UserModel... userModels) {
            if (userModels != null && userModels.length > 0){
                database.userDao().insertUser(userModels[0]);
            }
            return null;
        }
    }

    private static class UpdateUserTask extends AsyncTask<UserModel, Void, Void>{

        @Override
        protected Void doInBackground(UserModel... userModels) {
            if (userModels != null && userModels.length > 0){
                database.userDao().updateUser(userModels[0]);
            }
            return null;
        }
    }

    private static class DeleteUserTask extends AsyncTask<UserModel, Void, Void>{

        @Override
        protected Void doInBackground(UserModel... userModels) {
            if (userModels != null && userModels.length > 0){
                database.userDao().deleteUser(userModels[0]);
            }
            return null;
        }
    }

    public void deleteAllUsers(){
        new DeleteAllUsersTask().execute();
    }

    private static class DeleteAllUsersTask extends  AsyncTask <Void, Void, Void>{

        @Override
        protected Void doInBackground(Void... voids) {
            database.userDao().deleteAllUsers();
            return null;
        }


    }

}
