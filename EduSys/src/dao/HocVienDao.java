/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.HocVien;
import helper.XJDBC;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class HocVienDao extends EduSysDao<HocVien, Integer>{
    String selectbykh = "SELECT * FROM HocVien WHERE MaKH = ?";
    String insertsql = "INSERT INTO HocVien VALUES (?, ?, ?)";
    String updatesql = "UPDATE HocVien SET Diem = ? WHERE MaHV = ?";
    String deletesql = "DELETE FROM HocVien WHERE MaHV = ?";
    @Override
    public void insert(HocVien entity) {
        XJDBC.update(insertsql, entity.getMaKH(), entity.getMaNH(), entity.getDiem());
    }

    @Override
    public void update(HocVien entity) {
        XJDBC.update(updatesql, entity.getDiem(), entity.getMaHV());
    }

    @Override
    public void delete(Integer key) {
        XJDBC.update(deletesql, key);
    }

    @Override
    public List<HocVien> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HocVien selectByID(Integer key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public List<HocVien> selectByCoure(int key) {
        List<HocVien> list = selectBySQL(selectbykh, key);
        return list;
    }
    @Override
    protected List<HocVien> selectBySQL(String sql, Object... arg) {
        List<HocVien> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJDBC.query(sql, arg);
                while(rs.next()) {
                    HocVien hv = new HocVien(rs.getInt("MaHV"), rs.getInt("MaKH"), rs.getString("MaNH"), rs.getDouble("Diem"));
                    list.add(hv);                
                }
            } finally{
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
