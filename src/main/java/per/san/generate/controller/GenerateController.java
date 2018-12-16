package per.san.generate.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import per.san.common.utils.generate.PageRequest;
import per.san.generate.domain.Table;
import per.san.generate.service.IGenerateService;

/**
 * description:
 *
 * @author shencai.huang@hand-china.com
 * @date 12/13/2018 13:00
 * lastUpdateBy: shencai.huang@hand-china.com
 * lastUpdateDate: 12/13/2018
 */

@Controller
public class GenerateController {

    @Autowired
    IGenerateService iGenerateService;

    @RequestMapping("/test")
    @ResponseBody
    public PageInfo<Table> queryPage() {
        PageRequest pageRequest = new PageRequest(0, 20);
        Table table = new Table();
        return iGenerateService.queryPage(pageRequest, table);
    }
}
