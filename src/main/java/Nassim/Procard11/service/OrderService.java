package Nassim.Procard11.service;

import Nassim.Procard11.model.Order;
import Nassim.Procard11.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.nio.file.Path;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService  {

    @Autowired
    private OrderRepository orderRepository;

//    public OrderService(OrderRepository orderRepository) {
//        this.orderRepository = orderRepository;
//    }

    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    public void saveFromFile(InputStream fileInputStream) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(fileInputStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 13) {
                    Order order = new Order();
                    order.setClientPan(parts[0]);     //1
                    order.setClientMbr(parts[1]);     //2
                    order.setServiceCode(parts[2]);   //3
                    String[] splitName = (parts[3].split("\\ ")); //4
                    order.setFirstName(splitName[0]);
                    order.setSecondName(splitName[1]);
                    String[] splitNameOnCard = (parts[4].split("\\/")); //5
                    order.setFirstNameOnCard(splitNameOnCard[0]);
                    order.setSecondNameOnCard(splitNameOnCard[1]);
                    order.setCardDateInput(parts[5]);  //6
                    order.setCardDateExpire(parts[6]); //7
                    order.setFullNameOnEnv(parts[7]);  //8
                    order.setBankName(parts[9]);
                    order.setCardStatus(parts[10]);
                    order.setPassportNo(parts[12]);
                    orderRepository.save(order);
                }
            }
        }
    }




    public void filterAndSaveAmonatbonkLines(String filePath) throws IOException {
        List<String> filteredLines = Files.lines(Paths.get(filePath))
                .filter(line -> line.contains("AMONATBONK"))
                .collect(Collectors.toList());

        // Save the filtered lines to a new file
        Files.write(Paths.get("filtered_lines.txt"), filteredLines);
    }

    public void splitFileByKeywords(String inputFilePath, String[] keywords) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(inputFilePath));

        for (String keyword : keywords) {
            List<String> filteredLines = lines.stream()
                    .filter(line -> line.contains(keyword))
                    .collect(java.util.stream.Collectors.toList());

            if (!filteredLines.isEmpty()) {
                saveToFile(keyword + "_output.txt", filteredLines);
            }
        }
    }

    private void saveToFile(String outputFilePath, List<String> lines) throws IOException {
        Path outputPath = Paths.get(outputFilePath);
        Files.write(outputPath, lines);
    }

}
