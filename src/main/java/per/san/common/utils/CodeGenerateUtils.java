package per.san.common.utils;

import freemarker.template.Template;
import per.san.common.CommonConstant;
import per.san.generate.domain.Table;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * description: 代码生成器
 *
 * @author shencai.huang@hand-china.com
 * @date 12/10/2018 17:10
 * lastUpdateBy: shencai.huang@hand-china.com
 * lastUpdateDate: 12/10/2018
 */
public class CodeGenerateUtils {

    private static final String AUTHOR = "sanchar";

    private static Date CURRENT_DATE;

    private static String TARGET_PATH;

    private static String PACKAGE_PATH;

    private static String MAPPER_XML_PATH;

    static {
        CURRENT_DATE = new Date();
        TARGET_PATH = System.getProperty("user.dir") + "\\src\\main\\";
        PACKAGE_PATH = "per\\san\\demo\\";
        MAPPER_XML_PATH = "mapper\\demo\\";
    }

    public static void generate(Table table){
        generateModelFile(table);
        generateMapperXmlFile(table);
        generateMapperFile(table);
        generateServiceImplFile(table);
        generateServiceFile(table);
        generateControllerFile(table);
    }

    private static void generateModelFile(Table table){
        String suffix = ".java";
        String path = TARGET_PATH + "java\\" + PACKAGE_PATH + "domain\\" + table.getClassName() + suffix;
        String templateName = "Model.ftl";
        generateFile(table, path, PACKAGE_PATH, templateName);
    }

    private static void generateMapperXmlFile(Table table){
        String suffix = "Mapper.xml";
        String path = TARGET_PATH + "resources\\" + MAPPER_XML_PATH + table.getClassName() + suffix;
        String templateName = "MapperXml.ftl";
        generateFile(table, path, PACKAGE_PATH, templateName);
    }

    private static void generateMapperFile(Table table){
        String suffix = "Mapper.java";
        String path = TARGET_PATH + "java\\" + PACKAGE_PATH + "mapper\\" + table.getClassName() + suffix;
        String templateName = "Mapper.ftl";
        generateFile(table, path, PACKAGE_PATH, templateName);
    }

    private static void generateServiceImplFile(Table table){
        String suffix = "ServiceImpl.java";
        String path = TARGET_PATH + "java\\" + PACKAGE_PATH + "service\\impl\\" + table.getClassName() + suffix;
        String templateName = "ServiceImpl.ftl";
        generateFile(table, path, PACKAGE_PATH, templateName);
    }

    private static void generateServiceFile(Table table){
        String suffix = "Service.java";
        String path = TARGET_PATH + "java\\" + PACKAGE_PATH + "service\\I" + table.getClassName() + suffix;
        String templateName = "Service.ftl";
        generateFile(table, path, PACKAGE_PATH, templateName);
    }

    private static void generateControllerFile(Table table){
        String suffix = "Controller.java";
        String path = TARGET_PATH + "java\\" + PACKAGE_PATH + "controller\\" + table.getClassName() + suffix;
        String templateName = "Controller.ftl";
        generateFile(table, path, PACKAGE_PATH, templateName);
    }

    private static void generateFile(Table table, String path, String packagePath, String templateName){
        File file = new File(path);
        Map<String,Object> dataMap = new HashMap<>(2);
        dataMap.put("table",table);
        String packageName = packagePath.substring(0, packagePath.length()-1);
        if(packageName.contains(CommonConstant.SLASH)){
            packageName = packageName.replace(CommonConstant.SLASH, ".");
        }
        if(packageName.contains(CommonConstant.BACK_SLASH)){
            packageName = packageName.replace(CommonConstant.BACK_SLASH, ".");
        }
        dataMap.put("packageName",packageName);
        try {
            generateFileByTemplate(templateName,file,dataMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void generateFileByTemplate(final String templateName, File file, Map<String, Object> dataMap) throws Exception {
        Template template = FreeMarkerTemplateUtils.getTemplate(templateName);
        FileOutputStream fos = new FileOutputStream(file);
        dataMap.put("author", AUTHOR);
        dataMap.put("date", CURRENT_DATE);
        Writer out = new BufferedWriter(new OutputStreamWriter(fos, "utf-8"), 10240);
        template.process(dataMap, out);
    }
}
