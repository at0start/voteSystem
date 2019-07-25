package newthread.votesystem.controller;

import newthread.votesystem.bean.Admin;
import newthread.votesystem.bean.Message;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 一个糟老头子
 * @createDate 2019/7/17-15:29
 */
public class IndexController {


    /**
     * 登录
     * admin：username，password，type
     * @param admin
     * @return
     */
    @RequestMapping("/adminIndex")
    public Message adminIndex(@RequestBody Admin admin){

        //存入session，并设置时常
            Message message = null;
        return message;
    }
}
