package per.san.sys.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * description:
 *
 * @author shencai.huang@hand-china.com
 * @date 12/28/2018 17:13
 * lastUpdateBy: shencai.huang@hand-china.com
 * lastUpdateDate: 12/28/2018
 */
@Controller
@RequestMapping
public class OauthController {

    @ApiOperation(value = "登录")
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @ApiOperation(value = "注册")
    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @ApiOperation(value = "找回密码")
    @GetMapping("/find")
    public String findPassword() {
        return "findPassword";
    }

}
