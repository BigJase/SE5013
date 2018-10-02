package com.example.jason.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.valueOf;

public class viewList extends AppCompatActivity {

    private List<Trees> trees = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.itemlayout);

        populateTreesList();
        populateListView();
        onClickCall();
    }
    private void populateTreesList(){
        trees.add(new Trees("Pohu", "red stuff 1", 5, 1000.0, R.drawable.plantatreelogo));
        trees.add(new Trees("Kauri", "Big and cool", 10, 2500.0, R.drawable.kowhai));
        trees.add(new Trees("Fern", "red stuff 2", 20, 8000.0, R.drawable.pohutukawa));
        trees.add(new Trees("Apple tree", "red stuff 3", 2, 200.0, R.drawable.shovel));
        trees.add(new Trees("Carrot", "red stuff 4", 500, 3240.0, R.drawable.kowhai));
    }

    private void populateListView(){
        ArrayAdapter<Trees> adapter = new MyListAdapter();
        ListView list = findViewById(R.id.treesListView);
        list.setAdapter(adapter);
    }

    private void onClickCall(){
        ListView list = findViewById(R.id.treesListView);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Trees clickedTree = trees.get(position);

                String treeName = clickedTree.getTreeName();
                String treeDescription = clickedTree.getDescription();
                double treePrice = clickedTree.getPrice();
                int treePic = clickedTree.getTreePicture();

                setContentView(R.layout.activity_item_details);

                TextView treeN = findViewById(R.id.treeName);
                treeN.setText(treeName);

                TextView treeDesc = findViewById(R.id.treeDesc);
                treeDesc.setText(treeDescription);

                ImageView treepic = findViewById(R.id.treePicture);
                treepic.setImageResource(treePic);

                TextView treeP = findViewById(R.id.treePrice);
                treeP.setText(valueOf(treePrice));

            }
        });
    }

    private class MyListAdapter extends ArrayAdapter<Trees>{
        public MyListAdapter() {
            super(viewList.this, R.layout.activity_list_view, trees);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent){
            // make sure we have a view to work with
            View itemView = convertView;
            if(itemView == null){
                itemView = getLayoutInflater().inflate(R.layout.activity_list_view, parent, false);
            }

            //Find tree
            Trees currentTree = trees.get(position);

            //Picture of tree:
            ImageView imageview = itemView.findViewById(R.id.item_treeIcon);
            imageview.setImageResource(currentTree.getTreePicture());

            // Description of tree:
            TextView description = itemView.findViewById(R.id.item_treeDescription);
            description.setText(currentTree.getDescription());

            // Name of tree:
            TextView name = itemView.findViewById(R.id.item_treeName);
            name.setText(currentTree.getTreeName());

            // Price of tree:
            TextView price = itemView.findViewById(R.id.item_treePrice);
            price.setText("" + currentTree.getPrice());

            return itemView;
        }

    }
}
