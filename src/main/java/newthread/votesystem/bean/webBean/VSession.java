package newthread.votesystem.bean.webBean;

import newthread.votesystem.bean.Session;

import java.util.List;

/**
 * @author 一个糟老头子
 * @createDate 2019/8/2-15:32
 */
public class VSession {
    //未开始
    List<Session> before;
    //进行中
    List<Session> being;
    //已结束
    List<Session> after;

    public VSession() {
    }

    public VSession(List<Session> before, List<Session> being, List<Session> after) {
        this.before = before;
        this.being = being;
        this.after = after;
    }

    public List<Session> getBefore() {

        return before;
    }

    public void setBefore(List<Session> before) {
        this.before = before;
    }

    public List<Session> getBeing() {
        return being;
    }

    public void setBeing(List<Session> being) {
        this.being = being;
    }

    public List<Session> getAfter() {
        return after;
    }

    public void setAfter(List<Session> after) {
        this.after = after;
    }
}
