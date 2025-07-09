package com.bit.backend.services.impl;


import com.bit.backend.dtos.PaymentsDto;

import java.util.List;

public interface PaymentsServiceI {

    PaymentsDto addPaymentsEntity(PaymentsDto paymentsDto);
    List<PaymentsDto> getData();
    PaymentsDto updatePayments(long id, PaymentsDto paymentsDto);
    PaymentsDto deletePayments(long id);
}
