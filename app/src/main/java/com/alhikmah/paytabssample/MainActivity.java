package com.alhikmah.paytabssample;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import paytabs.project.PayTabActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                openPaytabs();


            }
        });

        /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();*/

    }

    private void openPaytabs() {
        Intent in = new Intent(MainActivity. this, PayTabActivity. class);
        in.putExtra( "pt_merchant_email", "merchant@myapp.com");
        //this a demo account for testing the sdk
        in.putExtra( "pt_secret_key",
                "oIUhj8mssa9rTWRAqHg4P9ECOcfs35lsOgJ7p6ARgJjaFbK6S1aIbOlZ1As5GNxu4hCtnclEWEOCPzIIBSrMGMMImeN22kx6C9zZ" );
        //Add your Secret Key Here
        in.putExtra( "pt_transaction_title" , "Mr. John Doe");
        in.putExtra( "pt_amount", "1");
        in.putExtra( "pt_currency_code" , "USD"); //Use Standard 3 character ISO
        in.putExtra( "pt_shared_prefs_name" , "myapp_shared");
        in.putExtra( "pt_customer_email", "test@example.com" );
        in.putExtra( "pt_customer_phone_number" , "0097300001");
        in.putExtra( "pt_order_id", "1234567");
        in.putExtra( "pt_product_name", "Samsung Galaxy S6");
        in.putExtra( "pt_timeout_in_seconds", "300"); //Optional
        //Billing Address
        in.putExtra( "pt_address_billing" , "Flat 1,Building 123, Road 2345");
        in.putExtra( "pt_city_billing", "Juffair");
        in.putExtra( "pt_state_billing", "Manama");
        in.putExtra( "pt_country_billing" , "Bahrain");
        in.putExtra( "pt_postal_code_billing" , "00973");
        //Put Country Phone code if Postal  code not available '00973'
        //Shipping Address
        in.putExtra( "pt_address_shipping", "Flat 1,Building 123, Road 2345");
        in.putExtra( "pt_city_shipping" , "Juffair");
        in.putExtra( "pt_state_shipping", "Manama");
        in.putExtra( "pt_country_shipping", "Bahrain");
        in.putExtra( "pt_postal_code_shipping", "00973");
        //Put Country Phone code if Postal code not available '00973'
        int requestCode = 0;
        startActivityForResult(in, requestCode);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
