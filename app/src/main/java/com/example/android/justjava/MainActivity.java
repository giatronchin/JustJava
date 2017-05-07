package com.example.android.justjava;
/**
 * Add your package below. Package name can be found in the project's AndroidManifest.xml file.
 * This is the package name our example uses:
 *
 * package com.example.android.justjava;
 */

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;



/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 2;       //tot quantity of coffees orderd


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {

        //Check if customer has added a Whipped Cream toping
        CheckBox whippedCreamCheckBox= (CheckBox) findViewById(R.id.checkbox_cream);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();

        //Check if customer has added a Chocolate toping
        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.checkbox_chocolate);
        boolean hasChocolate = chocolateCheckBox.isChecked();

        //Calculate total price for the submit order
        int totPrice = calculatePrice(hasWhippedCream, hasChocolate);

        //Get name that customer insert
        EditText nameField = (EditText) findViewById(R.id.textbox_name);
        String customer_name = nameField.getText().toString();

        String priceMessage = createOrderSummary(customer_name, totPrice, hasWhippedCream, hasChocolate);

        displayMessage(priceMessage);
    }
    /** Method that create a summary of the ordered
     * @param customer the name of customer who makes the order
     * @param hasCream store  eventual presence of whipped cream topping
     * @param hasChocolate store eventual presence of chocolate
     * @param price total price for the ordered stuff*/
    public String createOrderSummary (String customer, int price, boolean hasCream, boolean hasChocolate) {

        String message = "Customer Name: " + customer;
        message += "\nAdd whipped cream? " + hasCream;
        message += "\nAdd Chocolate? " + hasChocolate;
        message += "\nQuantity: " + quantity;
        message += "\nTotal: $" + price;
        message += "\nThank You!";

        return message;
    }
    /**
     * This method displays the given text on the screen.
     */
    public int calculatePrice(boolean addCream, boolean addChocolate) {
        int priceCupOfCoffe =  5;
        int totPrice = priceCupOfCoffe;

        if (addChocolate)
            totPrice += 2;

        if (addChocolate)
            totPrice += 1;

        return totPrice * quantity;
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }
    /**
     * This method increase the quantity ordered by 1
     */
    public void increment(View view) {

        Context context = getApplicationContext();
        CharSequence text = "E chi so Mandrake?!?";
        int duration = Toast.LENGTH_SHORT;

        if (quantity >= 10)
        {
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
            return;
        }
        else {
            quantity = quantity + 1;
        }

        display(quantity);
    }
    /**
     * This method decrease the quantity ordered by 1
     */
    public void decrement(View view) {
        Context context = getApplicationContext();
        CharSequence text = "Non fa er purciaro ordina qualcosa";
        int duration = Toast.LENGTH_SHORT;

        if (quantity <= 1) {
            Toast toast = Toast.makeText(context,text, duration);
            toast.show();
            return;
        }
        else {
            quantity = quantity - 1;
        }

        display(quantity);
    }
    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

}