package civil.dpr.domain.service;

import civil.dpr.application.dto.Request;
import civil.dpr.application.dto.workSummary.create.*;
import civil.dpr.domain.boundary.*;
import civil.dpr.domain.dto.workSummary.WorkSummaryCreateResponse;
import civil.dpr.domain.entities.*;
import civil.dpr.domain.enums.ApprovalEnum;
import civil.dpr.domain.exception.DomainException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class WorkSummaryService implements CommonService{

    @Autowired
    private WorkSummaryRepository workSummaryRepository;
    @Autowired
    private MaterialRepository materialRepository;
    @Autowired
    private LabourRepository labourRepository;
    @Autowired
    private MachineryRepository machineryRepository;

    @Autowired
    private UsedMaterialRepository usedMaterialRepository;
    @Autowired
    private UsedMachineryRepository usedMachineryRepository;
    @Autowired
    private UsedLabourRepository usedLabourRepository;

    @Autowired
    private BoqCodeRepository boqRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private WorkItemRepository workItemRepository;

    public WorkSummaryCreateResponse createWorkSummary(Request<WorkSummaryCreateRequestBody> request) throws DomainException {

        if (Objects.nonNull(request.getRequestBody().getWorkSummaryCreateDetailList()) && !request.getRequestBody().getWorkSummaryCreateDetailList().isEmpty()){

            for (WorkSummaryCreateDetail workSummary : request.getRequestBody().getWorkSummaryCreateDetailList()){
                // creating work summary entity
                WorkSummaryEntity workSummaryEntity = new WorkSummaryEntity();
                workSummaryEntity.setWorkItemEntityId(getWorkEntityById(workSummary.getWorkItemId()));
                workSummaryEntity.setWorkDate(workSummaryEntity.getWorkDate());
                workSummaryEntity.setUserEntityId(getUserEntityById(workSummary.getUserId()));
                workSummaryEntity.setBoqCodeEntityId(getBoqEntityById(workSummary.getBoqId()));
                workSummaryEntity.setCompletedQuantity(workSummary.getCompletedQuantity());
                workSummaryEntity.setApprovalStatus(ApprovalEnum.PENDING);
                WorkSummaryEntity createdWorkSummary = workSummaryRepository.saveAndFlush(workSummaryEntity);

                // creating used materials
                if (Objects.nonNull(workSummary.getUsedMaterialDetailList()) && !workSummary.getUsedMaterialDetailList().isEmpty()){
                    List<UsedMaterialEntity> usedMaterialEntityList = new ArrayList<>();
                    for (UsedMaterialDetail usedMaterialDetail : workSummary.getUsedMaterialDetailList()){
                        UsedMaterialEntity usedMaterialEntity = new UsedMaterialEntity();
                        usedMaterialEntity.setMaterialEntityId(getMaterialById(usedMaterialDetail.getMaterialId()));
                        usedMaterialEntity.setUsedQuantity(usedMaterialDetail.getQuantity());
                        usedMaterialEntity.setWorkSummaryEntityId(createdWorkSummary);
                        usedMaterialEntityList.add(usedMaterialEntity);
                    }
                    usedMaterialRepository.saveAllAndFlush(usedMaterialEntityList);
                }

                // creating used machinery
                if (Objects.nonNull(workSummary.getUsedMachineryDetailList()) && !workSummary.getUsedMachineryDetailList().isEmpty()){
                    List<UsedMachineryEntity> usedMachineryEntityList = new ArrayList<>();
                    for (UsedMachineryDetail usedMachineryDetail : workSummary.getUsedMachineryDetailList()){
                        UsedMachineryEntity usedMachineryEntity = new UsedMachineryEntity();
                        usedMachineryEntity.setMachineryEntityId(getMachineryById(usedMachineryDetail.getMachineryId()));
                        usedMachineryEntity.setUsedQuantity(usedMachineryDetail.getQuantity());
                        usedMachineryEntity.setWorkSummaryEntityId(createdWorkSummary);
                        usedMachineryEntityList.add(usedMachineryEntity);
                    }
                    usedMachineryRepository.saveAllAndFlush(usedMachineryEntityList);
                }

                // creating used labour
                if (Objects.nonNull(workSummary.getUsedLabourDetailList()) && !workSummary.getUsedLabourDetailList().isEmpty()){
                    List<UsedLabourEntity> usedLabourEntityList = new ArrayList<>();
                    for (UsedLabourDetail usedLabourDetail : workSummary.getUsedLabourDetailList()){
                        UsedLabourEntity usedLabourEntity = new UsedLabourEntity();
                        usedLabourEntity.setLabourEntityId(getLabourEntityById(usedLabourDetail.getLabourId()));
                        usedLabourEntity.setUsedQuantity(usedLabourDetail.getQuantity());
                        usedLabourEntity.setWorkSummaryEntityId(createdWorkSummary);
                        usedLabourEntityList.add(usedLabourEntity);
                    }
                    usedLabourRepository.saveAllAndFlush(usedLabourEntityList);
                }
            }
        }

        return new WorkSummaryCreateResponse(createResponseHeader(request.getRequestHeader()));
    }

    private LabourEntity getLabourEntityById(Long labourId) throws DomainException {
        try {
            return labourRepository.labourDetailsById(labourId, LocalDateTime.now());
        } catch (Exception ex){
            throw new DomainException("error occurred while getting Labour details", "");
        }
    }

    private MachineryEntity getMachineryById(Long machineryId) throws DomainException {
        try {
            return machineryRepository.machineryDetailsById(machineryId, LocalDateTime.now());
        } catch (Exception ex){
            throw new DomainException("error occurred while getting Machinery details", "");
        }
    }

    private MaterialEntity getMaterialById(Long materialId) throws DomainException {
        try {
            return materialRepository.MaterialDetailsById(materialId, LocalDateTime.now());
        } catch (Exception ex){
            throw new DomainException("error occurred while getting Material details", "");
        }
    }

    private BoqCodeEntity getBoqEntityById(Long boqId) throws DomainException {
        try {
            return boqRepository.boqDetailsById(boqId, LocalDateTime.now());
        } catch (Exception ex){
            throw new DomainException("error occurred while getting BOQ details", "");
        }

    }

    private UserEntity getUserEntityById(Long userId) throws DomainException {
        try {
            return userRepository.userDeatailsById(userId, LocalDateTime.now());
        } catch (Exception ex){
            throw new DomainException("error occurred while getting Labour details", "");
        }
    }

    private WorkItemEntity getWorkEntityById(Long workItemId) throws DomainException {
        try {
            return workItemRepository.workItemDetailsById(workItemId, LocalDateTime.now());
        } catch (Exception ex){
            throw new DomainException("error occurred while getting Labour details", "");
        }
    }
}
