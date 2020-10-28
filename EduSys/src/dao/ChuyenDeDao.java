/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.ChuyenDe;
import helper.XJDBC;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class ChuyenDeDao extends EduSysDao<ChuyenDe, String>{
    String insertsql = "INSERT INTO ChuyenDe VALUES (?,?,?,?,?,?)";
    String updatesql = "UPDATE ChuyenDe SET TenCD = ? , HocPhi = ?, ThoiLuong = ?, Hinh = ?, MoTa = ? WHERE MaCD = ?";
    String deletesql = "DELETE FROM ChuyenDe WHERE MaCD = ?";
    String selectallsql = "SELECT * FROM ChuyenDe";
    String selectbyidsql = "SElECT * FROM ChuyenDe WHERE MaCD = ?";
    @Override
    public void insert(ChuyenDe entity) {
        XJDBC.update(insertsql, entity.getMaCD(), entity.getTenCD(), entity.getHocPhi(), entity.getThoiLuong(), entity.getHinh(), entity.getMoTa());
    }

    @Override
    public void update(ChuyenDe entity) {
        XJDBC.update(updatesql, entity.getTenCD(), entity.getHocPhi(), entity.getThoiLuong(), entity.getHinh(), entity.getMoTa(), entity.getMaCD());
    }

    @Override
    public void delete(String key) {
        XJDBC.update(deletesql, key);
    }

    @Override
    public List<ChuyenDe> selectAll() {
        return selectBySQL(selectallsql);
    }

    @Override
    public ChuyenDe selectByID(String key) {
        List<ChuyenDe> list =  selectBySQL(selectbyidsql, key);
        if(list.isEmpty()){
            return null;
        }
        return list.get(0);
    }
    
    @Override
    protected List<ChuyenDe> selectBySQL(String sql, Object... arg) {
        List<ChuyenDe> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJDBC.query(sql, arg);
                while(rs.next()) {
                    ChuyenDe cd = new ChuyenDe(rs.getString("MaCD"),rs.getString("TenCD"), rs.getDouble("HocPhi"), rs.getInt("ThoiLuong"), rs.getString("Hinh"), rs.getString("MoTa"));
                    list.add(cd);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    
}
