package pe.gob.cusco.centro_medico.attention.repository;

import org.springframework.stereotype.Repository;

import pe.gob.cusco.centro_medico.attention.entity.LaboratoryResult;
import pe.gob.cusco.centro_medico.shared.BaseJpaRepository;

@Repository
public interface LaboratoryResultRepository extends BaseJpaRepository<LaboratoryResult> {
}