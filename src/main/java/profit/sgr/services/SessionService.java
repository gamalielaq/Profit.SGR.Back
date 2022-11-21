package profit.sgr.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import profit.sgr.models.entity.Session;
import profit.sgr.models.repository.ISessionRepository;
import profit.sgr.services.interfaces.ISessionService;

@Service
public class SessionService implements ISessionService {

    @Autowired
    private ISessionRepository repository;

    @Override
    public Session save(Session session) {
        session.setDate(null);
        return repository.save(session);
    }
}
