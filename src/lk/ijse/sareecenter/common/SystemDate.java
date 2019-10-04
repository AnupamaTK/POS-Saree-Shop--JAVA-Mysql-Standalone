/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sareecenter.common;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author User
 */
public  class SystemDate {
    
    public static String formatDate;
     public static void loadSystemDate() {
        Date d1 = new Date(); //Current System date
        SimpleDateFormat df = new SimpleDateFormat("YYYY-MM-dd");
        formatDate = df.format(d1);
        //lblDate.setText(formatDate);

    }
}
