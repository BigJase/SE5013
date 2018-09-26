package com.example.jason.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ProductAdapter adapter;
    List<Product> treeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //initializing the productlist
        treeList = new ArrayList<>();


        EditText editText = findViewById(R.id.edittext);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }
        });


        //adding some items to our list
        treeList.add(
                new Product(
                        1,
                        "Pohutukawa",
                        "a coastal evergreen tree in the myrtle family, Myrtaceae, that produces a brilliant display of red ",
                        4.3,
                        475,
                        R.drawable.pohutukawa));

        treeList.add(
                new Product(
                        1,
                        "Kōwhai",
                        "small woody legume trees within the genus Sophora that are native to New Zealand.",
                        4.3,
                        350,
                        R.drawable.kowhai));

        treeList.add(
                new Product(
                        1,
                        "Lemon Tree",
                        "citrus limon, is a species of small evergreen tree in the flowering plant family Rutaceae.",
                        4.3,
                        120,
                        R.drawable.lemontree));
        treeList.add(
                new Product(
                        1,
                        "Pohutukawa",
                        "a coastal evergreen tree in the myrtle family, Myrtaceae, that produces a brilliant display of red ",
                        4.3,
                        475,
                        R.drawable.pohutukawa));

        treeList.add(
                new Product(
                        1,
                        "Kōwhai",
                        "small woody legume trees within the genus Sophora that are native to New Zealand.",
                        4.3,
                        350,
                        R.drawable.kowhai));

        treeList.add(
                new Product(
                        1,
                        "Lemon Tree",
                        "citrus limon, is a species of small evergreen tree in the flowering plant family Rutaceae.",
                        4.3,
                        120,
                        R.drawable.lemontree));
        treeList.add(
                new Product(
                        1,
                        "Pohutukawa",
                        "a coastal evergreen tree in the myrtle family, Myrtaceae, that produces a brilliant display of red ",
                        4.3,
                        475,
                        R.drawable.pohutukawa));

        treeList.add(
                new Product(
                        1,
                        "Kōwhai",
                        "small woody legume trees within the genus Sophora that are native to New Zealand.",
                        4.3,
                        350,
                        R.drawable.kowhai));

        treeList.add(
                new Product(
                        1,
                        "Lemon Tree",
                        "citrus limon, is a species of small evergreen tree in the flowering plant family Rutaceae.",
                        4.3,
                        120,
                        R.drawable.lemontree));
        treeList.add(
                new Product(
                        1,
                        "Pohutukawa",
                        "a coastal evergreen tree in the myrtle family, Myrtaceae, that produces a brilliant display of red ",
                        4.3,
                        475,
                        R.drawable.pohutukawa));

        treeList.add(
                new Product(
                        1,
                        "Kōwhai",
                        "small woody legume trees within the genus Sophora that are native to New Zealand.",
                        4.3,
                        350,
                        R.drawable.kowhai));

        treeList.add(
                new Product(
                        1,
                        "Lemon Tree",
                        "citrus limon, is a species of small evergreen tree in the flowering plant family Rutaceae.",
                        4.3,
                        120,
                        R.drawable.lemontree));
        treeList.add(
                new Product(
                        1,
                        "Pohutukawa",
                        "a coastal evergreen tree in the myrtle family, Myrtaceae, that produces a brilliant display of red ",
                        4.3,
                        475,
                        R.drawable.pohutukawa));

        treeList.add(
                new Product(
                        1,
                        "Kōwhai",
                        "small woody legume trees within the genus Sophora that are native to New Zealand.",
                        4.3,
                        350,
                        R.drawable.kowhai));

        treeList.add(
                new Product(
                        1,
                        "Lemon Tree",
                        "citrus limon, is a species of small evergreen tree in the flowering plant family Rutaceae.",
                        4.3,
                        120,
                        R.drawable.lemontree));

        adapter = new ProductAdapter(this, treeList);
        recyclerView.setAdapter(adapter);

    }

    private void filter(String text){
        ArrayList<Product> filteredList = new ArrayList<>();

        for(Product item : treeList){
            if (item.getTitle().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            }
        }

        adapter.filterList(filteredList);
    }
}
