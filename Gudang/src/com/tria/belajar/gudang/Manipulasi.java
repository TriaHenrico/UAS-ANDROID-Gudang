package com.tria.belajar.gudang;

import android.os.Bundle;
import android.os.IInterface;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class Manipulasi extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_manipulasi);
		
		Button input = (Button)findViewById(R.id.input);
		input.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(Manipulasi.this, InputBarang.class);
				startActivity(intent);
			}
		});
		Button hapus = (Button)findViewById(R.id.hapus);
		hapus.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(Manipulasi.this, HapusBarang.class);
				startActivity(intent);
			}
		});
		
		Button btnretailer = (Button)findViewById(R.id.retailer);
		btnretailer.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(Manipulasi.this, InputRetailer.class);
				startActivity(intent);
			}
		});
		
		Button output = (Button)findViewById(R.id.output);
		output.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Manipulasi.this, OutputBarang.class);
				startActivity(intent);
			}
		});
		
		Button listbarang = (Button)findViewById(R.id.listbrg);
		listbarang.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Manipulasi.this, ListBarang.class);
				startActivity(intent);
			}
		});
		
		Button listretailer = (Button)findViewById(R.id.listrtl);
		listretailer.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Manipulasi.this, ListRetailer.class);
				startActivity(intent);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.act_manipulasi, menu);
		return true;
	}

}
