package newthread.votesystem.bean;

import javax.persistence.*;

@Table(name = "session_user")
public class SessionUser {
    @Column(name = "session_id")
    private Integer sessionId;

    @Column(name = "user_id")
    private String userId;

    //构造器

    public SessionUser() {
    }

    public SessionUser(Integer sessionId, String userId) {
        this.sessionId = sessionId;
        this.userId = userId;
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
     * @return user_id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }
}