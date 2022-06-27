package Group20SpringBoot.Group20.user.repository;

import Group20SpringBoot.Group20.user.entity.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
}

