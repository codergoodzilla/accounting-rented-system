package com.service.dictionary;

import com.domain.dictionary.VehicleMark;
import com.repository.VehicleMarkRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class VehicleMarkServiceImpl implements VehicleMarkService {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private VehicleMarkRepository repository;

    /**
     * {@inheritDoc}
     */
    @Override
    public Iterable<VehicleMark> getAll() {
        return repository.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public VehicleMark findByName(String name) {
        Assert.hasLength(name);
        return repository.findFirstByname(name);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public VehicleMark create(String name) {

        VehicleMark existing = repository.findFirstByname(name);
        Assert.isNull(existing, "vehicle mark with same name already exists: " + name);

        VehicleMark mark = new VehicleMark();
        mark.setName(name);

        repository.save(mark);

        log.info("new vehicle mark has been created: " + name);

        return mark;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(int id) {

        VehicleMark existing = repository.findOne(id);
        Assert.notNull(existing, "vehicle mark with same id does not exists: " + id);

        repository.delete(id);

        log.info("vehicle mark has been deleted: " + id);
    }
}