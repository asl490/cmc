package pe.gob.cusco.centro_medico.maintenance.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import pe.gob.cusco.centro_medico.maintenance.entity.Doctor;
import pe.gob.cusco.centro_medico.shared.BaseJpaRepository;

@Repository
public interface DoctorRepository extends BaseJpaRepository<Doctor> {

    Page<Doctor> findByPersonDniContainsAndPersonNameContainsAndPersonSurnameContainsAndSpecialtyContains(
            String dni, String name, String surname, String specialty, Pageable pageable);

}