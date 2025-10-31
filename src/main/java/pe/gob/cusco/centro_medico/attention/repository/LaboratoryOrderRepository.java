package pe.gob.cusco.centro_medico.attention.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.gob.cusco.centro_medico.attention.entity.Appointment;
import pe.gob.cusco.centro_medico.attention.entity.LaboratoryOrder;
import pe.gob.cusco.centro_medico.shared.BaseJpaRepository;

@Repository
public interface LaboratoryOrderRepository extends BaseJpaRepository<LaboratoryOrder> {

    List<LaboratoryOrder> findByAppointmentId(Long appointment);

    @Query("""
            SELECT DISTINCT lo.appointment
            FROM LaboratoryOrder lo
            WHERE LOWER(lo.status) LIKE LOWER(CONCAT('%', :status, '%'))
            """)
    Page<Appointment> findDistinctAppointmentsByStatusLike(@Param("status") String status, Pageable pageable);

}