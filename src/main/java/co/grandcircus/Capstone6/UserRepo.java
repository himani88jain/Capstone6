package co.grandcircus.Capstone6;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepo  extends JpaRepository<User,Long>{
	
	Optional<User> findByEmailAndPassword(String email,String password);

}
