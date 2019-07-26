package newthread.votesystem.bean;

public class ResultMsg {

    //场次编号
    private Integer sessionOrder;
    //场次名称
    private String sessionName;
    //投票方式
    private String voteType;
    //统计方式
    private String countType;
    //投票人数
    private Integer voteNum;
    //未投票人数
    private Integer notVoteNum;

    public ResultMsg() {

    }

    public ResultMsg(Integer sessionOrder, String sessionName, String voteType, String countType, Integer voteNum, Integer notVoteNum) {
        this.sessionOrder = sessionOrder;
        this.sessionName = sessionName;
        this.voteType = voteType;
        this.countType = countType;
        this.voteNum = voteNum;
        this.notVoteNum = notVoteNum;
    }

    public Integer getSessionOrder() {
        return sessionOrder;
    }

    public String getSessionName() {
        return sessionName;
    }

    public String getVoteType() {
        return voteType;
    }

    public String getCountType() {
        return countType;
    }

    public Integer getVoteNum() {
        return voteNum;
    }

    public Integer getNotVoteNum() {
        return notVoteNum;
    }

    public void setSessionOrder(Integer sessionOrder) {
        this.sessionOrder = sessionOrder;
    }

    public void setSessionName(String sessionName) {
        this.sessionName = sessionName;
    }

    public void setVoteType(String voteType) {
        this.voteType = voteType;
    }

    public void setCountType(String countType) {
        this.countType = countType;
    }

    public void setVoteNum(Integer voteNum) {
        this.voteNum = voteNum;
    }

    public void setNotVoteNum(Integer notVoteNum) {
        this.notVoteNum = notVoteNum;
    }

    @Override
    public String toString() {
        return "ResultMsg{" +
                "sessionOrder=" + sessionOrder +
                ", sessionName='" + sessionName + '\'' +
                ", voteType='" + voteType + '\'' +
                ", countType='" + countType + '\'' +
                ", voteNum=" + voteNum +
                ", notVoteNum=" + notVoteNum +
                '}';
    }
}
