
package View;

import javax.swing.JOptionPane;

public class Alerts {
    /**
     * 
     * @param msg Displays @msg in JOptionPane 
     */
    public static void alert(String msg) {
        JOptionPane.showMessageDialog(null, msg);
    } 
    /**
     * 
     * @param str String to test
     * @return true: @str size is greater then 0
     */
    public static boolean isEmpty(String str) {
        return str.equalsIgnoreCase("");
    } 
}

