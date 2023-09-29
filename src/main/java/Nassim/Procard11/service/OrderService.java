package Nassim.Procard11.service;

import Nassim.Procard11.model.Order;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public interface OrderService {
    public List<Order> getOrders();
    public void saveFromFile(InputStream inputStream) throws IOException;
}
