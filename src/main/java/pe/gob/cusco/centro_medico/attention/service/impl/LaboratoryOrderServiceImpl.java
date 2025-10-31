package pe.gob.cusco.centro_medico.attention.service.impl;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import pe.gob.cusco.centro_medico.attention.dto.AppointmentDTO;
import pe.gob.cusco.centro_medico.attention.dto.LaboratoryOrderDTO;
import pe.gob.cusco.centro_medico.attention.dto.LaboratoryOrderDTO.CreateLaboratoryOrderDTO;
import pe.gob.cusco.centro_medico.attention.dto.LaboratoryOrderDTO.FiltersLaboratoryOrderDTO;
import pe.gob.cusco.centro_medico.attention.dto.LaboratoryOrderDTO.UpdateLaboratoryOrderDTO;
import pe.gob.cusco.centro_medico.attention.entity.Appointment;
import pe.gob.cusco.centro_medico.attention.entity.LaboratoryOrder;
import pe.gob.cusco.centro_medico.attention.mapper.AppointmentMapper;
import pe.gob.cusco.centro_medico.attention.mapper.LaboratoryOrderMapper;
import pe.gob.cusco.centro_medico.attention.repository.LaboratoryOrderRepository;
import pe.gob.cusco.centro_medico.attention.service.LaboratoryOrderService;
import pe.gob.cusco.centro_medico.shared.BaseServiceImpl;
import pe.gob.cusco.centro_medico.shared.PagedResponse;

@Service
public class LaboratoryOrderServiceImpl extends
        BaseServiceImpl<LaboratoryOrder, CreateLaboratoryOrderDTO, UpdateLaboratoryOrderDTO, LaboratoryOrderDTO, FiltersLaboratoryOrderDTO>
        implements LaboratoryOrderService {
    private final LaboratoryOrderRepository repository;
    private final AppointmentMapper appointmentMapper;

    public LaboratoryOrderServiceImpl(LaboratoryOrderRepository repository,
            LaboratoryOrderMapper mapper, AppointmentMapper appointmentMapper) {
        super(repository, mapper);
        this.repository = repository;
        this.appointmentMapper = appointmentMapper;

    }

    @Override
    public LaboratoryOrderDTO create(CreateLaboratoryOrderDTO request) {
        request.setStatus("PENDIENTE");
        return super.create(request);
    }

    @Override
    public List<LaboratoryOrderDTO> createAll(List<CreateLaboratoryOrderDTO> request) {
        return request.stream().map(this::create).toList();
    }

    @Override
    public List<LaboratoryOrderDTO> getByAppointmentId(Long appointment) {
        return super.mapper.toDTOList(repository.findByAppointmentId(appointment));
    }

    @Override
    public List<AppointmentDTO> getAppointmentsWithPendingLaboratoryOrders() {

        Set<AppointmentDTO> appointments = super.getAll().stream()

                .map(order -> order.getAppointment()).collect(
                        Collectors.toSet());
        return appointments.stream().toList();

    }

    @Override
    public PagedResponse<AppointmentDTO> getAppointments(int page, int size, FiltersLaboratoryOrderDTO filters) {
        Pageable pageable = PageRequest.of(page, size);

        Page<Appointment> appointments = repository.findDistinctAppointmentsByStatusLike(filters.getStatus(), pageable);
        List<AppointmentDTO> appointmentDTOs = appointmentMapper.toDTOList(appointments.getContent());
        return new PagedResponse<>(
                appointmentDTOs,
                appointments.getNumber(),
                appointments.getSize(),
                appointments.getTotalElements(),
                appointments.getTotalPages(),
                appointments.isLast());

    }

}