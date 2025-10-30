package pe.gob.cusco.centro_medico.attention.repository;

import org.springframework.stereotype.Repository;

import pe.gob.cusco.centro_medico.attention.entity.LaboratoryOrder;
import pe.gob.cusco.centro_medico.shared.BaseJpaRepository;

@Repository
public interface LaboratoryOrderRepository extends BaseJpaRepository<LaboratoryOrder> {
}