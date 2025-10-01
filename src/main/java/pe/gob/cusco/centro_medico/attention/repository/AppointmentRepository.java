package pe.gob.cusco.centro_medico.attention.repository;

import org.springframework.stereotype.Repository;

import pe.gob.cusco.centro_medico.attention.entity.Appointment;
import pe.gob.cusco.centro_medico.shared.BaseJpaRepository;

@Repository
public interface AppointmentRepository extends BaseJpaRepository<Appointment> {
}