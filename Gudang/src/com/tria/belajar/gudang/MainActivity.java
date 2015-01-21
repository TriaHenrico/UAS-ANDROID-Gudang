package com.tria.belajar.gudang;

import databasehelper.DatabaseHelper;
import databasehelper.User;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	EditText username, pass;
	DatabaseHelper dh;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        dh = new DatabaseHelper(this);
        
        //cek ketersediaan user
        int user = dh.cekUser();
        if(user == 0){  //user belum ada
        	dh.tambahUserDefault();
        }
        
        username = (EditText)findViewById(R.id.username);
        pass = (EditText)findViewById(R.id.pass);
        
        Button signin = (Button)findViewById(R.id.signin);
        signin.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				String u = username.getText().toString();
				String p = pass.getText().toString(); 
				
				User user = new User(u, p);
				if(dh.login(user)){
					//Toast.makeText(getBaseContext(), "login berhasil", Toast.LENGTH_SHORT).show();
					finish();
					Intent i = new Intent(MainActivity.this, Manipulasi.class);
					startActivity(i);
					
				}
				else{
					Toast.makeText(getBaseContext(), "login gagal", Toast.LENGTH_SHORT).show();
				}
			}
		});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
}
