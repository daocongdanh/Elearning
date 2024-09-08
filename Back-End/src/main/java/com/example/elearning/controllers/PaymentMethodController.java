package com.example.elearning.controllers;

import com.example.elearning.dtos.PaymentMethodDTO;
import com.example.elearning.responses.ResponseSuccess;
import com.example.elearning.services.PaymentMethodService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${api.prefix}/payment-methods")
@RequiredArgsConstructor
public class PaymentMethodController {
    private final PaymentMethodService paymentMethodService;

    @PostMapping(value = "", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ResponseSuccess> createPaymentMethod(
            @Valid @ModelAttribute PaymentMethodDTO paymentMethodDTO){
        return ResponseEntity.ok().body(ResponseSuccess.builder()
                .message("Create payment method successfully")
                .status(HttpStatus.CREATED.value())
                .data(paymentMethodService.createPaymentMethod(paymentMethodDTO))
                .build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseSuccess> getPaymentMethodById(@PathVariable long id){
        return ResponseEntity.ok().body(ResponseSuccess.builder()
                .message("Get payment method information successfully")
                .status(HttpStatus.OK.value())
                .data(paymentMethodService.getPaymentMethodById(id))
                .build());
    }

    @GetMapping("")
    public ResponseEntity<ResponseSuccess> getAllPaymentMethods(){
        return ResponseEntity.ok().body(ResponseSuccess.builder()
                .message("Get all payment methods information successfully")
                .status(HttpStatus.OK.value())
                .data(paymentMethodService.getAllPaymentMethods())
                .build());
    }

    @PutMapping(value = "/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ResponseSuccess> updatePaymentMethod(@PathVariable long id,
                                                               @Valid @ModelAttribute PaymentMethodDTO paymentMethodDTO){
        return ResponseEntity.ok().body(ResponseSuccess.builder()
                .message("Update payment method successfully")
                .status(HttpStatus.OK.value())
                .data(paymentMethodService.updatePaymentMethod(id, paymentMethodDTO))
                .build());
    }

}
