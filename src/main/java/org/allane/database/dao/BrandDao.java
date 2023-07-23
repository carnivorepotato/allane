package org.allane.database.dao;

import org.allane.model.Brand;

import java.util.List;

public interface BrandDao {

    /**
     * Returns vehicle brands with model names
     * @return List of vehicle brands with model names
     */
    List<Brand> getAllBrandsAndModels();
}
