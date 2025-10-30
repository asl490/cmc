package pe.gob.cusco.centro_medico.attention.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import pe.gob.cusco.centro_medico.attention.entity.Attention;
import pe.gob.cusco.centro_medico.shared.BaseJpaRepository;

@Repository
public interface AttentionRepository extends BaseJpaRepository<Attention> {

    Optional<Attention> findByAppointmentId(Long appointmentId);
}