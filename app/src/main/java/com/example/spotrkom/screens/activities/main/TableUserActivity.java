package com.example.spotrkom.screens.activities.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.spotrkom.R;
import com.example.spotrkom.adapters.UserAdapter;
import com.example.spotrkom.pojo.UserModel;
import com.example.spotrkom.viewModel.UserViewModel;

import java.util.ArrayList;
import java.util.List;

public class TableUserActivity extends AppCompatActivity {

    private static final int RC_RC_IMAGE = 100;
    private RecyclerView recyclerView;
    private UserViewModel viewModel;
    private UserAdapter adapter;
    private List<UserModel> users;

    private Dialog modalAddUser;
    private TextView countUsers;
    private Button btnModalAddUser;
    private Button btnModalAddImage;
    private EditText etModalUsername;
    private EditText etModalExp;
    private ImageView imageUser;

    private Dialog modalEditUser;
    private TextView tvDescription;
    private Button btnModalEdit;
    private Button btnModalDelete;

    private Dialog modalAddPoint;
    private EditText etAddPoint;
    private Button btnAddPoint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_user);

        modalAddUser = new Dialog(this);
        modalAddUser.setContentView(R.layout.modal_add_user);

        modalEditUser = new Dialog(this);
        modalEditUser.setContentView(R.layout.modal_confirm_user);

        modalAddPoint = new Dialog(this);
        modalAddPoint.setContentView(R.layout.modal_add_point);

        btnModalAddUser = modalAddUser.findViewById(R.id.btnAddUser);
        btnModalAddImage = modalAddUser.findViewById(R.id.btnAddImage);
        etModalUsername = modalAddUser.findViewById(R.id.etUserName);
        etModalExp = modalAddUser.findViewById(R.id.etPoint);
        imageUser = modalAddUser.findViewById(R.id.imageUser);

        tvDescription = modalEditUser.findViewById(R.id.tvDescription);
        btnModalEdit = modalEditUser.findViewById(R.id.btnEdit);
        btnModalDelete = modalEditUser.findViewById(R.id.btnDelete);

        etAddPoint = modalAddPoint.findViewById(R.id.etAddPoint);
        btnAddPoint = modalAddPoint.findViewById(R.id.btnAddPoint);

        countUsers = findViewById(R.id.tvCountUsers);
        viewModel = new ViewModelProvider(this).get(UserViewModel.class);
        recyclerView = findViewById(R.id.rc_tableUsers);
        users = new ArrayList<>();
        adapter = new UserAdapter(users);
        getData();
        recyclerView.setAdapter(adapter);
        initClickBtnModalAddUser();
        tvDescription.setText(Html.fromHtml("Выберите, что вы хотите <br/><font color=\"#FF0000\">сделать</font> с участником?"));
        adapter.setOnNoteClickListener(new UserAdapter.OnNoteClickListener() {
            @Override
            public void onNoteClick(int position) {

            }

            @Override
            public void onNoteLongClick(int position) {
                onClickOpenModalEditUser(position); // открытие окна с редактированием
            }
        });
    }

    public void onClickExitFromActivity(View view) { // Закрытие активити
        finish();
    }

    private void removeUser(int position){ // метод реализующий удаление данных из БД
        UserModel user = adapter.getUsers().get(position);
        viewModel.deleteUser(user);
    }

    private void editUser(int position, int exp){ // метод реализующий обновление данных
        UserModel user = adapter.getUsers().get(position);
        user.setExp(user.getExp() + exp);
        viewModel.updateUser(user);
        adapter.notifyDataSetChanged();
    }

    private void onClickAddPoint(int position){ // при нажатии на кнопку вызывает метод обновления данных, если editText не пуст
        btnAddPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!etAddPoint.getText().toString().isEmpty()){
                    editUser(position,Integer.parseInt(etAddPoint.getText().toString()));
                    modalAddPoint.dismiss();
                    etAddPoint.setText("");
                } else {
                    Toast.makeText(TableUserActivity.this, "Введите кол-во очков", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void getData(){ // обновляет список при включении активити
        LiveData<List<UserModel>> notesFromDB = viewModel.getUsers();
        notesFromDB.observe(this, new Observer<List<UserModel>>() {
            @Override
            public void onChanged(List<UserModel> userModels) {
                adapter.setUsers(userModels);
                countUsers.setText("Участников " + adapter.getItemCount());
            }
        });
    }


    public void onClickOpenModalAddUser(View view) { // при нажатии на кнопку показывает модалку с добавлением участниа
        modalAddUser.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        modalAddUser.show();
    }

    public void onClickOpenModalEditUser(int position) {// при нажатии показывает модалку с кнопками добавить или удалить
        modalEditUser.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        modalEditUser.show();
        initClickBtnModalEditUser(position);
        onClickAddPoint(position);
    }

    private void initClickBtnModalEditUser(int position){ // инициализирует кнопки, вешает на них слушатель
        btnModalEdit.setOnClickListener(new View.OnClickListener() { // при нажатии на кнопку вызывает модалку с добавлением очков
            @Override
            public void onClick(View v) {
                modalEditUser.dismiss();
                modalAddPoint.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                modalAddPoint.show();
            }
        });
        btnModalDelete.setOnClickListener(new View.OnClickListener() { // при нажатии удаляет пользователя
            @Override
            public void onClick(View v) {
                removeUser(position);
                modalEditUser.dismiss();
            }
        });
    }

    private void initClickBtnModalAddUser(){ // инициализирует кнопки в модалке с добавление пользователя
        btnModalAddUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!etModalExp.getText().toString().trim().isEmpty() && !etModalUsername.getText().toString().trim().isEmpty()){
                    String userName = etModalUsername.getText().toString().trim();
                    int exp = Integer.parseInt(etModalExp.getText().toString());
                    if (exp < 20000){
                        viewModel.insertUser(new UserModel(R.drawable.image_avatar, userName, exp));
                        modalAddUser.dismiss();
                        etModalExp.setText("");
                        etModalUsername.setText("");
                    } else {
                        Toast.makeText(TableUserActivity.this, getString(R.string.poslanie), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(TableUserActivity.this, "Одно из полей пусто", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnModalAddImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/jpeg");
                intent.putExtra(Intent.EXTRA_LOCAL_ONLY, true);
                startActivityForResult(intent, RC_RC_IMAGE);
            }
        });
    }


}