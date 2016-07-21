package com.example.android.fivethings;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;



import java.text.NumberFormat;
/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends ActionBarActivity {
    int numberOfCoffees = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the plus button is clicked.
     */
    public void increment(View view) {
        numberOfCoffees = numberOfCoffees + 1 ;
        display(numberOfCoffees);
    }

    /**
     * This method is called when the minus button is clicked.
     */
    public void decrement(View view) {
        numberOfCoffees = numberOfCoffees - 1;
        display(numberOfCoffees);

    }

    /**
     * This method is called when the order button is clicked. test
     */
    public void submitOrder(View view) {
        EditText text = (EditText)findViewById(R.id.name_field);
        String name = text.getText().toString();
        Log.v("MainActivity", "Name: " + name);

        EditText texttext = (EditText)findViewById(R.id.menu_field);
        String menuname = texttext.getText().toString();
        Log.v("MainActivity", "Menu: " + menuname);

        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();
        Log.v("MainActivity", "Has whipped cream : " + hasWhippedCream);

        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        boolean hasChocolate = chocolateCheckBox.isChecked();
        Log.v("MainActivity", "Has chocolate : " + hasChocolate);

        int price = calculatePrice();
        String priceMessage = createOrderSummary(name, menuname, price, hasWhippedCream, hasChocolate);
        displayMessage(priceMessage);
    }

    private int calculatePrice() { return numberOfCoffees * 5;}

    private String createOrderSummary(String name, String menuname, int price, boolean addWhippedCream, boolean addChocolate){
        String priceMessage = "Name: " + name;
        priceMessage += "\nMenu: " + menuname;
        priceMessage += "\nAdd whipped cream? " + addWhippedCream;
        priceMessage += "\nAdd Chocolate drizzle? " + addChocolate;
        priceMessage += "\nQuantity: " + numberOfCoffees;
        priceMessage += "\nTotal: $ " + price;
        priceMessage += "\nThank you!";
        return priceMessage;
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }
    private void displayMessage(String number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(number);
    }
}