package predictivegui;

import javax.swing.*;
import java.awt.*;

public class PredictiveView {
    private JFrame frame;
    private JTextArea displayArea;
    private JPanel buttonPanel;

    public PredictiveView() {
        frame = new JFrame("Predictive Text GUI");
        displayArea = new JTextArea(10, 30);
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 3));

        frame.setLayout(new BorderLayout());
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public JTextArea getDisplayArea() {
        return displayArea;
    }

    public JPanel getButtonPanel() {
        return buttonPanel;
    }
}
