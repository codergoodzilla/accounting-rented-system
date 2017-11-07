package com.service.dictionary;

import com.domain.dictionary.VehicleCategory;
import com.repository.VehicleCategoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class VehicleCategoryServiceImpl implements VehicleCategoryService {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private VehicleCategoryRepository repository;

    /**
     * {@inheritDoc}
     */
    @Override
    public Iterable<VehicleCategory> getAll() {
        return repository.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public VehicleCategory findByName(String name) {
        Assert.hasLength(name);
        return repository.findFirstByname(name);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public VehicleCategory create(String name) {

        VehicleCategory existing = repository.findFirstByname(name);
        Assert.isNull(existing, "vehicle category with same name already exists: " + name);

        VehicleCategory category = new VehicleCategory();
        category.setName(name);

        repository.save(category);

        log.info("new vehicle category has been created: " + name);

        return category;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(int id) {

        VehicleCategory existing = repository.findOne(id);
        Assert.notNull(existing, "vehicle category with same id does not exists: " + id);

        repository.delete(id);

        log.info("vehicle category has been deleted: " + id);
    }
}