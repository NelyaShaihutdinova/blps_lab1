package org.example.blps_lab1.services;

import org.example.blps_lab1.dto.request.CreditRequest;
import org.example.blps_lab1.dto.response.CreditResponse;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Random;

@Service
public class CreditService {
    private final Random random = new Random();
    public CreditResponse getCreditDecision(CreditRequest creditRequest) {
        CreditResponse response = new CreditResponse();
        boolean isApproved = random.nextBoolean();
        response.setApproved(isApproved);

        if (isApproved) {
            response.setOffers(Arrays.asList(
                    "Кредит на 3 года с 8% годовых",
                    "Кредит на 5 лет с 10% годовых"
            ));
        } else {
            response.setRejectionReason("Низкий кредитный рейтинг");
        }
        return response;
    }
}
