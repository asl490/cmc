package pe.gob.cusco.centro_medico.attention.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import pe.gob.cusco.centro_medico.attention.entity.MedicalHistory;
import pe.gob.cusco.centro_medico.shared.BaseJpaRepository;

@Repository
public interface MedicalHistoryRepository extends BaseJpaRepository<MedicalHistory> {

    List<MedicalHistory> findByPatient(Long patient);
}