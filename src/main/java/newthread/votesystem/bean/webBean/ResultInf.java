package newthread.votesystem.bean.webBean;

public class ResultInf {

    //项目编号
    private Integer projectId;
    //学院
    private String collegeName;
    //项目名称
    private String projectName;
    //赞成票
    private Integer passVote;
    //反对票
    private Integer outVote;
    //弃权票
    private Integer abstentionVote;
    //分数
    private Double score;

    public ResultInf() {
    }

    public ResultInf(Integer projectId, String collegeName, String projectName, Integer passVote, Integer outVote, Integer abstentionVote, Double score) {
        this.projectId = projectId;
        this.collegeName = collegeName;
        this.projectName = projectName;
        this.passVote = passVote;
        this.outVote = outVote;
        this.abstentionVote = abstentionVote;
        this.score = score;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public void setPassVote(Integer passVote) {
        this.passVote = passVote;
    }

    public void setOutVote(Integer outVote) {
        this.outVote = outVote;
    }

    public void setAbstentionVote(Integer abstentionVote) {
        this.abstentionVote = abstentionVote;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public String getProjectName() {
        return projectName;
    }

    public Integer getPassVote() {
        return passVote;
    }

    public Integer getOutVote() {
        return outVote;
    }

    public Integer getAbstentionVote() {
        return abstentionVote;
    }

    public Double getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "ResultInf{" +
                "projectId=" + projectId +
                ", collegeName='" + collegeName + '\'' +
                ", projectName='" + projectName + '\'' +
                ", passVote=" + passVote +
                ", outVote=" + outVote +
                ", abstentionVote=" + abstentionVote +
                ", score=" + score +
                '}';
    }
}
