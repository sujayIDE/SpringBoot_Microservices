package in.ashokit.runner;

import in.ashokit.entity.Customer;
//import in.ashokit.entity.Order;
import in.ashokit.entity.Product;
import in.ashokit.entity.Review;
import in.ashokit.repository.CustomerRepository;
//import in.ashokit.repository.OrderRepository;
import in.ashokit.repository.ProductRepository;
import in.ashokit.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class MyRunner implements ApplicationRunner {

    @Autowired
    CustomerRepository customerRepository;

//    @Autowired
//    OrderRepository orderRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ReviewRepository reviewRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        saveCustomer();
        System.out.println("============================");
//        bookOrder();
        System.out.println("=============================");
        addProduct();
        System.out.println("============================");
        addReview();
    }

    private void saveCustomer()
    {
       Customer customer=new Customer();
       customer.setName("Ajay");
       customer.setEmail("ajay@gmail.com");
       customerRepository.save(customer);
    }

//    private void bookOrder()
//    {
//        Order order=new Order();
//        order.setOrderName("Pizza");
//        orderRepository.save(order);
//    }

    private void addProduct()
    {
        Product product1=new Product();
        product1.setProduct_name("Laptop");
        product1.setPrice(45000.0);

        Product product2=new Product();
        product2.setProduct_name("Mobile");
        product2.setPrice(23000.0);

        productRepository.save(product1);
        productRepository.save(product2);
    }

    private void addReview()
    {
        Review review=new Review();
        review.setReview("Food is delicious");

        reviewRepository.save(review);
    }
}
