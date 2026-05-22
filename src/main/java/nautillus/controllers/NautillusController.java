package nautillus.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NautillusController {

    @GetMapping("/api/")
    public String getNautillusName() {

        return "Hello World";
    }
}
