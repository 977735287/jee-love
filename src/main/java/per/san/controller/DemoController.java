package per.san.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import per.san.domain.Demo;
import per.san.service.IDemoService;

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

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return iDemoService.select().toString();
    }

    @RequestMapping("/demo")
    @ResponseBody
    List<Demo> demo() {
        return iDemoService.select();
    }
}
