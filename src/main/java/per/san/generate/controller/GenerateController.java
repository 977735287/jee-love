package per.san.generate.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import per.san.common.utils.page.CustomPageRequest;
import per.san.common.utils.page.PageRequest;
import per.san.generate.domain.Table;
import per.san.generate.service.IGenerateService;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;
import java.util.Map;

/**
 * description:
 *
 * @author shencai.huang@hand-china.com
 * @date 12/13/2018 13:00
 * lastUpdateBy: shencai.huang@hand-china.com
 * lastUpdateDate: 12/13/2018
 */

@RestController
public class GenerateController {

    @Autowired
    IGenerateService iGenerateService;

    @GetMapping("/test")
    @CustomPageRequest
    @ResponseBody
    public PageInfo<Table> queryPage(@ApiIgnore PageRequest pageRequest) {
        Table table = new Table();
        return iGenerateService.queryPage(pageRequest, table);
    }

    @PostMapping("/table/{name}")
    @ResponseBody
    public Table queryTable(@PathVariable("name") String name) {
        return iGenerateService.queryTable(name);
    }

    @GetMapping("/table1/{name}")
    @ResponseBody
    public List<Map<String, String>> queryColumns(@PathVariable("name") String name) {
        return iGenerateService.queryColumns(name);
    }
}
