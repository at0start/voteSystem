package mewThread.voteSystem.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "session")
public class Session {
    @Id
    @Column(name = "session_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sessionId;

    @Column(name = "session_name")
    private String sessionName;

    @Column(name = "session_date")
    private Date sessionDate;

    /**
     * 1.投票制，2.十分制，3.百分制
     */
    @Column(name = "vote_type")
    private Integer voteType;

    /**
     * 1，未开始；2，正在进行；3.已结束
     */
    @Column(name = "session_state")
    private Integer sessionState;

    /**
     * 轮次控制方式。0：手动，1：自动
     */
    @Column(name = "auto_control")
    private Integer autoControl;

    /**
     * 场次备注
     */
    @Column(name = "session_info")
    private String sessionInfo;

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
     * 获取1.投票制，2.十分制，3.百分制
     *
     * @return vote_type - 1.投票制，2.十分制，3.百分制
     */
    public Integer getVoteType() {
        return voteType;
    }

    /**
     * 设置1.投票制，2.十分制，3.百分制
     *
     * @param voteType 1.投票制，2.十分制，3.百分制
     */
    public void setVoteType(Integer voteType) {
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
     * 获取轮次控制方式。0：手动，1：自动
     *
     * @return auto_control - 轮次控制方式。0：手动，1：自动
     */
    public Integer getAutoControl() {
        return autoControl;
    }

    /**
     * 设置轮次控制方式。0：手动，1：自动
     *
     * @param autoControl 轮次控制方式。0：手动，1：自动
     */
    public void setAutoControl(Integer autoControl) {
        this.autoControl = autoControl;
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
}