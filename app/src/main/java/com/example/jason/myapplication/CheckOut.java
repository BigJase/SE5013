package com.example.jason.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.CompoundButton;

public class CheckOut extends AppCompatActivity { //implements CompoundButton.OnCheckedChangeListener

    private float total;
    private float discount;
    private float shippingFee;
    private float gst;
    private String deliveryAddress;

    RecyclerView checkOutRecycler;
    CheckBox deliveryCheckBox;
    EditText addressText;
    Button confirmbutton;
    TextView subTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_out);

        checkOutRecycler = findViewById(R.id.checkoutitems);
        subTotal =findViewById(R.id.total);
        deliveryCheckBox = findViewById(R.id.deliverycheckbutton);
        addressText = findViewById(R.id.deliveryaddresstext);
        addressText.setEnabled(false);
        confirmbutton = findViewById(R.id.confirmbutton);

        //ArrayList<Product> checkOut = new ArrayList<>();

        checkBoxListener();
        whenConfirmed();

        total= 1000;
        PrintTotal();
}


    public void checkBoxListener(){

        deliveryCheckBox.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener(){

            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){
                if (deliveryCheckBox.isChecked()){
                    Toast.makeText(CheckOut.this, "Delivery Checked", Toast.LENGTH_SHORT).show();
                    addressText.setEnabled(true);
                    isTeenTree();
                }
               else if(!deliveryCheckBox.isChecked()){
                    Toast.makeText(CheckOut.this, "Delivery Unchecked", Toast.LENGTH_SHORT).show();
                    addressText.setEnabled(false);
                    shippingFee = 0;
                }
            }


        });
    }

    public boolean isTeenTree(){ //Check order more than 10 tree
        //if (getArraySize() == 10)
        shippingFee = 99;
        return true;
    }

    public float calTotal(/*add product item*/){

        for(int i = 0 ; i  <10;  i++){
            //get array size
            //total =  total + getProduct
        }

        return total;
    }

    public void PrintTotal(){

        if(isTeenTree())
            shippingFee = 0;
             subTotal.setText("Total: " + calTotal() + "\n"
            + "Subtotal:  \n\n"
            + "Discount: \n\n"
            +"Shipping: \n");
    }

    public void whenConfirmed(){

        confirmbutton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                deliveryAddress = addressText.getText().toString();
                subTotal.append(deliveryAddress);
            }
        });

    }

    public String setAddressText(){

        return "nope";
    }

}
