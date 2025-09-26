package pe.gob.cusco.centro_medico.reports.repository;

import org.springframework.stereotype.Repository;

import pe.gob.cusco.centro_medico.reports.entity.MedicalCard;
import pe.gob.cusco.centro_medico.shared.BaseJpaRepository;

@Repository
public interface MedicalCardRepository extends BaseJpaRepository<MedicalCard> {
}