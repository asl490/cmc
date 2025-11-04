package pe.gob.cusco.centro_medico.attention.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import pe.gob.cusco.centro_medico.attention.entity.LaboratoryResult;
import pe.gob.cusco.centro_medico.shared.BaseJpaRepository;

@Repository
public interface LaboratoryResultRepository extends BaseJpaRepository<LaboratoryResult> {

    List<LaboratoryResult> findByLaboratoryOrderAppointmentId(Long appointment);
}