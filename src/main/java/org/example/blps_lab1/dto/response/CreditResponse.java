package org.example.blps_lab1.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CreditResponse {
    private boolean isApproved;
    private List<String> offers;
    private String rejectionReason;
}
