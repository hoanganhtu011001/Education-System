package helper;
import entity.NhanVien;
public class Auth {
    public static NhanVien user = null;
    public static boolean isLogin(){
        return Auth.user != null;
    }
    public static boolean isManager(){
        return Auth.isLogin()&&Auth.user.isVaiTro();
    }
}
