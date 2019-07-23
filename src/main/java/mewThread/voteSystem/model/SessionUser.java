package mewThread.voteSystem.model;

import javax.persistence.*;

@Table(name = "session_user")
public class SessionUser {
    @Column(name = "session_id")
    private Integer sessionId;

    @Column(name = "user_id")
    private Integer userId;

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
     * @return user_id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}