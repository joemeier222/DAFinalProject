package tarleton.dafinalproject;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Joe Meier
 */
@XmlRootElement
public class Data {
    private String id;
    private String humidity;
    private String temperature;
    private String heatIndex;
    private String sensorOne;
    private String sensorTwo;
    private String dateTime;

    public Data() {
    }

    public Data(String id, String humidity, String temperature, String heatIndex, String sensorOne, String sensorTwo, String dateTime) {
        this.id = id;
        this.humidity = humidity;
        this.temperature = temperature;
        this.heatIndex = heatIndex;
        this.sensorOne = sensorOne;
        this.sensorTwo = sensorTwo;
        this.dateTime = dateTime;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getHeatIndex() {
        return heatIndex;
    }

    public void setHeatIndex(String heatIndex) {
        this.heatIndex = heatIndex;
    }

    public String getSensorOne() {
        return sensorOne;
    }

    public void setSensorOne(String sensorOne) {
        this.sensorOne = sensorOne;
    }

    public String getSensorTwo() {
        return sensorTwo;
    }

    public void setSensorTwo(String sensorTwo) {
        this.sensorTwo = sensorTwo;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
}
