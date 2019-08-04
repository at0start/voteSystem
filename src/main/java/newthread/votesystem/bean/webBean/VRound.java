package newthread.votesystem.bean.webBean;

import java.util.List;

/**
 * @author 一个糟老头子
 * @createDate 2019/8/2-14:33
 */
public class VRound {
    //未开始
    private List<UserVoteInfo> before;
    //进行中
    private List<UserVoteInfo> being;
    //已结束
    private List<UserVoteInfo> after;

    public VRound(List<UserVoteInfo> before, List<UserVoteInfo> being, List<UserVoteInfo> after) {
        this.before = before;
        this.being = being;
        this.after = after;
    }

    public VRound() {

    }

    public List<UserVoteInfo> getBefore() {

        return before;
    }

    public void setBefore(List<UserVoteInfo> before) {
        this.before = before;
    }

    public List<UserVoteInfo> getBeing() {
        return being;
    }

    public void setBeing(List<UserVoteInfo> being) {
        this.being = being;
    }

    public List<UserVoteInfo> getAfter() {
        return after;
    }

    public void setAfter(List<UserVoteInfo> after) {
        this.after = after;
    }
}
