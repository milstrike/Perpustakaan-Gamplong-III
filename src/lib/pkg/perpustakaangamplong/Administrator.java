/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib.pkg.perpustakaangamplong;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.standard.MediaPrintableArea;
import javax.print.attribute.standard.MediaSize;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author milstrike
 */
public class Administrator extends javax.swing.JFrame {

    /**
     * Creates new form Administrator
     */
    
    public dbAccess db = new dbAccess();
    public mainFunction mf = new mainFunction();
    
    
    public Administrator() {
        initComponents();
        initLevel0();
        initLevel1();
        changeAllBlack();
        initLevel2();
        initLevel3();
        initLevel4();
        initLevel5();
        initLevel6();
        panelBeranda.setVisible(true);
    }

    public void initLevel0(){
        this.setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icon-apps-16.png")));
    }
    
    public void initLevel1(){
        berandaMenu.setHorizontalTextPosition(javax.swing.JLabel.CENTER);
        berandaMenu.setVerticalTextPosition(javax.swing.JLabel.BOTTOM);
        berandaMenu.setText("   Beranda   ");
        
        sirkulasiMenu.setHorizontalTextPosition(javax.swing.JLabel.CENTER);
        sirkulasiMenu.setVerticalTextPosition(javax.swing.JLabel.BOTTOM);
        sirkulasiMenu.setText("   Sirkulasi   ");
        
        katalogMenu.setHorizontalTextPosition(javax.swing.JLabel.CENTER);
        katalogMenu.setVerticalTextPosition(javax.swing.JLabel.BOTTOM);
        katalogMenu.setText("   Katalog   ");
        
        keanggotaanMenu.setHorizontalTextPosition(javax.swing.JLabel.CENTER);
        keanggotaanMenu.setVerticalTextPosition(javax.swing.JLabel.BOTTOM);
        keanggotaanMenu.setText("   Keanggotaan   ");
        
        userManagementMenu.setHorizontalTextPosition(javax.swing.JLabel.CENTER);
        userManagementMenu.setVerticalTextPosition(javax.swing.JLabel.BOTTOM);
        userManagementMenu.setText("   Manajemen User   ");
        
        manajemenDataMenu.setHorizontalTextPosition(javax.swing.JLabel.CENTER);
        manajemenDataMenu.setVerticalTextPosition(javax.swing.JLabel.BOTTOM);
        manajemenDataMenu.setText("   Manajemen Data   ");
        
        pengaturanMenu.setHorizontalTextPosition(javax.swing.JLabel.CENTER);
        pengaturanMenu.setVerticalTextPosition(javax.swing.JLabel.BOTTOM);
        pengaturanMenu.setText("   Pengaturan   ");
        
    }
    
    public void initLevel2(){
        berandaMenu.setForeground(Color.ORANGE);
    }
    
    public void initLevel3(){
        panelBeranda.setVisible(false);
        panelSirkulasi.setVisible(false);
        panelKatalogGeneral.setVisible(false);
        panelKeanggotaan.setVisible(false);
        panelUser.setVisible(false);
        panelManajemen.setVisible(false);
        panelPengaturan.setVisible(false);
        db.clearJudulBuku();
    }
    
    public void initLevel4(){
        addWindowListener(new java.awt.event.WindowAdapter() {
    @Override
    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
        if (JOptionPane.showConfirmDialog(null, 
            "Apakah Anda ingin keluar dari Aplikasi?", "Konfirmasi keluar?", 
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
            System.exit(0);
            }
    }
        });
    }
    
    public void initLevel5(){
        db.showPengaturanDenda();
        db.showPengaturanJudulBuku();
        db.showPengaturanSirkulasi();
        db.showDaftarSirkulasi();
        db.showDataUser();
        db.showKatalog();
        db.showKeanggotaan();
    }
    
    public void initLevel6(){
        globalVariabel.editData = 0;
        globalVariabel.cekData = 0;
        globalVariabel.cekDataKeanggotaan = 0;
        globalVariabel.changePassword = 0;
        globalVariabel.editKatalog = 0;
        globalVariabel.editUser = 0;
        globalVariabel.passwordEditor = 0;
        globalVariabel.cekPengembalian = 0;
        
        checkBebasDenda.setEnabled(false);
        checkEditKatalog.setSelected(false);
        cekData.setSelected(false);
        aktivasiEdit.setSelected(false);
        cekDataUser.setSelected(false);
        
        btnPinjamanKembali.setEnabled(false);
        
        textStatusKeterlambatan.setText("-");
        textDenda.setText("-");
    }
    
    public void exitApplication(){
        if (JOptionPane.showConfirmDialog(null, 
            "Apakah Anda ingin keluar dari Aplikasi?", "Konfirmasi keluar?", 
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }
    
    public void changeAllBlack(){
        berandaMenu.setForeground(Color.BLACK);
        sirkulasiMenu.setForeground(Color.BLACK);
        katalogMenu.setForeground(Color.BLACK);
        keanggotaanMenu.setForeground(Color.BLACK);    
        userManagementMenu.setForeground(Color.BLACK);    
        manajemenDataMenu.setForeground(Color.BLACK);   
        pengaturanMenu.setForeground(Color.BLACK);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        berandaMenu = new javax.swing.JLabel();
        sirkulasiMenu = new javax.swing.JLabel();
        katalogMenu = new javax.swing.JLabel();
        keanggotaanMenu = new javax.swing.JLabel();
        userManagementMenu = new javax.swing.JLabel();
        manajemenDataMenu = new javax.swing.JLabel();
        pengaturanMenu = new javax.swing.JLabel();
        generalPanel = new javax.swing.JPanel();
        panelBeranda = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        panelSirkulasi = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        optionPencarianSirkulasi = new javax.swing.JComboBox<>();
        inputPencarianSirkulasi = new javax.swing.JTextField();
        btnPencarianSirkulasi = new javax.swing.JButton();
        btnResetTabelSirkulasi = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelSirkulasi = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        inputIDAnggota = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        inputNamaAngfota = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        btnCariAnggota = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelJudulBuku = new javax.swing.JTable();
        btnTambahJudul = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        inputTanggalPinjam = new javax.swing.JTextField();
        btnSetTanggal = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        inputTanggalKembali = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        textStatusKeterlambatan = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        textDenda = new javax.swing.JLabel();
        checkBebasDenda = new javax.swing.JCheckBox();
        btnPinjamanKembali = new javax.swing.JButton();
        btnKonfirmasiPeminjaman = new javax.swing.JButton();
        btnHapusJudul = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        btnHapusSirkulasi = new javax.swing.JButton();
        panelKatalogGeneral = new javax.swing.JPanel();
        optionPencarianKatalog = new javax.swing.JComboBox<>();
        inputPencarianKatalog = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelKatalog = new javax.swing.JTable();
        btnPencarianKatalog = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel11 = new javax.swing.JPanel();
        jLabel47 = new javax.swing.JLabel();
        editIDKatalog = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        editJudulKatalog = new javax.swing.JTextField();
        jLabel49 = new javax.swing.JLabel();
        editPengarangKatalog = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        editPenerbitKatalog = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        editISBNKatalog = new javax.swing.JTextField();
        jLabel52 = new javax.swing.JLabel();
        editStokKatalog = new javax.swing.JTextField();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        editLokasiRakKatalog = new javax.swing.JTextField();
        btnSimpanPerubahanKatalog = new javax.swing.JButton();
        checkEditKatalog = new javax.swing.JCheckBox();
        btnHapusData = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        jLabel55 = new javax.swing.JLabel();
        newIDKatalog = new javax.swing.JTextField();
        jLabel56 = new javax.swing.JLabel();
        newJudulKatalog = new javax.swing.JTextField();
        jLabel57 = new javax.swing.JLabel();
        newPengarangKatalog = new javax.swing.JTextField();
        jLabel58 = new javax.swing.JLabel();
        newPenerbitKatalog = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        newISBNKatalog = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        newStokKatalog = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        newLokasiRakKatalog = new javax.swing.JTextField();
        btnTambahKatalog = new javax.swing.JButton();
        btnResetTabel = new javax.swing.JButton();
        panelKeanggotaan = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabelAnggota = new javax.swing.JTable();
        optionPencarianAnggota = new javax.swing.JComboBox<>();
        inputPencarianAnggota = new javax.swing.JTextField();
        btnPencarianAnggota = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        editID = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        editNama = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        editAlamat = new javax.swing.JTextArea();
        jLabel24 = new javax.swing.JLabel();
        editTelepon = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        editTanggal = new javax.swing.JTextField();
        aktivasiEdit = new javax.swing.JCheckBox();
        simpanPerubahanBtn = new javax.swing.JButton();
        btnHapusKeanggotaan = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        newID = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        newNama = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        newAlamat = new javax.swing.JTextArea();
        jLabel29 = new javax.swing.JLabel();
        newTelepon = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        newTanggal = new javax.swing.JTextField();
        tambahAnggotaBtn = new javax.swing.JButton();
        hasilkanIDBtn = new javax.swing.JButton();
        hasilkanTanggalBtn = new javax.swing.JButton();
        cekData = new javax.swing.JCheckBox();
        btnResetTabelKeanggotaan = new javax.swing.JButton();
        panelUser = new javax.swing.JPanel();
        optionPencarianUser = new javax.swing.JComboBox<>();
        inputPencarianUser = new javax.swing.JTextField();
        btnPencarianUser = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        tabelUser = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel10 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        editIDUser = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        editNamaUser = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        editUsernama = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        editPassword = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        editLevelling = new javax.swing.JComboBox<>();
        jLabel44 = new javax.swing.JLabel();
        editStatus = new javax.swing.JComboBox<>();
        jLabel45 = new javax.swing.JLabel();
        editPhones = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        editAddress = new javax.swing.JTextField();
        btnSimpanPerubahanUser = new javax.swing.JButton();
        cekDataUser = new javax.swing.JCheckBox();
        btnHapusUser = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        newIDUser = new javax.swing.JTextField();
        getIDUser = new javax.swing.JButton();
        jLabel32 = new javax.swing.JLabel();
        newNamaUser = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        newUsername = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        newPassword = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        newLevelling = new javax.swing.JComboBox<>();
        newStatus = new javax.swing.JComboBox<>();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        newPhones = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        newAddress = new javax.swing.JTextField();
        btnTambahUser = new javax.swing.JButton();
        btnResetTabelUser = new javax.swing.JButton();
        panelManajemen = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        bulanStart = new javax.swing.JComboBox<>();
        tahunStart = new javax.swing.JComboBox<>();
        btnProsesData = new javax.swing.JButton();
        jLabel59 = new javax.swing.JLabel();
        optionManajemenData = new javax.swing.JComboBox<>();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tampilanMultiFungsi = new javax.swing.JTextPane();
        jPanel15 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        panelPengaturan = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        inputTarifDenda = new javax.swing.JTextField();
        jLabel62 = new javax.swing.JLabel();
        inputPeriodeDenda = new javax.swing.JTextField();
        jLabel63 = new javax.swing.JLabel();
        btnSimpanPengaturanDenda = new javax.swing.JButton();
        jPanel16 = new javax.swing.JPanel();
        btnResetAplikasi = new javax.swing.JButton();
        jPanel17 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        inputMaksSirkulasi = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        btnSimpanMasaSirkulasi = new javax.swing.JButton();
        jPanel19 = new javax.swing.JPanel();
        jLabel68 = new javax.swing.JLabel();
        inputJudulMaksimal = new javax.swing.JTextField();
        jLabel71 = new javax.swing.JLabel();
        btnSimpanPengaturanJumlahJudul = new javax.swing.JButton();
        jPanel20 = new javax.swing.JPanel();
        btnRestartAplikasi = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        konfigurasiMenu = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        exitMenu = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        menuBantuan = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        menuTentang = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Aplikasi Perpustakaan Taman Bacaan Mentari Gamplong III - Administrator");
        setResizable(false);

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        berandaMenu.setForeground(new java.awt.Color(204, 153, 0));
        berandaMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lib/pkg/perpustakaangamplong/home.png"))); // NOI18N
        berandaMenu.setToolTipText("Beranda");
        berandaMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        berandaMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                berandaMenuMouseClicked(evt);
            }
        });
        jToolBar1.add(berandaMenu);

