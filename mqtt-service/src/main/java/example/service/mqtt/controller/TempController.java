package example.service.mqtt.controller;

import example.service.mqtt.statistics.TempStatistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TempController {

    @Autowired
    private TempStatistics tempStats;

    @GetMapping("/temps/count")
    public ResponseEntity<?> getTempCount() {
        return ResponseEntity.ok(tempStats.getCount());
    }

    @GetMapping("/temps/avg")
    public ResponseEntity<?> getAverageTemp() {
        return ResponseEntity.ok(tempStats.getAverage());
    }
}
