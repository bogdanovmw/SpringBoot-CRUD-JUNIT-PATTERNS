package ru.bogdanov.SpringBootCrudAndJunit.patterns.chainOfResponsibility.service;

import org.springframework.stereotype.Service;
import ru.bogdanov.SpringBootCrudAndJunit.patterns.chainOfResponsibility.model.Order;
import ru.bogdanov.SpringBootCrudAndJunit.patterns.chainOfResponsibility.model.Product;
import ru.bogdanov.SpringBootCrudAndJunit.patterns.chainOfResponsibility.service.dop.InsuranceService;
import ru.bogdanov.SpringBootCrudAndJunit.patterns.chainOfResponsibility.service.dop.PackagingService;
import ru.bogdanov.SpringBootCrudAndJunit.patterns.chainOfResponsibility.service.dop.SmsNotificator;
import ru.bogdanov.SpringBootCrudAndJunit.patterns.chainOfResponsibility.service.dop.TestingsService;

@Service
public class OrderServiceWithoutCor {
    private final OrderRepository orderRepository;
    private final SmsNotificator smsNotificator;
    private final InsuranceService insuranceService;
    private final PackagingService packagingService;
    private final TestingsService testingsService;

    public OrderServiceWithoutCor(OrderRepository orderRepository, SmsNotificator smsNotificator, InsuranceService insuranceService, PackagingService packagingService, TestingsService testingsService) {
        this.orderRepository = orderRepository;
        this.smsNotificator = smsNotificator;
        this.insuranceService = insuranceService;
        this.packagingService = packagingService;
        this.testingsService = testingsService;
    }

    public boolean createOrder(Order order) {
        String orderId = order.getId();

        orderRepository.orderSave(order);
        if (order.isSmsNotification())
            smsNotificator.enableNotifications(orderId, order.getPhoneNumber());

        for (Product product : order.getProducts()) {
            String productId = product.getId();

            if (product.isInsurance())
                insuranceService.insure(productId, orderId);

            if (product.isFestivePackaging())
                packagingService.festivelyPack(productId, orderId);

            if (product.isTesting())
                testingsService.testProduct(productId, orderId);
        }

        return true;
    }
}
