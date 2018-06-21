package beans;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.*;

/**
 * Simple example of using beans with PropertyChangeListeners implementations.
 */
public class App {

    public static void main(String[] args) {
        NetworkNode node1 = new NetworkNode(0xFF_FF_FF_FF, (short)2222);
        NetworkNode node2 = new NetworkNode();
        Set<NetworkNode> nodes = new LinkedHashSet<>(Arrays.asList(node1, node2));
        int i = 1;
        for (NetworkNode nn : nodes) {
            nn.setMessageToPrint("it was printed by node " + (i++));
        }
//        nodes.forEach(NetworkNode::doWork);

        PropertyChangeListener l1 = new Listener("l1");
        PropertyChangeListener l2 = new Listener("l2");
        Set<PropertyChangeListener> listeners = new LinkedHashSet<>(Arrays.asList(l1, l2));

        // set all listeners on all nodes
        for (NetworkNode n : nodes) {
            for (PropertyChangeListener l : listeners) {
                n.addPropertyChangeListener(l);
            }
        }

        // try to modify ip or port
        node1.setPort((short)1);
        node1.setIp(1);
        node2.setPort((short)53);
        node2.setIp(0xAC_00_00_01);
    }

    public static class Listener implements PropertyChangeListener {

        private String name;

        Listener(String name) {
            this.name = name;
        }

        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            System.out.printf("%s: %s%n", this.name, evt.toString());
        }
    }

}
