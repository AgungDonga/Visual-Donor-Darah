
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Locale;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Eustacc
 */
public class pendonor extends javax.swing.JFrame {

    private DefaultTableModel model;
    private final Connection con = koneksi.getConnection();
    private Statement stt;
    private ResultSet rss;
    private PreparedStatement pst;
    java.util.Date tglsekarang = new java.util.Date();
    private SimpleDateFormat smpdtfmt = new SimpleDateFormat("dd MMMMMMMMM yyyy", Locale.getDefault());
//diatas adalah pengaturan format penulisan, bisa diubah sesuai keinginan.
    private String tanggal = smpdtfmt.format(tglsekarang);

    /**
     * Creates new form pendonor
     */
    public pendonor() {
        initComponents();
        tglskrng.setText(tanggal);
        setJam();
//        tglhariini();
    }

//    private void tglhariini() {
//        Date now = new Date();
//        SimpleDateFormat simpleDateFormat
//                = new SimpleDateFormat("dd MMMM yyyy");
//        String tgl = simpleDateFormat.format(now);
//        tglskrng.setText(tgl);
//
//    }
    private boolean validasi(String nama, String alamat, String donor_ke) { //mthod agar tidk ada data yang sama ketika dibuat
        try { //untuk membuat eksepsi
            stt = con.createStatement(); //agar konek db
            String sql = "SELECT * FROM pendonor where nama='" + nama + "'" + " AND alamat='" + alamat + "'" + " AND donor_ke='" + donor_ke + "'"; //mendeklarasikan variabel sql dengan query untuk menampilkan data sesuai kondisi judul yang ditentukan
            rss = stt.executeQuery(sql); //untuk konek ke db
            if (rss.next()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) { //menangkap sebuah error pada SQL
            System.out.println(e.getMessage());
            return false;
        }
    }

    public final void setJam() {
        ActionListener taskPerformer = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                String nol_jam = "", nol_menit = "", nol_detik = "";

                java.util.Date dateTime = new java.util.Date();
                int nilai_jam = dateTime.getHours();
                int nilai_menit = dateTime.getMinutes();
                int nilai_detik = dateTime.getSeconds();

                if (nilai_jam <= 9) {
                    nol_jam = "0";
                }
                if (nilai_menit <= 9) {
                    nol_menit = "0";
                }
                if (nilai_detik <= 9) {
                    nol_detik = "0";
                }

                String jam = nol_jam + Integer.toString(nilai_jam);
                String menit = nol_menit + Integer.toString(nilai_menit);
                String detik = nol_detik + Integer.toString(nilai_detik);

                lblwaktu.setText(jam + ":" + menit + ":" + detik + "");
            }
        };
        new Timer(1000, taskPerformer).start();
    }

    private void InitTable() {//inisiasi tabel atau membuat table secara manual
        model = new DefaultTableModel(); //instansi class model dari class defaulttablemodel
        model.addColumn("ID PENDONOR"); //membuat kolom judul di instans class model
        model.addColumn("NAMA"); //membuat kolom judul di instans class model
        model.addColumn("ALAMAT"); //membuat kolom penulis di instans class model
        model.addColumn("UMUR"); // membuat kolom harga di instance class model
        model.addColumn("KELAMIN"); // membuat kolom harga di instance class model
        model.addColumn("PEKERJAAN"); // membuat kolom harga di instance class model
        model.addColumn("TANGGAL LAHIR"); // membuat kolom harga di instance class model
        model.addColumn("TELPON"); // membuat kolom harga di instance class model
        model.addColumn("GOLONGAN DARAH"); // membuat kolom harga di instance class model
        model.addColumn("TEKANAN DARAH"); // membuat kolom harga di instance class model
        model.addColumn("SUHU TUBUH"); // membuat kolom harga di instance class model
        model.addColumn("KADAR HB"); // membuat kolom harga di instance class model
        model.addColumn("DENYUT NADI"); // membuat kolom harga di instance class model
        model.addColumn("DARAH DIAMBIL"); // membuat kolom harga di instance class model
        model.addColumn("DONOR KE"); // membuat kolom harga di instance class model
        model.addColumn("DONOR TERAKHIR"); // membuat kolom harga di instance class model
        TABLE.setModel(model); //mengeset instance of class model ke table

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kelamin = new javax.swing.ButtonGroup();
        darah = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        panelGlass1 = new usu.widget.glass.PanelGlass();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        GOL_DARAH = new javax.swing.JComboBox<>();
        TEK_DARAH = new javax.swing.JTextField();
        SUHU_TUBUH = new javax.swing.JTextField();
        KADAR_HB = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        DENYUT_NADI = new javax.swing.JTextField();
        DONOR_KE = new javax.swing.JTextField();
        PROSES = new javax.swing.JButton();
        RESET = new javax.swing.JButton();
        dua50 = new javax.swing.JRadioButton();
        tiga50 = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        DONOR_TERAKHIR = new com.toedter.calendar.JDateChooser();
        NAMA = new javax.swing.JTextField();
        ALAMAT = new javax.swing.JTextField();
        UMUR = new javax.swing.JTextField();
        TELPON = new javax.swing.JTextField();
        PRIA = new javax.swing.JRadioButton();
        WANITA = new javax.swing.JRadioButton();
        PEKERJAAN = new javax.swing.JComboBox<>();
        TGL_LAHIR = new com.toedter.calendar.JDateChooser();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        photo = new javax.swing.JLabel();
        CHOOSE = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TABLE = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tglskrng = new javax.swing.JLabel();
        lblwaktu = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(248, 246, 246));

        jLabel1.setFont(new java.awt.Font("AmbersHand", 0, 18)); // NOI18N
        jLabel1.setText("Nama");

        jLabel2.setFont(new java.awt.Font("AmbersHand", 0, 18)); // NOI18N
        jLabel2.setText("Alamat");

        panelGlass1.setBorder(javax.swing.BorderFactory.createTitledBorder("Blood Control"));

        jLabel16.setFont(new java.awt.Font("AmbersHand", 0, 18)); // NOI18N
        jLabel16.setText("Tekanan Darah");

        jLabel17.setFont(new java.awt.Font("AmbersHand", 0, 18)); // NOI18N
        jLabel17.setText("Golongan Darah");

        jLabel18.setFont(new java.awt.Font("AmbersHand", 0, 18)); // NOI18N
        jLabel18.setText("Suhu Tubuh");

        jLabel19.setFont(new java.awt.Font("AmbersHand", 0, 18)); // NOI18N
        jLabel19.setText("Kadar HB");

        GOL_DARAH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "B", "AB", "O" }));

        SUHU_TUBUH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SUHU_TUBUHActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("AmbersHand", 0, 18)); // NOI18N
        jLabel20.setText("Denyut Nadi");

        jLabel21.setFont(new java.awt.Font("AmbersHand", 0, 18)); // NOI18N
        jLabel21.setText("Darah Diambil");

        jLabel22.setFont(new java.awt.Font("AmbersHand", 0, 18)); // NOI18N
        jLabel22.setText("Donor ke");

        jLabel23.setFont(new java.awt.Font("AmbersHand", 0, 18)); // NOI18N
        jLabel23.setText("Donor Terakhir");

        PROSES.setText("Proses");
        PROSES.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PROSESActionPerformed(evt);
            }
        });

        RESET.setText("Reset");
        RESET.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RESETActionPerformed(evt);
            }
        });

        darah.add(dua50);
        dua50.setText("250");

        darah.add(tiga50);
        tiga50.setText("350");

        jLabel5.setText("cc");

        DONOR_TERAKHIR.setDateFormatString("dd-MM-yyyy");

        javax.swing.GroupLayout panelGlass1Layout = new javax.swing.GroupLayout(panelGlass1);
        panelGlass1.setLayout(panelGlass1Layout);
        panelGlass1Layout.setHorizontalGroup(
            panelGlass1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGlass1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelGlass1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelGlass1Layout.createSequentialGroup()
                        .addGroup(panelGlass1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelGlass1Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addGap(18, 18, 18)
                                .addComponent(GOL_DARAH, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelGlass1Layout.createSequentialGroup()
                                .addGroup(panelGlass1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel18)
                                    .addComponent(jLabel19))
                                .addGap(18, 18, 18)
                                .addGroup(panelGlass1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(KADAR_HB, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(SUHU_TUBUH, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TEK_DARAH, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(65, 65, 65)
                        .addGroup(panelGlass1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addComponent(jLabel21)
                            .addComponent(jLabel22)
                            .addComponent(jLabel23))
                        .addGap(25, 25, 25)
                        .addGroup(panelGlass1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelGlass1Layout.createSequentialGroup()
                                .addGroup(panelGlass1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(DONOR_KE, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(DENYUT_NADI, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panelGlass1Layout.createSequentialGroup()
                                        .addComponent(dua50)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tiga50)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5))
                            .addComponent(DONOR_TERAKHIR, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(118, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGlass1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(RESET, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(PROSES, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13))))
        );
        panelGlass1Layout.setVerticalGroup(
            panelGlass1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGlass1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelGlass1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(GOL_DARAH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20)
                    .addComponent(DENYUT_NADI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelGlass1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelGlass1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel16)
                        .addComponent(TEK_DARAH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel21))
                    .addGroup(panelGlass1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(dua50)
                        .addComponent(tiga50)
                        .addComponent(jLabel5)))
                .addGap(19, 19, 19)
                .addGroup(panelGlass1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(DONOR_KE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SUHU_TUBUH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addGap(18, 18, 18)
                .addGroup(panelGlass1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelGlass1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel23)
                        .addGroup(panelGlass1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(KADAR_HB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(DONOR_TERAKHIR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(panelGlass1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RESET, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PROSES, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        kelamin.add(PRIA);
        PRIA.setText("Pria");

        kelamin.add(WANITA);
        WANITA.setText("Wanita");

        PEKERJAAN.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pegawai Negeri", "Pegawai Swasta", "Polisi", "Dosen/Guru", "Mahasiswa", "Rumah Tangga", "Lainnya" }));

        TGL_LAHIR.setDateFormatString("dd-MM-yyyy");

        jLabel11.setFont(new java.awt.Font("AmbersHand", 0, 18)); // NOI18N
        jLabel11.setText("Umur");

        jLabel12.setFont(new java.awt.Font("AmbersHand", 0, 18)); // NOI18N
        jLabel12.setText("Kelamin");

        jLabel13.setFont(new java.awt.Font("AmbersHand", 0, 18)); // NOI18N
        jLabel13.setText("Pekerjaan");

        jLabel14.setFont(new java.awt.Font("AmbersHand", 0, 18)); // NOI18N
        jLabel14.setText("Tanggal Lahir");

        jLabel15.setFont(new java.awt.Font("AmbersHand", 0, 18)); // NOI18N
        jLabel15.setText("Telpon/Hp");

        photo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Foto", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        CHOOSE.setText("Choose");
        CHOOSE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CHOOSEActionPerformed(evt);
            }
        });

        TABLE.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "id_pendonor", "Nama", "Alamat", "Umur", "Kelamin", "Pekerjaan", "Tanggal Lahir", "Telpon", "Golongan Darah", "Tekanan Darah", "Suhu Tubuh", "Kadar HB", "Denyut Nadi", "Darah Diambil", "Donor Ke", "Donor Terakhir"
            }
        ));
        TABLE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TABLEMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TABLE);
        if (TABLE.getColumnModel().getColumnCount() > 0) {
            TABLE.getColumnModel().getColumn(0).setPreferredWidth(10);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel11)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TELPON, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ALAMAT, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NAMA, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PEKERJAAN, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TGL_LAHIR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(PRIA, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(WANITA, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(UMUR, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addComponent(panelGlass1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(photo, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(CHOOSE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(18, 18, 18)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(1246, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(NAMA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16)
                                .addComponent(ALAMAT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19)
                                .addComponent(UMUR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(84, 84, 84)
                                .addComponent(jLabel11)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel12)
                                    .addComponent(WANITA)
                                    .addComponent(PRIA))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(PEKERJAAN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel14)
                            .addComponent(TGL_LAHIR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(TELPON, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(panelGlass1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(photo, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CHOOSE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(182, 182, 182))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(jLabel2)
                    .addContainerGap(531, Short.MAX_VALUE)))
        );

        jPanel2.setBackground(new java.awt.Color(247, 82, 100));

        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\Eustacc\\Pictures\\aplikasi darah\\bloodbook-covera.jpg")); // NOI18N

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Eustacc\\Pictures\\aplikasi darah\\fb4f40b9153ef43ad0917b2371b54c67a.jpg")); // NOI18N

        jLabel6.setFont(new java.awt.Font("Telegraphem", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(250, 87, 87));
        jLabel6.setText("SISTEM INFORMASI PENYEDIA STOK DARAH PMI UNMUL");

        jLabel7.setBackground(new java.awt.Color(255, 102, 102));
        jLabel7.setFont(new java.awt.Font("CYBERTOOTH", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(161, 36, 36));
        jLabel7.setText("Unit Transfusi Darah PMI Universitas Mulawarman");

        jLabel8.setFont(new java.awt.Font("COUTURE", 0, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 102, 102));
        jLabel8.setText("Jl. Kerayan, Samarinda-Kalimantan Timur");

        tglskrng.setFont(new java.awt.Font("Telegraphem", 0, 18)); // NOI18N
        tglskrng.setText("jLabel9");

        lblwaktu.setFont(new java.awt.Font("Telegraphem", 0, 18)); // NOI18N
        lblwaktu.setText("jLabel9");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel3)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(tglskrng)
                                .addGap(44, 44, 44)
                                .addComponent(lblwaktu)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel8))
                            .addComponent(jLabel7))))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tglskrng)
                        .addComponent(lblwaktu)))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void CHOOSEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CHOOSEActionPerformed
        // TODO add your handling code here:
        JFileChooser OPEN = new JFileChooser();
        int returnVal = OPEN.showOpenDialog(null);

        File filegambar = null;
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            filegambar = OPEN.getSelectedFile();
            String filename = filegambar.getAbsolutePath();
        }
        try {
            BufferedImage gambar = ImageIO.read(filegambar);
            ImageIcon icon = new ImageIcon(gambar.getScaledInstance(175, 230, 0));
            photo.setIcon(icon);

        } catch (IOException e) {
            e.getMessage();
        }
    }//GEN-LAST:event_CHOOSEActionPerformed

    private void TambahData(String nama, String alamat, String umur, String kelamin, String pekerjaan, String tgl_lahir, String telp, String gol_darah, String tek_darah, String suhu_tubuh, String kadar_hb, String denyut_nadi, String darah_diambil, String donor_ke, String donor_terakhir) {
        try {
//            String kelaminnya;
            String sql
                    = "INSERT INTO pendonor VALUES (NULL,'" + nama + "','" + alamat + "','" + umur + "','" + kelamin + "','" + pekerjaan + "','" + tgl_lahir + "','" + telp + "','" + gol_darah + "','" + tek_darah + "','" + suhu_tubuh + "','" + kadar_hb + "','" + denyut_nadi + "','" + darah_diambil + "','" + donor_ke + "','" + donor_terakhir + "')";
            stt = con.createStatement();
            stt.executeUpdate(sql);
            NAMA.setText("");
            ALAMAT.setText("");
            UMUR.setText("");
//            if (PRIA.isSelected()) {
//            kelaminnya = PRIA.getText();
//            } else {
//            if (WANITA.isSelected()) {
//                kelaminnya = WANITA.getText();
//            }
//            }   
            PEKERJAAN.setSelectedItem(0);
//            TGL_LAHIR.;
            TELPON.setText("");
            GOL_DARAH.setSelectedItem(0);
            TEK_DARAH.setText("");
            SUHU_TUBUH.setText("");
            KADAR_HB.setText("");
            DENYUT_NADI.setText("");
//            darah.setSelected(DA, rootPaneCheckingEnabled);
            DONOR_KE.setText("");
            DONOR_TERAKHIR.setDateFormatString("");
            model.addRow(new Object[]{nama, alamat, umur, kelamin, pekerjaan, tgl_lahir, telp, gol_darah, tek_darah, suhu_tubuh, kadar_hb, denyut_nadi, darah_diambil, donor_ke, donor_terakhir});
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void PROSESActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PROSESActionPerformed
//        java.sql.Date sqldate = new java.sql.Date(TGL_LAHIR.getDate().getTime());
        String kelamin = null, darah_ambil = null, tgl_lahir;
        String nama = NAMA.getText();
        String alamat = ALAMAT.getText();
        String umur = UMUR.getText();
        String telpon = TELPON.getText();
        if (PRIA.isSelected()) {
            kelamin = "Pria";
        } else {
            if (WANITA.isSelected()) {
                kelamin = "Wanita";
            }
        }
        String pekerjaan = PEKERJAAN.getSelectedItem().toString();
//        String tgl_lahir = TGL_LAHIR.getDateFormatString();
        java.util.Date d = TGL_LAHIR.getDate();
        if (d == null) {
            System.out.println("No date specified!");
        } else {
            java.sql.Date sqldate = new java.sql.Date(d.getTime());
            tgl_lahir = sqldate;
        }
        String gol_darah = GOL_DARAH.getSelectedItem().toString();
        String tek_darah = TEK_DARAH.getText();
        String suhu = SUHU_TUBUH.getText();
        String kadar_hb = KADAR_HB.getText();
        String denyut_nadi = DENYUT_NADI.getText();
        if (dua50.isSelected()) {
            darah_ambil = "250";
        } else {
            if (tiga50.isSelected()) {
                darah_ambil = "350";
            }
        }
        String donor_ke = DONOR_KE.getText();
        String donor_terakhir = DONOR_TERAKHIR.getDateFormatString();
        if (validasi(nama, alamat, donor_ke)) {
            JOptionPane.showMessageDialog(null, "Judul sudah ada");
        } else {
            TambahData(nama, alamat, umur, kelamin, pekerjaan, tgl_lahir, telpon, gol_darah, tek_darah, suhu, kadar_hb, denyut_nadi, darah_ambil, donor_ke, donor_terakhir);
            InitTable();
            TampilData();
            JOptionPane.showMessageDialog(null, "Kamu Berhasil Bosku");
        }

    }//GEN-LAST:event_PROSESActionPerformed

    private void RESETActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RESETActionPerformed
        // TODO add your handling code here:
        NAMA.setText("");
        ALAMAT.setText("");
        UMUR.setText("");
        TELPON.setText("");
        TEK_DARAH.setText("");
        SUHU_TUBUH.setText("");
        KADAR_HB.setText("");
        DENYUT_NADI.setText("");
        DONOR_KE.setText("");
        kelamin.clearSelection();
        darah.clearSelection();
//        TGL_LAHIR.setDateFormatString("");
//        DONOR_TERAKHIR.setDateFormatString("");
    }//GEN-LAST:event_RESETActionPerformed

    private void TABLEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TABLEMouseClicked
        // TODO add your handling code here:
        int baris = TABLE.getSelectedRow();
        NAMA.setText(TABLE.getValueAt(baris, 1).toString());
        ALAMAT.setText(TABLE.getValueAt(baris, 2).toString());
        UMUR.setText(TABLE.getValueAt(baris, 3).toString());
