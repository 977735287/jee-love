package per.san.generate.service.impl;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import per.san.common.utils.generate.PageHelper;
import per.san.common.utils.generate.PageRequest;
import per.san.generate.domain.Table;
import per.san.generate.mapper.MySQLGenerateMapper;
import per.san.generate.service.IGenerateService;

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
}
