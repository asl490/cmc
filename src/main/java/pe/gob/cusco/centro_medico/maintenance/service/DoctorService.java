package pe.gob.cusco.centro_medico.maintenance.service;

import pe.gob.cusco.centro_medico.maintenance.util.DoctorDTO;
import pe.gob.cusco.centro_medico.maintenance.util.DoctorDTO.FiltersDoctorPersonDTO;
import pe.gob.cusco.centro_medico.shared.BaseService;
import pe.gob.cusco.centro_medico.shared.PagedResponse;

public interface DoctorService
                extends
                BaseService<DoctorDTO.CreateDoctorDTO, DoctorDTO.UpdateDoctorDTO, DoctorDTO, DoctorDTO.FiltersDoctorDTO> {

        PagedResponse<DoctorDTO> pageFilterDoctorPerson(int page, int size, FiltersDoctorPersonDTO filters);
}