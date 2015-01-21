package databasehelper;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper{
	// Logcat tag
    private static final String LOG = "DatabaseHelper";
 
    // Database Version
    private static final int DATABASE_VERSION = 1;
 
    // Database Name
    private static final String DATABASE_NAME = "GudangDB";
 
    // Table Names
    private static final String TABLE_USER = "User";
    private static final String TABLE_RETAILER = "Retailer";
    private static final String TABLE_BARANG = "Barang";
    private static final String TABLE_TRANSAKSI = "Transaksi";
 
    // Common column names
    private static final String KEY_ID = "id_tabel";
    //private static final String KEY_CREATED_AT = "created_at";
 
    // Tabel User - column names
    private static final String KEY_USERNAME = "username";
    private static final String KEY_PASSWORD = "password";
 
    // Tabel Retailer - column names
    private static final String KEY_NAMA_RETAILER = "nama_retailer";
    private static final String KEY_ALAMAT_RETAILER = "alamat";
    private static final String KEY_TELEPON_RETAILER = "telepon";
 
    // Tabel Barang - column names
    private static final String KEY_NAMA_BARANG = "nama_barang";
    private static final String KEY_JENIS_BARANG = "jenis";
    private static final String KEY_QUANTITY_BARANG = "quantity";
    private static final String KEY_HARGA_BARANG = "harga";
 
    // Tabel Transaksi - column names
    private static final String KEY_ID_BARANG = "id_barang";
    private static final String KEY_ID_RETAILER = "id_retailer";
    
    
    // Table Create Statements
    // Todo table create statement
    private static final String CREATE_TABLE_USER = "CREATE TABLE "
            + TABLE_USER + "(" + KEY_ID + "INTEGER PRIMARY KEY," + KEY_USERNAME
            + " TEXT, " + KEY_PASSWORD + " TEXT" + ")"; 
    
    private static final String CREATE_TABLE_RETAILER = "CREATE TABLE "
            + TABLE_RETAILER + "(id_retailer INTEGER," + KEY_NAMA_RETAILER
            + " TEXT, " + KEY_ALAMAT_RETAILER + " TEXT,"+ KEY_TELEPON_RETAILER + " TEXT" + ")";
    
    private static final String CREATE_TABLE_BARANG = "CREATE TABLE "
            + TABLE_BARANG + "(id_barang INTEGER," + KEY_NAMA_BARANG
            + " TEXT, " + KEY_JENIS_BARANG + " TEXT," + KEY_QUANTITY_BARANG + " INTEGER," + KEY_HARGA_BARANG 
            + " INTEGER " + ")";
    
    private static final String CREATE_TABLE_TRANSAKSI = "CREATE TABLE "
            + TABLE_TRANSAKSI + "(" + KEY_ID + "INTEGER PRIMARY KEY," + KEY_ID_BARANG
            + " INTEGER, " + KEY_QUANTITY_BARANG + " INTEGER,"+ KEY_ID_RETAILER + " INTEGER" + ")";
    
 
 
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
 
    @Override
    public void onCreate(SQLiteDatabase db) {
 
        // creating required tables
        db.execSQL(CREATE_TABLE_USER);
        db.execSQL(CREATE_TABLE_RETAILER);
        db.execSQL(CREATE_TABLE_BARANG);
        db.execSQL(CREATE_TABLE_TRANSAKSI);
    }
 
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // on upgrade drop older tables
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_RETAILER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_BARANG);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TRANSAKSI);
 
        // create new tables
        onCreate(db);
    }
    
    public boolean login(User u){
    	SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  COUNT(*) FROM " + TABLE_USER + " WHERE " + KEY_USERNAME + " = '" + u.getUsername()
        		+ "' AND " + KEY_PASSWORD + " = '" + u.getPassword()+"'";
        Cursor c = db.rawQuery(selectQuery, null);
     
        if (c != null){
            c.moveToFirst();
            if(c.getInt(0)>0){
            	return true;
            }
            return false;
        }
    	return false;
    }
    
    public int cekUser(){
    	String query = "SELECT COUNT(*) FROM " + TABLE_USER;
    	SQLiteDatabase db = this.getReadableDatabase();
    	
    	Cursor c = db.rawQuery(query, null);
        
        if (c != null){
            c.moveToFirst();
            int hasil = c.getInt(0);
            return hasil;
        }
        return 0;
    }
    
    public void tambahUserDefault(){
    	SQLiteDatabase db = this.getWritableDatabase();
    	 
        ContentValues values = new ContentValues();
        values.put(KEY_USERNAME, "koko");
        values.put(KEY_PASSWORD, "kokojuga");
 
        
        // Inserting Row
        db.insert(TABLE_USER, null, values);
        db.close(); // Closing database connection
    }
    
    //Tambah Barang Baru 
    public void tambahBarang(Barang b){
    	SQLiteDatabase db = this.getWritableDatabase();
    	 
        ContentValues values = new ContentValues();
        values.put("id_barang", b.getId());
        values.put(KEY_NAMA_BARANG, b.getNama());
        values.put(KEY_JENIS_BARANG, b.getJenis());
        values.put(KEY_QUANTITY_BARANG, b.getQuantiy());
        values.put(KEY_HARGA_BARANG, b.getHarga());
 
        
        // Inserting Row
        db.insert(TABLE_BARANG, null, values);
        db.close(); // Closing database connection
    }
    
    //hapus barang
    public boolean hapusBarang(int idBarang){
		SQLiteDatabase db = this.getWritableDatabase();
		return db.delete(TABLE_BARANG, "id_barang = " + idBarang, null) > 0;
	}
    
    //tambah retailer
    public void tambahRetailer(Retailer r){
    	SQLiteDatabase db = this.getWritableDatabase();
    	 
        ContentValues values = new ContentValues();
        values.put("id_retailer", r.getId());
        values.put(KEY_NAMA_RETAILER, r.getNama());
        values.put(KEY_ALAMAT_RETAILER, r.getAlamat());
        values.put(KEY_TELEPON_RETAILER, r.getTelepon());
        
 
        
        // Inserting Row
        db.insert(TABLE_RETAILER, null, values);
        db.close(); // Closing database connection
    }
    //buat pengganti auto increment nya
  	public int getNextId(String namatabel){
  		if(namatabel == "Barang"){
	  		String query = "SELECT COUNT(*) FROM "+TABLE_BARANG;
	  		SQLiteDatabase db = this.getWritableDatabase();
	  		Cursor c = db.rawQuery(query, null);
	  		
	  		if(c != null){
	  			c.moveToFirst();
	  		}
	  		int hasil = Integer.parseInt(c.getString(0))+1;
	  		return hasil;
  		}
  		if(namatabel == "Retailer"){
	  		String query = "SELECT COUNT(*) FROM "+TABLE_RETAILER;
	  		SQLiteDatabase db = this.getWritableDatabase();
	  		Cursor c = db.rawQuery(query, null);
	  		
	  		if(c != null){
	  			c.moveToFirst();
	  		}
	  		int hasil = Integer.parseInt(c.getString(0))+1;
	  		return hasil;
  		}
  		return 0;
  	}
    
    //tampilkan list barang
    public List<Barang> getAllBarang(){
    	List<Barang> barangList = new ArrayList<Barang>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_BARANG;
 
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
 
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Barang barang = new Barang();
                barang.setId(cursor.getInt(0));
                barang.setNama(cursor.getString(1));
                barang.setJenis(cursor.getString(2));
                barang.setQuantity(cursor.getInt(3));
                barang.setHarga(cursor.getInt(4));
                
                barangList.add(barang);
            } while (cursor.moveToNext());
        }
        // return contact list
        return barangList;
    }
    
    public List<String> getAllNamaBarang(){
    	List<String> barangList = new ArrayList<String>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_BARANG;
 
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
 
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                barangList.add(cursor.getString(1));
            } while (cursor.moveToNext());
        }
        // return contact list
        return barangList;
    }
    
    //tampilkan list retailer
    public List<Retailer> getAllRetailer(){
    	List<Retailer> retailerList = new ArrayList<Retailer>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_RETAILER;
 
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
 
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Retailer retailer = new Retailer();
                retailer.setId(cursor.getInt(0));
                retailer.setNama(cursor.getString(1));
                retailer.setAlamat(cursor.getString(2));
                retailer.setTelepon(cursor.getString(3));
                
                
                retailerList.add(retailer);
            } while (cursor.moveToNext());
        }
        // return contact list
        return retailerList;
    }
    
    // 
    
    public int OutputBarang(String namaBrg, int Stok){
    	SQLiteDatabase db = this.getWritableDatabase();
	   	 
        ContentValues values = new ContentValues();
        values.put(KEY_QUANTITY_BARANG, Stok);
        
        return db.update(TABLE_BARANG, values, KEY_NAMA_BARANG + " = '" + namaBrg + "'", null);
    }
    
    public int cekStok(String namaBrg){
    	//int stok = 0;
    	
    	// Select All Query
        String selectQuery = "SELECT " + KEY_QUANTITY_BARANG + " FROM " + TABLE_BARANG + " WHERE " + KEY_NAMA_BARANG + " = '"+ namaBrg +"'";
 
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
 
        // looping through all rows and adding to list
        if(cursor != null){
        	cursor.moveToFirst();
        }
        
        return cursor.getInt(0);
        //stok = cursor.getInt(0);
        //return stok;
    }
}
