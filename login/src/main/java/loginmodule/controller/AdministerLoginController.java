package loginmodule.controller;

import com.google.gson.Gson;
import loginmodule.bean.Administer;
import loginmodule.service.LoginService;
import loginmodule.service.NECaptchaVerifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
//@ComponentScan(basePackages = "loginmodule.service.LoginService")
@RequestMapping("/administer")
public class AdministerLoginController {

    @Autowired
    LoginService loginService;

    @Autowired
    Gson gson;

    /**
     * 管理员登陆
     * @param username 用户名
     * @param password 密码
     * NECaptchaVerifier.REQ_VALIDATE = 'NECaptchaValidate'
     * @return 登陆的管理员json
     */
    @GetMapping("/alogin")
    public  String administer(@RequestParam("username") String username,@RequestParam("password") String password){
        Administer administer;
       // if(loginService.Verification(veri)) {
            administer = loginService.selectAdministerByUNAndPW(username, password);
      //  }
        return gson.toJson(administer);
    }

}
