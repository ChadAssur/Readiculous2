package za.ac.readiculous.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.readiculous.domain.JoinPage;
import za.ac.readiculous.repository.JoinPageRepository;

import java.util.List;

@Service
public class JoinPageService implements IJoinPageService {

    private final JoinPageRepository repository;

    @Autowired
    public JoinPageService(JoinPageRepository repository) {
        this.repository = repository;
    }

    @Override
    public JoinPage create(JoinPage joinPage) {
        return this.repository.save(joinPage);
    }

    @Override
    public JoinPage read(Long id) {
        return this.repository.findById(id).orElse(null);
    }

    @Override
    public JoinPage update(JoinPage joinPage) {
        return this.repository.save(joinPage);
    }

    @Override
    public boolean delete(Long id) {
        if (this.repository.existsById(id)) {
            this.repository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<JoinPage> getAll() {
        return this.repository.findAll();
    }
}

