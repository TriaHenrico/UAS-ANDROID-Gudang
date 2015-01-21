package com.tria.belajar.gudang;

import adapter.BarangAdapter;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class ListBarang extends Activity {
	BarangAdapter barangAdapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_barang);
		
		final ListView listBarang = (ListView)findViewById(R.id.ListBarang);
		
		barangAdapter = new BarangAdapter(getBaseContext());
		listBarang.setAdapter(barangAdapter);
		listBarang.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View clickView, int position,
					long id) {
				int idBarang = barangAdapter.getItem(position).getId();
				Toast.makeText(getBaseContext(), String.valueOf(idBarang), Toast.LENGTH_SHORT).show();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_list_barang, menu);
		return true;
	}

}
