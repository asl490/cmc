package pe.gob.cusco.centro_medico.maintenance.service;

import pe.gob.cusco.centro_medico.maintenance.util.PatientDTO;
import pe.gob.cusco.centro_medico.shared.BaseService;

public interface PatientService
                extends
                BaseService<PatientDTO.CreatePatientDTO, PatientDTO.UpdatePatientDTO, PatientDTO, PatientDTO.FiltersPatientDTO> {

}