//        kelamin.S(TABLE.getValueAt(baris, 4).toString());
        PEKERJAAN.setSelectedItem(TABLE.getValueAt(baris, 5).toString());
        TGL_LAHIR.setDateFormatString(TABLE.getValueAt(baris, 6).toString());
        TELPON.setText(TABLE.getValueAt(baris, 7).toString());
        GOL_DARAH.setSelectedItem(TABLE.getValueAt(baris, 8).toString());
        TEK_DARAH.setText(TABLE.getValueAt(baris, 9).toString());
        SUHU_TUBUH.setText(TABLE.getValueAt(baris, 10).toString());
        KADAR_HB.setText(TABLE.getValueAt(baris, 11).toString());
        DENYUT_NADI.setText(TABLE.getValueAt(baris, 12).toString());
//        darah.setText(TABLE.getValueAt(baris, 13).toString());
        DONOR_KE.setText(TABLE.getValueAt(baris, 14).toString());
        DONOR_TERAKHIR.setDateFormatString(TABLE.getValueAt(baris, 15).toString());
    }//GEN-LAST:event_TABLEMouseClicked

    private void SUHU_TUBUHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SUHU_TUBUHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SUHU_TUBUHActionPerformed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(pendonor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pendonor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pendonor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pendonor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new pendonor().setVisible(true);
            }
        });
    }

    private void TampilData() {
        try {
            String sql = "SELECT * from pendonor"; //membuat perintah query yaitu query untuk melihat isi atau data dari table buku
            stt = con.createStatement(); //pembuatan statement
            rss = stt.executeQuery(sql); //eksekusi query
            while (rss.next()) {
                Object[] o = new Object[15];
                o[0] = rss.getString("id_pendonor");
                o[1] = rss.getString("nama");
                o[2] = rss.getString("alamat");
                o[3] = rss.getString("umur");
                o[4] = rss.getString("kelamin");
                o[5] = rss.getString("pekerjaan");
                o[6] = rss.getString("tgl_lahir");
                o[7] = rss.getString("telp");
                o[8] = rss.getString("gol_darah");
                o[9] = rss.getString("tek_darah");
                o[10] = rss.getString("suhu_tubuh");
                o[11] = rss.getString("kadar_hb");
                o[12] = rss.getString("denyut_nadi");
                o[13] = rss.getString("darah_diambil");
                o[14] = rss.getString("donor_ke");
                o[15] = rss.getString("donor_terakhir");
                model.addRow(o);
            }
//            rss.close(); //menutup rss
//            stt.close(); //menutup stt
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ALAMAT;
    private javax.swing.JButton CHOOSE;
    private javax.swing.JTextField DENYUT_NADI;
    private javax.swing.JTextField DONOR_KE;
    private com.toedter.calendar.JDateChooser DONOR_TERAKHIR;
    private javax.swing.JComboBox<String> GOL_DARAH;
    private javax.swing.JTextField KADAR_HB;
    private javax.swing.JTextField NAMA;
    private javax.swing.JComboBox<String> PEKERJAAN;
    private javax.swing.JRadioButton PRIA;
    private javax.swing.JButton PROSES;
    private javax.swing.JButton RESET;
    private javax.swing.JTextField SUHU_TUBUH;
    private javax.swing.JTable TABLE;
    private javax.swing.JTextField TEK_DARAH;
    private javax.swing.JTextField TELPON;
    private com.toedter.calendar.JDateChooser TGL_LAHIR;
    private javax.swing.JTextField UMUR;
    private javax.swing.JRadioButton WANITA;
    private javax.swing.ButtonGroup darah;
    private javax.swing.JRadioButton dua50;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.ButtonGroup kelamin;
    private javax.swing.JLabel lblwaktu;
    private usu.widget.glass.PanelGlass panelGlass1;
    private javax.swing.JLabel photo;
    private javax.swing.JLabel tglskrng;
    private javax.swing.JRadioButton tiga50;
    // End of variables declaration//GEN-END:variables
}
