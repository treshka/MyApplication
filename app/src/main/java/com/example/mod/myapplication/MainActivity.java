package com.example.mod.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button_call = (Button) findViewById(R.id.button_call);
        Button button_empty = (Button) findViewById(R.id.button_empty);
        Button button_sms = (Button) findViewById(R.id.button_sms);


    View.OnClickListener onClickListener = new View.OnClickListener() {


        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.button_empty:
                    Intent myIntent = new Intent(MainActivity.this,
                            SecondActivity.class);
                    startActivity(myIntent);
                    break;
                case R.id.button_call:
                    String phone = "";
                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
                    startActivity(intent);
                    break;
                case R.id.button_sms:
                    Intent smsIntent = new Intent(Intent.ACTION_VIEW);
                    smsIntent.setType("vnd.android-dir/mms-sms");
                    smsIntent.putExtra("sms_body", "TEXT SMS");
                    startActivity(smsIntent);
                    break;
            }
        }
    };

    button_empty.setOnClickListener(onClickListener);
    button_call.setOnClickListener(onClickListener);
    button_sms.setOnClickListener(onClickListener);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

   /* public boolean onCreateOptionsMenu(Menu menu) {
        // TODO Auto-generated method stub

        menu.add("settings");

        //return super.onCreateOptionsMenu(menu);
        return true;
    }*/

   /* @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO Auto-generated method stub
        Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }*/
}
