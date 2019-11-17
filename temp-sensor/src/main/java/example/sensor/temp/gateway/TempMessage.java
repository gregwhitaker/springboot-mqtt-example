package example.sensor.temp.gateway;

public class TempMessage {

    private String sensorId;
    private double temp;

    public TempMessage(String sensorId, double temp) {
        this.sensorId = sensorId;
        this.temp = temp;
    }

    public String getSensorId() {
        return sensorId;
    }

    public void setSensorId(String sensorId) {
        this.sensorId = sensorId;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    @Override
    public String toString() {
        return "TempMessage{" +
                "sensorId='" + sensorId + '\'' +
                ", temp=" + temp +
                '}';
    }
}
