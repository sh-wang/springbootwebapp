package guru.springframework.repositories;
import guru.springframework.domain.Patient;
import org.springframework.data.repository.CrudRepository;


public interface PatientRepository extends CrudRepository<Patient, Integer>{
}
