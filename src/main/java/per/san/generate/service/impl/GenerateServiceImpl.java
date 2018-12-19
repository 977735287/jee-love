package per.san.generate.service.impl;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import per.san.common.utils.CodeGenerateUtils;
import per.san.common.utils.PropertiesUtils;
import per.san.common.utils.page.PageHelper;
import per.san.common.utils.page.PageRequest;
import per.san.generate.domain.Table;
import per.san.generate.mapper.MySQLGenerateMapper;
import per.san.generate.service.IGenerateService;

import java.util.List;
import java.util.Map;

/**
 * description:
 *
 * @author shencai.huang@hand-china.com
 * @date 12/12/2018 19:04
 * lastUpdateBy: shencai.huang@hand-china.com
 * lastUpdateDate: 12/12/2018
 */
@Service
public class GenerateServiceImpl implements IGenerateService {

    @Autowired
    MySQLGenerateMapper mySQLGenerateMapper;

    @Override
    public PageInfo<Table> queryPage(PageRequest pageRequest, Table table) {
        return PageHelper.doPage(pageRequest, () -> mySQLGenerateMapper.queryList(table));
    }

    @Override
    public Table queryTable(String tableName) {
        Table table = mySQLGenerateMapper.queryTable(tableName);
        try {
            CodeGenerateUtils.generate(table);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return table;
    }

    @Override
    public List<Map<String, String>> queryColumns(String tableName) {
        return mySQLGenerateMapper.queryColumns(tableName);
    }
}
