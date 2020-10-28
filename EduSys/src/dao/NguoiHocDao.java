/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.NguoiHoc;
import helper.XJDBC;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import view.NguoiHocJInternalFrame;

/**
 *
 * @author Admin
 */
public class NguoiHocDao extends EduSysDao<NguoiHoc, String>{
    String insertsql = "INSERT INTO NguoiHoc VALUES(?,?,?,?,?,?,?,?,?)";
    String updatesql = "UPDATE NguoiHoc SET HoTen = ?, NgaySinh = ?, GioiTinh = ?, DienThoai = ?, Email = ?, GhiChu = ?, MaNV = ?, NgayDK = ? WHERE MaNH = ?";
    String deletesql = "DELETE FROM NguoiHoc WHERE MaNH = ?";
    String selectallsql = "SELECT * FROM NguoiHoc";
    String selectbyidsql = "SELECT * FROM NguoiHoc WHERE MaNH = ?";
    String selectbycouresql = "SELECT * FROM NguoiHoc WHERE MaNH NOT IN (SELECT MaNH FROM HocVien WHERE MaKH = ?) and HoTen LIKE ?";
    String selectbynamesql = "SELECT * FROM NguoiHoc WHERE HoTen LIKE ?";
    @Override
    public void insert(NguoiHoc entity) {
        XJDBC.update(insertsql,entity.getMaNH(), entity.getHoTen(), entity.getNgaySinh(), entity.getGioiTinh(), entity.getDienThoai(), entity.getEmail(), entity.getGhiChu(),
                entity.getMaNV(), entity.getNgayDK());
    }

    @Override
    public void update(NguoiHoc entity) {
        XJDBC.update(updatesql, entity.getHoTen(), entity.getNgaySinh(), entity.getGioiTinh(), entity.getDienThoai(), entity.getEmail(), entity.getGhiChu(),
                entity.getMaNV(), entity.getNgayDK(), entity.getMaNH());
    }

    @Override
    public void delete(String key) {
        XJDBC.update(deletesql, key);
    }

    @Override
    public List<NguoiHoc> selectAll() {
        return selectBySQL(selectallsql);
    }

    @Override
    public NguoiHoc selectByID(String key) {
        List<NguoiHoc> list = selectBySQL(selectbyidsql, key);
        if(list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
    
    public List<NguoiHoc> selectByCoure(Integer key, String name) {
        return  selectBySQL(selectbycouresql, key, "%" + name + "%");
    }
    
    public List<NguoiHoc> selectByName(String name) {
        return selectBySQL(selectbynamesql, "%" + name + "%");
    }
    
    @Override
    protected List<NguoiHoc> selectBySQL(String sql, Object... arg) {
        List<NguoiHoc> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJDBC.query(sql, arg);
                while(rs.next()) {
                    list.add(new NguoiHoc(rs.getString("MaNH"), rs.getString("HoTen"), rs.getDate("NgaySinh"), rs.getInt("GioiTinh"), rs.getString("DienThoai"), rs.getString("Email"),
                            rs.getString("Ghichu"), rs.getString("MaNV"), rs.getDate("NgayDK")));
                }
            }finally{
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
