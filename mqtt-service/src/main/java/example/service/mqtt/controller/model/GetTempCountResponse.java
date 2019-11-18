package example.service.mqtt.controller.model;

public class GetTempCountResponse {

    private long count;

    public GetTempCountResponse() {}

    public GetTempCountResponse(long count) {
        this.count = count;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}
