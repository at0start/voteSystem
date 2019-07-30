package newthread.votesystem.bean;

import java.util.Date;

public class UserVoteInfo {

    // 场次编号
    private Integer sessionId;
    // 场次名称
    private String sessionName;
    // 场次时间
    private Date sessionDate;
    // 轮次编号
    private Integer roundOrder;
    // 场次状态
    private Integer sessionState;
    // 轮次状态
    private Integer roundState;
    //投票类型
    private String voteType;

    // 构造器
    public UserVoteInfo() {
    }

    public UserVoteInfo(Integer sessionId, String sessionName, Date sessionDate, Integer roundOrder, Integer sessionState, Integer roundState,String voteType) {
        this.sessionId = sessionId;
        this.sessionName = sessionName;
        this.sessionDate = sessionDate;
        this.roundOrder = roundOrder;
        this.sessionState = sessionState;
        this.roundState = roundState;
        this.voteType = voteType;
    }

    @Override
    public String toString() {
        return "UserVoteInfo{" +
                "sessionId=" + sessionId +
                ", sessionName='" + sessionName + '\'' +
                ", sessionDate=" + sessionDate +
                ", roundOrder=" + roundOrder +
                ", sessionState=" + sessionState +
                ", roundState=" + roundState +
                '}';
    }

    public String getVoteType() {
        return voteType;
    }

    public void setVoteType(String voteType) {
        this.voteType = voteType;
    }

    public void setSessionId(Integer sessionId) {
        this.sessionId = sessionId;
    }

    public void setSessionName(String sessionName) {
        this.sessionName = sessionName;
    }

    public void setSessionDate(Date sessionDate) {
        this.sessionDate = sessionDate;
    }

    public void setRoundOrder(Integer roundOrder) {
        this.roundOrder = roundOrder;
    }

    public void setSessionState(Integer sessionState) {
        this.sessionState = sessionState;
    }

    public void setRoundState(Integer roundState) {
        this.roundState = roundState;
    }

    public Integer getSessionId() {

        return sessionId;
    }

    public String getSessionName() {
        return sessionName;
    }

    public Date getSessionDate() {
        return sessionDate;
    }

    public Integer getRoundOrder() {
        return roundOrder;
    }

    public Integer getSessionState() {
        return sessionState;
    }

    public Integer getRoundState() {
        return roundState;
    }
}
