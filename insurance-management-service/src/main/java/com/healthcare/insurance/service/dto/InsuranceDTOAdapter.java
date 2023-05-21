package com.healthcare.insurance.service.dto;

import com.healthcare.insurance.model.InsuranceClaim;

public class InsuranceDTOAdapter {
    public static InsuranceClaim getInsurance(InsuranceClaimRequest insuranceClaimRequest){
        return  new InsuranceClaim()
                .builder()
                .patientId(insuranceClaimRequest.getPatientId())
                .billedAmount(insuranceClaimRequest.getBilledAmount())
                .insurance(insuranceClaimRequest.getInsurance())
                .diagnosisCodes(insuranceClaimRequest.getDiagnosisCodes())
                .procedureCodes(insuranceClaimRequest.getProcedureCodes())
                .build();

    }

}
