package nautillus.repositories;

import nautillus.models.Batch;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BatchRepository extends JpaRepository<Batch, Long> {

    List<Batch> findByMedication_MedicationId(long medicationId);
}
