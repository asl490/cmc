package pe.gob.cusco.centro_medico.attention.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import pe.gob.cusco.centro_medico.attention.entity.Appointment;
import pe.gob.cusco.centro_medico.shared.BaseJpaRepository;

@Repository
public interface AppointmentRepository extends BaseJpaRepository<Appointment> {

    Page<Appointment> findByPatientPersonDniContainsAndPatientPersonNameContainsAndPatientPersonSurnameAndDoctorPersonDniContains(
            String patientDni, String patientName, String patientSurname, String doctorDni, Pageable pageable);

    Page<Appointment> findByPatientPersonDniContainsAndDoctorPersonDniContainsAndStatusContainsAndPatientClinicHistoryContains(
            String patientDni, String doctorDni, String status, String clinicHistory, Pageable pageable);

}