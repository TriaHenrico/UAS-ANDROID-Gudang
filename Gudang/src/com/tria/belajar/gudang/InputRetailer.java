package com.tria.belajar.gudang;

import databasehelper.DatabaseHelper;
import databasehelper.Retailer;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class InputRetailer extends Activity {
	EditText txtnamaretailer, txtalamatretailer, txtteleponretailer;
	DatabaseHelper dh;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_input_retailer);
		
		txtnamaretailer = (EditText)findViewById(R.id.txtnamaretailer);
		txtalamatretailer = (EditText)findViewById(R.id.txtalamatretailer);
		txtteleponretailer = (EditText)findViewById(R.id.txtteleponretailer);
		
		Button btn = (Button)findViewById(R.id.btnsimpan);
		btn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				String nama = txtnamaretailer.getText().toString();
				String alamat = txtalamatretailer.getText().toString();
				String telepon = txtteleponretailer.getText().toString();
				
				dh = new DatabaseHelper(getBaseContext());
				
				//ambil id barang selanjutnya
				int idRetailer = dh.getNextId("Retailer");
				
				Retailer r = new Retailer(idRetailer, nama, alamat, telepon);
				dh.tambahRetailer(r);
				
				finish();
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_input_retailer, menu);
		return true;
	}

}