        sirkulasiMenu.setForeground(new java.awt.Color(51, 51, 51));
        sirkulasiMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lib/pkg/perpustakaangamplong/sirkulasi.png"))); // NOI18N
        sirkulasiMenu.setToolTipText("Manajemen Sirkulasi Perpustakaan");
        sirkulasiMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sirkulasiMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sirkulasiMenuMouseClicked(evt);
            }
        });
        jToolBar1.add(sirkulasiMenu);

        katalogMenu.setForeground(new java.awt.Color(51, 51, 51));
        katalogMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lib/pkg/perpustakaangamplong/katalog.png"))); // NOI18N
        katalogMenu.setToolTipText("Lihat dan Cari Katalog");
        katalogMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        katalogMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                katalogMenuMouseClicked(evt);
            }
        });
        jToolBar1.add(katalogMenu);

        keanggotaanMenu.setForeground(new java.awt.Color(51, 51, 51));
        keanggotaanMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lib/pkg/perpustakaangamplong/keanggotan.png"))); // NOI18N
        keanggotaanMenu.setToolTipText("Manajemen Keanggotaan Perpustakaan");
        keanggotaanMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        keanggotaanMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                keanggotaanMenuMouseClicked(evt);
            }
        });
        jToolBar1.add(keanggotaanMenu);

        userManagementMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lib/pkg/perpustakaangamplong/usermanagement.png"))); // NOI18N
        userManagementMenu.setToolTipText("Manajemen Operator Perpustakaan");
        userManagementMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        userManagementMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userManagementMenuMouseClicked(evt);
            }
        });
        jToolBar1.add(userManagementMenu);

        manajemenDataMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lib/pkg/perpustakaangamplong/manajemendata.png"))); // NOI18N
        manajemenDataMenu.setToolTipText("Manajemen Data Perpustakaan");
        manajemenDataMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        manajemenDataMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                manajemenDataMenuMouseClicked(evt);
            }
        });
        jToolBar1.add(manajemenDataMenu);

        pengaturanMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lib/pkg/perpustakaangamplong/setting.png"))); // NOI18N
        pengaturanMenu.setToolTipText("Pengaturan Aplikasi Perpustakaan");
        pengaturanMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pengaturanMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pengaturanMenuMouseClicked(evt);
            }
        });
        jToolBar1.add(pengaturanMenu);

        generalPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Selamat Datang di Aplikasi Perpustakaan Taman Bacaan Mentari Gamplong III");

        jLabel2.setText("Anda login sebagai Administrator");

        jLabel3.setText("Untuk bantuan menggunakan aplikasi ini, Anda dapat menggunakan menu bantuan atau klik bantuan di bawah ini.");

        jLabel4.setForeground(new java.awt.Color(51, 51, 255));
        jLabel4.setText("<html><u>bantuan</u></html>");
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelBerandaLayout = new javax.swing.GroupLayout(panelBeranda);
        panelBeranda.setLayout(panelBerandaLayout);
        panelBerandaLayout.setHorizontalGroup(
            panelBerandaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBerandaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBerandaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(486, Short.MAX_VALUE))
        );
        panelBerandaLayout.setVerticalGroup(
            panelBerandaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBerandaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(485, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        optionPencarianSirkulasi.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        optionPencarianSirkulasi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID Anggota", "Tanggal Pinjam" }));

        btnPencarianSirkulasi.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        btnPencarianSirkulasi.setText("Cari!");
        btnPencarianSirkulasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPencarianSirkulasiActionPerformed(evt);
            }
        });

        btnResetTabelSirkulasi.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        btnResetTabelSirkulasi.setText("Reset Tabel");
        btnResetTabelSirkulasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetTabelSirkulasiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(optionPencarianSirkulasi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputPencarianSirkulasi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPencarianSirkulasi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnResetTabelSirkulasi)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(optionPencarianSirkulasi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputPencarianSirkulasi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPencarianSirkulasi)
                    .addComponent(btnResetTabelSirkulasi))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jScrollPane1.setForeground(new java.awt.Color(204, 204, 204));

        tabelSirkulasi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "#", "ID Sirkulasi", "ID Anggota", "Nama", "Total Judul", "Tanggal Pinjam", "Tanggal Kembali", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelSirkulasi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelSirkulasiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelSirkulasi);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 847, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setText("ID Anggota");

        jLabel6.setText("Nama");

        inputNamaAngfota.setEditable(false);

        btnCariAnggota.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        btnCariAnggota.setText("Cari");
        btnCariAnggota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariAnggotaActionPerformed(evt);
            }
        });

        jScrollPane2.setForeground(new java.awt.Color(204, 204, 204));

        tabelJudulBuku.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "#", "ID Katalog", "Judul Buku"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelJudulBuku.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelJudulBukuMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabelJudulBuku);

        btnTambahJudul.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        btnTambahJudul.setText("+");
        btnTambahJudul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahJudulActionPerformed(evt);
            }
        });

        jLabel7.setText("Tanggal Pinjam");

        btnSetTanggal.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        btnSetTanggal.setText("Set Tanggal");
        btnSetTanggal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSetTanggalActionPerformed(evt);
            }
        });

        jLabel8.setText("Tanggal Kembali");

        jLabel9.setText("Status");

        textStatusKeterlambatan.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        textStatusKeterlambatan.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        textStatusKeterlambatan.setText("-");

        jLabel11.setText("Denda");

        textDenda.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        textDenda.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        textDenda.setText("-");

        checkBebasDenda.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        checkBebasDenda.setText("Bebas Denda");
        checkBebasDenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBebasDendaActionPerformed(evt);
            }
        });

        btnPinjamanKembali.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        btnPinjamanKembali.setText("Pinjaman Kembali");
        btnPinjamanKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPinjamanKembaliActionPerformed(evt);
            }
        });

        btnKonfirmasiPeminjaman.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        btnKonfirmasiPeminjaman.setText("Konfirmasi Peminjaman");
        btnKonfirmasiPeminjaman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKonfirmasiPeminjamanActionPerformed(evt);
            }
        });

        btnHapusJudul.setText("-");
        btnHapusJudul.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHapusJudulMouseClicked(evt);
            }
        });

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        btnHapusSirkulasi.setText("Hapus Sirkulasi");
        btnHapusSirkulasi.setEnabled(false);
        btnHapusSirkulasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusSirkulasiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inputNamaAngfota)
                    .addComponent(jSeparator3)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(inputIDAnggota)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCariAnggota))
                    .addComponent(jSeparator4)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(textDenda))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(textStatusKeterlambatan))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(btnHapusJudul)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnTambahJudul))
                            .addComponent(btnKonfirmasiPeminjaman, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(inputTanggalPinjam)
                            .addComponent(inputTanggalKembali, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(102, 102, 102))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(btnRefresh)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPinjamanKembali))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(85, 85, 85)
                                .addComponent(btnSetTanggal))
                            .addComponent(checkBebasDenda)
                            .addComponent(btnHapusSirkulasi))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(0, 0, 0)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputIDAnggota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCariAnggota))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addGap(0, 0, 0)
                .addComponent(inputNamaAngfota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTambahJudul)
                    .addComponent(btnHapusJudul))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addGap(4, 4, 4)
                .addComponent(inputTanggalPinjam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(btnSetTanggal))
                .addGap(4, 4, 4)
                .addComponent(inputTanggalKembali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnKonfirmasiPeminjaman)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(textStatusKeterlambatan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(textDenda))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(checkBebasDenda)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPinjamanKembali)
                    .addComponent(btnRefresh))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnHapusSirkulasi)
                .addContainerGap())
        );

        javax.swing.GroupLayout panelSirkulasiLayout = new javax.swing.GroupLayout(panelSirkulasi);
        panelSirkulasi.setLayout(panelSirkulasiLayout);
        panelSirkulasiLayout.setHorizontalGroup(
            panelSirkulasiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1166, Short.MAX_VALUE)
            .addGroup(panelSirkulasiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelSirkulasiLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(panelSirkulasiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)))
        );
        panelSirkulasiLayout.setVerticalGroup(
            panelSirkulasiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 635, Short.MAX_VALUE)
            .addGroup(panelSirkulasiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelSirkulasiLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(panelSirkulasiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelSirkulasiLayout.createSequentialGroup()
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addContainerGap()))
        );

        optionPencarianKatalog.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        optionPencarianKatalog.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID Katalog", "Judul Buku", "Pengarang", "ISBN" }));

        tabelKatalog.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "#", "ID Katalog", "Judul", "Pengarang", "Penerbit", "ISBN", "Stok", "Rak"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelKatalog.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelKatalogMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tabelKatalog);

        btnPencarianKatalog.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        btnPencarianKatalog.setText("Cari");
        btnPencarianKatalog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPencarianKatalogActionPerformed(evt);
            }
        });

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel47.setText("ID Katalog");

        editIDKatalog.setEditable(false);

        jLabel48.setText("Judul");

        editJudulKatalog.setEditable(false);

        jLabel49.setText("Pengarang");

        editPengarangKatalog.setEditable(false);

        jLabel50.setText("Penerbit");

        editPenerbitKatalog.setEditable(false);

        jLabel51.setText("ISBN");

        editISBNKatalog.setEditable(false);

        jLabel52.setText("Stok");

        editStokKatalog.setEditable(false);

        jLabel53.setText("unit");

        jLabel54.setText("Lokasi Rak");

        editLokasiRakKatalog.setEditable(false);

        btnSimpanPerubahanKatalog.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        btnSimpanPerubahanKatalog.setText("Simpan Perubahan");
        btnSimpanPerubahanKatalog.setEnabled(false);
        btnSimpanPerubahanKatalog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanPerubahanKatalogActionPerformed(evt);
            }
        });

        checkEditKatalog.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        checkEditKatalog.setText("Aktifkan Pengeditan");
        checkEditKatalog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkEditKatalogActionPerformed(evt);
            }
        });

        btnHapusData.setText("Hapus Data");
        btnHapusData.setEnabled(false);
        btnHapusData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusDataActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(btnHapusData)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                        .addComponent(btnSimpanPerubahanKatalog))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(checkEditKatalog)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel11Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(editIDKatalog)
                        .addComponent(editJudulKatalog)
                        .addComponent(editPengarangKatalog)
                        .addComponent(editPenerbitKatalog)
                        .addComponent(editISBNKatalog)
                        .addComponent(editLokasiRakKatalog)
                        .addGroup(jPanel11Layout.createSequentialGroup()
                            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel47)
                                .addComponent(jLabel48)
                                .addComponent(jLabel49)
                                .addComponent(jLabel50)
                                .addComponent(jLabel51)
                                .addComponent(jLabel52)
                                .addGroup(jPanel11Layout.createSequentialGroup()
                                    .addComponent(editStokKatalog, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel53))
                                .addComponent(jLabel54))
                            .addGap(0, 0, Short.MAX_VALUE)))
                    .addContainerGap()))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(437, Short.MAX_VALUE)
                .addComponent(checkEditKatalog)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSimpanPerubahanKatalog)
                    .addComponent(btnHapusData))
                .addContainerGap())
            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel11Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel47)
                    .addGap(0, 0, 0)
                    .addComponent(editIDKatalog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel48)
                    .addGap(0, 0, 0)
                    .addComponent(editJudulKatalog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel49)
                    .addGap(0, 0, 0)
                    .addComponent(editPengarangKatalog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel50)
                    .addGap(0, 0, 0)
                    .addComponent(editPenerbitKatalog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel51)
                    .addGap(0, 0, 0)
                    .addComponent(editISBNKatalog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel52)
                    .addGap(0, 0, 0)
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(editStokKatalog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel53))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel54)
                    .addGap(0, 0, 0)
                    .addComponent(editLokasiRakKatalog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jTabbedPane3.addTab("Edit Katalog", jPanel11);

        jLabel55.setText("ID Katalog");

        jLabel56.setText("Judul");

        jLabel57.setText("Pengarang");

        jLabel58.setText("Penerbit");

        jLabel13.setText("ISBN");

        jLabel14.setText("Stok");

        jLabel15.setText("unit");

        jLabel16.setText("Lokasi Rak");

        btnTambahKatalog.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        btnTambahKatalog.setText("Tambah Data Katalog");
        btnTambahKatalog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahKatalogActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap(190, Short.MAX_VALUE)
                .addComponent(btnTambahKatalog)
                .addContainerGap())
            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel12Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(newIDKatalog)
                        .addComponent(newJudulKatalog)
                        .addComponent(newPengarangKatalog)
                        .addComponent(newPenerbitKatalog)
                        .addComponent(newISBNKatalog)
                        .addComponent(newLokasiRakKatalog)
                        .addGroup(jPanel12Layout.createSequentialGroup()
                            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel55)
                                .addComponent(jLabel56)
                                .addComponent(jLabel57)
                                .addComponent(jLabel58)
                                .addComponent(jLabel13)
                                .addComponent(jLabel14)
                                .addGroup(jPanel12Layout.createSequentialGroup()
                                    .addComponent(newStokKatalog, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel15))
                                .addComponent(jLabel16))
                            .addGap(0, 0, Short.MAX_VALUE)))
                    .addContainerGap()))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap(467, Short.MAX_VALUE)
                .addComponent(btnTambahKatalog)
                .addContainerGap())
            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel12Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel55)
                    .addGap(0, 0, 0)
                    .addComponent(newIDKatalog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel56)
                    .addGap(0, 0, 0)
                    .addComponent(newJudulKatalog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel57)
                    .addGap(0, 0, 0)
                    .addComponent(newPengarangKatalog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel58)
                    .addGap(0, 0, 0)
                    .addComponent(newPenerbitKatalog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel13)
                    .addGap(0, 0, 0)
                    .addComponent(newISBNKatalog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel14)
                    .addGap(0, 0, 0)
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(newStokKatalog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel15))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel16)
                    .addGap(0, 0, 0)
                    .addComponent(newLokasiRakKatalog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jTabbedPane3.addTab("Tambah Katalog", jPanel12);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 348, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jTabbedPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 641, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jTabbedPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        btnResetTabel.setText("Reset Tabel");
        btnResetTabel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetTabelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelKatalogGeneralLayout = new javax.swing.GroupLayout(panelKatalogGeneral);
        panelKatalogGeneral.setLayout(panelKatalogGeneralLayout);
        panelKatalogGeneralLayout.setHorizontalGroup(
            panelKatalogGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelKatalogGeneralLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelKatalogGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelKatalogGeneralLayout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 803, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelKatalogGeneralLayout.createSequentialGroup()
                        .addComponent(optionPencarianKatalog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inputPencarianKatalog)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPencarianKatalog)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnResetTabel)))
                .addContainerGap())
        );
        panelKatalogGeneralLayout.setVerticalGroup(
            panelKatalogGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelKatalogGeneralLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelKatalogGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(optionPencarianKatalog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputPencarianKatalog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPencarianKatalog)
                    .addComponent(btnResetTabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelKatalogGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 645, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        tabelAnggota.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "#", "ID Anggota", "Nama"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelAnggota.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelAnggotaMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tabelAnggota);

        optionPencarianAnggota.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        optionPencarianAnggota.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID Anggota", "Nama" }));

        btnPencarianAnggota.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        btnPencarianAnggota.setText("Cari");
        btnPencarianAnggota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPencarianAnggotaActionPerformed(evt);
            }
        });

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel21.setText("ID Anggota");

        editID.setEditable(false);

        jLabel22.setText("Nama");

        editNama.setEditable(false);

        jLabel23.setText("Alamat");

        editAlamat.setEditable(false);
        editAlamat.setColumns(20);
        editAlamat.setRows(5);
        jScrollPane5.setViewportView(editAlamat);

        jLabel24.setText("No Telp / HP");

        editTelepon.setEditable(false);

        jLabel25.setText("Aktif Sejak Tanggal");

        editTanggal.setEditable(false);

        aktivasiEdit.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        aktivasiEdit.setText("Aktifkan Fitur Pengeditan");
        aktivasiEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aktivasiEditActionPerformed(evt);
            }
        });

        simpanPerubahanBtn.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        simpanPerubahanBtn.setText("Simpan Perubahan");
        simpanPerubahanBtn.setEnabled(false);
        simpanPerubahanBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanPerubahanBtnActionPerformed(evt);
            }
        });

        btnHapusKeanggotaan.setText("Hapus Data");
        btnHapusKeanggotaan.setEnabled(false);
        btnHapusKeanggotaan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusKeanggotaanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(editID)
                    .addComponent(editNama)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
                    .addComponent(editTelepon)
                    .addComponent(editTanggal)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21)
                            .addComponent(jLabel22)
                            .addComponent(jLabel23)
                            .addComponent(jLabel24)
                            .addComponent(jLabel25))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(aktivasiEdit))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(btnHapusKeanggotaan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(simpanPerubahanBtn)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(aktivasiEdit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editTelepon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 130, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(simpanPerubahanBtn)
                    .addComponent(btnHapusKeanggotaan))
                .addContainerGap())
        );

        jTabbedPane1.addTab("  Edit Data  ", jPanel6);

        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel26.setText("ID Anggota");

        newID.setEditable(false);

        jLabel27.setText("Nama");

        jLabel28.setText("Alamat");

        newAlamat.setColumns(20);
        newAlamat.setRows(5);
        jScrollPane6.setViewportView(newAlamat);

        jLabel29.setText("No Telp / HP");

        jLabel30.setText("Aktif Sejak Tanggal");

        newTanggal.setEditable(false);

        tambahAnggotaBtn.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        tambahAnggotaBtn.setText("Tambah Anggota");
        tambahAnggotaBtn.setEnabled(false);
        tambahAnggotaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahAnggotaBtnActionPerformed(evt);
            }
        });

        hasilkanIDBtn.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        hasilkanIDBtn.setText("Hasilkan");
        hasilkanIDBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hasilkanIDBtnActionPerformed(evt);
            }
        });

        hasilkanTanggalBtn.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        hasilkanTanggalBtn.setText("Hasilkan");
        hasilkanTanggalBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hasilkanTanggalBtnActionPerformed(evt);
            }
        });

        cekData.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        cekData.setText("Data sudah diperiksa dan dinyatakan benar");
        cekData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cekDataActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(newNama)
                            .addComponent(jScrollPane6)
                            .addComponent(newTelepon)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(tambahAnggotaBtn))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                .addComponent(newID)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(hasilkanIDBtn)))
                        .addContainerGap())
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(newTanggal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hasilkanTanggalBtn))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel26)
                            .addComponent(jLabel27)
                            .addComponent(jLabel28)
                            .addComponent(jLabel29)
                            .addComponent(jLabel30)
                            .addComponent(cekData))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hasilkanIDBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(newNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel29)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(newTelepon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel30)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hasilkanTanggalBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cekData)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tambahAnggotaBtn)
                .addContainerGap())
        );

        jTabbedPane1.addTab("  Tambah Data  ", jPanel7);

        btnResetTabelKeanggotaan.setText("Reset Tabel");
        btnResetTabelKeanggotaan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetTabelKeanggotaanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelKeanggotaanLayout = new javax.swing.GroupLayout(panelKeanggotaan);
        panelKeanggotaan.setLayout(panelKeanggotaanLayout);
        panelKeanggotaanLayout.setHorizontalGroup(
            panelKeanggotaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelKeanggotaanLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelKeanggotaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelKeanggotaanLayout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 832, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelKeanggotaanLayout.createSequentialGroup()
                        .addComponent(optionPencarianAnggota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inputPencarianAnggota)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPencarianAnggota)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnResetTabelKeanggotaan)))
                .addContainerGap())
        );
        panelKeanggotaanLayout.setVerticalGroup(
            panelKeanggotaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelKeanggotaanLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelKeanggotaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(optionPencarianAnggota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputPencarianAnggota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPencarianAnggota)
                    .addComponent(btnResetTabelKeanggotaan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelKeanggotaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
                    .addComponent(jScrollPane4))
                .addContainerGap())
        );

        optionPencarianUser.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        optionPencarianUser.setForeground(new java.awt.Color(0, 0, 0));
        optionPencarianUser.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID User", "Nama Profil", "Username" }));

        btnPencarianUser.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        btnPencarianUser.setText("Cari");
        btnPencarianUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPencarianUserActionPerformed(evt);
            }
        });

        jScrollPane8.setForeground(new java.awt.Color(204, 204, 204));

        tabelUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null}
            },
            new String [] {
                "#", "ID User", "Nama Profil", "Username", "Level", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelUserMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(tabelUser);

        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel39.setText("ID User");

        editIDUser.setEditable(false);

        jLabel40.setText("Nama Profil");

        editNamaUser.setEditable(false);

        jLabel41.setText("Username");

        editUsernama.setEditable(false);

        jLabel42.setText("Password");

        editPassword.setEditable(false);

        jLabel43.setText("Level");

        editLevelling.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrator", "Kepala Perpustakaan", "Operator" }));
        editLevelling.setEnabled(false);

        jLabel44.setText("Status");

        editStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Aktif", "Tidak Aktif" }));
        editStatus.setEnabled(false);

        jLabel45.setText("No.Telepon/HP");

        editPhones.setEditable(false);

        jLabel46.setText("Alamat");

        editAddress.setEditable(false);

        btnSimpanPerubahanUser.setText("Simpan Perubahan");
        btnSimpanPerubahanUser.setEnabled(false);
        btnSimpanPerubahanUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanPerubahanUserActionPerformed(evt);
            }
        });

        cekDataUser.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        cekDataUser.setText("Aktifkan Pengeditan");
        cekDataUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cekDataUserActionPerformed(evt);
            }
        });

        btnHapusUser.setText("Hapus Data");
        btnHapusUser.setEnabled(false);
        btnHapusUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusUserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(editNamaUser)
                    .addComponent(editUsernama)
                    .addComponent(editPassword)
                    .addComponent(editPhones)
                    .addComponent(editAddress)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addComponent(btnHapusUser)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSimpanPerubahanUser))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel39)
                            .addComponent(jLabel40)
                            .addComponent(jLabel41)
                            .addComponent(jLabel42)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(editLevelling, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel43))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel44)
                                    .addComponent(editStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel45)
                            .addComponent(jLabel46)
                            .addComponent(cekDataUser))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(editIDUser))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel39)
                .addGap(4, 4, 4)
                .addComponent(editIDUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel40)
                .addGap(0, 0, 0)
                .addComponent(editNamaUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel41)
                .addGap(0, 0, 0)
                .addComponent(editUsernama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel42)
                .addGap(0, 0, 0)
                .addComponent(editPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43)
                    .addComponent(jLabel44))
                .addGap(0, 0, 0)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editLevelling, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel45)
                .addGap(0, 0, 0)
                .addComponent(editPhones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel46)
                .addGap(0, 0, 0)
                .addComponent(editAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cekDataUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 145, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSimpanPerubahanUser)
                    .addComponent(btnHapusUser))
                .addContainerGap())
        );

        jTabbedPane2.addTab("Edit Data User", jPanel10);

        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jLabel31.setText("ID User");

        newIDUser.setEditable(false);

        getIDUser.setText(">");
        getIDUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getIDUserActionPerformed(evt);
            }
        });

        jLabel32.setText("Nama Profil");

        jLabel33.setText("Username");

        jLabel34.setText("Password");

        jLabel35.setText("Level");

        newLevelling.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrator", "Operator" }));

        newStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Aktif", "Tidak Aktif" }));

        jLabel36.setText("Status");

        jLabel37.setText("No.Telepon/HP");

        jLabel38.setText("Alamat");

        btnTambahUser.setText("Tambah User Baru");
        btnTambahUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahUserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(newIDUser)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(getIDUser))
                    .addComponent(newNamaUser)
                    .addComponent(newUsername)
                    .addComponent(newPassword)
                    .addComponent(newPhones)
                    .addComponent(newAddress)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel31)
                            .addComponent(jLabel32)
                            .addComponent(jLabel33)
                            .addComponent(jLabel34)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(newLevelling, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel35))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel36)
                                    .addComponent(newStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel37)
                            .addComponent(jLabel38))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnTambahUser)))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel31)
                .addGap(0, 0, 0)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newIDUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(getIDUser))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel32)
                .addGap(0, 0, 0)
                .addComponent(newNamaUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel33)
                .addGap(0, 0, 0)
                .addComponent(newUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel34)
                .addGap(0, 0, 0)
                .addComponent(newPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(jLabel36))
                .addGap(0, 0, 0)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newLevelling, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel37)
                .addGap(0, 0, 0)
                .addComponent(newPhones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel38)
                .addGap(0, 0, 0)
                .addComponent(newAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 171, Short.MAX_VALUE)
                .addComponent(btnTambahUser)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Tambah Data User", jPanel9);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2)
                .addContainerGap())
        );

        btnResetTabelUser.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        btnResetTabelUser.setText("Reset Tabel");
        btnResetTabelUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetTabelUserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelUserLayout = new javax.swing.GroupLayout(panelUser);
        panelUser.setLayout(panelUserLayout);
        panelUserLayout.setHorizontalGroup(
            panelUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelUserLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelUserLayout.createSequentialGroup()
                        .addComponent(optionPencarianUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inputPencarianUser)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPencarianUser)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnResetTabelUser, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 875, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelUserLayout.setVerticalGroup(
            panelUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelUserLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelUserLayout.createSequentialGroup()
                        .addGroup(panelUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(optionPencarianUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inputPencarianUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPencarianUser)
                            .addComponent(btnResetTabelUser))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder("[ Opsi Data ]"));

        jLabel17.setText("Pilih Periode");

        bulanStart.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember" }));

        tahunStart.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036", "2037", "2038", "2039", "2040", "2041", "2042", "2043", "2044", "2045" }));

        btnProsesData.setText("Proses");
        btnProsesData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProsesDataActionPerformed(evt);
            }
        });

        jLabel59.setText("Pilih Data:");

        optionManajemenData.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Katalog", "Sirkulasi (Peminjaman/Pengembalian)", "Denda" }));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(optionManajemenData, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel59)
                            .addComponent(jLabel17))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnProsesData))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                        .addComponent(bulanStart, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tahunStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel59)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(optionManajemenData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bulanStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tahunStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnProsesData)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder("[ Tampilan Multi Fungsi ]"));

        tampilanMultiFungsi.setEditable(false);
        tampilanMultiFungsi.setContentType("text/html"); // NOI18N
        tampilanMultiFungsi.setText("");
        jScrollPane7.setViewportView(tampilanMultiFungsi);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 545, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane7)
                .addGap(0, 0, 0))
        );

        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder("[ Olah Data ]"));

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lib/pkg/perpustakaangamplong/excel.png"))); // NOI18N
        jLabel19.setText("Export Data ke Excel");
        jLabel19.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel19MouseClicked(evt);
            }
        });

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lib/pkg/perpustakaangamplong/Printer.png"))); // NOI18N
        jLabel20.setText("Cetak Data");
        jLabel20.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel20MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel20)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelManajemenLayout = new javax.swing.GroupLayout(panelManajemen);
        panelManajemen.setLayout(panelManajemenLayout);
        panelManajemenLayout.setHorizontalGroup(
            panelManajemenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelManajemenLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelManajemenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelManajemenLayout.setVerticalGroup(
            panelManajemenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelManajemenLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelManajemenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelManajemenLayout.createSequentialGroup()
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 268, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("[ Pengaturan Denda ]"));

        jLabel60.setText("Masukkan tarif denda");

        jLabel61.setText("Rp");

        inputTarifDenda.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel62.setText(",00 / ");

        inputPeriodeDenda.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        inputPeriodeDenda.setText("1");

        jLabel63.setText("hari");

        btnSimpanPengaturanDenda.setText("Simpan");
        btnSimpanPengaturanDenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanPengaturanDendaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel60)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel61)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inputTarifDenda)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel62)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputPeriodeDenda, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel63)
                .addContainerGap(12, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSimpanPengaturanDenda)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel60)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel61)
                    .addComponent(inputTarifDenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel62)
                    .addComponent(inputPeriodeDenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel63))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSimpanPengaturanDenda)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel16.setBorder(javax.swing.BorderFactory.createTitledBorder("[ Atur Ulang Aplikasi ]"));

        btnResetAplikasi.setText("Atur Ulang Aplikasi");
        btnResetAplikasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetAplikasiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addComponent(btnResetAplikasi, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(btnResetAplikasi)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel17.setBorder(javax.swing.BorderFactory.createTitledBorder("[ Atur Masa Sirkulasi ]"));

        jLabel10.setText("Masukkan masa maksimal sirkulasi");

        inputMaksSirkulasi.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel12.setText("hari");

        btnSimpanMasaSirkulasi.setText("Simpan");
        btnSimpanMasaSirkulasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanMasaSirkulasiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSimpanMasaSirkulasi))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addComponent(inputMaksSirkulasi, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel12)))
                        .addGap(0, 17, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputMaksSirkulasi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSimpanMasaSirkulasi)
                .addContainerGap())
        );

        jPanel19.setBorder(javax.swing.BorderFactory.createTitledBorder("[ Pengaturan Jumlah Judul ]"));

        jLabel68.setText("Masukkan Jumlah Judul Maksimal");

        inputJudulMaksimal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        inputJudulMaksimal.setText("1");

        jLabel71.setText("Judul");

        btnSimpanPengaturanJumlahJudul.setText("Simpan");
        btnSimpanPengaturanJumlahJudul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanPengaturanJumlahJudulActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel68)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(inputJudulMaksimal, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel71)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSimpanPengaturanJumlahJudul)
                .addContainerGap())
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel68)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputJudulMaksimal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel71))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSimpanPengaturanJumlahJudul)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel20.setBorder(javax.swing.BorderFactory.createTitledBorder("[ Restart Aplikasi ]"));

        btnRestartAplikasi.setText("Restart Aplikasi");
        btnRestartAplikasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestartAplikasiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(btnRestartAplikasi, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(btnRestartAplikasi)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelPengaturanLayout = new javax.swing.GroupLayout(panelPengaturan);
        panelPengaturan.setLayout(panelPengaturanLayout);
        panelPengaturanLayout.setHorizontalGroup(
            panelPengaturanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPengaturanLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPengaturanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelPengaturanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(656, Short.MAX_VALUE))
        );
        panelPengaturanLayout.setVerticalGroup(
            panelPengaturanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPengaturanLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPengaturanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelPengaturanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPengaturanLayout.createSequentialGroup()
                        .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(472, 472, 472))
                    .addGroup(panelPengaturanLayout.createSequentialGroup()
                        .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout generalPanelLayout = new javax.swing.GroupLayout(generalPanel);
        generalPanel.setLayout(generalPanelLayout);
        generalPanelLayout.setHorizontalGroup(
            generalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(generalPanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(panelBeranda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
            .addGroup(generalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(generalPanelLayout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(panelSirkulasi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(0, 0, 0)))
            .addGroup(generalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(generalPanelLayout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(panelKatalogGeneral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(0, 0, 0)))
            .addGroup(generalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(generalPanelLayout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(panelKeanggotaan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(0, 0, 0)))
            .addGroup(generalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(generalPanelLayout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(panelUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(0, 0, 0)))
            .addGroup(generalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(generalPanelLayout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(panelManajemen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(0, 0, 0)))
            .addGroup(generalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(generalPanelLayout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(panelPengaturan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(0, 0, 0)))
        );
        generalPanelLayout.setVerticalGroup(
            generalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(generalPanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(panelBeranda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
            .addGroup(generalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(generalPanelLayout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(panelSirkulasi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(0, 0, 0)))
            .addGroup(generalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(generalPanelLayout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(panelKatalogGeneral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(0, 0, 0)))
            .addGroup(generalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(generalPanelLayout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(panelKeanggotaan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(0, 0, 0)))
            .addGroup(generalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(generalPanelLayout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(panelUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(0, 0, 0)))
            .addGroup(generalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(generalPanelLayout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(panelManajemen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(0, 0, 0)))
            .addGroup(generalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(generalPanelLayout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(panelPengaturan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(0, 0, 0)))
        );

        jMenu1.setText("Aplikasi");

        konfigurasiMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lib/pkg/perpustakaangamplong/user.png"))); // NOI18N
        konfigurasiMenu.setText("Konfigurasi Akun          ");
        konfigurasiMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                konfigurasiMenuActionPerformed(evt);
            }
        });
        jMenu1.add(konfigurasiMenu);

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lib/pkg/perpustakaangamplong/lock.png"))); // NOI18N
        jMenuItem2.setText("Log out dari Aplikasi          ");
        jMenuItem2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem2MouseClicked(evt);
            }
        });
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);
        jMenu1.add(jSeparator2);

        exitMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        exitMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lib/pkg/perpustakaangamplong/Badge-multiply.png"))); // NOI18N
        exitMenu.setText("Tutup Aplikasi");
        exitMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuActionPerformed(evt);
            }
        });
        jMenu1.add(exitMenu);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Bantuan");

        menuBantuan.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        menuBantuan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lib/pkg/perpustakaangamplong/help.png"))); // NOI18N
        menuBantuan.setText("Bantuan               ");
        menuBantuan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuBantuanActionPerformed(evt);
            }
        });
        jMenu2.add(menuBantuan);
        jMenu2.add(jSeparator1);

        menuTentang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lib/pkg/perpustakaangamplong/info.png"))); // NOI18N
        menuTentang.setText("Tentang");
        menuTentang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuTentangActionPerformed(evt);
            }
        });
        jMenu2.add(menuTentang);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(generalPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(generalPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void konfigurasiMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_konfigurasiMenuActionPerformed
        new pengaturanAkun().setVisible(true);
    }//GEN-LAST:event_konfigurasiMenuActionPerformed

    private void menuBantuanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuBantuanActionPerformed
        new Bantuan().setVisible(true);
    }//GEN-LAST:event_menuBantuanActionPerformed

    private void menuTentangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuTentangActionPerformed
        new About().setVisible(true);
    }//GEN-LAST:event_menuTentangActionPerformed

    private void berandaMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_berandaMenuMouseClicked
        initLevel6();
        changeAllBlack();
        berandaMenu.setForeground(Color.ORANGE);
        initLevel3();
        panelBeranda.setVisible(true);
    }//GEN-LAST:event_berandaMenuMouseClicked

    private void sirkulasiMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sirkulasiMenuMouseClicked
        initLevel6();
        changeAllBlack();
        sirkulasiMenu.setForeground(Color.ORANGE);
        initLevel3();
        panelSirkulasi.setVisible(true);

    }//GEN-LAST:event_sirkulasiMenuMouseClicked

    private void katalogMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_katalogMenuMouseClicked
        initLevel6();
        changeAllBlack();
        katalogMenu.setForeground(Color.ORANGE);
        initLevel3();
        panelKatalogGeneral.setVisible(true);
    }//GEN-LAST:event_katalogMenuMouseClicked

    private void keanggotaanMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_keanggotaanMenuMouseClicked
        initLevel6();
        changeAllBlack();
        keanggotaanMenu.setForeground(Color.ORANGE);
        initLevel3();
        panelKeanggotaan.setVisible(true);
    }//GEN-LAST:event_keanggotaanMenuMouseClicked

    private void btnTambahJudulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahJudulActionPerformed
        new tambahJudulBuku().setVisible(true);
    }//GEN-LAST:event_btnTambahJudulActionPerformed

    private void aktivasiEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aktivasiEditActionPerformed
                if(globalVariabel.editData == 0){
                        editNama.setEditable(true);
                        editAlamat.setEditable(true);
                        editTelepon.setEditable(true);
                        simpanPerubahanBtn.setEnabled(true);
                        globalVariabel.editData = 1;
                    }
                else{
                        editNama.setEditable(false);
                        editAlamat.setEditable(false);
                        editTelepon.setEditable(false);
                        simpanPerubahanBtn.setEnabled(false);
                        globalVariabel.editData = 0;
                    }
    }//GEN-LAST:event_aktivasiEditActionPerformed

    private void hasilkanIDBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hasilkanIDBtnActionPerformed
        newID.setText(new GeneralConfiguration().IDUserCreator().toString());
    }//GEN-LAST:event_hasilkanIDBtnActionPerformed

    private void hasilkanTanggalBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hasilkanTanggalBtnActionPerformed
        newTanggal.setText(new GeneralConfiguration().getDate().toString());
    }//GEN-LAST:event_hasilkanTanggalBtnActionPerformed

    private void cekDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cekDataActionPerformed
                if(globalVariabel.cekDataKeanggotaan == 0){
                        tambahAnggotaBtn.setEnabled(true);
                        globalVariabel.cekDataKeanggotaan = 1;
                    }
                else{
                        tambahAnggotaBtn.setEnabled(false);
                        globalVariabel.cekDataKeanggotaan = 0;
                    }
    }//GEN-LAST:event_cekDataActionPerformed

    private void userManagementMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userManagementMenuMouseClicked
        initLevel6();
        changeAllBlack();
        userManagementMenu.setForeground(Color.ORANGE);
        initLevel3();
        panelUser.setVisible(true);
    }//GEN-LAST:event_userManagementMenuMouseClicked

    private void manajemenDataMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_manajemenDataMenuMouseClicked
        initLevel6();
        changeAllBlack();
        manajemenDataMenu.setForeground(Color.ORANGE);
        initLevel3();
        panelManajemen.setVisible(true);
    }//GEN-LAST:event_manajemenDataMenuMouseClicked

    private void pengaturanMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pengaturanMenuMouseClicked
        initLevel6();
        changeAllBlack();
        pengaturanMenu.setForeground(Color.ORANGE);
        initLevel3();
        panelPengaturan.setVisible(true);
    }//GEN-LAST:event_pengaturanMenuMouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        new Bantuan().setVisible(true);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void btnSetTanggalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSetTanggalActionPerformed
        inputTanggalPinjam.setText(new GeneralConfiguration().getDate());
        inputTanggalKembali.setText(new GeneralConfiguration().getReturnDate());
    }//GEN-LAST:event_btnSetTanggalActionPerformed

    private void checkEditKatalogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkEditKatalogActionPerformed
        if(globalVariabel.editKatalog == 0){
                        editJudulKatalog.setEditable(true);
                        editPengarangKatalog.setEditable(true);
                        editPenerbitKatalog.setEditable(true);
                        editISBNKatalog.setEditable(true);
                        editStokKatalog.setEditable(true);
                        editLokasiRakKatalog.setEditable(true);
                        btnSimpanPerubahanKatalog.setEnabled(true);
                        globalVariabel.editKatalog = 1;
                    }
                else{
                        editJudulKatalog.setEditable(false);
                        editPengarangKatalog.setEditable(false);
                        editPenerbitKatalog.setEditable(false);
                        editISBNKatalog.setEditable(false);
                        editStokKatalog.setEditable(false);
                        editLokasiRakKatalog.setEditable(false);
                        btnSimpanPerubahanKatalog.setEnabled(false);
                        globalVariabel.editKatalog = 0;
                    }
    }//GEN-LAST:event_checkEditKatalogActionPerformed

    private void cekDataUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cekDataUserActionPerformed
        if(globalVariabel.editUser == 0){
                        editNamaUser.setEditable(true);
                        editUsernama.setEditable(true);
                        editPassword.setEditable(true);
                        editLevelling.setEnabled(true);
                        editStatus.setEnabled(true);
                        editPhones.setEditable(true);
                        editAddress.setEditable(true);
                        btnSimpanPerubahanUser.setEnabled(true);
                        globalVariabel.editUser = 1;
                    }
                else{
                        editNamaUser.setEditable(false);
                        editUsernama.setEditable(false);
                        editPassword.setEditable(false);
                        editLevelling.setEnabled(false);
                        editStatus.setEnabled(false);
                        editPhones.setEditable(false);
                        editAddress.setEditable(false);
                        btnSimpanPerubahanUser.setEnabled(false);
                        globalVariabel.editUser = 0;
                    }
    }//GEN-LAST:event_cekDataUserActionPerformed

    private void exitMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuActionPerformed
        exitApplication();
    }//GEN-LAST:event_exitMenuActionPerformed

    private void btnTambahKatalogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahKatalogActionPerformed
        String ID = newIDKatalog.getText();
        String Judul = newJudulKatalog.getText();
        String Pengarang = newPengarangKatalog.getText();
        String Penerbit = newPenerbitKatalog.getText();
        String ISBN = newISBNKatalog.getText();
        String Stok = newStokKatalog.getText();
        String LokasiRak = newLokasiRakKatalog.getText();
        mf.storeKatalog(ID, Judul, Pengarang, Penerbit, ISBN, Stok, LokasiRak);
        db.createKatalog();
        newIDKatalog.setText("");
        newJudulKatalog.setText("");
        newPengarangKatalog.setText("");
        newPenerbitKatalog.setText("");
        newISBNKatalog.setText("");
        newStokKatalog.setText("");
        newLokasiRakKatalog.setText("");
    }//GEN-LAST:event_btnTambahKatalogActionPerformed

    private void tabelKatalogMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelKatalogMouseClicked
        String IDKatalog = tabelKatalog.getValueAt(tabelKatalog.getSelectedRow(), 1).toString();
        mf.storeSelectedKatalog(IDKatalog);
        db.selectKatalog();
        btnHapusData.setEnabled(true);
    }//GEN-LAST:event_tabelKatalogMouseClicked

    private void btnSimpanPerubahanKatalogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanPerubahanKatalogActionPerformed
        String ID = editIDKatalog.getText();
        String Judul = editJudulKatalog.getText();
        String Pengarang = editPengarangKatalog.getText();
        String Penerbit = editPenerbitKatalog.getText();
        String ISBN = editISBNKatalog.getText();
        String Stok = editStokKatalog.getText();
        String LokasiRak = editLokasiRakKatalog.getText();
        mf.storeKatalog(ID, Judul, Pengarang, Penerbit, ISBN, Stok, LokasiRak);
        db.updateKatalog();
        editIDKatalog.setText("");
        editJudulKatalog.setText("");
        editPengarangKatalog.setText("");
        editPenerbitKatalog.setText("");
        editISBNKatalog.setText("");
        editStokKatalog.setText("");
        editLokasiRakKatalog.setText("");
        editIDKatalog.setEditable(false);
        editJudulKatalog.setEditable(false);
        editPengarangKatalog.setEditable(false);
        editPenerbitKatalog.setEditable(false);
        editISBNKatalog.setEditable(false);
        editStokKatalog.setEditable(false);
        editLokasiRakKatalog.setEditable(false);
    }//GEN-LAST:event_btnSimpanPerubahanKatalogActionPerformed

    private void btnHapusDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusDataActionPerformed
        db.deleteKatalog();
        editIDKatalog.setText("");
        editJudulKatalog.setText("");
        editPengarangKatalog.setText("");
        editPenerbitKatalog.setText("");
        editISBNKatalog.setText("");
        editStokKatalog.setText("");
        editLokasiRakKatalog.setText("");
        editIDKatalog.setEditable(false);
        editJudulKatalog.setEditable(false);
        editPengarangKatalog.setEditable(false);
        editPenerbitKatalog.setEditable(false);
        editISBNKatalog.setEditable(false);
        editStokKatalog.setEditable(false);
        editLokasiRakKatalog.setEditable(false);
    }//GEN-LAST:event_btnHapusDataActionPerformed

    private void btnPencarianKatalogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPencarianKatalogActionPerformed
        mf.storeSearchOption(optionPencarianKatalog.getSelectedItem().toString());
        mf.storeSearchQuery(inputPencarianKatalog.getText());
        db.showKatalogSearch();
    }//GEN-LAST:event_btnPencarianKatalogActionPerformed

    private void btnResetTabelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetTabelActionPerformed
        db.showKatalog();
    }//GEN-LAST:event_btnResetTabelActionPerformed

    private void tambahAnggotaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahAnggotaBtnActionPerformed
        String ID = newID.getText();
        String Nama = newNama.getText();
        String Alamat = newAlamat.getText();
        String Telepon = newTelepon.getText();
        String Tanggal = newTanggal.getText();
        mf.storeKeanggotaan(ID, Nama, Alamat, Telepon, Tanggal);
        db.createKeanggotaan();
        newID.setText("");
        newNama.setText("");
        newAlamat.setText("");
        newTelepon.setText("");
        newTanggal.setText("");
        initLevel6();
        cekData.setSelected(false);
        tambahAnggotaBtn.setEnabled(true);
    }//GEN-LAST:event_tambahAnggotaBtnActionPerformed

    private void tabelAnggotaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelAnggotaMouseClicked
        String IDAnggota = tabelAnggota.getValueAt(tabelAnggota.getSelectedRow(), 1).toString();
        mf.storeSelectedKeanggotaan(IDAnggota);
        db.selectKeanggotaan();
        btnHapusKeanggotaan.setEnabled(true);
    }//GEN-LAST:event_tabelAnggotaMouseClicked

    private void simpanPerubahanBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanPerubahanBtnActionPerformed
        String ID = editID.getText();
        String Nama = editNama.getText();
        String Alamat = editAlamat.getText();
        String Telepon = editTelepon.getText();
        String Tanggal = editTanggal.getText();
        mf.storeKeanggotaan(ID, Nama, Alamat, Telepon, Tanggal);
        db.updateKeanggotaan();
        editID.setText("");
        editNama.setText("");
        editAlamat.setText("");
        editTelepon.setText("");
        editTanggal.setText("");
        editID.setEditable(false);
        editNama.setEditable(false);
        editAlamat.setEditable(false);
        editTelepon.setEditable(false);
        editTanggal.setEditable(false);
        initLevel6();
        aktivasiEdit.setSelected(false);
        simpanPerubahanBtn.setEnabled(true);
    }//GEN-LAST:event_simpanPerubahanBtnActionPerformed

    private void btnHapusKeanggotaanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusKeanggotaanActionPerformed
        db.deleteKeanggotaan();
        editID.setText("");
        editNama.setText("");
        editAlamat.setText("");
        editTelepon.setText("");
        editTanggal.setText("");
        editID.setEditable(false);
        editNama.setEditable(false);
        editAlamat.setEditable(false);
        editTelepon.setEditable(false);
        editTanggal.setEditable(false);
    }//GEN-LAST:event_btnHapusKeanggotaanActionPerformed

    private void btnPencarianAnggotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPencarianAnggotaActionPerformed
        mf.storeSearchOption(optionPencarianAnggota.getSelectedItem().toString());
        mf.storeSearchQuery(inputPencarianAnggota.getText());
        db.showKeanggotaanSearch();
    }//GEN-LAST:event_btnPencarianAnggotaActionPerformed

    private void btnResetTabelKeanggotaanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetTabelKeanggotaanActionPerformed
        db.showKeanggotaan();
    }//GEN-LAST:event_btnResetTabelKeanggotaanActionPerformed

    private void getIDUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getIDUserActionPerformed
        newIDUser.setText(new GeneralConfiguration().IDCreator());
    }//GEN-LAST:event_getIDUserActionPerformed

    private void btnTambahUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahUserActionPerformed
        String ID = newIDUser.getText();
        String Nama = newNamaUser.getText();
        String Username = newUsername.getText();
        String Password = newPassword.getText();
        String Level = newLevelling.getSelectedItem().toString();
        String Status = newStatus.getSelectedItem().toString();
        String Telepon = newPhones.getText();
        String Alamat = newAddress.getText();
        mf.storeOperator(ID, Nama, Username, Password, Level, Status, Telepon, Alamat);
        db.createDataUser();
        newIDUser.setText("");
        newNamaUser.setText("");
        newUsername.setText("");
        newPassword.setText("");
        newLevelling.setSelectedItem("Administrator");
        newStatus.setSelectedItem("Aktif");
        newPhones.setText("");
        newAddress.setText("");
    }//GEN-LAST:event_btnTambahUserActionPerformed

    private void tabelUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelUserMouseClicked
        String IDOperator = tabelUser.getValueAt(tabelUser.getSelectedRow(), 1).toString();
        mf.storeSelectedOperator(IDOperator);
        db.selectDataUser();
        btnHapusUser.setEnabled(true);
    }//GEN-LAST:event_tabelUserMouseClicked

    private void btnSimpanPerubahanUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanPerubahanUserActionPerformed
        String ID = editIDUser.getText();
        String Nama = editNamaUser.getText();
        String Username = editUsernama.getText();
        String Password = editPassword.getText();
        String Level = editLevelling.getSelectedItem().toString();
        String Status = editStatus.getSelectedItem().toString();
        String Telepon = editPhones.getText();
        String Alamat = editAddress.getText();
        mf.storeOperator(ID, Nama, Username, Password, Level, Status, Telepon, Alamat);
        db.updateDataUser();
        editIDUser.setText("");
        editNamaUser.setText("");
        editUsernama.setText("");
        editPassword.setText("");
        editLevelling.setSelectedItem("Administrator");
        editStatus.setSelectedItem("Aktif");
        editPhones.setText("");
        editAddress.setText("");
        editIDUser.setEditable(false);
        editNamaUser.setEditable(false);
        editUsernama.setEditable(false);
        editPassword.setEditable(false);
        editLevelling.setEnabled(false);
        editStatus.setEnabled(false);
        editPhones.setEditable(false);
        editAddress.setEditable(false);
        initLevel6();
    }//GEN-LAST:event_btnSimpanPerubahanUserActionPerformed

    private void btnHapusUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusUserActionPerformed
        db.deleteDataUser();
        editIDUser.setText("");
        editNamaUser.setText("");
        editUsernama.setText("");
        editPassword.setText("");
        editLevelling.setSelectedItem("Administrator");
        editStatus.setSelectedItem("Aktif");
        editPhones.setText("");
        editAddress.setText("");
        initLevel6();
        editIDUser.setEditable(false);
        editNamaUser.setEditable(false);
        editUsernama.setEditable(false);
        editPassword.setEditable(false);
        editLevelling.setEnabled(false);
        editStatus.setEnabled(false);
        editPhones.setEditable(false);
        editAddress.setEditable(false);
    }//GEN-LAST:event_btnHapusUserActionPerformed

    private void btnPencarianUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPencarianUserActionPerformed
        mf.storeSearchOption(optionPencarianUser.getSelectedItem().toString());
        mf.storeSearchQuery(inputPencarianUser.getText());
        db.showDataUserSearch();
    }//GEN-LAST:event_btnPencarianUserActionPerformed

    private void btnResetTabelUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetTabelUserActionPerformed
        db.showDataUser();
    }//GEN-LAST:event_btnResetTabelUserActionPerformed

    private void tabelJudulBukuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelJudulBukuMouseClicked
        String IDKatalog = tabelJudulBuku.getValueAt(tabelJudulBuku.getSelectedRow(), 1).toString();
        mf.storeSelectedDaftarJudul(IDKatalog);
    }//GEN-LAST:event_tabelJudulBukuMouseClicked

    private void btnHapusJudulMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHapusJudulMouseClicked
        db.deleteJudulBuku();
    }//GEN-LAST:event_btnHapusJudulMouseClicked

    private void btnCariAnggotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariAnggotaActionPerformed
        String IDAnggota = inputIDAnggota.getText();
        mf.storeIDUserSearch(IDAnggota);
        db.searchIDAnggota();
    }//GEN-LAST:event_btnCariAnggotaActionPerformed

    private void btnSimpanPengaturanDendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanPengaturanDendaActionPerformed
        String TarifDenda = inputTarifDenda.getText();
        String periodeDenda = inputPeriodeDenda.getText();
        mf.storePengaturanDenda(TarifDenda, periodeDenda);
        db.updatePengaturanDenda();
    }//GEN-LAST:event_btnSimpanPengaturanDendaActionPerformed

    private void btnSimpanPengaturanJumlahJudulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanPengaturanJumlahJudulActionPerformed
        String JudulMaksimal = inputJudulMaksimal.getText();
        mf.storePengaturanJumlahJudulMaksimal(JudulMaksimal);
        db.updatePengaturanJudulMaksimal();
    }//GEN-LAST:event_btnSimpanPengaturanJumlahJudulActionPerformed

    private void btnSimpanMasaSirkulasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanMasaSirkulasiActionPerformed
        String masaSirkulasi = inputMaksSirkulasi.getText();
        mf.storePengaturanMasaSirkulasiMaksimal(masaSirkulasi);
        db.updatePengaturanSirkulasiMaksimal();
    }//GEN-LAST:event_btnSimpanMasaSirkulasiActionPerformed

    private void btnKonfirmasiPeminjamanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKonfirmasiPeminjamanActionPerformed
        String IDSirkulasi = new GeneralConfiguration().IDCreator();
        String IDAnggota = inputIDAnggota.getText();
        String TanggalPinjam = inputTanggalPinjam.getText();
        String TanggalKembali = inputTanggalKembali.getText();
        mf.storeSirkulasi(IDSirkulasi, IDAnggota, TanggalPinjam, TanggalKembali);
        int totalData = tabelJudulBuku.getRowCount();
        for(int i=0; i<totalData; i++){
            db.createDetailSirkulasi(tabelJudulBuku.getValueAt(i, 1).toString());
        }
        db.clearJudulBuku();
        db.createDataSirkulasi();
        inputIDAnggota.setText("");
        inputNamaAngfota.setText("");
        inputTanggalPinjam.setText("");
        inputTanggalKembali.setText("");
    }//GEN-LAST:event_btnKonfirmasiPeminjamanActionPerformed

    private void tabelSirkulasiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelSirkulasiMouseClicked
        globalVariabel.IDSirkulasi = tabelSirkulasi.getValueAt(tabelSirkulasi.getSelectedRow(), 1).toString();
        db.selectDataSirkulasi();
        btnKonfirmasiPeminjaman.setEnabled(false);
        btnHapusSirkulasi.setEnabled(true);
        btnTambahJudul.setEnabled(false);
        btnHapusJudul.setEnabled(false);
        btnSetTanggal.setEnabled(false);
        btnPinjamanKembali.setRequestFocusEnabled(true);
        mf.hitungTanggalPengembalian();
    }//GEN-LAST:event_tabelSirkulasiMouseClicked

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        inputIDAnggota.setText("");
        inputNamaAngfota.setText("");
        inputTanggalPinjam.setText("");
        inputTanggalKembali.setText("");
        btnKonfirmasiPeminjaman.setEnabled(true);
        btnTambahJudul.setEnabled(true);
        btnHapusJudul.setEnabled(true);
        btnSetTanggal.setEnabled(true);
        btnPinjamanKembali.setRequestFocusEnabled(false);
        DefaultTableModel tabelKatalog = (DefaultTableModel) Administrator.tabelJudulBuku.getModel();
        int rowCount = tabelKatalog.getRowCount();
            //Remove rows one by one from the end of the table
        for (int i = rowCount - 1; i >= 0; i--) {
            tabelKatalog.removeRow(i);
        }
        initLevel6();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void checkBebasDendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBebasDendaActionPerformed
        if(globalVariabel.cekPengembalian == 0){
            btnPinjamanKembali.setEnabled(true);
            globalVariabel.cekPengembalian = 1;
        }
        else{
            btnPinjamanKembali.setEnabled(false);
            globalVariabel.cekPengembalian = 0;
        }
    }//GEN-LAST:event_checkBebasDendaActionPerformed

    private void btnPinjamanKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPinjamanKembaliActionPerformed
        db.createLaporanDenda();
        db.updateSirkulasi();
        inputIDAnggota.setText("");
        inputNamaAngfota.setText("");
        inputTanggalPinjam.setText("");
        inputTanggalKembali.setText("");
        btnKonfirmasiPeminjaman.setEnabled(true);
        btnTambahJudul.setEnabled(true);
        btnHapusJudul.setEnabled(true);
        btnSetTanggal.setEnabled(true);
        btnPinjamanKembali.setRequestFocusEnabled(false);
        DefaultTableModel tabelKatalog = (DefaultTableModel) Administrator.tabelJudulBuku.getModel();
        int rowCount = tabelKatalog.getRowCount();
            //Remove rows one by one from the end of the table
        for (int i = rowCount - 1; i >= 0; i--) {
            tabelKatalog.removeRow(i);
        }
        initLevel6();
    }//GEN-LAST:event_btnPinjamanKembaliActionPerformed

    private void jMenuItem2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuLogoutMouseClicked
        new loginAplikasi().setVisible(true);
        dispose();
    }//GEN-LAST:event_menuLogoutMouseClicked

    private void btnRestartAplikasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestartAplikasiActionPerformed
        try {
            restartApplication();
        } catch (IOException ex) {
            Logger.getLogger(Administrator.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(Administrator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRestartAplikasiActionPerformed

    private void btnPencarianSirkulasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPencarianSirkulasiActionPerformed
        mf.storeSearchOption(optionPencarianSirkulasi.getSelectedItem().toString());
        mf.storeSearchQuery(inputPencarianSirkulasi.getText());
        db.showSirkulasiSearch();
    }//GEN-LAST:event_btnPencarianSirkulasiActionPerformed

    private void btnResetTabelSirkulasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetTabelSirkulasiActionPerformed
        db.showDaftarSirkulasi();
    }//GEN-LAST:event_btnResetTabelSirkulasiActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        new loginAplikasi().setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void btnProsesDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProsesDataActionPerformed
        globalVariabel.exporter = 1;
        String jenisLaporan = optionManajemenData.getSelectedItem().toString();
        String periodeBulan = bulanStart.getSelectedItem().toString();
        String periodeTahun = tahunStart.getSelectedItem().toString();
        mf.storeLaporan(jenisLaporan, periodeBulan, periodeTahun);
        db.showLaporanManajemen();
        tampilanMultiFungsi.setText(globalVariabel.resultLaporan);
    }//GEN-LAST:event_btnProsesDataActionPerformed

    private void jLabel20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseClicked
        int width = Math.round(MediaSize.ISO.A4.getX(MediaSize.MM));
        int height = Math.round(MediaSize.ISO.A4.getY(MediaSize.MM));
        
        
        MediaPrintableArea mpa = new MediaPrintableArea(20, 20, width-20, height-20,MediaPrintableArea.MM);
        
        HashPrintRequestAttributeSet hpras=new HashPrintRequestAttributeSet(mpa); 
        
        try {
            tampilanMultiFungsi.print(null, null, rootPaneCheckingEnabled, null, hpras, true);
        } catch (PrinterException ex) {
            Logger.getLogger(Administrator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabel20MouseClicked

    private void jLabel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseClicked
        if(globalVariabel.exporter < 1){
            JOptionPane.showMessageDialog(null, "Klik Tombol Proses sebelum melakukan cetak/print!", "Error!", JOptionPane.ERROR_MESSAGE);
        }
        else{
            try {
                db.exportLaporanManajemen();
            } catch (Exception ex) {
                Logger.getLogger(Administrator.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jLabel19MouseClicked

    private void btnResetAplikasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetAplikasiActionPerformed
        if (JOptionPane.showConfirmDialog(null, 
            "Data yang akan dihapus: Anggota, Detail Sirkulasi, Katalog, Laporan Denda, dan Sirkulasi.\nSetelah selesai menghapus data, aplikasi akan restart. \nLanjutkan?", "Konfirmasi Reset Aplikasi", 
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
            db.clearDataAnggota();
            db.clearDataDetailSirkulasi();
            db.clearKatalog();
            db.clearLaporanDenda();
            db.clearSirkulasi();
            JOptionPane.showMessageDialog(null, "Data berhasil di hapus!","Hapus Berhasil",JOptionPane.INFORMATION_MESSAGE);
            try {
                restartApplication();
            } catch (IOException | URISyntaxException ex) {
                Logger.getLogger(Administrator.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnResetAplikasiActionPerformed

    private void btnHapusSirkulasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusSirkulasiActionPerformed
        db.deleteSirkulasi();
        inputIDAnggota.setText("");
        inputNamaAngfota.setText("");
        inputTanggalPinjam.setText("");
        inputTanggalKembali.setText("");
        btnKonfirmasiPeminjaman.setEnabled(true);
        btnTambahJudul.setEnabled(true);
        btnHapusJudul.setEnabled(true);
        btnSetTanggal.setEnabled(true);
        btnPinjamanKembali.setRequestFocusEnabled(false);
        JOptionPane.showMessageDialog(null, "Data Sirkulasi berhasil dihapus");
        btnHapusSirkulasi.setEnabled(false);
    }//GEN-LAST:event_btnHapusSirkulasiActionPerformed

    public void restartApplication() throws IOException, URISyntaxException
{
  final String javaBin = System.getProperty("java.home") + File.separator + "bin" + File.separator + "java";
  final File currentJar = new File(loginAplikasi.class.getProtectionDomain().getCodeSource().getLocation().toURI());

  /* is it a jar file? */
  if(!currentJar.getName().endsWith(".jar"))
    return;

  /* Build command: java -jar application.jar */
  final ArrayList<String> command = new ArrayList<String>();
  command.add(javaBin);
  command.add("-jar");
  command.add(currentJar.getPath());

  final ProcessBuilder builder = new ProcessBuilder(command);
  builder.start();
  System.exit(0);
}
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if (globalVariabel.activeTheme.equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Administrator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Administrator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Administrator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Administrator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Administrator().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JCheckBox aktivasiEdit;
    private javax.swing.JLabel berandaMenu;
    public static javax.swing.JButton btnCariAnggota;
    public static javax.swing.JButton btnHapusData;
    public static javax.swing.JButton btnHapusJudul;
    public static javax.swing.JButton btnHapusKeanggotaan;
    private javax.swing.JButton btnHapusSirkulasi;
    public static javax.swing.JButton btnHapusUser;
    public static javax.swing.JButton btnKonfirmasiPeminjaman;
    public static javax.swing.JButton btnPencarianAnggota;
    public static javax.swing.JButton btnPencarianKatalog;
    public static javax.swing.JButton btnPencarianSirkulasi;
    public static javax.swing.JButton btnPencarianUser;
    public static javax.swing.JButton btnPinjamanKembali;
    public static javax.swing.JButton btnProsesData;
    public static javax.swing.JButton btnRefresh;
    public static javax.swing.JButton btnResetAplikasi;
    public static javax.swing.JButton btnResetTabel;
    public static javax.swing.JButton btnResetTabelKeanggotaan;
    public static javax.swing.JButton btnResetTabelSirkulasi;
    public static javax.swing.JButton btnResetTabelUser;
    public static javax.swing.JButton btnRestartAplikasi;
    public static javax.swing.JButton btnSetTanggal;
    public static javax.swing.JButton btnSimpanMasaSirkulasi;
    public static javax.swing.JButton btnSimpanPengaturanDenda;
    public static javax.swing.JButton btnSimpanPengaturanJumlahJudul;
    public static javax.swing.JButton btnSimpanPerubahanKatalog;
    public static javax.swing.JButton btnSimpanPerubahanUser;
    public static javax.swing.JButton btnTambahJudul;
    public static javax.swing.JButton btnTambahKatalog;
    public static javax.swing.JButton btnTambahUser;
    public static javax.swing.JComboBox<String> bulanStart;
    public static javax.swing.JCheckBox cekData;
    public static javax.swing.JCheckBox cekDataUser;
    public static javax.swing.JCheckBox checkBebasDenda;
    public static javax.swing.JCheckBox checkEditKatalog;
    public static javax.swing.JTextField editAddress;
    public static javax.swing.JTextArea editAlamat;
    public static javax.swing.JTextField editID;
    public static javax.swing.JTextField editIDKatalog;
    public static javax.swing.JTextField editIDUser;
    public static javax.swing.JTextField editISBNKatalog;
    public static javax.swing.JTextField editJudulKatalog;
    public static javax.swing.JComboBox<String> editLevelling;
    public static javax.swing.JTextField editLokasiRakKatalog;
    public static javax.swing.JTextField editNama;
    public static javax.swing.JTextField editNamaUser;
    public static javax.swing.JTextField editPassword;
    public static javax.swing.JTextField editPenerbitKatalog;
    public static javax.swing.JTextField editPengarangKatalog;
    public static javax.swing.JTextField editPhones;
    protected static javax.swing.JComboBox<String> editStatus;
    public static javax.swing.JTextField editStokKatalog;
    public static javax.swing.JTextField editTanggal;
    public static javax.swing.JTextField editTelepon;
    public static javax.swing.JTextField editUsernama;
    private javax.swing.JMenuItem exitMenu;
    private javax.swing.JPanel generalPanel;
    public static javax.swing.JButton getIDUser;
    public static javax.swing.JButton hasilkanIDBtn;
    private javax.swing.JButton hasilkanTanggalBtn;
    public static javax.swing.JTextField inputIDAnggota;
    protected static javax.swing.JTextField inputJudulMaksimal;
    public static javax.swing.JTextField inputMaksSirkulasi;
    public static javax.swing.JTextField inputNamaAngfota;
    public static javax.swing.JTextField inputPencarianAnggota;
    public static javax.swing.JTextField inputPencarianKatalog;
    public static javax.swing.JTextField inputPencarianSirkulasi;
    public static javax.swing.JTextField inputPencarianUser;
    protected static javax.swing.JTextField inputPeriodeDenda;
    public static javax.swing.JTextField inputTanggalKembali;
    public static javax.swing.JTextField inputTanggalPinjam;
    public static javax.swing.JTextField inputTarifDenda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel katalogMenu;
    private javax.swing.JLabel keanggotaanMenu;
    private javax.swing.JMenuItem konfigurasiMenu;
    private javax.swing.JLabel manajemenDataMenu;
    private javax.swing.JMenuItem menuBantuan;
    private javax.swing.JMenuItem menuTentang;
    public static javax.swing.JTextField newAddress;
    public static javax.swing.JTextArea newAlamat;
    public static javax.swing.JTextField newID;
    public static javax.swing.JTextField newIDKatalog;
    public static javax.swing.JTextField newIDUser;
    public static javax.swing.JTextField newISBNKatalog;
    public static javax.swing.JTextField newJudulKatalog;
    public static javax.swing.JComboBox<String> newLevelling;
    public static javax.swing.JTextField newLokasiRakKatalog;
    public static javax.swing.JTextField newNama;
    public static javax.swing.JTextField newNamaUser;
    public static javax.swing.JTextField newPassword;
    public static javax.swing.JTextField newPenerbitKatalog;
    public static javax.swing.JTextField newPengarangKatalog;
    public static javax.swing.JTextField newPhones;
    public static javax.swing.JComboBox<String> newStatus;
    public static javax.swing.JTextField newStokKatalog;
    public static javax.swing.JTextField newTanggal;
    public static javax.swing.JTextField newTelepon;
    public static javax.swing.JTextField newUsername;
    public static javax.swing.JComboBox<String> optionManajemenData;
    public static javax.swing.JComboBox<String> optionPencarianAnggota;
    public static javax.swing.JComboBox<String> optionPencarianKatalog;
    public static javax.swing.JComboBox<String> optionPencarianSirkulasi;
    public static javax.swing.JComboBox<String> optionPencarianUser;
    private javax.swing.JPanel panelBeranda;
    private javax.swing.JPanel panelKatalogGeneral;
    private javax.swing.JPanel panelKeanggotaan;
    private javax.swing.JPanel panelManajemen;
    private javax.swing.JPanel panelPengaturan;
    private javax.swing.JPanel panelSirkulasi;
    private javax.swing.JPanel panelUser;
    private javax.swing.JLabel pengaturanMenu;
    public static javax.swing.JButton simpanPerubahanBtn;
    private javax.swing.JLabel sirkulasiMenu;
    public static javax.swing.JTable tabelAnggota;
    public static javax.swing.JTable tabelJudulBuku;
    public static javax.swing.JTable tabelKatalog;
    public static javax.swing.JTable tabelSirkulasi;
    public static javax.swing.JTable tabelUser;
    public static javax.swing.JComboBox<String> tahunStart;
    public static javax.swing.JButton tambahAnggotaBtn;
    public static javax.swing.JTextPane tampilanMultiFungsi;
    public static javax.swing.JLabel textDenda;
    public static javax.swing.JLabel textStatusKeterlambatan;
    private javax.swing.JLabel userManagementMenu;
    // End of variables declaration//GEN-END:variables
}
