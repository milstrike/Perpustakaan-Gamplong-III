/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib.pkg.perpustakaangamplong;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author milstrike
 */
public class mainFunction {
    
    
    
    public void storeUsernameAndPasswordForAuthentification(String username, String password){
        globalVariabel.usernameAuth = username;
        globalVariabel.passwordAuth = password;
    }
    
    
    public void SessionChooser(String Level){
        if(Level.equalsIgnoreCase("Administrator")){
            new Administrator().setVisible(true);
        }
        else if(Level.equalsIgnoreCase("Kepala Perpustakaan")){
            new KepalaPerpustakaan().setVisible(true);
        }
        else{
            new Operator().setVisible(true);
        }
    }
    
    public void storeKatalog(String ID, String Judul, String Pengarang, String Penerbit, String ISBN, String Stok, String LokasiRak){
        globalVariabel.IDKatalog = ID;
        globalVariabel.JudulKatalog = Judul;
        globalVariabel.PengarangKatalog = Pengarang;
        globalVariabel.PenerbitKatalog = Penerbit;
        globalVariabel.ISBNKatalog = ISBN;
        globalVariabel.StokKatalog = Stok;
        globalVariabel.LokasiRakKatalog = LokasiRak;
    }
    
    public void storeSelectedKatalog(String IDKatalog){
        globalVariabel.IDKatalog = IDKatalog;
    }
    
    public void storeSearchOption(String option){
        globalVariabel.searchOption = option;
    }
    
    public void storeSearchQuery(String query){
        globalVariabel.searchQuery = query;
    }
    
    public void storeKeanggotaan(String ID, String Nama, String Alamat, String Telepon, String Tanggal){
        globalVariabel.IDAnggota = ID;
        globalVariabel.NamaAnggota = Nama;
        globalVariabel.AlamatAnggota = Alamat;
        globalVariabel.TeleponAnggota = Telepon;
        globalVariabel.TanggalAnggota = Tanggal;
    }
    
    public void storeSelectedKeanggotaan(String ID){
        globalVariabel.IDAnggota = ID;
    }
    
    public void storeOperator(String ID, String Nama, String Username, String Password, String Level, String Status, String Telepon, String Alamat){
        globalVariabel.IDOperator = ID;
        globalVariabel.NamaOperator = Nama;
        globalVariabel.UsernameOperator = Username;
        globalVariabel.PasswordOperator = Password;
        globalVariabel.LevelOperator = Level;
        globalVariabel.StatusOperator = Status;
        globalVariabel.TeleponOperator = Telepon;
        globalVariabel.AlamatOperator = Alamat;
    }
    
    public void storeSelectedOperator(String ID){
        globalVariabel.IDOperator = ID;
    }
    
    public void storeSelectedJudulBuku(String ID, String Judul){
        globalVariabel.IDKatalogTambahJudul = ID;
        globalVariabel.IDKatalogJudulTambahJudul = Judul;
    }
    
    public void storeSelectedDaftarJudul(String ID){
        globalVariabel.IDKatalogDaftarJudul = ID;
    }
    
    public void storeIDUserSearch(String ID){
        globalVariabel.IDUserSearch = ID;
    }
    
    public void storePengaturanDenda(String Tarif, String Periode){
        globalVariabel.tarifDenda = Tarif;
        globalVariabel.periodeDenda = Periode;
    }
    
    public void storePengaturanJumlahJudulMaksimal(String Jumlah){
        globalVariabel.jumlahJudulMaksimal = Jumlah;
    }
    
    public void storePengaturanMasaSirkulasiMaksimal(String Masa){
        globalVariabel.masaSirkulasiMaksimal = Masa;
    }
    
    public void storeSirkulasi(String IDSirkulasi, String IDAnggota, String TanggalPinjam, String TanggalKembali){
        globalVariabel.IDSirkulasi = IDSirkulasi;
        globalVariabel.IDAnggotaSirkulasi = IDAnggota;
        globalVariabel.TanggalPinjam = TanggalPinjam;
        globalVariabel.TanggalKembali = TanggalKembali;
    }
    
