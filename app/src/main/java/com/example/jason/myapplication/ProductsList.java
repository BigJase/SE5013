package com.example.jason.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.valueOf;

public class ProductsList extends AppCompatActivity {

    Button addToCart;
    CartList cart = new CartList();
    List<Object> cartList = new ArrayList<>();
    CartItem cartItem = new CartItem();
    //private List<Trees> trees = new ArrayList<>();
    private List<Products> products = new ArrayList<>();

    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if(id == android.R.id.home){
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_viewlist);

        populateProductsList();
        populateProductListView();
        onClickCallProduct();

        cartList = cart.getCart();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
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
                "Special Shoveel",
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
        products.add(new Products(
                "This is the used product list",
                "As described",
                4.8,
                149.99,
                R.drawable.treecutter)
        );
        products.add(new Products(
                "Special Shovel",
                "This is a all in one special shovel used for shoveling stuff",
                4.8,
                49.99,
                R.drawable.shovel)
        );
        products.add(new Products(
                "Special Shoveel",
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
        products.add(new Products(
                "This is the used product list",
                "As described",
                4.8,
                149.99,
                R.drawable.treecutter)
        );
    }

    //This method populate the ListView for the Trees
    private void populateProductListView() {
        ArrayAdapter<Products> adapter2 = new MyListAdapter2();
        ListView list2 = findViewById(R.id.treesListView);
        list2.setAdapter(adapter2);
    }
    private void onClickCallProduct(){
        ListView list = findViewById(R.id.treesListView);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //PRODUCTS PRODUCTS

                //GETS THE POSITION OF THE CLICKED PRODUCT
                final Products clickedProduct = products.get(position);

                //GETTING THE VALUES OF THE PRODUCT THAT WAS CLICKED AND ASSIGNING THEM TO VARIABLES
                final String prodName = clickedProduct.getProductName();
                String prodDescription = clickedProduct.getDescription();
                final double prodPrice = clickedProduct.getPrice();
                int prodPic = clickedProduct.getProductPicture();
                double prodRating = clickedProduct.getRating();

                //WHEN AN ITEM IS CLICKED, WILL OPEN UP IN NEW WINDOW WITH JUST THATT ITEM IN A DIFFERENT VIEW
                setContentView(R.layout.view_selected_item);

                addToCart = findViewById(R.id.add_cart_button);

                addToCart.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        System.out.println("Test for Product button");
                        cartItem.setItemName(prodName);
                        cartItem.setItemPrice(prodPrice);

                        cartList = cart.getCart();
                        System.out.println("Product before add Cart Size : "+cartList.size());
                        cartList.add(cartItem);
                        System.out.println("Product after add Cart Size : "+cartList.size());
                        cart.setCart(cartList);


                        System.out.println(cartItem.getItemName());
                        System.out.println(cartItem.getItemPrice());
                    }
                });

                TextView labelChange = findViewById(R.id.labelHeight);
                labelChange.setText("Size : "+prodRating);

                TextView prodN = findViewById(R.id.itemName);
                prodN.setText(prodName);

                TextView prodDesc = findViewById(R.id.itemDescription);
                prodDesc.setText(prodDescription);

                ImageView prodPicture = findViewById(R.id.itemPic);
                prodPicture.setImageResource(prodPic);

                TextView prodPric = findViewById(R.id.itemPrice);
                prodPric.setText("$"+valueOf(prodPrice));
            }
        });
    }

    // PRODUCTS (shovel etc)
    private class MyListAdapter2 extends ArrayAdapter<Products> {
        public MyListAdapter2() {
            super(ProductsList.this, R.layout.item_list_format, products);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // make sure we have a view to work with
            View itemView = convertView;
            if(itemView == null) {
                itemView = getLayoutInflater().inflate(R.layout.item_list_format, parent, false);
            }

            // Find product
            Products currentProduct = products.get(position);

            // Picture of product:
            ImageView imageview = itemView.findViewById(R.id.itemPic1);
            imageview.setImageResource(currentProduct.getProductPicture());

            // Description of product:
            TextView description = itemView.findViewById(R.id.itemDescription1);
            description.setText(currentProduct.getDescription());

            // Name of product:
            TextView name = itemView.findViewById(R.id.itemName1);
            name.setText(currentProduct.getProductName());

            // Price of product:
            TextView price = itemView.findViewById(R.id.itemPrice1);
            price.setText("$..." + valueOf(currentProduct.getPrice()));

            return itemView;
        }
    }
}
