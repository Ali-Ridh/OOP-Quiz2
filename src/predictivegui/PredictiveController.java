package predictivegui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PredictiveController {
    private PredictiveModel model;
    private PredictiveView view;

    public PredictiveController(PredictiveModel model, PredictiveView view) {
        this.model = model;
        this.view = view;

        // Add buttons for 2-9, *, 0, and #
        for (char c = '1'; c <= '9'; c++) {
            addButton(String.valueOf(c));
        }
        addButton("*");
        addButton("0");
        addButton("#");
    }

    private void addButton(String label) {
        JButton button = new JButton(label);
        view.getButtonPanel().add(button);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleButtonPress(label);
            }
        });
    }

    private void handleButtonPress(String label) {
        if (label.matches("[2-9]")) {
            model.addDigit(label.charAt(0));
        } else if (label.equals("0")) {
            model.completeWord();
        } else if (label.equals("#")) {
            model.removeLastDigit();
        }

        // Update display
        view.getDisplayArea().setText("Signature: " + model.getCurrentSignature() + "\nMatches: " + model.getCurrentMatches());
    }
}
