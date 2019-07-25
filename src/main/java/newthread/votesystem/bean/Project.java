package newthread.votesystem.bean;

import javax.persistence.*;

public class Project {
    /**
     * 项目编号（数据库自动生成）
     */
    @Id
    @Column(name = "project_id")
    private Integer projectId;

    /**
     * 场次编号
     */
    @Column(name = "session_id")
    private Integer sessionId;

    /**
     * 项目序号
     */
    @Column(name = "project_order")
    private Integer projectOrder;

    /**
     * 项目名称
     */
    @Column(name = "project_name")
    private String projectName;

    /**
     * 项目类型
     */
    @Column(name = "project_type")
    private String projectType;

    /**
     * 项目部门（评审端不显示）
     */
    @Column(name = "college_name")
    private Integer collegeName;

    /**
     * 项目负责人（评审端不显示）
     */
    @Column(name = "project_man")
    private String projectMan;

    /**
     * 申请费用（评审端不显示）
     */
    private Double money;

    /**
     * 项目文件
     */
    @Column(name = "project_file")
    private String projectFile;

    /**
     * 项目简介
     */
    @Column(name = "project_info")
    private String projectInfo;

    /**
     * 获取项目编号（数据库自动生成）
     *
     * @return project_id - 项目编号（数据库自动生成）
     */
    public Integer getProjectId() {
        return projectId;
    }

    /**
     * 设置项目编号（数据库自动生成）
     *
     * @param projectId 项目编号（数据库自动生成）
     */
    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    /**
     * 获取场次编号
     *
     * @return session_id - 场次编号
     */
    public Integer getSessionId() {
        return sessionId;
    }

    /**
     * 设置场次编号
     *
     * @param sessionId 场次编号
     */
    public void setSessionId(Integer sessionId) {
        this.sessionId = sessionId;
    }

    /**
     * 获取项目序号
     *
     * @return project_order - 项目序号
     */
    public Integer getProjectOrder() {
        return projectOrder;
    }

    /**
     * 设置项目序号
     *
     * @param projectOrder 项目序号
     */
    public void setProjectOrder(Integer projectOrder) {
        this.projectOrder = projectOrder;
    }

    /**
     * 获取项目名称
     *
     * @return project_name - 项目名称
     */
    public String getProjectName() {
        return projectName;
    }

    /**
     * 设置项目名称
     *
     * @param projectName 项目名称
     */
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    /**
     * 获取项目类型
     *
     * @return project_type - 项目类型
     */
    public String getProjectType() {
        return projectType;
    }

    /**
     * 设置项目类型
     *
     * @param projectType 项目类型
     */
    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    /**
     * 获取项目部门（评审端不显示）
     *
     * @return college_name - 项目部门（评审端不显示）
     */
    public Integer getCollegeName() {
        return collegeName;
    }

    /**
     * 设置项目部门（评审端不显示）
     *
     * @param collegeName 项目部门（评审端不显示）
     */
    public void setCollegeName(Integer collegeName) {
        this.collegeName = collegeName;
    }

    /**
     * 获取项目负责人（评审端不显示）
     *
     * @return project_man - 项目负责人（评审端不显示）
     */
    public String getProjectMan() {
        return projectMan;
    }

    /**
     * 设置项目负责人（评审端不显示）
     *
     * @param projectMan 项目负责人（评审端不显示）
     */
    public void setProjectMan(String projectMan) {
        this.projectMan = projectMan;
    }

    /**
     * 获取申请费用（评审端不显示）
     *
     * @return money - 申请费用（评审端不显示）
     */
    public Double getMoney() {
        return money;
    }

    /**
     * 设置申请费用（评审端不显示）
     *
     * @param money 申请费用（评审端不显示）
     */
    public void setMoney(Double money) {
        this.money = money;
    }

    /**
     * 获取项目文件
     *
     * @return project_file - 项目文件
     */
    public String getProjectFile() {
        return projectFile;
    }

    /**
     * 设置项目文件
     *
     * @param projectFile 项目文件
     */
    public void setProjectFile(String projectFile) {
        this.projectFile = projectFile;
    }

    /**
     * 获取项目简介
     *
     * @return project_info - 项目简介
     */
    public String getProjectInfo() {
        return projectInfo;
    }

    /**
     * 设置项目简介
     *
     * @param projectInfo 项目简介
     */
    public void setProjectInfo(String projectInfo) {
        this.projectInfo = projectInfo;
    }
}