package nautillus.controllers;

import nautillus.models.Batch;
import nautillus.models.Medication;
import nautillus.repositories.BatchRepository;
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
@RequestMapping("/batches")
public class BatchesController {

    private final BatchRepository batchRepository;
    private final MedicationRepository medicationRepository;

    public BatchesController(BatchRepository batchRepository, MedicationRepository medicationRepository) {
        this.batchRepository = batchRepository;
        this.medicationRepository = medicationRepository;
    }

    @GetMapping
    public ResponseEntity<List<Batch>> getBatches(@RequestParam(required = false) Long id,
                                                  @RequestParam(required = false) Long medid) {
        if (id != null) {
            Optional<Batch> batch = batchRepository.findById(id);
            return batch.map(b -> ResponseEntity.ok(List.of(b)))
                    .orElseGet(() -> ResponseEntity.notFound().build());
        }
        if (medid != null) {
            return ResponseEntity.ok(batchRepository.findByMedication_MedicationId(medid));
        }
        return ResponseEntity.ok(batchRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<?> addBatch(@RequestBody Batch batch) {
        Medication medication = batch.getMedication();
        if (medication == null) {
            return ResponseEntity.badRequest().body("O campo 'medication' é obrigatório.");
        }
        Optional<Medication> optionalMedication = medicationRepository.findById(medication.getMedicationId());
        if (optionalMedication.isEmpty()) {
            return ResponseEntity.badRequest()
                    .body("Medicamento com id " + medication.getMedicationId() + " não encontrado.");
        }
        batch.setMedication(optionalMedication.get());
        Batch saved = batchRepository.save(batch);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PutMapping
    public ResponseEntity<?> updateBatch(@RequestParam long id, @RequestBody Batch batch) {
        Optional<Batch> optionalBatch = batchRepository.findById(id);
        if (optionalBatch.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Batch existing = optionalBatch.get();
        existing.setMedicationQuantity(batch.getMedicationQuantity());

        Medication medication = batch.getMedication();
        if (medication != null) {
            Optional<Medication> optionalMedication = medicationRepository.findById(medication.getMedicationId());
            if (optionalMedication.isEmpty()) {
                return ResponseEntity.badRequest()
                        .body("Medicamento com id " + medication.getMedicationId() + " não encontrado.");
            }
            existing.setMedication(optionalMedication.get());
        }
        return ResponseEntity.ok(batchRepository.save(existing));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteBatch(@RequestParam long id) {
        if (batchRepository.existsById(id)) {
            batchRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
