package per.san.common.utils;

public class StringUtils extends org.springframework.util.StringUtils {

    public static String replaceUnderLine(String str){
        StringBuffer sb = new StringBuffer();
        sb.append(str);
        int count = sb.indexOf("_");
        while(count!=0){
            int num = sb.indexOf("_",count);
            count = num + 1;
            if(num != -1){
                char ss = sb.charAt(count);
                char ia = (char) (ss - 32);
                sb.replace(count , count + 1,ia + "");
            }
        }
        return sb.toString().replaceAll("_","");
    }

    public static String replaceUnderLineAndUpperCase(String str){
        return capitalize(replaceUnderLine(str));
    }
}
