package per.san;

import per.san.sys.domain.BaseDomain;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * description:
 *
 * @author shencai.huang@hand-china.com
 * @date 12/27/2018 19:15
 * lastUpdateBy: shencai.huang@hand-china.com
 * lastUpdateDate: 12/27/2018
 */
public class Test {
    public static void main(String[] args) {

        Class<?> clz = new BaseDomain().getClass();
        Field[] fields = clz.getDeclaredFields();
        List<String> list = new ArrayList<>();
        for (Field field : fields) {
            list.add(field.getName());
        }
        List<String> exists = new ArrayList<>();
        exists.add("createdBy");
        exists.add("creationDate");
        list.stream().filter(item -> !exists.contains(item)).collect(Collectors.toList());
        System.out.println(list);





//        List<String> list = new ArrayList<>();
//        list.add("aaaaaa");
//        list.add("bbbbbb");
//        list.add("cccccccccc");
//        list.add("dddddddddd");
//        list.add("eeeeeeeeeee");
//        list.add("ggggggg");
//        Test2 test2 = new Test2();
//        test2.setList(list);
//        System.out.println(test2.getList());
//        System.out.println(test2.getList());
//        System.out.println(test2.getList());
//        System.out.println(test2.getSize());
//        System.out.println(test2.getSize());
//        System.out.println(test2.getSize());
    }
}
