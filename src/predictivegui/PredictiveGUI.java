package predictivegui;

public class PredictiveGUI {
    public static void main(String[] args) {
        String dictionaryPath = ".//src/words";
        PredictiveModel model = new PredictiveModel(dictionaryPath);
        PredictiveView view = new PredictiveView();
        new PredictiveController(model, view);
    }
}
