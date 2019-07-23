package mewThread.voteSystem.model;

import javax.persistence.*;

@Table(name = "round_project")
public class RoundProject {
    /**
     * 赋予xx用户对xx场次的投票权限
     */
    @Column(name = "session_id")
    private Integer sessionId;

    /**
     * 轮次编号
     */
    @Column(name = "round_order")
    private Integer roundOrder;

    /**
     * 本轮从项目
     */
    @Column(name = "project_id")
    private Integer projectId;

    /**
     * 获取赋予xx用户对xx场次的投票权限
     *
     * @return session_id - 赋予xx用户对xx场次的投票权限
     */
    public Integer getSessionId() {
        return sessionId;
    }

    /**
     * 设置赋予xx用户对xx场次的投票权限
     *
     * @param sessionId 赋予xx用户对xx场次的投票权限
     */
    public void setSessionId(Integer sessionId) {
        this.sessionId = sessionId;
    }

    /**
     * 获取轮次编号
     *
     * @return round_order - 轮次编号
     */
    public Integer getRoundOrder() {
        return roundOrder;
    }

    /**
     * 设置轮次编号
     *
     * @param roundOrder 轮次编号
     */
    public void setRoundOrder(Integer roundOrder) {
        this.roundOrder = roundOrder;
    }

    /**
     * 获取本轮从项目
     *
     * @return project_id - 本轮从项目
     */
    public Integer getProjectId() {
        return projectId;
    }

    /**
     * 设置本轮从项目
     *
     * @param projectId 本轮从项目
     */
    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }
}