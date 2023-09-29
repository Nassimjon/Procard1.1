package Nassim.Procard11.controller;

import Nassim.Procard11.model.Order;
import Nassim.Procard11.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/procard")
public class OrderController {

    OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/getOrders")
    public List<Order> getOrders() {
        return orderService.getOrders();
    }

    @PostMapping("/saveFromFile")
    public ResponseEntity<Void> addOrdersFrromFile(@RequestParam("file") MultipartFile file) {
        try {
            orderService.saveFromFile(file.getInputStream());
            return ResponseEntity.ok().build();
        } catch (IOException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
