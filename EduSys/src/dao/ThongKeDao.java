
package dao;

import helper.XJDBC;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ThongKeDao {

    public List<Object[]> getBangDiem(Integer maKH) {
        List<Object[]> list = new ArrayList<>();
        String sql = "{call sp_BangDiem(?)}";
        try {
            ResultSet rs = null;
            try {
                rs = XJDBC.query(sql, maKH);
                while (rs.next()) {
                    double diem = rs.getDouble("Diem");
                    String xepLoai = "Xuất sắc";
                    if (diem < 0) {
                        xepLoai = "Chưa nhập";
                    } else if (diem < 3) {
                        xepLoai = "Yếu";
                    } else if (diem < 5) {
                        xepLoai = "Kém";
                    } else if (diem < 6.5) {
                        xepLoai = "Trung bình";
                    } else if (diem < 7.5) {
                        xepLoai = "Khá";
                    } else if (diem < 9) {
                        xepLoai = "Giỏi";
                    }
                    Object[] model = new Object[]{rs.getString("MaNH"), rs.getString("HoTen"), diem, xepLoai};
                    list.add(model);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public List<Object[]> getDoanhThu(Integer nam) {
        List<Object[]> list = new ArrayList<>();
        String sql = "{call [sp_ThongKeDoanhThu](?)}";
        ResultSet rs = null;
        try {
            try {
                rs = XJDBC.query(sql, nam);
                while (rs.next()) {
                    Object[] model = new Object[]{rs.getString("ChuyenDe"), rs.getInt("SoKH"), rs.getInt("SoHV"),
                        rs.getDouble("DoanhThu"), rs.getDouble("ThapNhat"), rs.getDouble("CaoNhat"), rs.getDouble("TrungBinh")};
                    list.add(model);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException e) {
            throw  new RuntimeException(e);
        }
        return list;
    }
    
    public List<Object[]> getNguoiHoc() {
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            String sql = "{call sp_ThongKeNguoiHoc}";
            try {
                rs = XJDBC.query(sql);
                while(rs.next()) {
                    Object[] model = new Object[] {rs.getString("Nam"), rs.getInt("SoLuong"), rs.getDate("DauTien"), rs.getDate("CuoiCung")};
                    list.add(model);
                }
            } finally{
                rs.getStatement().getConnection().close();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    
    public List<Object[]> getDiemTheoChuyenDe() {
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJDBC.query("{call sp_ThongKeDiem}");
                while(rs.next()) {
                    Object[] model = new Object[] {rs.getString("ChuyenDe"), rs.getInt("SoHV"), rs.getDouble("ThapNhat"),
                    rs.getDouble("CaoNhat"), rs.getDouble("TrungBinh")};
                    list.add(model);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return list;
    }
}
