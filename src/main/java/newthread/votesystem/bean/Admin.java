package newthread.votesystem.bean;

import javax.persistence.*;

public class Admin {
    /**
     * 管理员编号
     */
    @Id
    @Column(name = "admin_id")
    private String adminId;

    /**
     * 管理员密码
     */
    @Column(name = "admin_password")
    private String adminPassword;

    public Admin() {
    }

    public Admin(String adminId, String adminPassword) {
        this.adminId = adminId;
        this.adminPassword = adminPassword;
    }

    /**
     * 获取管理员编号
     *
     * @return admin_id - 管理员编号
     */
    public String getAdminId() {
        return adminId;
    }

    /**
     * 设置管理员编号
     *
     * @param adminId 管理员编号
     */
    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    /**
     * 获取管理员密码
     *
     * @return admin_password - 管理员密码
     */
    public String getAdminPassword() {
        return adminPassword;
    }

    /**
     * 设置管理员密码
     *
     * @param adminPassword 管理员密码
     */
    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }
}