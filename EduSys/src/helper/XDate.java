
package helper;

import java.text.SimpleDateFormat;
import java.util.Date;

public class XDate {
    static SimpleDateFormat formater = new SimpleDateFormat();
    public static Date toDate(String date, String patten) {
        try {
            formater.applyPattern(patten);
            return formater.parse(date);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    
}
