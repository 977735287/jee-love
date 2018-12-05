package per.san.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World!";
    }
}
