package Nassim.Procard11.controller;

import Nassim.Procard11.model.Order;
import Nassim.Procard11.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/procard")
public class OrderController {

    @Autowired
    OrderService orderService;


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


    @PostMapping("/processFile")
    public String processFile(@RequestParam("file") MultipartFile file) {
        try {
            // Save the uploaded file to a temporary location
            String filePath = "temp.txt";
            file.transferTo(Paths.get(filePath));

            // Filter and save AMONATBONK lines
            orderService.filterAndSaveAmonatbonkLines(filePath);

            return "File processed successfully.";
        } catch (IOException e) {
            return "Error processing the file: " + e.getMessage();
        }
    }

    @PostMapping("/splitByKeywords")
    public ResponseEntity<String> splitFileByKeywords(@RequestParam("file") MultipartFile file) {
        try {
            String[] keywords = {"AMONATBONK", "ORIYONBONK", "SPITAMENBONK"};
            file.transferTo(Paths.get(String.valueOf(file)));
            orderService.splitFileByKeywords(String.valueOf(file), keywords);
            return ResponseEntity.ok("File successfully split by keywords.");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error splitting the file: " + e.getMessage());
        }
    }


}