    public void hitungTanggalPengembalian(){
        String TanggalPinjam = globalVariabel.TanggalPinjam;
        String TanggalKembali = globalVariabel.TanggalKembali;
        String TanggalSekarang = new GeneralConfiguration().getDate();
        
        SimpleDateFormat myFormat = new SimpleDateFormat("dd/MM/yyyy");
        String inputString1 = TanggalKembali;
        String inputString2 = TanggalSekarang;
        
        int day = 0;
        String days;

        try {
            Date date1 = myFormat.parse(inputString1);
            Date date2 = myFormat.parse(inputString2);
            long diff = date2.getTime() - date1.getTime();
            days = String.valueOf(TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));
            day = Integer.parseInt(days);
            } catch (ParseException e) {
            }
        
        if(day < 0){
            if(globalVariabel.jabatanUser.equalsIgnoreCase("Administrator")){
                Administrator.textStatusKeterlambatan.setText("Masih kurang " + (day*-1) + " hari");
                Administrator.textDenda.setText("0");
            }
            else{                
                Operator.textStatusKeterlambatan.setText("Masih kurang " + (day*-1) + " hari");
                Operator.textDenda.setText("0");
            }
            
        }
        else if(day == 0){
            if(globalVariabel.jabatanUser.equalsIgnoreCase("Administrator")){
                Administrator.textStatusKeterlambatan.setText("Tepat Waktu");
                Administrator.textDenda.setText("0");
            }
            else{                
                Operator.textStatusKeterlambatan.setText("Tepat Waktu");
                Operator.textDenda.setText("0");
            }            
        }
        else{
            hitungBiayaKeterlambatan(day);
            if(globalVariabel.jabatanUser.equalsIgnoreCase("Administrator")){
                Administrator.textStatusKeterlambatan.setText("Terlambat " + day + " hari");
                Administrator.textDenda.setText("Rp" + globalVariabel.BiayaKeterlambatan +",00");
            }
            else{                
                Operator.textStatusKeterlambatan.setText("Terlambat " + day + " hari");
                Operator.textDenda.setText("Rp" + globalVariabel.BiayaKeterlambatan +",00");
            }
        }
     }
    
    public void hitungBiayaKeterlambatan(int terlambat){
        double denda = Integer.parseInt(globalVariabel.tarifDenda);
        double periode = Integer.parseInt(globalVariabel.periodeDenda);
        double hari = terlambat;
        
        double dendaTotal = (hari/periode) * denda;
        int dendaTampil = (int) dendaTotal;
        globalVariabel.BiayaKeterlambatan = String.valueOf(dendaTampil);
    }
    
    public void storeLaporan(String jenis, String bulan, String tahun){
        globalVariabel.jenisLaporan = jenis;
        globalVariabel.periodeBulan = bulan;
        globalVariabel.periodeTahun = tahun;
        
        String prepareBulan = bulanConverter(globalVariabel.periodeBulan);
        String query = queryBuilder(prepareBulan, globalVariabel.periodeTahun);
        String query2 = queryBuilder2(prepareBulan, globalVariabel.periodeTahun);
        globalVariabel.queryBuilder = query;
        globalVariabel.queryBuilder2 = query2;
    }
    
    public String bulanConverter(String bulan){
        String bulanConvert = "";
        
            switch(bulan){
                case "Januari":
                    bulanConvert = "1";
                    break;
                case "Februari":
                    bulanConvert = "2";
                    break;
                case "Maret":
                    bulanConvert = "3";
                    break;
                case "April":
                    bulanConvert = "4";
                    break;
                case "Mei":
                    bulanConvert = "5";
                    break;
                case "Juni":
                    bulanConvert = "6";
                    break;
                case "Juli":
                    bulanConvert = "7";
                    break;
                case "Agustus":
                    bulanConvert = "8";
                    break;
                case "September":
                    bulanConvert = "9";
                    break;
                case "Oktober":
                    bulanConvert = "10";
                    break;
                case "November":
                    bulanConvert = "11";
                    break;
                case "Desember":
                    bulanConvert = "12";
                    break;
            }
        
        return bulanConvert;
    }
    
    public String queryBuilder(String BulanAngka, String TahunAngka){
        String query = "/"+BulanAngka+"/"+TahunAngka;
        return query;
    }
    
    public String queryBuilder2(String BulanAngka, String TahunAngka){
        String query = TahunAngka+"-"+BulanAngka+"-";
        return query;
    }
}
