
package dao;

import entity.KhoaHoc;
import helper.XJDBC;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class KhoaHocDao extends EduSysDao<KhoaHoc, Integer>{
    String selectallsql = "SELECT * FROM KhoaHoc";
    String insertsql = "INSERT INTO KhoaHoc VALUES (?,?,?,?,?,?,?)";
    String updatesql = "UPDATE KhoaHoc SET NgayKG = ?, GhiChu = ?, MaNV = ?, NgayTao = ? WHERE MaKH = ?";
    String deletesql = "DELETE KhoaHoc WHERE MaKH = ?";
    String selectbyidsql = "SELECT * FROM KhoaHoc WHERE MaKH = ?";
    String selectbycdsql = "SELECT * FROM KhoaHoc Where MaCD = ?";
    @Override
    public void insert(KhoaHoc entity) {
        XJDBC.update(insertsql, entity.getMaCD(), entity.getHocPhi(), entity.getThoiLuong(), entity.getNgayKG(), entity.getGhiChu(), entity.getMaNV(), entity.getNgayTao());
    }

    @Override
    public void update(KhoaHoc entity) {
        XJDBC.update(updatesql, entity.getNgayKG(), entity.getGhiChu(), entity.getMaNV(), entity.getNgayTao(), entity.getMaKH());
    }

    @Override
    public void delete(Integer key) {
        XJDBC.update(deletesql, key);
    }

    @Override
    public List<KhoaHoc> selectAll() {
        List<KhoaHoc> list = selectBySQL(selectallsql);
        return list;
    }

    @Override
    public KhoaHoc selectByID(Integer key) {
        List<KhoaHoc> list = selectBySQL(selectbyidsql, key);
        if(list.isEmpty()){
            return null;
        }
        return list.get(0);
    }

    public List<KhoaHoc> selectByCD(String key){
        List<KhoaHoc> list = selectBySQL(selectbycdsql, key);
        return list;
    }
    
    @Override
    protected List<KhoaHoc> selectBySQL(String sql, Object... arg) {
        List<KhoaHoc> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJDBC.query(sql, arg);
                while(rs.next()) {
                    list.add(new KhoaHoc(rs.getInt("MaKH"), rs.getString("MaCD"), rs.getDouble("HocPhi"), rs.getInt("ThoiLuong"), rs.getDate("NgayKG"), rs.getString("GhiChu"), 
                            rs.getString("MaNV"), rs.getDate("NgayTao")));
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
