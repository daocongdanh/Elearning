package com.example.elearning.services;

import com.example.elearning.dtos.PaymentMethodDTO;
import com.example.elearning.models.PaymentMethod;

import java.util.List;

public interface PaymentMethodService {
    PaymentMethod createPaymentMethod(PaymentMethodDTO paymentMethodDTO);
    PaymentMethod updatePaymentMethod(long id, PaymentMethodDTO paymentMethodDTO);
    PaymentMethod getPaymentMethodById(long id);
    List<PaymentMethod> getAllPaymentMethods();
}
