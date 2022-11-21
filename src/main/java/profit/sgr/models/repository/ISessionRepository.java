package profit.sgr.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import profit.sgr.models.entity.Session;

public interface ISessionRepository extends JpaRepository<Session, Long> {
    
}
