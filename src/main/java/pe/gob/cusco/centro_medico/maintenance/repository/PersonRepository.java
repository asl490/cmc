package pe.gob.cusco.centro_medico.maintenance.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import pe.gob.cusco.centro_medico.maintenance.entity.Person;
import pe.gob.cusco.centro_medico.shared.BaseJpaRepository;

@Repository
public interface PersonRepository extends BaseJpaRepository<Person> {

    Optional<Person> findByDni(String dni);
}