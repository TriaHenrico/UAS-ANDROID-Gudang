package com.tria.belajar.gudang;

import databasehelper.Barang;
import databasehelper.DatabaseHelper;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class InputBarang extends Activity {
	EditText harga;
	EditText quantity;
	EditText namaBrg;
	Spinner jenisBrg;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_input_barang);
		
		//ambil variabel textbox dari layout nya
		harga = (EditText)findViewById(R.id.harga);
		quantity = (EditText)findViewById(R.id.quantity);
		namaBrg = (EditText)findViewById(R.id.namaBrg);
		jenisBrg = (Spinner)findViewById(R.id.spinner1);
		
		Button masukkan = (Button)findViewById(R.id.masukkan);
		masukkan.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				try{
					int hrg = Integer.parseInt(harga.getText().toString());
					int qty = Integer.parseInt(quantity.getText().toString());
					String nama = namaBrg.getText().toString();
					String jenis = String.valueOf(jenisBrg.getSelectedItem());
					
					if(jenis == "-Pilih-"){
						//Toast
					}
					else{
						DatabaseHelper dh = new DatabaseHelper(getBaseContext());
						
						//ambil id barang selanjutnya
						int idBarang = dh.getNextId("Barang");
						
						//bikin objek barang sesuai data yang dimasukin
						Barang b = new Barang(idBarang, nama, jenis, qty, hrg);
						
						//masukin ke database
						dh.tambahBarang(b);
						
						finish();
					}
				}
				catch(NumberFormatException nfe){
					Toast.makeText(getBaseContext(), "Inputan qty dan harga harus berupa angka", Toast.LENGTH_SHORT).show();
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.act_input_barang, menu);
		return true;
	}

}
