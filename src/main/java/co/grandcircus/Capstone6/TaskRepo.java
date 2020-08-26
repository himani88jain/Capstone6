package co.grandcircus.Capstone6;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepo extends JpaRepository<Task,Long> {

	List<Task> findByUserId(Long userId);
}
