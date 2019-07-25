package newthread.votesystem.bean;

import javax.persistence.*;

public class Result {
    @Id
    @Column(name = "result_id")
    private Integer resultId;

    /**
     * 未通过，改0为1
     */
    @Id
    @Column(name = "out_vote")
    private Integer outVote;

    @Column(name = "session_id")
    private Integer sessionId;

    @Column(name = "session_name")
    private String sessionName;

    @Column(name = "round_id")
    private Integer roundId;

    @Column(name = "project_id")
    private Integer projectId;

    /**
     * 评审员编号
     */
    @Column(name = "user_id")
    private String userId;

    @Column(name = "project_name")
    private String projectName;

    /**
     * 项目编号
     */
    @Column(name = "project_order")
    private Integer projectOrder;

    /**
     * 通过，改0为1
     */
    @Column(name = "pass_vote")
    private Integer passVote;

    /**
     * 弃权，改0为1
     */
    @Column(name = "abstention_vote")
    private Integer abstentionVote;

    /**
     * 分数；打分制时使用
     */
    private Double score;

    /**
     * @return result_id
     */
    public Integer getResultId() {
        return resultId;
    }

    /**
     * @param resultId
     */
    public void setResultId(Integer resultId) {
        this.resultId = resultId;
    }

    /**
     * 获取未通过，改0为1
     *
     * @return out_vote - 未通过，改0为1
     */
    public Integer getOutVote() {
        return outVote;
    }

    /**
     * 设置未通过，改0为1
     *
     * @param outVote 未通过，改0为1
     */
    public void setOutVote(Integer outVote) {
        this.outVote = outVote;
    }

    /**
     * @return session_id
     */
    public Integer getSessionId() {
        return sessionId;
    }

    /**
     * @param sessionId
     */
    public void setSessionId(Integer sessionId) {
        this.sessionId = sessionId;
    }

    /**
     * @return session_name
     */
    public String getSessionName() {
        return sessionName;
    }

    /**
     * @param sessionName
     */
    public void setSessionName(String sessionName) {
        this.sessionName = sessionName;
    }

    /**
     * @return round_id
     */
    public Integer getRoundId() {
        return roundId;
    }

    /**
     * @param roundId
     */
    public void setRoundId(Integer roundId) {
        this.roundId = roundId;
    }

    /**
     * @return project_id
     */
    public Integer getProjectId() {
        return projectId;
    }

    /**
     * @param projectId
     */
    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    /**
     * 获取评审员编号
     *
     * @return user_id - 评审员编号
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置评审员编号
     *
     * @param userId 评审员编号
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * @return project_name
     */
    public String getProjectName() {
        return projectName;
    }

    /**
     * @param projectName
     */
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    /**
     * 获取项目编号
     *
     * @return project_order - 项目编号
     */
    public Integer getProjectOrder() {
        return projectOrder;
    }

    /**
     * 设置项目编号
     *
     * @param projectOrder 项目编号
     */
    public void setProjectOrder(Integer projectOrder) {
        this.projectOrder = projectOrder;
    }

    /**
     * 获取通过，改0为1
     *
     * @return pass_vote - 通过，改0为1
     */
    public Integer getPassVote() {
        return passVote;
    }

    /**
     * 设置通过，改0为1
     *
     * @param passVote 通过，改0为1
     */
    public void setPassVote(Integer passVote) {
        this.passVote = passVote;
    }

    /**
     * 获取弃权，改0为1
     *
     * @return abstention_vote - 弃权，改0为1
     */
    public Integer getAbstentionVote() {
        return abstentionVote;
    }

    /**
     * 设置弃权，改0为1
     *
     * @param abstentionVote 弃权，改0为1
     */
    public void setAbstentionVote(Integer abstentionVote) {
        this.abstentionVote = abstentionVote;
    }

    /**
     * 获取分数；打分制时使用
     *
     * @return score - 分数；打分制时使用
     */
    public Double getScore() {
        return score;
    }

    /**
     * 设置分数；打分制时使用
     *
     * @param score 分数；打分制时使用
     */
    public void setScore(Double score) {
        this.score = score;
    }
}