package pe.gob.cusco.centro_medico.attention.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import pe.gob.cusco.centro_medico.attention.entity.NursingRecord;
import pe.gob.cusco.centro_medico.shared.BaseJpaRepository;

@Repository
public interface NursingRecordRepository extends BaseJpaRepository<NursingRecord> {

    List<NursingRecord> findByAppointmentId(Long appointment);
}