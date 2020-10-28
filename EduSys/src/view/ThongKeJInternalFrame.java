package view;
import dao.KhoaHocDao;
import dao.ThongKeDao;
import entity.KhoaHoc;
import helper.Auth;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
public final class ThongKeJInternalFrame extends javax.swing.JInternalFrame {

    public ThongKeJInternalFrame() {
        initComponents();
        setTitle("TỔNG HỢP THỐNG KÊ");
        fillToCboKhoaHoc();
        fillToCBoNam();
        fillToTableNguoiHoc();
        fillToTableKhoaHoc();
        if (!Auth.isManager()) {
            tabs.remove(3);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabs = new javax.swing.JTabbedPane();
        nguoihoc = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNguoiHoc = new javax.swing.JTable();
        bangdiem = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblBangDiem = new javax.swing.JTable();
        cboKhoaHoc = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        tonghopdiem = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblKhoaHoc = new javax.swing.JTable();
        doanhthu = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        cboNam = new javax.swing.JComboBox<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblDoanhThu = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        tblNguoiHoc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NĂM", "SỐ NGƯỜI HỌC", "ĐẦU TIÊN", "SAU CÙNG"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblNguoiHoc);

        javax.swing.GroupLayout nguoihocLayout = new javax.swing.GroupLayout(nguoihoc);
        nguoihoc.setLayout(nguoihocLayout);
        nguoihocLayout.setHorizontalGroup(
            nguoihocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 806, Short.MAX_VALUE)
        );
        nguoihocLayout.setVerticalGroup(
            nguoihocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nguoihocLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        tabs.addTab("NGƯỜI HỌC", nguoihoc);

        tblBangDiem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MÃ NH", "HỌ VÀ TÊN", "ĐIỂM", "XẾP LOẠI"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblBangDiem);

        cboKhoaHoc.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboKhoaHocItemStateChanged(evt);
            }
        });

        jLabel2.setText("Khóa học");

        javax.swing.GroupLayout bangdiemLayout = new javax.swing.GroupLayout(bangdiem);
        bangdiem.setLayout(bangdiemLayout);
        bangdiemLayout.setHorizontalGroup(
            bangdiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 806, Short.MAX_VALUE)
            .addGroup(bangdiemLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboKhoaHoc, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        bangdiemLayout.setVerticalGroup(
            bangdiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bangdiemLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bangdiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cboKhoaHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE))
        );

        tabs.addTab("BẢNG ĐIỂM", bangdiem);

        tblKhoaHoc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CHUYÊN ĐỀ", "TỔNG SỐ HV", "THẤP NHẤT", "CAO NHẤT", "ĐIỂM TB"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblKhoaHoc);

        javax.swing.GroupLayout tonghopdiemLayout = new javax.swing.GroupLayout(tonghopdiem);
        tonghopdiem.setLayout(tonghopdiemLayout);
        tonghopdiemLayout.setHorizontalGroup(
            tonghopdiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 806, Short.MAX_VALUE)
        );
        tonghopdiemLayout.setVerticalGroup(
            tonghopdiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE)
        );

        tabs.addTab("TỔNG HỢP ĐIỂM", tonghopdiem);

        jLabel3.setText("Năm");

        cboNam.setToolTipText("");
        cboNam.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboNamItemStateChanged(evt);
            }
        });
        cboNam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboNamActionPerformed(evt);
            }
        });

        tblDoanhThu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CHUYÊN ĐỀ", "SỐ KHÓA", "SỐ HỌC VIÊN", "DOANH THU", "HP CAO NHẤT", "HP THẤP NHẤT", "HP TRUNG BÌNH"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tblDoanhThu);

        javax.swing.GroupLayout doanhthuLayout = new javax.swing.GroupLayout(doanhthu);
        doanhthu.setLayout(doanhthuLayout);
        doanhthuLayout.setHorizontalGroup(
            doanhthuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(doanhthuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cboNam, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 806, Short.MAX_VALUE)
        );
        doanhthuLayout.setVerticalGroup(
            doanhthuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(doanhthuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(doanhthuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cboNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE))
        );

        tabs.addTab("DOANH THU", doanhthu);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 204));
        jLabel1.setText("TỔNG HỢP THỐNG KÊ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(tabs))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabs, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cboNamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboNamActionPerformed

    }//GEN-LAST:event_cboNamActionPerformed

    private void cboNamItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboNamItemStateChanged
        fillTableDoanhThu();
    }//GEN-LAST:event_cboNamItemStateChanged

    private void cboKhoaHocItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboKhoaHocItemStateChanged
        fillTableBangDiem();
    }//GEN-LAST:event_cboKhoaHocItemStateChanged

    
    ThongKeDao dao = new ThongKeDao();
    KhoaHocDao khdao = new KhoaHocDao();
    public void fillToCboKhoaHoc() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cboKhoaHoc.getModel();
        model.removeAllElements();
        List<KhoaHoc> list = khdao.selectAll();
        for(KhoaHoc kh : list){
            model.addElement(kh);
        }
    }
    public void fillTableBangDiem(){
        DefaultTableModel model = (DefaultTableModel) tblBangDiem.getModel();
        model.setRowCount(0);
        KhoaHoc kh = (KhoaHoc) cboKhoaHoc.getSelectedItem();
        int maKH = kh.getMaKH();
        List<Object[]> list = dao.getBangDiem(maKH);
        list.forEach((row) -> {
            model.addRow(row);
        });
    }
    public void fillToCBoNam() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cboNam.getModel();
        model.removeAllElements();
        List<KhoaHoc> list = khdao.selectAll();
        for(KhoaHoc kh : list) {
            int nam = kh.getNgayKG().getYear() + 1900;
            if(model.getIndexOf(nam) < 0) {
                model.addElement(nam);
            }
        }
    }
    public void fillTableDoanhThu() {
        DefaultTableModel model = (DefaultTableModel) tblDoanhThu.getModel();
        model.setRowCount(0);
        int nam = Integer.parseInt(cboNam.getSelectedItem()+"");
        List<Object[]> list = dao.getDoanhThu(nam);
        list.forEach((row) -> {
            model.addRow(row);
        });
    }
    
    public void fillToTableNguoiHoc() {
        DefaultTableModel model = (DefaultTableModel) tblNguoiHoc.getModel();
        model.setRowCount(0);
        List<Object[]> list = dao.getNguoiHoc();
        list.forEach((row) -> {
            model.addRow(row);
        });
    }
    
    public void fillToTableKhoaHoc() {
        DefaultTableModel model = (DefaultTableModel) tblKhoaHoc.getModel();
        model.setRowCount(0);
        List<Object[]> list = dao.getDiemTheoChuyenDe();
        list.forEach((row) -> {
            model.addRow(row);
        });  
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JPanel bangdiem;
    private javax.swing.JComboBox<String> cboKhoaHoc;
    private javax.swing.JComboBox<String> cboNam;
    public javax.swing.JPanel doanhthu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    public javax.swing.JPanel nguoihoc;
    public javax.swing.JTabbedPane tabs;
    private javax.swing.JTable tblBangDiem;
    private javax.swing.JTable tblDoanhThu;
    private javax.swing.JTable tblKhoaHoc;
    private javax.swing.JTable tblNguoiHoc;
    public javax.swing.JPanel tonghopdiem;
    // End of variables declaration//GEN-END:variables
}
