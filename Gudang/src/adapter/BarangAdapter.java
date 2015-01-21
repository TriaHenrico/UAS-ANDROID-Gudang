package adapter;

import java.util.ArrayList;
import java.util.List;

import com.tria.belajar.gudang.R;

import databasehelper.Barang;
import databasehelper.DatabaseHelper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class BarangAdapter extends BaseAdapter{
	
	private static ArrayList<Barang> daftarBarang = new ArrayList<Barang>();
	private static int counter = 0;
	DatabaseHelper dbhelper;
	
	public BarangAdapter(Context c){
		refreshList(c);
	}
	
	private void refreshList(Context c) {
		// TODO Auto-generated method stub
		daftarBarang.clear();
		dbhelper = new DatabaseHelper(c);
		List<Barang> listBarang = dbhelper.getAllBarang();
		for(Barang barang : listBarang){
			daftarBarang.add(barang);
		}
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		// return 0;
		return daftarBarang.size();
	}

	@Override
	public Barang getItem(int index) {
		for(int i=0;i<daftarBarang.size();i++){
			if(i == index){
				return daftarBarang.get(i);
			}
		}
		//return new DiaryObject("","",new Date());
		return new Barang();
	}

	@Override
	public long getItemId(int index) {
		// TODO Auto-generated method stub
		return index;
	}

	@Override
	public View getView(int index, View view, ViewGroup parent) {
		// TODO Auto-generated method stub
		if(view == null){
			LayoutInflater inflater = LayoutInflater.from(parent.getContext());
			view = inflater.inflate(R.layout.listbarangcustom, parent, false);
		}
		
		Barang barang = daftarBarang.get(index);
		TextView txtNama = (TextView) view.findViewById(R.id.textNama);
		txtNama.setText(barang.getNama());
		TextView txtQty = (TextView) view.findViewById(R.id.textQty);
		txtQty.setText(String.valueOf(barang.getQuantiy()));
				
		return view;
	}
}
