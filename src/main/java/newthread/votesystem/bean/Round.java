package newthread.votesystem.bean;

import javax.persistence.*;

public class Round {
    /**
     * 轮次主键
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    @Column(name = "round_id")
    private Integer roundId;

    /**
     * 轮次序号（1，2，3....）
     */
    @Column(name = "round_order")
    private Integer roundOrder;

    /**
     * 场次编号
     */
    @Column(name = "session_id")
    private Integer sessionId;

    /**
     * 轮次状态； 1：进行中，0：已结束
     */
    @Column(name = "round_state")
    private Integer roundState;

    /**
     * 投票类型；T，投票制，B.百分制，S.十分制
     */
    @Column(name = "vote_type")
    private String voteType;

    /**
     * 投票实现
     */
    @Column(name = "up_limit")
    private Integer upLimit;

    /**
     * 获取轮次主键
     *
     * @return round_id - 轮次主键
     */
    public Integer getRoundId() {
        return roundId;
    }

    /**
     * 设置轮次主键
     *
     * @param roundId 轮次主键
     */
    public void setRoundId(Integer roundId) {
        this.roundId = roundId;
    }

    /**
     * 获取轮次序号（1，2，3....）
     *
     * @return round_order - 轮次序号（1，2，3....）
     */
    public Integer getRoundOrder() {
        return roundOrder;
    }

    /**
     * 设置轮次序号（1，2，3....）
     *
     * @param roundOrder 轮次序号（1，2，3....）
     */
    public void setRoundOrder(Integer roundOrder) {
        this.roundOrder = roundOrder;
    }

    /**
     * 获取场次编号
     *
     * @return session_id - 场次编号
     */
    public Integer getSessionId() {
        return sessionId;
    }

    /**
     * 设置场次编号
     *
     * @param sessionId 场次编号
     */
    public void setSessionId(Integer sessionId) {
        this.sessionId = sessionId;
    }

    /**
     * 获取轮次状态； 1：进行中，0：已结束
     *
     * @return round_state - 轮次状态； 1：进行中，0：已结束
     */
    public Integer getRoundState() {
        return roundState;
    }

    /**
     * 设置轮次状态； 1：进行中，0：已结束
     *
     * @param roundState 轮次状态； 1：进行中，0：已结束
     */
    public void setRoundState(Integer roundState) {
        this.roundState = roundState;
    }

    /**
     * 获取投票类型；T，投票制，B.百分制，S.十分制
     *
     * @return vote_type - 投票类型；T，投票制，B.百分制，S.十分制
     */
    public String getVoteType() {
        return voteType;
    }

    /**
     * 设置投票类型；T，投票制，B.百分制，S.十分制
     *
     * @param voteType 投票类型；T，投票制，B.百分制，S.十分制
     */
    public void setVoteType(String voteType) {
        this.voteType = voteType;
    }

    /**
     * 获取投票实现
     *
     * @return up_limit - 投票实现
     */
    public Integer getUpLimit() {
        return upLimit;
    }

    /**
     * 设置投票实现
     *
     * @param upLimit 投票实现
     */
    public void setUpLimit(Integer upLimit) {
        this.upLimit = upLimit;
    }
}