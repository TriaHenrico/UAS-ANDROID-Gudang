package com.tria.belajar.gudang;

import databasehelper.Retailer;
import adapter.BarangAdapter;
import adapter.RetailerAdapter;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class ListRetailer extends Activity {
	RetailerAdapter adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_retailer);
		
		final ListView listRetailer= (ListView)findViewById(R.id.ListRetailer);
		
		adapter = new RetailerAdapter(getBaseContext());
		listRetailer.setAdapter(adapter);
		listRetailer.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View clickView, int position,
					long id) {
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_list_retailer, menu);
		return true;
	}

}
