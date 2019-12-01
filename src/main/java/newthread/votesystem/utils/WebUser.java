package newthread.votesystem.utils;

import com.xuxueli.poi.excel.annotation.ExcelField;

/**
 * @author 一个糟老头子
 * @createDate 2019/10/28-19:24
 */
public class WebUser {


    private String userId;

    @ExcelField(name = "密码")
    private String userPassword;

    public WebUser() {
    }

    public WebUser(String userId, String userPassword) {
        this.userId = userId;
        this.userPassword = userPassword;
    }

    public String getUserId() {
        return userId;
    }

    public WebUser setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public WebUser setUserPassword(String userPassword) {
        this.userPassword = userPassword;
        return this;
    }
}
