import javax.swing.*;
import java.awt.*;

public class GraphicsFrame extends JFrame {
    JLabel mouseStateLabel;
    JLabel mousePointLabel;

    public GraphicsFrame() {
        super("Graphics Fun");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(500, 500));
        setVisible(true);
        setupUI();
        pack();
    }

    private void setupUI() {
        mouseStateLabel = new JLabel("");
        mousePointLabel = new JLabel("");

        JPanel mouseLabelPanel = new JPanel();
        mouseLabelPanel.setLayout(new GridLayout(2, 2));
        mouseLabelPanel.add(new JLabel("Mouse State: "));
        mouseLabelPanel.add(mouseStateLabel);
        mouseLabelPanel.add(new JLabel("Mouse Point: "));
        mouseLabelPanel.add(mousePointLabel);
        getContentPane().add(mouseLabelPanel, BorderLayout.NORTH);

        GraphicsPanel graphicsPanel = new GraphicsPanel(this);
        getContentPane().add(graphicsPanel, BorderLayout.CENTER);
    }
}
