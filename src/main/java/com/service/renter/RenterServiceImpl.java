package com.service.renter;

import com.domain.renter.InputRenter;
import com.domain.renter.Renter;
import com.repository.RenterRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class RenterServiceImpl implements RenterService{

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private RenterRepository repository;

    /**
     * {@inheritDoc}
     */
    @Override
    public Renter findByName(String accountName) {
        Assert.hasLength(accountName);
        return repository.findFirstByfullName(accountName);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Renter create(InputRenter user) {

        Renter existing = repository.findFirstByfullName(user.getFullName());
        Assert.isNull(existing, "renter account already exists: " + user.getFullName());

        Renter account = new Renter();
        account.setFullName(user.getFullName());

        repository.save(account);

        log.info("new renter account has been created: " + user.getFullName());

        return account;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(int id) {

        Renter existing = repository.findOne(id);
        Assert.notNull(existing, "renter account with same id does not exists: " + id);

        repository.delete(id);

        log.info("renter account has been deleted: " + id);
    }
}

