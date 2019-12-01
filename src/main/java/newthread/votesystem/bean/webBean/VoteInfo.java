package newthread.votesystem.bean.webBean;

import newthread.votesystem.bean.Project;

import java.util.List;

/**
 * @author 一个糟老头子
 * @createDate 2019/9/2-16:59
 */
public class VoteInfo {
    private boolean  isVote ;
    private boolean haveAuthority;
    private String voteType;
    private int upLimit;
    private String VoteRule;
    private List<Project> projects;

    public String getVoteRule() {
        return VoteRule;
    }

    public VoteInfo setVoteRule(String voteRule) {
        VoteRule = voteRule;
        return this;
    }

    public VoteInfo() {
    }

    public boolean isVote() {
        return isVote;
    }

    public void setVote(boolean vote) {
        isVote = vote;
    }

    public boolean isHaveAuthority() {
        return haveAuthority;
    }

    public void setHaveAuthority(boolean haveAuthority) {
        this.haveAuthority = haveAuthority;
    }

    public String getVoteType() {
        return voteType;
    }

    public void setVoteType(String voteType) {
        this.voteType = voteType;
    }

    public int getUpLimit() {
        return upLimit;
    }

    public void setUpLimit(int upLimit) {
        this.upLimit = upLimit;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public VoteInfo(boolean isVote, boolean haveAuthority, String voteType, int upLimit, String voteRule, List<Project> projects) {
        this.isVote = isVote;
        this.haveAuthority = haveAuthority;
        this.voteType = voteType;
        this.upLimit = upLimit;
        VoteRule = voteRule;
        this.projects = projects;
    }
}
