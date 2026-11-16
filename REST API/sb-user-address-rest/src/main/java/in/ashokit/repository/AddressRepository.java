package in.ashokit.repository;

import in.ashokit.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<AddressEntity,Integer> {
    public List<AddressEntity> findByUserEntity_UserId(Integer userId);
}
