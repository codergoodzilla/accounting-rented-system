package com.service.dictionary;

import com.domain.dictionary.InputVehicleModel;
import com.domain.dictionary.VehicleCategory;
import com.domain.dictionary.VehicleMark;
import com.domain.dictionary.VehicleModel;
import com.repository.VehicleCategoryRepository;
import com.repository.VehicleMarkRepository;
import com.repository.VehicleModelRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class VehicleModelServiceImpl implements VehicleModelService {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private VehicleModelRepository repository;

    @Autowired
    private VehicleCategoryRepository categoryRepository;

    @Autowired
    private VehicleMarkRepository markRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public Iterable<VehicleModel> getAll() {
        return repository.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public VehicleModel findByName(String name) {
        Assert.hasLength(name);
        return repository.findFirstByname(name);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<VehicleModel> findByCategoryAndMark(int categoryId, int markId) {
        Assert.notNull(categoryId);
        Assert.notNull(markId);
        return repository.findByCategoryAndMark(categoryId, markId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public VehicleModel create(InputVehicleModel vehicleModel) {

        VehicleModel existing = repository.findFirstByname(vehicleModel.getName());
        Assert.isNull(existing, "vehicle model with same name already exists: " + vehicleModel.getName());

        VehicleCategory existCategory = categoryRepository.findOne(vehicleModel.getCategotyId());
        Assert.notNull(existCategory, "vehicle category with same id does not exists: " + vehicleModel.getCategotyId());

        VehicleMark existMark = markRepository.findOne(vehicleModel.getMarkId());
        Assert.notNull(existMark, "vehicle mark with same id does not exists: " + vehicleModel.getMarkId());

        VehicleModel model = new VehicleModel();
        model.setCategoryId(vehicleModel.getCategotyId());
        model.setMarkId(vehicleModel.getMarkId());
        model.setName(vehicleModel.getName());

        repository.save(model);

        log.info("new vehicle model has been created: " + model.getName());

        return model;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(int id) {

        VehicleModel existing = repository.findOne(id);
        Assert.notNull(existing, "vehicle model with same id does not exists: " + id);

        repository.delete(id);

        log.info("vehicle model has been deleted: " + id);
    }
    }