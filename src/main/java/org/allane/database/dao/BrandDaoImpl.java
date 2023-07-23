package org.allane.database.dao;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.allane.model.Brand;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BrandDaoImpl implements BrandDao {

    @NonNull
    private DaoFactory daoFactory;

    @Override
    public List<Brand> getAllBrandsAndModels() {
        return daoFactory.getBrandRepository().findAll();
    }
}
