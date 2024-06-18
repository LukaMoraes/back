package spring.tuto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring.tuto.Models.Tasks;
import java.util.List;


@Repository
public interface TasksRepository extends JpaRepository<Tasks, Long> {
    
    
    List<Tasks> findByUser_Id(Long id);

}
