package beans;

import java.beans.*;
import java.io.Serializable;

public abstract class AbstractNetworkNode implements Serializable {

    private PropertyChangeSupport mPcs = new PropertyChangeSupport(this);
    private int ip = 0x00_00_00_00;
    private short port = 0;

    AbstractNetworkNode() {}

    AbstractNetworkNode(int ip, short port) {
        setIp(ip);
        setPort(port);
    }

    public abstract void doWork();

    public int getIp() { return ip; }
    public short getPort() { return port; }

    void setIp(int ip) {
        int oldIp = this.ip;
        this.ip = ip;
        mPcs.firePropertyChange("ip", oldIp, ip);
    }

    void setPort(short port) {
        short oldPort = this.port;
        this.port = port;
        mPcs.firePropertyChange("port", oldPort, port);
    }

    void addPropertyChangeListener(PropertyChangeListener listener) {
        mPcs.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        mPcs.removePropertyChangeListener(listener);
    }

    @Override
    public String toString() {
        return String.format(
                "ip: %d.%d.%d.%d  port: %d",
                ip >> 24 & 0xFF,
                ip >> 16 & 0xFF,
                ip >> 8 & 0xFF,
                ip & 0xFF,
                port
        );
    }

}
