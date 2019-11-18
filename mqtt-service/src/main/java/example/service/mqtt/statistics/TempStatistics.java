package example.service.mqtt.statistics;

import org.springframework.stereotype.Component;

import java.util.DoubleSummaryStatistics;

@Component
public class TempStatistics {

    private DoubleSummaryStatistics tempStats = new DoubleSummaryStatistics();

    public void addTemp(double temp) {
        tempStats.accept(temp);
    }

    public long getCount() {
        return tempStats.getCount();
    }

    public double getAverage() {
        return tempStats.getAverage();
    }

    public double getMax() {
        return tempStats.getMax();
    }

    public double getMin() {
        return tempStats.getMin();
    }
}
