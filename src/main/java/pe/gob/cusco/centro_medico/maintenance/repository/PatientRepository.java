package pe.gob.cusco.centro_medico.maintenance.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import pe.gob.cusco.centro_medico.maintenance.entity.Patient;
import pe.gob.cusco.centro_medico.shared.BaseJpaRepository;

@Repository
public interface PatientRepository extends BaseJpaRepository<Patient> {

    Page<Patient> findByPersonDniContainsAndPersonNameContainsAndPersonSurnameContainsAndClinicHistoryContains(
            String dni, String name, String surname, String clinicHistory, Pageable pageable);

    Optional<Patient> findByPersonDni(String dni);
}