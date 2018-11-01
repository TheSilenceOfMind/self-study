package awt.events;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SampleFrameDemo extends Frame {

    SampleFrameDemo(String title) {
        super(title);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                SampleFrameDemo.this.setVisible(false);
            }
        });

        addKeyListener(new KeyListener() {
            Color was = SampleFrameDemo.this.getBackground();

            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == 'r')
                    SampleFrameDemo.this.setVisible(true);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                was = SampleFrameDemo.this.getBackground();
                if (e.getKeyChar() == 'c')
                    SampleFrameDemo.this.setBackground(Color.YELLOW);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyChar() == 'c')
                    SampleFrameDemo.this.setBackground(was);
            }
        });
    }

    public static void main(String[] args) {
        Frame f = new SampleFrameDemo("title");

        f.setBackground(Color.BLUE);
        f.setSize(new Dimension(300, 300));

        f.setVisible(true);
    }


}
