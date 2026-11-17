package in.ashokit.restcontroller;

import in.ashokit.entity.AddressEntity;
import in.ashokit.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/address")
public class AddressRestController {

    @Autowired
    private AddressService addressService;

    @PostMapping("/create/{userId}")
    public ResponseEntity<AddressEntity> createAddress(@PathVariable Integer userId, @RequestBody AddressEntity addressEntity){
        AddressEntity addressEntity1 = addressService.saveAddress(userId, addressEntity);
        return new ResponseEntity<>(addressEntity, HttpStatus.CREATED);
    }

    @PutMapping("/update/{addressId}")
    public ResponseEntity<AddressEntity> updateAddress(@PathVariable Integer addressId,@RequestBody AddressEntity addressEntity)
    {
        AddressEntity updateAddress = addressService.updateAddress(addressId, addressEntity);
        if(updateAddress!=null)
        {
            return new ResponseEntity<>(updateAddress,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(updateAddress,HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{addressId}")
    public ResponseEntity<AddressEntity> deleteAddress(@PathVariable Integer addressId){
        AddressEntity addressEntity = addressService.deleteAddress(addressId);
        if(addressEntity!=null)
        {
            return new ResponseEntity<>(addressEntity,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(addressEntity,HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/addresses/{userid}")
    public ResponseEntity<List<AddressEntity>> getaddressByUserId(@PathVariable Integer userid)
    {
        List<AddressEntity> addressesByUserId = addressService.getAddressesByUserId(userid);
        return new ResponseEntity<>(addressesByUserId,HttpStatus.OK);
    }

    @GetMapping("/add/{addressId}")
    public ResponseEntity<AddressEntity> getaddressById(@PathVariable Integer addressId)
    {
        AddressEntity addressById = addressService.getAddressById(addressId);
        return new ResponseEntity<>(addressById,HttpStatus.OK);
    }
}
