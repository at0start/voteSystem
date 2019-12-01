package newthread.votesystem.bean.webBean;

import java.util.Date;

public class UserVoteInfo {

    // 场次编号
    private Integer sessionId;
    // 场次名称
    private String sessionName;
    // 场次时间
    private String sessionDate;
    // 轮次编号
    private Integer roundOrder;
    // 场次状态
    private Integer sessionState;
    // 轮次状态
    private Integer roundState;
    //投票类型
    private String voteType;

    private Integer roundId;

    public UserVoteInfo(Integer sessionId, String sessionName, String sessionDate, Integer roundOrder
            , Integer sessionState, Integer roundState, String voteType, Integer roundId) {
        this.sessionId = sessionId;
        this.sessionName = sessionName;
        this.sessionDate = sessionDate;
        this.roundOrder = roundOrder;
        this.sessionState = sessionState;
        this.roundState = roundState;
        this.voteType = voteType;
        this.roundId = roundId;
    }

    public Integer getRoundId() {

        return roundId;
    }

    public UserVoteInfo setRoundId(Integer roundId) {
        this.roundId = roundId;
        return this;
    }

    public UserVoteInfo() {

    }

    public Integer getSessionId() {
        return sessionId;
    }

    public UserVoteInfo setSessionId(Integer sessionId) {
        this.sessionId = sessionId;
        return this;
    }

    public String getSessionName() {
        return sessionName;
    }

    public UserVoteInfo setSessionName(String sessionName) {
        this.sessionName = sessionName;
        return this;
    }

    public String getSessionDate() {
        return sessionDate;
    }

    public UserVoteInfo setSessionDate(String sessionDate) {
        this.sessionDate = sessionDate;
        return this;
    }

    public Integer getRoundOrder() {
        return roundOrder;
    }

    public UserVoteInfo setRoundOrder(Integer roundOrder) {
        this.roundOrder = roundOrder;
        return this;
    }

    public Integer getSessionState() {
        return sessionState;
    }

    public UserVoteInfo setSessionState(Integer sessionState) {
        this.sessionState = sessionState;
        return this;
    }

    public Integer getRoundState() {
        return roundState;
    }

    public UserVoteInfo setRoundState(Integer roundState) {
        this.roundState = roundState;
        return this;
    }

    public String getVoteType() {
        return voteType;
    }

    public UserVoteInfo setVoteType(String voteType) {
        this.voteType = voteType;
        return this;
    }
}
