package newthread.votesystem.bean.webBean;

public class Message {
    private String message;

    public String getMessage() {
        return message;
    }

    public Message setMessage(String message) {
        this.message = message;
        return this;
    }

    public Message() {
    }

    public Message(String message) {
        this.message = message;
    }
}
