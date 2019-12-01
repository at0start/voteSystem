package newthread.votesystem.bean;

import javax.persistence.*;

public class Project {

    @Transient
    private Integer chosed;
    /**
     * 项目编号（数据库自动生成）
     */
    @Id
    @Column(name = "project_id")
    @GeneratedValue(generator = "JDBC")
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
    private String collegeName;

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
     * 项目文件id
     */
    @Column(name = "file_id")
    private Integer fileId;

    /**
     * 项目简介
     */
    @Column(name = "project_info")
    private String projectInfo;

    public Integer getChosed() {

        return chosed;
    }

    public void setChosed(Integer chosed) {
        this.chosed = chosed;
    }
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
    public String getCollegeName() {
        return collegeName;
    }

    /**
     * 设置项目部门（评审端不显示）
     *
     * @param collegeName 项目部门（评审端不显示）
     */
    public void setCollegeName(String collegeName) {
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
     * 获取项目文件id
     *
     * @return file_id - 项目文件id
     */
    public Integer getFileId() {
        return fileId;
    }

    /**
     * 设置项目文件id
     *
     * @param fileId 项目文件id
     */
    public void setFileId(Integer fileId) {
        this.fileId = fileId;
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

    @Override
    public String toString() {
        return "Project{" +
                "projectId=" + projectId +
                ", sessionId=" + sessionId +
                ", projectOrder=" + projectOrder +
                ", projectName='" + projectName + '\'' +
                ", projectType='" + projectType + '\'' +
                ", collegeName='" + collegeName + '\'' +
                ", projectMan='" + projectMan + '\'' +
                ", money=" + money +
                ", fileId=" + fileId +
                ", projectInfo='" + projectInfo + '\'' +
                '}';
    }
    public Project(){}
    public Project(Integer chosed, Integer projectId, Integer sessionId, Integer projectOrder, String projectName, String projectType, String collegeName, String projectMan, Double money, Integer fileId, String projectInfo) {
        this.chosed = chosed;
        this.projectId = projectId;
        this.sessionId = sessionId;
        this.projectOrder = projectOrder;
        this.projectName = projectName;
        this.projectType = projectType;
        this.collegeName = collegeName;
        this.projectMan = projectMan;
        this.money = money;
        this.fileId = fileId;
        this.projectInfo = projectInfo;
    }
}