package runtime;

import org.springframework.web.bind.annotation.*;
import slo_violation_detector_engine.detector.DetectorSubcomponent;

import static configuration.Constants.default_handled_application_name;
import static runtime.Main.detectors;
import static slo_violation_detector_engine.detector.DetectorSubcomponent.detector_integer_id;
import static utilities.DebugDataSubscription.debug_data_generation;
import static utility_beans.CharacterizedThread.CharacterizedThreadRunMode.detached;
@RestController
@RequestMapping("/api")
public class DetectorRequestMappings {

    @RequestMapping("/add-new-detector")
    public static String start_new_detector_subcomponent() {
        detectors.add(new DetectorSubcomponent(default_handled_application_name,detached));
        return ("Spawned new SLO Detector subcomponent instance! Currently, there have been "+detector_integer_id+" detectors spawned");
    }

    //TODO refine calls to debug_data_generation below, once the interface to AMQP is available
    @GetMapping("/component-statistics")
    public static String get_component_statistics() {
        debug_data_generation.apply("","");
        return "Debug data generation was successful";
    }
    @GetMapping("/component-statistics/detectors/{id}")
    public static String get_detector_subcomponent_statistics(@PathVariable String id) {
        debug_data_generation.apply(id,"");
        return DetectorSubcomponent.get_detector_subcomponent_statistics();
    }
}