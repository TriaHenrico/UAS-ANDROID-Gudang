package databasehelper;

public class Barang {
	int id_barang, quantity, harga; 
	String nama_barang, jenis;
	
	public Barang(){}
	
	public Barang(int id, String nama, String jenis, int quantity, int harga){
		this.id_barang = id;
		this.nama_barang = nama;
		this.jenis = jenis;
		this.quantity = quantity;
		this.harga = harga;
	}
	
	public Barang(String nama, String jenis, int quantity, int harga){
		this.nama_barang = nama;
		this.jenis = jenis;
		this.quantity = quantity;
		this.harga = harga;
	}
	
	//setter
	public void setId(int id){
		this.id_barang = id;
	}
	public void setNama(String nama){
		this.nama_barang = nama;
	}
	public void setJenis(String jenis){
		this.jenis = jenis;
	}
	public void setQuantity(int qty){
		this.quantity = qty;
	}
	public void setHarga(int harga){
		this.harga = harga;
	}
	
	//getter
	public int getId(){
		return this.id_barang;
	}
	public String getNama(){
		return this.nama_barang;	
	}
	public String getJenis(){
		return this.jenis;
	}
	public int getQuantiy(){
		return this.quantity;
	}
	public int getHarga(){
		return this.harga;
	}
	
}
