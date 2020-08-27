package co.grandcircus.Capstone6;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



public interface TaskRepo extends JpaRepository<Task,Long> {

	List<Task> findByUserId(Long userId);
	
	@Query("from Task where description like %:prefix% and user_id=:userId")
	 List<Task> findTaskByUserIdAndName(@Param("prefix") String name,@Param("userId") Long userId);
	
	@Query("from Task where user_id=:userId order by duedate ")
	List<Task> findByUserIdAndOrderByDuedateDesc(@Param("userId") Long userId);

	}
