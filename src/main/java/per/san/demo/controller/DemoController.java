package per.san.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import per.san.demo.domain.Demo;
import per.san.demo.service.IDemoService;

import java.util.List;

/**
 * description:
 *
 * @author sanchar
 * @date 12/5/2018 15:00
 * lastUpdateBy: sanchar
 * lastUpdateDate: 12/5/2018
 */
@Controller
public class DemoController {

    @Autowired
    IDemoService iDemoService;

    @RequestMapping("/demo")
    @ResponseBody
    List<Demo> demo() {
        return iDemoService.select();
    }
}
