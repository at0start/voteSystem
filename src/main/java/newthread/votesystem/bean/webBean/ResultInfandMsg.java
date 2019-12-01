package newthread.votesystem.bean.webBean;

import java.util.List;

/**
 * @author 一个糟老头子
 * @createDate 2019/9/2-19:57
 */
public class ResultInfandMsg {
    private ResultMsg resultMsg;
    List<ResultInf> results;

    public ResultMsg getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(ResultMsg resultMsg) {
        this.resultMsg = resultMsg;
    }

    public List<ResultInf> getResults() {
        return results;
    }

    public void setResults(List<ResultInf> results) {
        this.results = results;
    }

    public ResultInfandMsg(ResultMsg resultMsg, List<ResultInf> results) {

        this.resultMsg = resultMsg;
        this.results = results;
    }

    public ResultInfandMsg() {

    }
}
