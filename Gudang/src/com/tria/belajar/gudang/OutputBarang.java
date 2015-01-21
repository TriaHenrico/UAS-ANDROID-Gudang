package com.tria.belajar.gudang;

import java.util.List;

import databasehelper.Barang;
import databasehelper.DatabaseHelper;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class OutputBarang extends Activity {
	DatabaseHelper dh;
	
	Button btnbrg;
	Spinner pilihbrg;
	EditText txtQty;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_output_barang);
		
		btnbrg = (Button)findViewById(R.id.btnbrg);
		pilihbrg = (Spinner)findViewById(R.id.pilihbrg);
		txtQty = (EditText)findViewById(R.id.txtQty);
		
		dh = new DatabaseHelper(this);
		
		loadbrg();
		
		btnbrg.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				try{
					String namaBrg = String.valueOf(pilihbrg.getSelectedItem());
					int Qty = Integer.parseInt(txtQty.getText().toString());
					
					int StokBrg = dh.cekStok(namaBrg);
					
					if(StokBrg>Qty){
						int newStok = StokBrg-Qty;
						int hasil = dh.OutputBarang(namaBrg, newStok);
						
						if(hasil==1){
							Toast.makeText(getBaseContext(), "Barang keluar", Toast.LENGTH_SHORT).show();
							finish();
						}
					}
					else{
						Toast.makeText(getBaseContext(), "Stok tidak cukup", Toast.LENGTH_SHORT).show();
					}
				}
				catch(NumberFormatException nfe){
					Toast.makeText(getBaseContext(), "Periksa kembali!", Toast.LENGTH_SHORT).show();
				}
			}
		});
		
		
	}

	public void loadbrg(){
		DatabaseHelper dh = new DatabaseHelper(getBaseContext());
		List<String> barangs = dh.getAllNamaBarang();
		
		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, barangs);
		pilihbrg.setAdapter(dataAdapter);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_output_barang, menu);
		return true;
	}

}
