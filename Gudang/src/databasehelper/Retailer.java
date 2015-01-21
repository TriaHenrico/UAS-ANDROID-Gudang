package databasehelper;

public class Retailer {
	int id_retailer; 
	String nama_retailer, alamat_retailer, telepon_retailer;
	
	public Retailer(){}
	
	public Retailer(int id_retailer, String nama_retailer, String alamat_retailer, String telepon_retailer){
		this.id_retailer = id_retailer;
		this.nama_retailer = nama_retailer;
		this.alamat_retailer = alamat_retailer;
		this.telepon_retailer= telepon_retailer;
		
	}
	
	public Retailer(String nama_retailer, String alamat_retailer, String telepon_retailer){
		//this.id_retailer = id_retailer;
		this.nama_retailer = nama_retailer;
		this.alamat_retailer = alamat_retailer;
		this.telepon_retailer= telepon_retailer;
		
	}
	
	//setter
	public void setId(int id_retailer){
		this.id_retailer = id_retailer;
	}
	public void setNama(String nama_retailer){
		this.nama_retailer = nama_retailer;
	}
	public void setAlamat(String alamat_retailer){
		this.alamat_retailer = alamat_retailer;
	}
	public void setTelepon(String telepon_retailer){
		this.telepon_retailer = telepon_retailer;
	}
	
	
	//getter
	public int getId(){
		return this.id_retailer;
	}
	public String getNama(){
		return this.nama_retailer;	
	}
	public String getAlamat(){
		return this.alamat_retailer;
	}
	public String getTelepon(){
		return this.telepon_retailer;
	}
	
	
}
