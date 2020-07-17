package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;

import java.io.IOException;

public class Controller {

    @FXML
    private ListView<Telemetry> telemetryListView;
    @FXML
    private Text telemetryText;

//
//
    public void initialize() {

        Telemetry telemetry = new Telemetry();

        telemetryText = new Text();
        telemetryText.setText("Figure out how to put XML here");

    }

    public void getTelemetryData() throws IOException {
        Telemetry telemetry = new Telemetry();
        telemetry.readTelemetry();
    }
}
