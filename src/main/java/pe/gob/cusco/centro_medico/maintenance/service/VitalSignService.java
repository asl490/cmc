package pe.gob.cusco.centro_medico.maintenance.service;

import pe.gob.cusco.centro_medico.maintenance.util.VitalSignDTO;
import pe.gob.cusco.centro_medico.shared.BaseService;

public interface VitalSignService
        extends BaseService<VitalSignDTO.CreateVitalSignDTO, VitalSignDTO.UpdateVitalSignDTO, VitalSignDTO, VitalSignDTO.FiltersVitalSignDTO> {
}