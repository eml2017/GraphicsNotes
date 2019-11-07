import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

public class GraphicsPanel extends JPanel {
    GraphicsFrame graphicsFrame;

    public GraphicsPanel(GraphicsFrame parentFrame) {
        graphicsFrame = parentFrame;

        setBackground(Color.WHITE);

        // 1. mouse events
        // 2. graphics (drawing on the jpanel)
        // 3. tie the mouse to the graphics... e.g. let
        // the user draw somethings

        // two mouse listener interfaces
        // MouseListener: click, enter component, exit component, press, release
        // MouseMotionListener: moving, dragging

        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                graphicsFrame.mouseStateLabel.setText("Clicked");
                graphicsFrame.mousePointLabel.setText(e.getX() + " " + e.getY());
                // MouseEvent has info about the event
                // e.g. getX(), getPoint(), getClickCount(), ...
            }

            @Override
            public void mousePressed(MouseEvent e) {
                graphicsFrame.mouseStateLabel.setText("Pressed");
                graphicsFrame.mousePointLabel.setText(e.getX() + " " + e.getY());
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                graphicsFrame.mouseStateLabel.setText("Released");
                graphicsFrame.mousePointLabel.setText(e.getX() + " " + e.getY());
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                graphicsFrame.mouseStateLabel.setText("Entered");
                graphicsFrame.mousePointLabel.setText(e.getX() + " " + e.getY());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                graphicsFrame.mouseStateLabel.setText("Exited");
                graphicsFrame.mousePointLabel.setText(e.getX() + " " + e.getY());
            }
        });

        // task: add a MouseMotionListener and do the same thing for its two events
        // dragging, moving
        addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                graphicsFrame.mouseStateLabel.setText("Dragged");
                graphicsFrame.mousePointLabel.setText(e.getX() + " " + e.getY());
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                graphicsFrame.mouseStateLabel.setText("Moved");
                graphicsFrame.mousePointLabel.setText(e.getX() + " " + e.getY());
            }
        });
    }

    // we can draw on the JPanel by overriding paintComponent(Graphics g)
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // typecast Graphics g to Graphics2D
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.BLUE); // color of what is drawn
        g2.setFont(new Font("Default", Font.BOLD, 36));
        g2.drawString("Hello", 100, 100);

        // draw a line
        Line2D.Double line = new Line2D.Double(200, 250, 300, 350);
        g2.draw(line);

        // draw a circle
        g2.setColor(Color.CYAN);
        Ellipse2D.Double ellipse = new Ellipse2D.Double(300, 300, 50, 50);
        g2.fill(ellipse);

    }
}
