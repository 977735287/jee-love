package per.san.common.utils;

/**
 * description: String工具类
 *
 * @author shencai.huang@hand-china.com
 * @date 12/18/2018 19:47
 * lastUpdateBy: shencai.huang@hand-china.com
 * lastUpdateDate: 12/18/2018
 */
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
