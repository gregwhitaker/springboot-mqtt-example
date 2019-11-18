package example.service.mqtt.controller.model;

public class GetTempAverageResponse {

    private double average;

    public GetTempAverageResponse() {}

    public GetTempAverageResponse(double average) {
        this.average = average;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }
}
