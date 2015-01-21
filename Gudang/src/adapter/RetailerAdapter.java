package adapter;

import java.util.ArrayList;
import java.util.List;

import com.tria.belajar.gudang.R;

import databasehelper.DatabaseHelper;
import databasehelper.Retailer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class RetailerAdapter extends BaseAdapter{
	
	private static ArrayList<Retailer> daftarRetailer = new ArrayList<Retailer>();
	private static int counter = 0;
	DatabaseHelper dbhelper;
	
	public RetailerAdapter(Context c){
		refreshList(c);
	}
	
	private void refreshList(Context c) {
		// TODO Auto-generated method stub
		daftarRetailer.clear();
		dbhelper = new DatabaseHelper(c);
		List<Retailer> listRetailer = dbhelper.getAllRetailer();
		for(Retailer retailer : listRetailer){
			daftarRetailer.add(retailer);
		}
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		// return 0;
		return daftarRetailer.size();
	}

	@Override
	public Retailer getItem(int index) {
		for(int i=0;i<daftarRetailer.size();i++){
			if(i == index){
				return daftarRetailer.get(i);
			}
		}
		//return new DiaryObject("","",new Date());
		return new Retailer();
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
			view = inflater.inflate(R.layout.listretailercustom, parent, false);
		}
		
		Retailer retailer = daftarRetailer.get(index);
		TextView txtNama = (TextView) view.findViewById(R.id.textNama);
		txtNama.setText(retailer.getNama());
		TextView txtAlamat = (TextView) view.findViewById(R.id.textAlamat);
		txtAlamat.setText(String.valueOf(retailer.getAlamat()));
		TextView txtTelepon = (TextView) view.findViewById(R.id.textTelepon);
		txtTelepon.setText(String.valueOf(retailer.getTelepon()));
				
		return view;
	}
}
