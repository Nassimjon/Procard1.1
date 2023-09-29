package Nassim.Procard11.repository;

import Nassim.Procard11.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
