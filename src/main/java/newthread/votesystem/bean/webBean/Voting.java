package newthread.votesystem.bean.webBean;

import java.util.List;

/**
 * @author 一个糟老头子
 * @createDate 2019/9/8-14:45
 */
public class Voting {
    private int userNumber;
    private List<String> list;
    private String sessionName;
    private Integer roundOrder;

    public Voting() {
    }

    public int getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(int userNumber) {
        this.userNumber = userNumber;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public String getSessionName() {
        return sessionName;
    }

    public void setSessionName(String sessionName) {
        this.sessionName = sessionName;
    }

    public Integer getRoundOrder() {
        return roundOrder;
    }

    public void setRoundOrder(Integer roundOrder) {
        this.roundOrder = roundOrder;
    }

    public Voting(int userNumber, List<String> list, String sessionName, Integer roundOrder) {

        this.userNumber = userNumber;
        this.list = list;
        this.sessionName = sessionName;
        this.roundOrder = roundOrder;
    }
}
