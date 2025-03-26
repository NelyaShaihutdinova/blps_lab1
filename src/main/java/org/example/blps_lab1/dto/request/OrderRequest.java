package org.example.blps_lab1.dto.request;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderRequest {
    private String status;
    private List<Long> productsId;
    private Long storeId;
    private Long userId;
}
