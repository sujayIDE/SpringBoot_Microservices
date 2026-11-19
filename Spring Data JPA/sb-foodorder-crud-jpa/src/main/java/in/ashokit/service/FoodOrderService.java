package in.ashokit.service;

import in.ashokit.entity.FoodOrderEntity;
import in.ashokit.repository.FoodOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodOrderService {

    @Autowired
    private FoodOrderRepository foodOrderRepository;

    public FoodOrderEntity saveFoodOrder(FoodOrderEntity foodOrderEntity)
    {
        FoodOrderEntity save = foodOrderRepository.save(foodOrderEntity);
        return save;
    }

    public FoodOrderEntity updateFoodOrder(Integer id,FoodOrderEntity foodOrderEntity)
    {
        Optional<FoodOrderEntity> byId = foodOrderRepository.findById(id);
        if(byId.isPresent())
        {
           return foodOrderRepository.save(foodOrderEntity);
        }else {
            return null;
        }
    }

    public void deleteFoodOrder(Integer id)
    {
        Optional<FoodOrderEntity> byId = foodOrderRepository.findById(id);
        if(byId.isPresent())
        {
            foodOrderRepository.deleteById(id);
        }
    }

    public List<FoodOrderEntity> getAllOrders()
    {
        return foodOrderRepository.findAll();
    }

    public List<FoodOrderEntity> getFoodOrderByName(String foodName){
        return foodOrderRepository.findByFoodName(foodName);
    }
}
