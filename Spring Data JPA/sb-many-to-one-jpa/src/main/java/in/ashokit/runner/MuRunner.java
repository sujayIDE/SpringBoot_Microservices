package in.ashokit.runner;

import in.ashokit.enitity.CustomerEntity;
import in.ashokit.enitity.OrderEntity;
import in.ashokit.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Optional;

@Component
public class MuRunner implements ApplicationRunner {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        saveOrder();
        System.out.println("=================================");
        fetchOrder("09198a04-b0b7-449b-add1-dd437d43df66");
    }

    private void saveOrder() {
        OrderEntity orderEntity=new OrderEntity();
        orderEntity.setOrder_date(LocalDate.now());
        orderEntity.setStatus("Shipped");

        CustomerEntity customerEntity=new CustomerEntity();
        customerEntity.setCustomer_name("Sujay");
        customerEntity.setCustomer_email("sujay@gmail.com");
        orderEntity.setCustomerEntity(customerEntity);

        orderRepository.save(orderEntity);
    }

    public void fetchOrder(String id){
        Optional<OrderEntity> byId = orderRepository.findById(id);
        OrderEntity orderEntity = byId.get();
        System.out.println(orderEntity.getOrder_id());
        System.out.println(orderEntity.getOrder_date());
        System.out.println(orderEntity.getStatus());
        System.out.println(orderEntity.getCustomerEntity().toString());
    }
}
