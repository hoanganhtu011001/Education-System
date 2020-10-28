package dao;

import entity.NhanVien;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NhanVienDao extends EduSysDao<NhanVien, String> {
    String insertsql = "INSERT INTO NhanVien VALUES(?,?,?,?)";
    String updatesql = "UPDATE NhanVien SET HoTen = ?, VaiTro = ?, MatKhau = ? WHERE MaNV = ?";
    String deletesql = "DELETE FROM NhanVien WHERE MaNV = ?";
    String selectbyidsql = "SELECT * FROM NhanVien WHERE MaNV = ?";
    String selectAllsql = "SELECT * FROM NhanVien";
    String selectaccountsql = "SELECT * FROM NhanVien WHERE MaNV = ? and MatKhau = ?";
    @Override
    public void insert(NhanVien entity) {
        helper.XJDBC.update(insertsql, entity.getMaNV(),entity.getHoTen(), entity.getMatKhau(), entity.isVaiTro());
    }

    @Override
    public void update(NhanVien entity) {
        helper.XJDBC.update(updatesql, entity.getHoTen(), entity.isVaiTro(), entity.getMatKhau(), entity.getMaNV());
    }

    @Override
    public void delete(String key) {
        helper.XJDBC.update(deletesql, key);
    }

    @Override
    public List<NhanVien> selectAll() {
        return selectBySQL(selectAllsql);
    }

    @Override
    public NhanVien selectByID(String key) {
        List<NhanVien> list = selectBySQL(selectbyidsql, key);
        if(list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
    public NhanVien selectAccount(String maNV, String matKhau) {
        List<NhanVien> list = selectBySQL(selectaccountsql, maNV, matKhau);
        if(list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
    @Override
    protected List<NhanVien> selectBySQL(String sql, Object... arg) {
        List<NhanVien> list = new ArrayList<>();
        try {
            ResultSet rs = helper.XJDBC.query(sql, arg);
                while (rs.next()) {
                    list.add(new NhanVien(rs.getString("MaNV"), rs.getString("MatKhau"), rs.getString("HoTen"), rs.getBoolean("VaiTro")));
                }
                rs.getStatement().getConnection().close();
                return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
    }

}
