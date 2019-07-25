package newthread.votesystem.bean;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

public class Session {
    @Id
    @GeneratedValue(generator = "JDBC")
    @Column(name = "session_id")
    private Integer sessionId;

    @Column(name = "session_name")
    private String sessionName;

    @Column(name = "session_date")
    private Date sessionDate;

    /**
     * V.投票制，T.十分制，H.百分制
     */
    @Column(name = "vote_type")
    private String voteType;

    /**
     * 1，未开始；2，正在进行；3.已结束
     */
    @Column(name = "session_state")
    private Integer sessionState;

    /**
     * 场次备注
     */
    @Column(name = "session_info")
    private String sessionInfo;

    @Column(name = "user_number")
    private Integer userNumber;

    //构造器

    public Session() {
    }

    public Session(Integer sessionId, String sessionName, Date sessionDate, String voteType, Integer sessionState, String sessionInfo, Integer userNumber) {
        this.sessionId = sessionId;
        this.sessionName = sessionName;
        this.sessionDate = sessionDate;
        this.voteType = voteType;
        this.sessionState = sessionState;
        this.sessionInfo = sessionInfo;
        this.userNumber = userNumber;
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
     * @return session_date
     */
    public Date getSessionDate() {
        return sessionDate;
    }

    /**
     * @param sessionDate
     */
    public void setSessionDate(Date sessionDate) {
        this.sessionDate = sessionDate;
    }

    /**
     * 获取V.投票制，T.十分制，H.百分制
     *
     * @return vote_type - V.投票制，T.十分制，H.百分制
     */
    public String getVoteType() {
        return voteType;
    }

    /**
     * 设置V.投票制，T.十分制，H.百分制
     *
     * @param voteType V.投票制，T.十分制，H.百分制
     */
    public void setVoteType(String voteType) {
        this.voteType = voteType;
    }

    /**
     * 获取1，未开始；2，正在进行；3.已结束
     *
     * @return session_state - 1，未开始；2，正在进行；3.已结束
     */
    public Integer getSessionState() {
        return sessionState;
    }

    /**
     * 设置1，未开始；2，正在进行；3.已结束
     *
     * @param sessionState 1，未开始；2，正在进行；3.已结束
     */
    public void setSessionState(Integer sessionState) {
        this.sessionState = sessionState;
    }

    /**
     * 获取场次备注
     *
     * @return session_info - 场次备注
     */
    public String getSessionInfo() {
        return sessionInfo;
    }

    /**
     * 设置场次备注
     *
     * @param sessionInfo 场次备注
     */
    public void setSessionInfo(String sessionInfo) {
        this.sessionInfo = sessionInfo;
    }

    /**
     * @return user_number
     */
    public Integer getUserNumber() {
        return userNumber;
    }

    /**
     * @param userNumber
     */
    public void setUserNumber(Integer userNumber) {
        this.userNumber = userNumber;
    }

    @Override
    public String toString() {
        return "Session{" +
                "sessionId=" + sessionId +
                ", sessionName='" + sessionName + '\'' +
                ", sessionDate=" + sessionDate +
                ", voteType='" + voteType + '\'' +
                ", sessionState=" + sessionState +
                ", sessionInfo='" + sessionInfo + '\'' +
                ", userNumber=" + userNumber +
                '}';
    }
}