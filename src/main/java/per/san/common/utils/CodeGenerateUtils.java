package per.san.common.utils;

import freemarker.template.Template;
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

    private static final String AUTHOR = "shencai.huang@hand-china.com";

    private static final Date CURRENT_DATE = new Date();

    public static void generateModelFile(Table table, String packageName) throws Exception{
        final String suffix = ".java";
        final String path = "C:\\workspaces\\idea\\jee-love\\src\\main\\java\\" + packageName + table.getClassName() + suffix;
        final String templateName = "Model.ftl";
        File ModelFile = new File(path);
        Map<String,Object> dataMap = new HashMap<>();
        dataMap.put("table",table);
        dataMap.put("packageName","per.san.demo.domain");
        generateFileByTemplate(templateName,ModelFile,dataMap);

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
