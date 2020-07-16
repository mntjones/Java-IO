package sample;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class DataSource {

    public SimpleStringProperty sourceId;
    public SimpleStringProperty sourceName;
    public SimpleStringProperty msgId;
    public SimpleStringProperty msgName;
    public SimpleStringProperty value;
    public SimpleStringProperty timestamp;
    public SimpleStringProperty periodicity;

    public DataSource() {
        this.sourceId = new SimpleStringProperty("");
        this.sourceName = new SimpleStringProperty("");
        this.msgId = new SimpleStringProperty("");
        this.msgName = new SimpleStringProperty("");
        this.value =  new SimpleStringProperty("");
        this.timestamp =  new SimpleStringProperty("");
        this.periodicity = new SimpleStringProperty("");
    }

    public String getSourceId() {
        return sourceId.get();
    }

    public SimpleStringProperty sourceIdProperty() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId.set(sourceId);
    }

    public String getSourceName() {
        return sourceName.get();
    }

    public SimpleStringProperty sourceNameProperty() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName.set(sourceName);
    }

    public String getMsgId() {
        return msgId.get();
    }

    public SimpleStringProperty msgIdProperty() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId.set(msgId);
    }

    public String getMsgName() {
        return msgName.get();
    }

    public SimpleStringProperty msgNameProperty() {
        return msgName;
    }

    public void setMsgName(String msgName) {
        this.msgName.set(msgName);
    }

    public String getValue() {
        return value.get();
    }

    public SimpleStringProperty valueProperty() {
        return value;
    }

    public void setValue(String value) {
        this.value.set(value);
    }

    public String getTimestamp() {
        return timestamp.get();
    }

    public SimpleStringProperty timestampProperty() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp.set(timestamp);
    }

    public String getPeriodicity() {
        return periodicity.get();
    }

    public SimpleStringProperty periodicityProperty() {
        return periodicity;
    }

    public void setPeriodicity(String periodicity) {
        this.periodicity.set(periodicity);
    }
}
