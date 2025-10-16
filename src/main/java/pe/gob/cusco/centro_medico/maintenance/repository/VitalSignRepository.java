package pe.gob.cusco.centro_medico.maintenance.repository;

import org.springframework.stereotype.Repository;

import pe.gob.cusco.centro_medico.maintenance.entity.VitalSign;
import pe.gob.cusco.centro_medico.shared.BaseJpaRepository;

@Repository
public interface VitalSignRepository extends BaseJpaRepository<VitalSign> {
}