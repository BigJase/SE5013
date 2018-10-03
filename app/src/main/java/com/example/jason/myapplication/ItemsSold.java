package com.example.jason.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.valueOf;

public class ItemsSold extends AppCompatActivity {

    private List<Trees> trees = new ArrayList<>();
    private List<Products> products = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tree_list_item);

        populateTreesList();
        populateProductsList();
        populateListView();
        onClickCall();
    }
    private void populateTreesList(){
        trees.add(new Trees(
                "Pohu",
                "red stuff 1",
                5,
                1000.0,
                R.drawable.plantatreelogo)
        );
        trees.add(new Trees(
                "Kauri",
                "Big and cool",
                10,
                2500.0,
                R.drawable.kowhai)
        );
        trees.add(new Trees(
                "Fern",
                "red stuff 2",
                20,
                8000.0,
                R.drawable.pohutukawa)
        );
        trees.add(new Trees(
                "Apple tree",
                "red stuff 3",
                2,
                200.0,
                R.drawable.shovel)
        );
        trees.add(new Trees(
                "Carrot",
                "red stuff 4",
                500,
                3240.0,
                R.drawable.kowhai)
        );
    }

    private void populateProductsList(){
        products.add(new Products(
                "Special Shovel",
                "This is a all in one special shovel used for shoveling stuff",
                4.8,
                49.99,
                R.drawable.shovel)
        );
        products.add(new Products(
                "Hose",
                "This is no ordinary hose. Comes with a multi spraying attachment for all your hosing needs.",
                4.5,
                35.99,
                R.drawable.hose)
        );
        products.add(new Products(
                "Gardening Gloves",
                "Where them on your hands, don't mess up ya glands.",
                5.0,
                24.99,
                R.drawable.gloves)
        );
        products.add(new Products(
                "Electric Plant Groomer",
                "As described",
                4.8,
                149.99,
                R.drawable.treecutter)
        );
    }

    private void populateListView(){
        ArrayAdapter<Trees> adapter = new MyListAdapter();
        ListView list = findViewById(R.id.treesListView);
        list.setAdapter(adapter);

        /*ArrayAdapter<Products> adapter2 = new MyListAdapter2();
        ListView list2 = findViewById(R.id.treesListView);
        list2.setAdapter(adapter2);*/
    }
    private void onClickCall(){
        ListView list = findViewById(R.id.treesListView);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //  TREES  TREES
                Trees clickedTree = trees.get(position);

                String treeName = clickedTree.getTreeName();
                String treeDescription = clickedTree.getDescription();
                double treePrice = clickedTree.getPrice();
                int treePic = clickedTree.getTreePicture();

                setContentView(R.layout.view_selected_item);

                TextView treeN = findViewById(R.id.itemName);
                treeN.setText(treeName);

                TextView treeDesc = findViewById(R.id.itemDescription);
                treeDesc.setText(treeDescription);

                ImageView treepic = findViewById(R.id.itemPic);
                treepic.setImageResource(treePic);

                TextView treeP = findViewById(R.id.itemPrice);
                treeP.setText("$"+valueOf(treePrice));

                //PRODUCTS PRODUCTS
                /*Products clickedProduct = products.get(position);

                String prodName = clickedProduct.getProductName();
                String prodDescription = clickedProduct.getDescription();
                double prodPrice = clickedProduct.getPrice();
                int prodPic = clickedProduct.getProductPicture();

                setContentView(R.layout.view_selected_item);

                TextView prodN = findViewById(R.id.textViewTitle);
                prodN.setText(prodName);

                TextView prodDesc = findViewById(R.id.textViewShortDesc);
                prodDesc.setText(prodDescription);

                ImageView prodPicture = findViewById(R.id.imageView);
                prodPicture.setImageResource(prodPic);

                TextView prodPric = findViewById(R.id.textViewPrice);
                prodPric.setText("$"+valueOf(prodPrice));*/

            }
        });
    }

    // Products (shovel etc)
    private class MyListAdapter2 extends ArrayAdapter<Products> {
        public MyListAdapter2() {
            super(ItemsSold.this, R.layout.tree_list_item_format, products);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // make sure we have a view to work with
            View itemView = convertView;
            if (itemView == null) {
                itemView = getLayoutInflater().inflate(R.layout.tree_list_item_format, parent, false);
            }

            // Find product
            Products currentProduct = products.get(position);

            // Picture of product:
            ImageView imageview = itemView.findViewById(R.id.imageView);
            imageview.setImageResource(currentProduct.getProductPicture());

            // Description of product:
            TextView description = itemView.findViewById(R.id.textViewShortDesc);
            description.setText(currentProduct.getDescription());

            // Name of product:
            TextView name = itemView.findViewById(R.id.textViewTitle);
            name.setText(currentProduct.getProductName());

            // Price of product:
            TextView price = itemView.findViewById(R.id.textViewPrice);
            price.setText("$" + currentProduct.getPrice());

            return itemView;
        }
    }

        //Trees
    private class MyListAdapter extends ArrayAdapter<Trees>{
        public MyListAdapter() {
            super(ItemsSold.this, R.layout.tree_list_item_format, trees);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent){
            // make sure we have a view to work with
            View itemView = convertView;
            if(itemView == null){
                itemView = getLayoutInflater().inflate(R.layout.tree_list_item_format, parent, false);
            }

            //Find tree
            Trees currentTree = trees.get(position);

            //Picture of tree:
            ImageView imageview = itemView.findViewById(R.id.itemPic);
            imageview.setImageResource(currentTree.getTreePicture());

            // Description of tree:
            TextView description = itemView.findViewById(R.id.itemDescription);
            description.setText(currentTree.getDescription());

            // Name of tree:
            TextView name = itemView.findViewById(R.id.itemName);
            name.setText(currentTree.getTreeName());

            // Price of tree:
            TextView price = itemView.findViewById(R.id.itemPrice);
            price.setText("$" + currentTree.getPrice());

            return itemView;
        }

    }
}
