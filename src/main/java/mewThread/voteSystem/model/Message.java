package mewThread.voteSystem.model;

/**
 * @author 一个糟老头子
 * @createDate 2019/7/20-19:42
 */
public class Message {
    private String message;

    public Message() {
    }

    public Message(String message) {

        this.message = message;
    }

    public String getMessage() {

        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
