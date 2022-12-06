package Classes;
import java.time.format.DateTimeFormatter;
import Interfaces.IJournal;
import java.time.LocalDateTime; 
public class AffichageDate implements IJournal {
    String message;
     static String className;
    public AffichageDate(){}
    @Override
    public void outPut_Msg(String message) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();  
        System.out.println(dtf.format(now)); 
        System.out.println(message + "from : " + className);
    }
    public static void setClassName(String classname){
        className = classname;
    }
}
