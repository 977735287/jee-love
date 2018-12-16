package per.san.generate.service;

import com.github.pagehelper.PageInfo;
import per.san.common.utils.generate.PageRequest;
import per.san.generate.domain.Table;

/**
 * description:
 *
 * @author shencai.huang@hand-china.com
 * @date 12/12/2018 19:03
 * lastUpdateBy: shencai.huang@hand-china.com
 * lastUpdateDate: 12/12/2018
 */
public interface IGenerateService {

    PageInfo<Table> queryPage(PageRequest pageRequest, Table table);
}
