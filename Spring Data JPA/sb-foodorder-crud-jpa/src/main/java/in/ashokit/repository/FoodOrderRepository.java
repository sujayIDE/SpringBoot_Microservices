package in.ashokit.repository;

import in.ashokit.entity.FoodOrderEntity;
import in.ashokit.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FoodOrderRepository extends JpaRepository<FoodOrderEntity,Integer> {

    public List<FoodOrderEntity> findByCustomerName(String customerName);

    List<FoodOrderEntity> findByOrderStatus(Status orderStatus);

    public FoodOrderEntity findByPriceGreaterThan(Integer price);

    @Query(value = "select e from FoodOrderEntity e where e.foodName=:foodName", nativeQuery = false)
    public List<FoodOrderEntity> findByFoodName(String foodName);
}
