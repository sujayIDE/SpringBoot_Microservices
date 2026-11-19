package in.ashokit.restcontroller;

import in.ashokit.entity.FoodOrderEntity;
import in.ashokit.exception.FoodOrderNotFoundException;
import in.ashokit.service.FoodOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FoodOrderRestController {

    @Autowired
    private FoodOrderService foodOrderService;

    @PostMapping("/create")
    public ResponseEntity<FoodOrderEntity> createFoodOrder(@RequestBody FoodOrderEntity foodOrderEntity){
        FoodOrderEntity create = foodOrderService.saveFoodOrder(foodOrderEntity);
        if(create!=null)
        {
            return new ResponseEntity<>(create, HttpStatus.CREATED);
        }else{
           throw new FoodOrderNotFoundException("Food Order is not created...");
        }
    }

    @GetMapping("/display")
    public ResponseEntity<List<FoodOrderEntity>> getAllFoodOrders()
    {
        List<FoodOrderEntity> allOrders = foodOrderService.getAllOrders();
        if(!allOrders.isEmpty())
        {
            return new ResponseEntity<>(allOrders,HttpStatus.OK);
        }else{
            throw new FoodOrderNotFoundException("FoodOrder is not present");
        }
    }

    @GetMapping("/displayfood/{foodName}")
    public ResponseEntity<List<FoodOrderEntity>> getFoodOrderByName(@PathVariable String foodName)
    {
        List<FoodOrderEntity> foodOrderByName = foodOrderService.getFoodOrderByName(foodName);
        if(!foodOrderByName.isEmpty())
        {
            return new ResponseEntity<>(foodOrderByName,HttpStatus.OK);
        }else{
            throw new FoodOrderNotFoundException("Food order by this name is not present");
        }
    }

}
