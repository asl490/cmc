package pe.gob.cusco.centro_medico.attention.repository;

import org.springframework.stereotype.Repository;

import pe.gob.cusco.centro_medico.attention.entity.NursingRecord;
import pe.gob.cusco.centro_medico.shared.BaseJpaRepository;

@Repository
public interface NursingRecordRepository extends BaseJpaRepository<NursingRecord> {
}