/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib.pkg.perpustakaangamplong;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static org.apache.poi.hssf.usermodel.HeaderFooter.file;

/**
 *
 * @author milstrike
 */
public class dbAccess {
    
    private Connection internalconnect() {
        // SQLite connection string
        Path currentRelativePath = Paths.get("");
        String path = currentRelativePath.toAbsolutePath().toString();
        String url = "jdbc:sqlite:" + path + "\\db\\perpustakaan_lite.sqlite";
        System.out.println(url);
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
            System.out.println("Success");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    
    public int checkAuth(){
        String sql = "SELECT * FROM _user WHERE _username='"+globalVariabel.usernameAuth+"' AND _password='"+globalVariabel.passwordAuth+"'";
        int row = 0;
        try (Connection conn = this.internalconnect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            // loop through the result set
            while (rs.next()) {
                globalVariabel.idleUser = rs.getString("_profil_name");
                globalVariabel.jabatanUser = rs.getString("_level");
                globalVariabel.IDUser = rs.getString("_id_user");
                globalVariabel.ProfilName = rs.getString("_profil_name");
                globalVariabel.StatusUser = rs.getString("_status");
                globalVariabel.TeleponUser = rs.getString("_telepon");
                globalVariabel.AlamatUser = rs.getString("_alamat");
                row++;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return row;
    }
    
    public void showDataUser(){
        String sql = "SELECT * FROM _user";
        
        int row = 1;
        String id_user;
        String profil_user;
        String username;
        String level;
        String status;
        
        DefaultTableModel tabelUser = (DefaultTableModel) Administrator.tabelUser.getModel();
        
        int rowCount = tabelUser.getRowCount();
            //Remove rows one by one from the end of the table
        for (int i = rowCount - 1; i >= 0; i--) {
            tabelUser.removeRow(i);
        }
        
        try (Connection conn = this.internalconnect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            // loop through the result set
            while (rs.next()) {
                id_user = rs.getString("_id_user");
                profil_user = rs.getString("_profil_name");
                username = rs.getString("_username");
                level = rs.getString("_level");
                status = rs.getString("_status");
                tabelUser.addRow(new Object[]{row, id_user, profil_user, username, level, status});
                row++;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void createDataUser(){
        String ID = globalVariabel.IDOperator;
        String Nama = globalVariabel.NamaOperator;
        String Username = globalVariabel.UsernameOperator;
        String Password = globalVariabel.PasswordOperator;
        String Level = globalVariabel.LevelOperator;
        String Status = globalVariabel.StatusOperator;
        String Telepon = globalVariabel.TeleponOperator;
        String Alamat = globalVariabel.AlamatOperator;
        String SQL = "INSERT INTO _user (_id, _id_user, _profil_name, _username, _password, _level, _status, _telepon, _alamat) VALUES (NULL, '"+ID+"', '"+Nama+"', '"+Username+"', '"+Password+"', '"+Level+"', '"+Status+"', '"+Telepon+"', '"+Alamat+"')";
        
        try (Connection conn = this.internalconnect();
            PreparedStatement pstmt = conn.prepareStatement(SQL)){
            pstmt.executeUpdate();
         }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
            JOptionPane.showMessageDialog(null, "Data user baru berhasil ditambahkan!");
        showDataUser();   
    }
    
    public void selectDataUser(){
        String sql = "SELECT * FROM _user WHERE _id_user='" + globalVariabel.IDOperator + "'";

        try (Connection conn = this.internalconnect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            // loop through the result set
            while (rs.next()) {
                Administrator.editIDUser.setText(rs.getString("_id_user"));
                Administrator.editNamaUser.setText(rs.getString("_profil_name"));
                Administrator.editUsernama.setText(rs.getString("_username"));
                Administrator.editPassword.setText(rs.getString("_password"));
                Administrator.editLevelling.setSelectedItem(rs.getString("_level"));
                Administrator.editStatus.setSelectedItem(rs.getString("_status"));
                Administrator.editPhones.setText(rs.getString("_telepon"));
                Administrator.editAddress.setText(rs.getString("_alamat"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void updateDataUser(){
        String ID = globalVariabel.IDOperator;
        String Nama = globalVariabel.NamaOperator;
        String Username = globalVariabel.UsernameOperator;
        String Password = globalVariabel.PasswordOperator;
        String Level = globalVariabel.LevelOperator;
        String Status = globalVariabel.StatusOperator;
        String Telepon = globalVariabel.TeleponOperator;
        String Alamat = globalVariabel.AlamatOperator;
        
        String SQL = "UPDATE _user SET _profil_name='"+Nama+"', _username='"+Username+"', _password='"+Password+"', _level='"+Level+"', _status='"+Status+"', _telepon='"+Telepon+"', _alamat='"+Alamat+"' WHERE _id_user='"+ID+"'";
        
        try (Connection conn = this.internalconnect();
            PreparedStatement pstmt = conn.prepareStatement(SQL)){
            pstmt.executeUpdate();
         }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
     showDataUser();   
     JOptionPane.showMessageDialog(null, "Berhasil mengupdate data!");
    }
    
    public void deleteDataUser(){
        String ID = globalVariabel.IDOperator;
        String SQL = "DELETE FROM _user WHERE _id_user='"+ID+"'";
        try (Connection conn = this.internalconnect();
            PreparedStatement pstmt = conn.prepareStatement(SQL)){
            pstmt.executeUpdate();
         }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
     showDataUser();
     JOptionPane.showMessageDialog(null, "Berhasil menghapus data!");
    }
    
     public void showDataUserSearch(){
        String searchOption = globalVariabel.searchOption;
        String searchQuery = globalVariabel.searchQuery;
        String sql = "";
        
        switch(searchOption){
            case "ID User":
                sql = "SELECT * FROM _user WHERE _id_user LIKE '%"+searchQuery+"%' ORDER BY _id_user ASC";
                break;
            case "Nama Profil":
                sql = "SELECT * FROM _user WHERE _profil_name LIKE '%"+searchQuery+"%' ORDER BY _id_user ASC";
                break;
            case "Username":
                sql = "SELECT * FROM _user WHERE _username LIKE '%"+searchQuery+"%' ORDER BY _id_user ASC";
                break;
        }
        
        int row = 1;
        String id_user;
        String profil_user;
        String username;
        String level;
        String status;
        
        DefaultTableModel tabelUser = (DefaultTableModel) Administrator.tabelUser.getModel();
        
        int rowCount = tabelUser.getRowCount();
            //Remove rows one by one from the end of the table
        for (int i = rowCount - 1; i >= 0; i--) {
            tabelUser.removeRow(i);
        }
        
        try (Connection conn = this.internalconnect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            // loop through the result set
            while (rs.next()) {
                id_user = rs.getString("_id_user");
                profil_user = rs.getString("_profil_name");
                username = rs.getString("_username");
                level = rs.getString("_level");
                status = rs.getString("_status");
                tabelUser.addRow(new Object[]{row, id_user, profil_user, username, level, status});
                row++;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void showKatalogSearch(){
        String searchOption = globalVariabel.searchOption;
        String searchQuery = globalVariabel.searchQuery;
        String sql = "";
        
        switch(searchOption){
            case "ID Katalog":
                sql = "SELECT * FROM _katalog WHERE _id_katalog LIKE '%"+searchQuery+"%' ORDER BY _id_katalog ASC";
                break;
            case "Judul Buku":
                sql = "SELECT * FROM _katalog WHERE _judul LIKE '%"+searchQuery+"%' ORDER BY _id_katalog ASC";
                break;
            case "Pengarang":
                sql = "SELECT * FROM _katalog WHERE _pengarang LIKE '%"+searchQuery+"%' ORDER BY _id_katalog ASC";
                break;
            case "ISBN":
                sql = "SELECT * FROM _katalog WHERE _isbn LIKE '%"+searchQuery+"%' ORDER BY _id_katalog ASC";
                break;
        }
        
        int row = 1;
        String ID;
        String Judul;
        String Pengarang;
        String Penerbit;
        String ISBN;
        String Stok;
        String Rak;
        DefaultTableModel tabelKatalog;
        
        if(globalVariabel.jabatanUser.equalsIgnoreCase("Administrator")){
            tabelKatalog = (DefaultTableModel) Administrator.tabelKatalog.getModel();
        }
        else{
            tabelKatalog = (DefaultTableModel) Operator.tabelKatalog.getModel();
        }
        
        
        
        int rowCount = tabelKatalog.getRowCount();
            //Remove rows one by one from the end of the table
        for (int i = rowCount - 1; i >= 0; i--) {
            tabelKatalog.removeRow(i);
        }
        
        try (Connection conn = this.internalconnect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            // loop through the result set
            while (rs.next()) {
                ID = rs.getString("_id_katalog");
                Judul = rs.getString("_judul");
                Pengarang = rs.getString("_pengarang");
                Penerbit = rs.getString("_penerbit");
                ISBN = rs.getString("_isbn");
                Stok = rs.getString("_stok");
                Rak = rs.getString("_rak");
                tabelKatalog.addRow(new Object[]{row, ID, Judul, Pengarang, Penerbit, ISBN, Stok, Rak});
                row++;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
     
     public void showKatalog(){
        String sql = "SELECT * FROM _katalog ORDER BY _id_katalog ASC";
        int row = 1;
        String ID;
        String Judul;
        String Pengarang;
        String Penerbit;
        String ISBN;
        String Stok;
        String Rak;
        DefaultTableModel tabelKatalog;
        
        if(globalVariabel.jabatanUser.equalsIgnoreCase("Administrator")){
            tabelKatalog = (DefaultTableModel) Administrator.tabelKatalog.getModel();
        }
        else{
            tabelKatalog = (DefaultTableModel) Operator.tabelKatalog.getModel();
        }
        
        
        
        int rowCount = tabelKatalog.getRowCount();
            //Remove rows one by one from the end of the table
        for (int i = rowCount - 1; i >= 0; i--) {
            tabelKatalog.removeRow(i);
        }
        
        try (Connection conn = this.internalconnect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            // loop through the result set
            while (rs.next()) {
                ID = rs.getString("_id_katalog");
                Judul = rs.getString("_judul");
                Pengarang = rs.getString("_pengarang");
                Penerbit = rs.getString("_penerbit");
                ISBN = rs.getString("_isbn");
                Stok = rs.getString("_stok");
                Rak = rs.getString("_rak");
                tabelKatalog.addRow(new Object[]{row, ID, Judul, Pengarang, Penerbit, ISBN, Stok, Rak});
                row++;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void createKatalog(){
        String ID = globalVariabel.IDKatalog;
        String Judul = globalVariabel.JudulKatalog;
        String Pengarang = globalVariabel.PengarangKatalog;
        String Penerbit = globalVariabel.PenerbitKatalog;
        String ISBN = globalVariabel.ISBNKatalog;
        String Stok = globalVariabel.StokKatalog;
        String LokasiRak = globalVariabel.LokasiRakKatalog;
        String tanggal = new GeneralConfiguration().getDate();
        String SQL = "INSERT INTO _katalog (_id, _id_katalog, _judul, _pengarang, _penerbit, _isbn, _stok, _rak, _tanggal) VALUES (NULL, '"+ID+"', '"+Judul+"', '"+Pengarang+"', '"+Penerbit+"', '"+ISBN+"', '"+Stok+"', '"+LokasiRak+"', '"+tanggal+"')";
        
        try (Connection conn = this.internalconnect();
            PreparedStatement pstmt = conn.prepareStatement(SQL)){
            pstmt.executeUpdate();
         }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
            JOptionPane.showMessageDialog(null, "Data katalog baru berhasil ditambahkan!");
     showKatalog();   
    }
    
    public void selectKatalog(){
        String sql = "SELECT * FROM _katalog WHERE _id_katalog='" + globalVariabel.IDKatalog + "'";

        try (Connection conn = this.internalconnect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            // loop through the result set
            while (rs.next()) {
                if(globalVariabel.jabatanUser.equalsIgnoreCase("Administrator")){
                    Administrator.editIDKatalog.setText(rs.getString("_id_katalog"));
                    Administrator.editJudulKatalog.setText(rs.getString("_judul"));
                    Administrator.editPengarangKatalog.setText(rs.getString("_pengarang"));
                    Administrator.editPenerbitKatalog.setText(rs.getString("_penerbit"));
                    Administrator.editISBNKatalog.setText(rs.getString("_isbn"));
                    Administrator.editStokKatalog.setText(rs.getString("_stok"));
                    Administrator.editLokasiRakKatalog.setText(rs.getString("_rak"));
                }
                else{                
                    Operator.editIDKatalog.setText(rs.getString("_id_katalog"));
                    Operator.editJudulKatalog.setText(rs.getString("_judul"));
                    Operator.editPengarangKatalog.setText(rs.getString("_pengarang"));
                    Operator.editPenerbitKatalog.setText(rs.getString("_penerbit"));
                    Operator.editISBNKatalog.setText(rs.getString("_isbn"));
                    Operator.editStokKatalog.setText(rs.getString("_stok"));
                    Operator.editLokasiRakKatalog.setText(rs.getString("_rak"));
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void updateKatalog(){
        String ID = globalVariabel.IDKatalog;
        String Judul = globalVariabel.JudulKatalog;
        String Pengarang = globalVariabel.PengarangKatalog;
        String Penerbit = globalVariabel.PenerbitKatalog;
        String ISBN = globalVariabel.ISBNKatalog;
        String Stok = globalVariabel.StokKatalog;
        String LokasiRak = globalVariabel.LokasiRakKatalog;
        
        String SQL = "UPDATE _katalog SET _id_katalog='"+ID+"', _judul='"+Judul+"', _pengarang='"+Pengarang+"', _penerbit='"+Penerbit+"', _isbn='"+ISBN+"', _stok='"+Stok+"', _rak='"+LokasiRak+"' WHERE _id_katalog='"+ID+"'";
        
        try (Connection conn = this.internalconnect();
            PreparedStatement pstmt = conn.prepareStatement(SQL)){
            pstmt.executeUpdate();
         }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
     showKatalog();   
     JOptionPane.showMessageDialog(null, "Berhasil mengupdate data!");
    }
    
    public void deleteKatalog(){
        String ID = globalVariabel.IDKatalog;
        String SQL = "DELETE FROM _katalog WHERE _id_katalog='"+ID+"'";
        try (Connection conn = this.internalconnect();
            PreparedStatement pstmt = conn.prepareStatement(SQL)){
            pstmt.executeUpdate();
         }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
     showKatalog();
     JOptionPane.showMessageDialog(null, "Berhasil menghapus data!");
    }
    
    public void showKeanggotaanSearch(){
        String searchOption = globalVariabel.searchOption;
        String searchQuery = globalVariabel.searchQuery;
        String sql = "";
    
        switch(searchOption){
            case "ID Anggota":
                sql = "SELECT * FROM _anggota WHERE _id_anggota LIKE '%"+searchQuery+"%' ORDER BY _id_anggota ASC";
                break;
            case "Nama":
                sql = "SELECT * FROM _anggota WHERE _nama LIKE '%"+searchQuery+"%' ORDER BY _id_anggota ASC";
                break;
        }
        
        int row = 1;
        String ID;
        String Nama;
        DefaultTableModel tabelAnggota;
        
        if(globalVariabel.jabatanUser.equalsIgnoreCase("Administrator")){
            tabelAnggota = (DefaultTableModel) Administrator.tabelAnggota.getModel();
        }
        else{
            tabelAnggota = (DefaultTableModel) Operator.tabelAnggota.getModel();
        }
        
        
        
        int rowCount = tabelAnggota.getRowCount();
            //Remove rows one by one from the end of the table
        for (int i = rowCount - 1; i >= 0; i--) {
            tabelAnggota.removeRow(i);
        }
        
        try (Connection conn = this.internalconnect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            // loop through the result set
            while (rs.next()) {
                ID = rs.getString("_id_anggota");
                Nama = rs.getString("_nama");
                tabelAnggota.addRow(new Object[]{row, ID, Nama});
                row++;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void showKeanggotaan(){
        String sql = "SELECT * FROM _anggota ORDER BY _nama ASC";
        int row = 1;
        String ID;
        String Nama;
        DefaultTableModel tabelAnggota;
        
        if(globalVariabel.jabatanUser.equalsIgnoreCase("Administrator")){
            tabelAnggota = (DefaultTableModel) Administrator.tabelAnggota.getModel();
        }
        else{
            tabelAnggota = (DefaultTableModel) Operator.tabelAnggota.getModel();
        }
        
        
        
        int rowCount = tabelAnggota.getRowCount();
            //Remove rows one by one from the end of the table
        for (int i = rowCount - 1; i >= 0; i--) {
            tabelAnggota.removeRow(i);
        }
        
        try (Connection conn = this.internalconnect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            // loop through the result set
            while (rs.next()) {
                ID = rs.getString("_id_anggota");
                Nama = rs.getString("_nama");
                tabelAnggota.addRow(new Object[]{row, ID, Nama});
                row++;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void createKeanggotaan(){
        String ID = globalVariabel.IDAnggota;
        String Nama = globalVariabel.NamaAnggota;
        String Alamat = globalVariabel.AlamatAnggota;
        String Telepon = globalVariabel.TeleponAnggota;
        String Aktif = globalVariabel.TanggalAnggota;
        String SQL = "INSERT INTO _anggota (_id, _id_anggota, _nama, _alamat, _telepon, _aktif) VALUES (NULL, '"+ID+"', '"+Nama+"', '"+Alamat+"', '"+Telepon+"', '"+Aktif+"')";
        
        try (Connection conn = this.internalconnect();
            PreparedStatement pstmt = conn.prepareStatement(SQL)){
            pstmt.executeUpdate();
         }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
            JOptionPane.showMessageDialog(null, "Data anggota baru berhasil ditambahkan!");
     showKeanggotaan();   
    }
    
    public void selectKeanggotaan(){
        String sql = "SELECT * FROM _anggota WHERE _id_anggota='" + globalVariabel.IDAnggota + "'";

        try (Connection conn = this.internalconnect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            // loop through the result set
            while (rs.next()) {
                if(globalVariabel.jabatanUser.equalsIgnoreCase("Administrator")){
                    Administrator.editID.setText(rs.getString("_id_anggota"));
                    Administrator.editNama.setText(rs.getString("_nama"));
                    Administrator.editAlamat.setText(rs.getString("_alamat"));
                    Administrator.editTelepon.setText(rs.getString("_telepon"));
                    Administrator.editTanggal.setText(rs.getString("_aktif"));
                }
                else{                
                    Operator.editID.setText(rs.getString("_id_anggota"));
                    Operator.editNama.setText(rs.getString("_nama"));
                    Operator.editAlamat.setText(rs.getString("_alamat"));
                    Operator.editTelepon.setText(rs.getString("_telepon"));
                    Operator.editTanggal.setText(rs.getString("_aktif"));
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void updateKeanggotaan(){
        String ID = globalVariabel.IDAnggota;
        String Nama = globalVariabel.NamaAnggota;
        String Alamat = globalVariabel.AlamatAnggota;
        String Telepon = globalVariabel.TeleponAnggota;
        
        String SQL = "UPDATE _anggota SET _nama='"+Nama+"', _alamat='"+Alamat+"', _telepon='"+Telepon+"' WHERE _id_anggota='"+ID+"'";
        
        try (Connection conn = this.internalconnect();
            PreparedStatement pstmt = conn.prepareStatement(SQL)){
            pstmt.executeUpdate();
         }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
     showKeanggotaan();   
     JOptionPane.showMessageDialog(null, "Berhasil mengupdate data!");
    }
    
    public void deleteKeanggotaan(){
        String ID = globalVariabel.IDAnggota;
        String SQL = "DELETE FROM _anggota WHERE _id_anggota='"+ID+"'";
        try (Connection conn = this.internalconnect();
            PreparedStatement pstmt = conn.prepareStatement(SQL)){
            pstmt.executeUpdate();
         }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
     showKeanggotaan();
     JOptionPane.showMessageDialog(null, "Berhasil menghapus data!");
    }
    
    public void showKatalogTambahBuku(){
        String sql = "SELECT * FROM _katalog ORDER BY _id_katalog ASC";
        int row = 1;
        String ID;
        String Judul;
        String Pengarang;
        String Stok;
        
        DefaultTableModel tabelKatalog = (DefaultTableModel) tambahJudulBuku.tabelKatalog.getModel();
        
        int rowCount = tabelKatalog.getRowCount();
            //Remove rows one by one from the end of the table
        for (int i = rowCount - 1; i >= 0; i--) {
            tabelKatalog.removeRow(i);
        }
        
        try (Connection conn = this.internalconnect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            // loop through the result set
            while (rs.next()) {
                ID = rs.getString("_id_katalog");
                Judul = rs.getString("_judul");
                Pengarang = rs.getString("_pengarang");
                Stok = rs.getString("_stok");
                tabelKatalog.addRow(new Object[]{row, ID, Judul, Pengarang, Stok});
                row++;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void showKatalogSearchTambahJudulBuku(){
        String searchOption = globalVariabel.searchOption;
        String searchQuery = globalVariabel.searchQuery;
        String sql = "";

        switch(searchOption){
            case "ID Katalog":
                sql = "SELECT * FROM _katalog WHERE _id_katalog LIKE '%"+searchQuery+"%' ORDER BY _id_katalog ASC";
                break;
            case "Judul Buku":
                sql = "SELECT * FROM _katalog WHERE _judul LIKE '%"+searchQuery+"%' ORDER BY _id_katalog ASC";
                break;
        }
        
        int row = 1;
        String ID;
        String Judul;
        String Pengarang;
        String Stok;
        
        DefaultTableModel tabelKatalog = (DefaultTableModel) tambahJudulBuku.tabelKatalog.getModel();
        
        int rowCount = tabelKatalog.getRowCount();
            //Remove rows one by one from the end of the table
        for (int i = rowCount - 1; i >= 0; i--) {
            tabelKatalog.removeRow(i);
        }
        
        try (Connection conn = this.internalconnect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            // loop through the result set
            while (rs.next()) {
                ID = rs.getString("_id_katalog");
                Judul = rs.getString("_judul");
                Pengarang = rs.getString("_pengarang");
                Stok = rs.getString("_stok");
                tabelKatalog.addRow(new Object[]{row, ID, Judul, Pengarang, Stok});
                row++;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void showDaftarJudulBuku(){
        String sql = "SELECT * FROM _temp_judul ORDER BY _id ASC";
        int row = 1;
        String ID;
        String Judul;
        DefaultTableModel tabelKatalog;
        
        if(globalVariabel.jabatanUser.equalsIgnoreCase("Administrator")){
            tabelKatalog = (DefaultTableModel) Administrator.tabelJudulBuku.getModel();
        }
        else{
            tabelKatalog = (DefaultTableModel) Operator.tabelJudulBuku.getModel();
        }
        
        
        
        int rowCount = tabelKatalog.getRowCount();
            //Remove rows one by one from the end of the table
        for (int i = rowCount - 1; i >= 0; i--) {
            tabelKatalog.removeRow(i);
        }
        
        try (Connection conn = this.internalconnect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            // loop through the result set
            while (rs.next()) {
                ID = rs.getString("_id_katalog");
                Judul = rs.getString("_judul");
                tabelKatalog.addRow(new Object[]{row, ID, Judul});
                row++;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public int getTotalDaftarJudulBuku(){
        String sql = "SELECT * FROM _temp_judul ORDER BY _id ASC";
        int row = 0;
        
        try (Connection conn = this.internalconnect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            // loop through the result set
            while (rs.next()) {
                row++;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return row;
    }
    
    public void tambahJudulBuku(){
        String ID = globalVariabel.IDKatalogTambahJudul;
        String Judul = globalVariabel.IDKatalogJudulTambahJudul;
        String SQL = "INSERT INTO _temp_judul (_id, _id_katalog, _judul) VALUES (NULL, '"+ID+"', '"+Judul+"')";
        
        try (Connection conn = this.internalconnect();
            PreparedStatement pstmt = conn.prepareStatement(SQL)){
            pstmt.executeUpdate();
         }catch (SQLException e) {
            System.out.println(e.getMessage());
        }            
     showDaftarJudulBuku();   
    }
    
    public void deleteJudulBuku(){
        String ID = globalVariabel.IDKatalogDaftarJudul;
        String SQL = "DELETE FROM _temp_judul WHERE _id_katalog='"+ID+"'";
        try (Connection conn = this.internalconnect();
            PreparedStatement pstmt = conn.prepareStatement(SQL)){
            pstmt.executeUpdate();
         }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
     showDaftarJudulBuku();
    }
    
    public void searchIDAnggota(){
        String IDAnggota = globalVariabel.IDUserSearch;
        String sql = "SELECT * FROM _anggota WHERE _id_anggota='"+IDAnggota+"'";
        int row = 0;
        
        try (Connection conn = this.internalconnect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            // loop through the result set
            while (rs.next()) {
                Administrator.inputNamaAngfota.setText(rs.getString("_nama"));
                row++;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        if(row < 1){
            JOptionPane.showMessageDialog(null, "ID Anggota Tidak Ditemukan!");
        }
    }
    
    public void showPengaturanDenda(){
        String sql = "SELECT * FROM _pengaturan WHERE _id='1'";
        try (Connection conn = this.internalconnect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            while (rs.next()) {
                if(globalVariabel.jabatanUser.equalsIgnoreCase("Administrator")){
                    Administrator.inputTarifDenda.setText(rs.getString("_value"));
                    Administrator.inputPeriodeDenda.setText(rs.getString("_extension"));
                    globalVariabel.tarifDenda = rs.getString("_value");
                    globalVariabel.periodeDenda = rs.getString("_extension");
                }
                else{                
                    globalVariabel.tarifDenda = rs.getString("_value");
                    globalVariabel.periodeDenda = rs.getString("_extension");
                }
                
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void showPengaturanSirkulasi(){
        String sql = "SELECT * FROM _pengaturan WHERE _id='3'";
        try (Connection conn = this.internalconnect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            while (rs.next()) {
                Administrator.inputMaksSirkulasi.setText(rs.getString("_value"));
                globalVariabel.masaSirkulasiMaksimal = rs.getString("_value");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void showPengaturanJudulBuku(){
        String sql = "SELECT * FROM _pengaturan WHERE _id='2'";
        try (Connection conn = this.internalconnect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            while (rs.next()) {
                Administrator.inputJudulMaksimal.setText(rs.getString("_value"));
                globalVariabel.jumlahJudulMaksimal = rs.getString("_value");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void updatePengaturanDenda(){
        String TarifDenda = globalVariabel.tarifDenda;
        String PeriodeDenda = globalVariabel.periodeDenda;
        
        String SQL = "UPDATE _pengaturan SET _value='"+TarifDenda+"', _extension='"+PeriodeDenda+"' WHERE _id='1'";
        
        try (Connection conn = this.internalconnect();
            PreparedStatement pstmt = conn.prepareStatement(SQL)){
            pstmt.executeUpdate();
         }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
     showPengaturanDenda(); 
     JOptionPane.showMessageDialog(null, "Pengaturan Denda Tersimpan!");
    }
    
    public void updatePengaturanJudulMaksimal(){
        String JudulMaksimal = globalVariabel.jumlahJudulMaksimal;
        
        String SQL = "UPDATE _pengaturan SET _value='"+JudulMaksimal+"' WHERE _id='2'";
        
        try (Connection conn = this.internalconnect();
            PreparedStatement pstmt = conn.prepareStatement(SQL)){
            pstmt.executeUpdate();
         }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
     showPengaturanJudulBuku();
     JOptionPane.showMessageDialog(null, "Pengaturan Jumlah Judul Maksimal Tersimpan!");
    }
    
    public void updatePengaturanSirkulasiMaksimal(){
        String SirkulasiMaksimal = globalVariabel.masaSirkulasiMaksimal;
        
        String SQL = "UPDATE _pengaturan SET _value='"+SirkulasiMaksimal+"' WHERE _id='3'";
        
        try (Connection conn = this.internalconnect();
            PreparedStatement pstmt = conn.prepareStatement(SQL)){
            pstmt.executeUpdate();
         }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
     showPengaturanSirkulasi();
     JOptionPane.showMessageDialog(null, "Pengaturan Masa Sirkulasi Maksimal Tersimpan!");
    }
    
    public void DaftarJudulBukuMover(){
        String sql = "SELECT * FROM _temp_judul ORDER BY _id ASC";
        String ID;
        
        try (Connection conn = this.internalconnect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            // loop through the result set
            while (rs.next()) {
                createDetailSirkulasi(rs.getString("_id_katalog"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        clearJudulBuku();
    }
    
    public void createDetailSirkulasi(String IDKatalog){
        String IDSirkulasi = globalVariabel.IDSirkulasi;
        String SQL2 = "INSERT INTO _detail_sirkulasi (_id, _id_sirkulasi, _id_katalog) VALUES (NULL, '"+IDSirkulasi+"', '"+IDKatalog+"')";
        try (Connection conn2 = this.internalconnect();
            PreparedStatement pstmt2 = conn2.prepareStatement(SQL2)){
            pstmt2.executeUpdate();
         }catch (SQLException e) {
            System.out.println(e.getMessage());
        }            
    }
    
        
    public void deleteSirkulasi(){
        String SQL3 = "DELETE FROM _sirkulasi WHERE _id_sirkulasi='"+globalVariabel.IDSirkulasi+"'";
        try (Connection conn3 = this.internalconnect();
            PreparedStatement pstmt3 = conn3.prepareStatement(SQL3)){
            pstmt3.executeUpdate();
         }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
     showDaftarSirkulasi();
    }
    
    
    public void clearJudulBuku(){
        String SQL3 = "DELETE FROM _temp_judul";
        try (Connection conn3 = this.internalconnect();
            PreparedStatement pstmt3 = conn3.prepareStatement(SQL3)){
            pstmt3.executeUpdate();
         }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
     showDaftarJudulBuku();
    }
    
    public int getTotalJudulBuku(String IDSirkulasi){
        String sql = "SELECT * FROM _detail_sirkulasi WHERE _id_sirkulasi='"+IDSirkulasi+"'";
        int row = 0;
        
        try (Connection conn = this.internalconnect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            // loop through the result set
            while (rs.next()) {
                row++;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return row;
    }
    
    public void createDataSirkulasi(){
        String IDSirkulasi = globalVariabel.IDSirkulasi;
        String IDAnggota = globalVariabel.IDAnggotaSirkulasi;
        String TanggalPinjam = globalVariabel.TanggalPinjam;
        String TanggalKembali = globalVariabel.TanggalKembali;
        String Status = "Dalam Peminjaman";
        String Denda = "0";
        String RealKembali = "-";
        String SQL2 = "INSERT INTO _sirkulasi (_id, _id_sirkulasi, _id_anggota, _tanggal_pinjam, _tanggal_kembali, _status, _denda, _change_time, _real_kembali) VALUES (NULL, '"+IDSirkulasi+"', '"+IDAnggota+"', '"+TanggalPinjam+"', '"+TanggalKembali+"', '"+Status+"', '"+Denda+"', CURRENT_TIMESTAMP, '"+RealKembali+"')";
        try (Connection conn2 = this.internalconnect();
            PreparedStatement pstmt2 = conn2.prepareStatement(SQL2)){
            pstmt2.executeUpdate();
         }catch (SQLException e) {
            System.out.println(e.getMessage());
        }    
        JOptionPane.showMessageDialog(null, "Sirkulasi Baru Tersimpan!");
        showDaftarSirkulasi();
    }
    
    public void showDaftarSirkulasi(){
        String sql = "SELECT * FROM _sirkulasi";
        int row = 1;
        String ID;
        String IDAnggota;
        String Nama;
        String TotalJudul;
        String TanggalPinjam;
        String TanggalKembali;
        String Status;
        DefaultTableModel tabelSirkulasi;
        
        if(globalVariabel.jabatanUser.equalsIgnoreCase("Administrator")){
            tabelSirkulasi = (DefaultTableModel) Administrator.tabelSirkulasi.getModel();
        }
        else{
            tabelSirkulasi = (DefaultTableModel) Operator.tabelSirkulasi.getModel();
        }
        
        
        int rowCount = tabelSirkulasi.getRowCount();
            //Remove rows one by one from the end of the table
        for (int i = rowCount - 1; i >= 0; i--) {
            tabelSirkulasi.removeRow(i);
        }
        
        try (Connection conn = this.internalconnect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            // loop through the result set
            while (rs.next()) {
                ID = rs.getString("_id_sirkulasi");
                IDAnggota = rs.getString("_id_anggota");
                Nama = getNamaAnggota(IDAnggota);
                TotalJudul = String.valueOf(getTotalJudulBuku(ID));
                TanggalPinjam = rs.getString("_tanggal_pinjam");
                TanggalKembali = rs.getString("_tanggal_kembali");
                Status = rs.getString("_status");
                tabelSirkulasi.addRow(new Object[]{row, ID, IDAnggota, Nama, TotalJudul, TanggalPinjam, TanggalKembali, Status});
                row++;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public String getNamaAnggota(String IDAnggota){
        String Nama = "";
        String sql = "SELECT * FROM _anggota WHERE _id_anggota='"+IDAnggota+"'";
        try (Connection conn = this.internalconnect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            while (rs.next()) {
                Nama = rs.getString("_nama");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return Nama;
    }
    
    public String getJudulBuku(String IDKatalog){
        String Nama = "";
        String sql3 = "SELECT * FROM _katalog WHERE _id_katalog='"+IDKatalog+"'";
        try (Connection conn3 = this.internalconnect();
             Statement stmt3  = conn3.createStatement();
             ResultSet rs3    = stmt3.executeQuery(sql3)){
            
            while (rs3.next()) {
                Nama = rs3.getString("_judul");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return Nama;
    }
    
    public void selectDataSirkulasi(){
        String sql = "SELECT * FROM _sirkulasi WHERE _id_sirkulasi='" + globalVariabel.IDSirkulasi + "'";

        try (Connection conn = this.internalconnect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            // loop through the result set
            while (rs.next()) {
                if(globalVariabel.jabatanUser.equalsIgnoreCase("Administrator")){
                    Administrator.inputIDAnggota.setText(rs.getString("_id_anggota"));
                    Administrator.inputNamaAngfota.setText(getNamaAnggota(rs.getString("_id_anggota")));
                    Administrator.inputTanggalPinjam.setText(rs.getString("_tanggal_pinjam"));
                    Administrator.inputTanggalKembali.setText(rs.getString("_tanggal_kembali"));
                    Administrator.textStatusKeterlambatan.setText(rs.getString("_status"));
                }
                else{
                    Operator.inputIDAnggota.setText(rs.getString("_id_anggota"));
                    Operator.inputNamaAngfota.setText(getNamaAnggota(rs.getString("_id_anggota")));
                    Operator.inputTanggalPinjam.setText(rs.getString("_tanggal_pinjam"));
                    Operator.inputTanggalKembali.setText(rs.getString("_tanggal_kembali"));
                    Operator.textStatusKeterlambatan.setText(rs.getString("_status"));
                }
                
                showDaftarJudulBukuSelected(rs.getString("_id_sirkulasi"));
                globalVariabel.TanggalPinjam = rs.getString("_tanggal_pinjam");
                globalVariabel.TanggalKembali = rs.getString("_tanggal_kembali");
                String status = rs.getString("_status");
                if(status.equalsIgnoreCase("Sudah Kembali")){
                    if(globalVariabel.jabatanUser.equalsIgnoreCase("Administrator")){
                        Administrator.checkBebasDenda.setEnabled(false);
                    }
                    else{                
                        Operator.checkBebasDenda.setEnabled(false);
                    }
                    
                }
                else{
                    if(globalVariabel.jabatanUser.equalsIgnoreCase("Administrator")){
                        Administrator.checkBebasDenda.setEnabled(true);
                    }
                    else{                
                        Operator.checkBebasDenda.setEnabled(true);
                    }
                    
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void showDaftarJudulBukuSelected(String IDSirkulasi){
        String sql2 = "SELECT * FROM _detail_sirkulasi WHERE _id_sirkulasi='"+IDSirkulasi+"'";
        int row = 1;
        String ID;
        String Judul;
        DefaultTableModel tabelJudulBuku;
        
        if(globalVariabel.jabatanUser.equalsIgnoreCase("Administrator")){
            tabelJudulBuku = (DefaultTableModel) Administrator.tabelJudulBuku.getModel();
        }
        else{
            tabelJudulBuku = (DefaultTableModel) Operator.tabelJudulBuku.getModel();
        }
        
        
        
        int rowCount = tabelJudulBuku.getRowCount();
            //Remove rows one by one from the end of the table
        for (int i = rowCount - 1; i >= 0; i--) {
            tabelJudulBuku.removeRow(i);
        }
        
        try (Connection conn2 = this.internalconnect();
             Statement stmt2  = conn2.createStatement();
             ResultSet rs2    = stmt2.executeQuery(sql2)){
            
            // loop through the result set
            while (rs2.next()) {
                ID = rs2.getString("_id_katalog");
                Judul = getJudulBuku(ID);
                tabelJudulBuku.addRow(new Object[]{row, ID, Judul});
                row++;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void createLaporanDenda(){
        String IDSirkulasi = globalVariabel.IDSirkulasi;
        String denda = globalVariabel.BiayaKeterlambatan;
        String SQL2 = "INSERT INTO _laporan_denda (_id, _id_sirkulasi, _denda, _tanggal) VALUES (NULL, '"+IDSirkulasi+"', '"+denda+"', CURRENT_TIMESTAMP)";
        try (Connection conn2 = this.internalconnect();
            PreparedStatement pstmt2 = conn2.prepareStatement(SQL2)){
            pstmt2.executeUpdate();
         }catch (SQLException e) {
            System.out.println(e.getMessage());
        }            
    }
    
    public void updateSirkulasi(){
        String IDSirkulasi = globalVariabel.IDSirkulasi;
        String RealKembali = new GeneralConfiguration().getDate();
        String Status = "Sudah Kembali";
        String Denda = globalVariabel.BiayaKeterlambatan;
        
        String SQL = "UPDATE _sirkulasi SET _status='"+Status+"', _denda='"+Denda+"', _change_time=CURRENT_TIMESTAMP, _real_kembali='"+RealKembali+"' WHERE _id_sirkulasi='"+IDSirkulasi+"'";
        
        try (Connection conn = this.internalconnect();
            PreparedStatement pstmt = conn.prepareStatement(SQL)){
            pstmt.executeUpdate();
         }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
     showDaftarSirkulasi();   
     JOptionPane.showMessageDialog(null, "Berhasil mengupdate data sirkulasi!");
    }
    
    public void showSirkulasiSearch(){
        String searchOption = globalVariabel.searchOption;
        String searchQuery = globalVariabel.searchQuery;
        String sql = "";
    
        switch(searchOption){
            case "ID Anggota":
                sql = "SELECT * FROM _sirkulasi WHERE _id_anggota LIKE '%"+searchQuery+"%' ORDER BY _tanggal_pinjam ASC";
                break;
            case "Tanggal Pinjam":
                sql = "SELECT * FROM _sirkulasi WHERE _tanggal_pinjam LIKE '%"+searchQuery+"%' ORDER BY _tanggal_pinjam ASC";
                break;
        }
        
        int row = 1;
        String ID;
        String IDAnggota;
        String Nama;
        String TotalJudul;
        String TanggalPinjam;
        String TanggalKembali;
        String Status;
        DefaultTableModel tabelSirkulasi;
        
        if(globalVariabel.jabatanUser.equalsIgnoreCase("Administrator")){
            tabelSirkulasi = (DefaultTableModel) Administrator.tabelSirkulasi.getModel();
        }
        else{
            tabelSirkulasi = (DefaultTableModel) Operator.tabelSirkulasi.getModel();
        }
        
        
        
        int rowCount = tabelSirkulasi.getRowCount();
            //Remove rows one by one from the end of the table
        for (int i = rowCount - 1; i >= 0; i--) {
            tabelSirkulasi.removeRow(i);
        }
        
        try (Connection conn = this.internalconnect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            // loop through the result set
            while (rs.next()) {
                ID = rs.getString("_id_sirkulasi");
                IDAnggota = rs.getString("_id_anggota");
                Nama = getNamaAnggota(IDAnggota);
                TotalJudul = String.valueOf(getTotalJudulBuku(ID));
                TanggalPinjam = rs.getString("_tanggal_pinjam");
                TanggalKembali = rs.getString("_tanggal_kembali");
                Status = rs.getString("_status");
                tabelSirkulasi.addRow(new Object[]{row, ID, IDAnggota, Nama, TotalJudul, TanggalPinjam, TanggalKembali, Status});
                row++;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void showLaporanManajemen(){
        String sql;
        String queryBuilder = globalVariabel.queryBuilder;
        String queryBuilder2 = globalVariabel.queryBuilder2;
        
        String jenisLaporan = globalVariabel.jenisLaporan.toUpperCase();
        
        String headerComponent = "<html><head><title>Laporan "+globalVariabel.jenisLaporan+" Perpustakaan Taman Bacaan Mentari Gamplong III Periode Bulan: "+globalVariabel.periodeBulan+" Tahun: "+globalVariabel.periodeTahun+"</title></head><body><p align: center><strong>LAPORAN "+jenisLaporan+" PERPUSTAKAAN TAMAN BACAAN MENTARI GAMPLONG III</strong></p><p align: center><strong>Periode "+globalVariabel.periodeBulan+" "+globalVariabel.periodeTahun+"</strong></p><p align: justify><table border=1 width=100%>";
        String theadComponent;
        String tbodyComponent = "";
        String footerComponent = "</tbody></table></p><p align=justify>Dicetak tanggal: "+new GeneralConfiguration().getTime()+"</p></body></html>";
        
        int row = 1;
        
        if(globalVariabel.jenisLaporan.equalsIgnoreCase("Katalog")){
            sql = "SELECT * FROM _katalog WHERE _tanggal LIKE '%"+queryBuilder+"%' ORDER BY _id ASC";
            theadComponent = "<thead><tr><th>No</th><th>ID Katalog</th><th>Judul</th><th>Pengarang</th><th>Penerbit</th><th>ISBN</th><th>Stok</th><th>Nomor Rak</th><th>Reg. Tanggal</th></tr></thead><tbody>";
        }
        else if(globalVariabel.jenisLaporan.equalsIgnoreCase("Sirkulasi (Peminjaman/Pengembalian)")){
            sql = "SELECT * FROM _sirkulasi WHERE _change_time LIKE '%"+queryBuilder2+"%' ORDER BY _id ASC";
            theadComponent = "<thead><tr><th>No</th><th>ID Sirkulasi</th><th>ID Anggota</th><th>Tanggal Pinjam</th><th>Tanggal Kembali</th><th>Status</th><th>Denda</th><th>Tanggal Pengembalian</th></tr></thead><tbody>";
        }
        else{
            sql = "SELECT * FROM _laporan_denda WHERE _tanggal LIKE '%"+queryBuilder2+"%' ORDER BY _id ASC";
            theadComponent = "<thead><tr><th width=5%>No</th><th width=10%>ID Sirkulasi</th><th width=35%>Denda</th><th width=50%>Tanggal Masuk</th></tr></thead><tbody>";
        }
        //rs.getString("_value")
        
        try (Connection conn = this.internalconnect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            while (rs.next()) {
                if(globalVariabel.jenisLaporan.equalsIgnoreCase("Katalog")){
                    tbodyComponent = tbodyComponent + "<tr><td style='text-align:right'>"+row+"</td><td style='text-align:center'>"+rs.getString("_id_katalog")+"</td><td>"+rs.getString("_judul")+"</td><td>"+rs.getString("_pengarang")+"</td><td >"+rs.getString("_penerbit")+"</td><td style='text-align:right'>"+rs.getString("_isbn")+"</td><td style='text-align:right'>"+rs.getString("_stok")+"</td><td>"+rs.getString("_rak")+"</td><td style='text-align:right'>"+rs.getString("_tanggal")+"</td></tr>";
                }
                else if(globalVariabel.jenisLaporan.equalsIgnoreCase("Sirkulasi (Peminjaman/Pengembalian)")){
                    tbodyComponent = tbodyComponent + "<tr><td style='text-align:right'>"+row+"</td><td style='text-align:center'>"+rs.getString("_id_sirkulasi")+"</td><td style='text-align:center'>"+rs.getString("_id_anggota")+"</td><td style='text-align:right'>"+rs.getString("_tanggal_pinjam")+"</td><td style='text-align:right'>"+rs.getString("_tanggal_kembali")+"</td><td>"+rs.getString("_status")+"</td><td style='text-align:right;'>"+rs.getString("_denda")+"</td><td style='text-align:right'>"+rs.getString("_real_kembali")+"</td></tr>";
                }
                else{
                    tbodyComponent = tbodyComponent + "<tr><td style='text-align:right'>"+row+"</td><td style='text-align:center'>"+rs.getString("_id_sirkulasi")+"</td><td style='text-align:right;'>"+rs.getString("_denda")+"</td><td style='text-align:center'>"+rs.getString("_tanggal")+"</td></tr>";
                }
                row++;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        globalVariabel.resultLaporan = headerComponent + theadComponent + tbodyComponent + footerComponent;
    }
    
    public void exportLaporanManajemen() throws Exception{
        final int DEFAULT_BUFFER_SIZE = 100000; 
        
        String sql;
        String queryBuilder = globalVariabel.queryBuilder;
        String queryBuilder2 = globalVariabel.queryBuilder2;
        
        if(globalVariabel.jenisLaporan.equalsIgnoreCase("Katalog")){
            sql = "SELECT _id_katalog AS IDKatalog, _judul AS Judul, _pengarang AS Pengarang, _penerbit AS Penerbit, _isbn AS ISBN, _stok AS Stok, _rak AS Lokasi, _tanggal AS REGTanggal FROM _katalog WHERE _tanggal LIKE '%"+queryBuilder+"%' ORDER BY _id ASC";
        }
        else if(globalVariabel.jenisLaporan.equalsIgnoreCase("Sirkulasi (Peminjaman/Pengembalian)")){
            sql = "SELECT _id_sirkulasi AS IDSirkulasi, _id_anggota AS IDAnggota, _tanggal_pinjam AS Peminjaman, _tanggal_kembali AS Pengembalian, _status AS Status, _denda AS Denda, _real_kembali AS Penerimaan FROM _sirkulasi WHERE _change_time LIKE '%"+queryBuilder2+"%' ORDER BY _id ASC";    
        }
        else{
            sql = "SELECT _id_sirkulasi AS IDSirkulasi, _denda AS Denda, _tanggal AS Masuk FROM _laporan_denda WHERE _tanggal LIKE '%"+queryBuilder2+"%' ORDER BY _id ASC";
        }
        try (Connection conn = this.internalconnect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
                resultSetToExcel exporter = new resultSetToExcel(rs, "Export Laporan");
                String filename = JOptionPane.showInputDialog("Nama file hasil export: ", "Nama File Hasil Export");
                JFileChooser savefile = new JFileChooser();
                savefile.setSelectedFile(new File(filename+".xls"));
                int sf = savefile.showSaveDialog(null);
                if(sf == JFileChooser.APPROVE_OPTION){
                    try {
                        File file = savefile.getSelectedFile();
                        exporter.generate(file);
                        JOptionPane.showMessageDialog(null, "File export berhasil disimpan.","Berhasil Export",JOptionPane.INFORMATION_MESSAGE);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                            }else if(sf == JFileChooser.CANCEL_OPTION){
                                JOptionPane.showMessageDialog(null, "Export gagal!", "Error", JOptionPane.ERROR_MESSAGE);
                             }             
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void clearDataAnggota(){
        String SQL = "DELETE FROM _anggota";
        try (Connection conn = this.internalconnect();
            PreparedStatement pstmt = conn.prepareStatement(SQL)){
            pstmt.executeUpdate();
         }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void clearDataDetailSirkulasi(){
        String SQL = "DELETE FROM _detail_sirkulasi";
        try (Connection conn = this.internalconnect();
            PreparedStatement pstmt = conn.prepareStatement(SQL)){
            pstmt.executeUpdate();
         }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void clearKatalog(){
        String SQL = "DELETE FROM _katalog";
        try (Connection conn = this.internalconnect();
            PreparedStatement pstmt = conn.prepareStatement(SQL)){
            pstmt.executeUpdate();
         }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void clearLaporanDenda(){
        String SQL = "DELETE FROM _laporan_denda";
        try (Connection conn = this.internalconnect();
            PreparedStatement pstmt = conn.prepareStatement(SQL)){
            pstmt.executeUpdate();
         }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void clearSirkulasi(){        
        String SQL = "DELETE FROM _sirkulasi";
        try (Connection conn = this.internalconnect();
            PreparedStatement pstmt = conn.prepareStatement(SQL)){
            pstmt.executeUpdate();
         }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void updateDataSelfUserWithoutPassword(){
        String ID = globalVariabel.IDUser;
        String Nama = globalVariabel.changeName;
        
        String SQL = "UPDATE _user SET _profil_name='"+Nama+"' WHERE _id_user='"+ID+"'";
        
        try (Connection conn = this.internalconnect();
            PreparedStatement pstmt = conn.prepareStatement(SQL)){
            pstmt.executeUpdate();
         }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
     pengaturanAkun.passwordError.setText("Berhasil mengupdate Data!");
     pengaturanAkun.passwordError.setForeground(Color.green);
     pengaturanAkun.passwordError.setVisible(true);
     globalVariabel.ProfilName = Nama;
    }
    
    public void updateDataSelfUserWithPassword(){
        String ID = globalVariabel.IDUser;
        String Nama = globalVariabel.changeName;
        String Password = globalVariabel.changePass;
                
        String SQL = "UPDATE _user SET _profil_name='"+Nama+"', _password='"+Password+"' WHERE _id_user='"+ID+"'";
        
        try (Connection conn = this.internalconnect();
            PreparedStatement pstmt = conn.prepareStatement(SQL)){
            pstmt.executeUpdate();
         }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
     pengaturanAkun.passwordError.setText("Berhasil mengupdate Data!");
     pengaturanAkun.passwordError.setForeground(Color.green);
     pengaturanAkun.passwordError.setVisible(true);
     globalVariabel.ProfilName = Nama;
    }
    
    public void showTopikBantuan(){
        String sql = "SELECT * FROM _bantuan";
        DefaultListModel model = new DefaultListModel();
        String title;
        
        try (Connection conn = this.internalconnect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            // loop through the result set
            while (rs.next()) {
                title = rs.getString("_title");
                model.addElement(title);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        Bantuan.topikBantuan.setModel(model);
    }
    
    public void showKontenBantuan(){
        String topik = globalVariabel.topikBantuan;
        String sql = "SELECT * FROM _bantuan WHERE _title='"+topik+"'";
        
        String konten = "";
        
        try (Connection conn = this.internalconnect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            // loop through the result set
            while (rs.next()) {
                konten = rs.getString("_content");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        globalVariabel.kontenBantuan = konten;
    }
}

