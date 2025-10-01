package pe.gob.cusco.centro_medico.maintenance.service.impl;

import java.util.Collections;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;
import pe.gob.cusco.centro_medico.exception.exception.ResourceNotFoundException;
import pe.gob.cusco.centro_medico.maintenance.entity.Person;
import pe.gob.cusco.centro_medico.maintenance.repository.PersonRepository;
import pe.gob.cusco.centro_medico.maintenance.service.PersonService;
import pe.gob.cusco.centro_medico.maintenance.util.PersonDTO;
import pe.gob.cusco.centro_medico.maintenance.util.PersonDTO.CreatePersonDTO;
import pe.gob.cusco.centro_medico.maintenance.util.PersonDTO.FiltersPersonDTO;
import pe.gob.cusco.centro_medico.maintenance.util.PersonDTO.UpdatePersonDTO;
import pe.gob.cusco.centro_medico.maintenance.util.PersonMapper;
import pe.gob.cusco.centro_medico.maintenance.util.PidePerson;
import pe.gob.cusco.centro_medico.shared.BaseServiceImpl;

@Service
@Slf4j
public class PersonServiceImpl extends
        BaseServiceImpl<Person, CreatePersonDTO, UpdatePersonDTO, PersonDTO, FiltersPersonDTO>
        implements PersonService {

    @Value("${pide.url}")
    private String pideUrl;
    @Value("${pide.token}")
    private String pideToken;

    private final PersonRepository repository;
    private final RestTemplate restTemplate;

    public PersonServiceImpl(PersonRepository repository,
            PersonMapper mapper, RestTemplate restTemplate) {
        super(repository, mapper);
        this.repository = repository;
        this.restTemplate = restTemplate;
    }

    @Override
    public PersonDTO create(CreatePersonDTO dto) {
        Optional<Person> existingPerson = repository.findByDni(dto.getDni());
        if (existingPerson.isPresent()) {
            throw new IllegalArgumentException("A person with the same DNI already exists.");
        }
        return super.create(dto);
    }

    @Override
    public Optional<Person> findOptionalByDNI(String dni) {
        Optional<Person> person = repository.findByDni(dni);
        return person;
    }

    @Override
    public Optional<PidePerson> pidePerson(String dni) {
        try {
            // Construir la URL final (asumiendo que el endpoint requiere el DNI al final)
            String url = pideUrl + dni;

            // Crear headers con el token
            HttpHeaders headers = new HttpHeaders();
            headers.set("Authorization", "Bearer " + pideToken);
            headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

            // Crear entidad HTTP con los headers
            HttpEntity<Void> requestEntity = new HttpEntity<>(headers);
            log.info("Llamando a PIDE con URL: " + url);
            // Ejecutar la llamada
            ResponseEntity<PidePerson> response = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    requestEntity,
                    PidePerson.class);

            // Retornar el resultado si es 200 OK
            return Optional.ofNullable(response.getBody());

        } catch (HttpClientErrorException.NotFound e) {
            log.error("No se encontró la persona en PIDE: " + e.getMessage());
            throw new ResourceNotFoundException("No se encontró la persona en PIDE");
        } catch (Exception e) {
            log.error("No se encontró la persona en PIDE: " + e.getMessage());
            throw new ResourceNotFoundException("No se encontró la persona en PIDE");
        }
    }

}