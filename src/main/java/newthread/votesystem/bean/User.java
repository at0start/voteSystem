package newthread.votesystem.bean;

import javax.persistence.*;

public class User {
    /**
     * 用户编号
     */
    @Id
    @Column(name = "user_id")
    private String userId;

    /**
     * 用户密码
     */
    @Column(name = "user_password")
    private String userPassword;

    //构造器
    public User() {
    }

    public User(String userId, String userPassword) {
        this.userId = userId;
        this.userPassword = userPassword;
    }

    /**
     * 获取用户编号
     *
     * @return user_id - 用户编号
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置用户编号
     *
     * @param userId 用户编号
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 获取用户密码
     *
     * @return user_password - 用户密码
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * 设置用户密码
     *
     * @param userPassword 用户密码
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}