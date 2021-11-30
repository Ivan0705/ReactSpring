package reactspring.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import reactspring.demo.model.Employer;

@Repository
public interface EmployerRepository extends JpaRepository<Employer, Long> {
}

