package beans;

public class NetworkNode extends AbstractNetworkNode {
    private String messageToPrint;

    NetworkNode() {
        super();
    }

    NetworkNode(int ip, short port) {
        super(ip, port);
    }

    void setMessageToPrint(String messageToPrint) {
        this.messageToPrint = messageToPrint;
    }

    public String getMessageToPrint() {
        return messageToPrint;
    }

    @Override
    public void doWork() {
        System.out.println(messageToPrint);
    }
}
