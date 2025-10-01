package pe.gob.cusco.centro_medico.maintenance.service;

import pe.gob.cusco.centro_medico.maintenance.util.PatientDTO;
import pe.gob.cusco.centro_medico.maintenance.util.PatientDTO.FiltersPatientPersonDTO;
import pe.gob.cusco.centro_medico.shared.BaseService;
import pe.gob.cusco.centro_medico.shared.PagedResponse;

public interface PatientService
        extends
        BaseService<PatientDTO.CreatePatientDTO, PatientDTO.UpdatePatientDTO, PatientDTO, PatientDTO.FiltersPatientDTO> {

    PagedResponse<PatientDTO> pageFilterPatientPerson(int page, int size, FiltersPatientPersonDTO filters);

}