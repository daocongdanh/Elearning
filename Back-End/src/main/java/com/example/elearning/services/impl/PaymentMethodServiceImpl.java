package com.example.elearning.services.impl;

import com.example.elearning.dtos.PaymentMethodDTO;
import com.example.elearning.exceptions.ResourceNotFoundException;
import com.example.elearning.models.PaymentMethod;
import com.example.elearning.repositories.PaymentMethodRepository;
import com.example.elearning.services.PaymentMethodService;
import com.example.elearning.utils.FileUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentMethodServiceImpl implements PaymentMethodService {
    private final PaymentMethodRepository paymentMethodRepository;
    private final FileUtil fileUtil;
    @Override
    @Transactional
    public PaymentMethod createPaymentMethod(PaymentMethodDTO paymentMethodDTO) {
        PaymentMethod paymentMethod = PaymentMethod.builder()
                .name(paymentMethodDTO.getName())
                .status(true)
                .build();

        String image = fileUtil.uploadImage(paymentMethodDTO.getFile());
        if(StringUtils.hasLength(image)){
            paymentMethod.setImage(image);
        }
        paymentMethodRepository.save(paymentMethod);
        return paymentMethod;
    }

    @Override
    @Transactional
    public PaymentMethod updatePaymentMethod(long id, PaymentMethodDTO paymentMethodDTO) {
        PaymentMethod paymentMethod = getPaymentMethodById(id);
        paymentMethod.setName(paymentMethodDTO.getName());
        String image = fileUtil.uploadImage(paymentMethodDTO.getFile());
        if(StringUtils.hasLength(image)){
            paymentMethod.setImage(image);
        }
        paymentMethodRepository.save(paymentMethod);
        return paymentMethod;
    }

    @Override
    public PaymentMethod getPaymentMethodById(long id) {
        return paymentMethodRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Payment method not found"));
    }

    @Override
    public List<PaymentMethod> getAllPaymentMethods() {
        return paymentMethodRepository.findAll();
    }

}
