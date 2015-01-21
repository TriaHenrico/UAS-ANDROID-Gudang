package com.tria.belajar.gudang;

import databasehelper.DatabaseHelper;
import adapter.BarangAdapter;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class HapusBarang extends Activity {
	BarangAdapter barangAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_hapus_barang);
		
		final ListView listBarang = (ListView)findViewById(R.id.ListBarang);
		
		barangAdapter = new BarangAdapter(getBaseContext());
		listBarang.setAdapter(barangAdapter);
		listBarang.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View clickView, int position,
					long id) {
				int idBarang = barangAdapter.getItem(position).getId();
				DatabaseHelper dh = new DatabaseHelper(getBaseContext());
				boolean hasil = dh.hapusBarang(idBarang);
				
				if (hasil){
					Toast.makeText(getBaseContext(), "Okeh, dihapus..", Toast.LENGTH_SHORT).show();
					finish();
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_hapus_barang, menu);
		return true;
	}

}
