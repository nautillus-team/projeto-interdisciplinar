package nautillus.controllers;

import nautillus.models.Medication;
import nautillus.repositories.MedicationRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/medication")
public class MedicationController {

    private final MedicationRepository medicationRepository;

    public MedicationController(MedicationRepository medicationRepository) {
        this.medicationRepository = medicationRepository;
    }

    @GetMapping
    public ResponseEntity<List<Medication>> getMedications(@RequestParam(required = false) Long id) {
        if (id != null) {
            Optional<Medication> medication = medicationRepository.findById(id);
            return medication.map(m -> ResponseEntity.ok(List.of(m)))
                    .orElseGet(() -> ResponseEntity.notFound().build());
        }
        return ResponseEntity.ok(medicationRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<Medication> addMedication(@RequestBody Medication medication) {
        Medication saved = medicationRepository.save(medication);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PutMapping
    public ResponseEntity<Medication> updateMedication(@RequestParam long id,
                                                       @RequestBody Medication medication) {
        return medicationRepository.findById(id)
                .map(existing -> {
                    existing.setMedicationName(medication.getMedicationName());
                    return ResponseEntity.ok(medicationRepository.save(existing));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteMedication(@RequestParam long id) {
        if (medicationRepository.existsById(id)) {
            medicationRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
