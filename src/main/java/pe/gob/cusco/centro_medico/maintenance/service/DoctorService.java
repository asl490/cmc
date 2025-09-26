package pe.gob.cusco.centro_medico.maintenance.service;

import pe.gob.cusco.centro_medico.maintenance.util.DoctorDTO;
import pe.gob.cusco.centro_medico.shared.BaseService;

public interface DoctorService
        extends BaseService<DoctorDTO.CreateDoctorDTO, DoctorDTO.UpdateDoctorDTO, DoctorDTO, DoctorDTO.FiltersDoctorDTO> {
}