package example.service.mqtt.controller.model;

public class GetTempsResponse {

    private long count;
    private double average;

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }
}
