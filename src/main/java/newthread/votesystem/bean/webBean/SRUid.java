package newthread.votesystem.bean.webBean;

/**
 * @author 一个糟老头子
 * @createDate 2019/9/2-19:47
 */
public class SRUid {
    private int sessionId;
    private int roundId;
    private String userId;
    private int projectId;

    public SRUid(int sessionId, int roundId, String userId, int projectId) {
        this.sessionId = sessionId;
        this.roundId = roundId;
        this.userId = userId;
        this.projectId = projectId;
    }

    public SRUid() {

    }

    public int getSessionId() {

        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    public int getRoundId() {
        return roundId;
    }

    public void setRoundId(int roundId) {
        this.roundId = roundId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getProjectId() {
        return projectId;
    }

    @Override
    public String toString() {
        return "SRUid{" +
                "sessionId=" + sessionId +
                ", roundId=" + roundId +
                ", userId='" + userId + '\'' +
                ", projectId=" + projectId +
                '}';
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }
}
