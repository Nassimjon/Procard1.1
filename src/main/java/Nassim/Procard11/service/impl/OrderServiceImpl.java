package Nassim.Procard11.service.impl;

import Nassim.Procard11.model.Order;
import Nassim.Procard11.repository.OrderRepository;
import Nassim.Procard11.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

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

}
