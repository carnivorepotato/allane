package org.allane.mapper;

import org.allane.model.Brand;
import org.allane.model.Model;
import org.allane.model.Vehicle;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.mockito.Spy;

import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VehicleMapperTest {

    @Spy
    private VehicleMapper mapper = Mappers.getMapper(VehicleMapper.class);

    @Test
    public void testMapVehicleToDto() {
        Vehicle testSubject = getVehicle();
        org.openapitools.model.Vehicle result = mapper.map(testSubject);

        assertEquals(result.getBrand(), testSubject.getBrand());
        assertEquals(result.getModel(), testSubject.getModel());
        assertEquals(result.getVin(), testSubject.getVin());
        assertEquals(result.getProductionYear(), testSubject.getProductionYear());
        assertEquals(result.getPrice(), testSubject.getPrice());
    }

    @Test
    public void testMapVehicleFromDto() {
        org.openapitools.model.Vehicle testSubject = getVehicleDto();
        Vehicle result = mapper.map(testSubject);

        assertEquals(result.getBrand(), testSubject.getBrand());
        assertEquals(result.getModel(), testSubject.getModel());
        assertEquals(result.getVin(), testSubject.getVin());
        assertEquals(result.getProductionYear(), testSubject.getProductionYear());
        assertEquals(result.getPrice(), testSubject.getPrice());
    }

    @Test
    public void testMapBrandToDto() {
        Brand testSubject = getBrand();
        org.openapitools.model.Brand result = mapper.map(testSubject);

        assertEquals(result.getName(), testSubject.getName());
        compareModels(result.getModels(), testSubject.getModels());
    }

    @Test
    public void testMapBrandListToDtoList() {
        Brand testSubject = getBrand();
        List<org.openapitools.model.Brand> resultList = mapper.map(List.of(testSubject, testSubject, testSubject));

        resultList.forEach(result -> {
            assertEquals(result.getName(), testSubject.getName());
            compareModels(result.getModels(), testSubject.getModels());
        });
    }

    private Vehicle getVehicle() {
        Vehicle result = new Vehicle();
        result.setVin("SC0173P");
        result.setBrand("GPT");
        result.setModel("V5.1");
        result.setProductionYear("2034");
        result.setPrice(99999.99);

        return result;
    }

    private org.openapitools.model.Vehicle getVehicleDto() {
        org.openapitools.model.Vehicle result = new org.openapitools.model.Vehicle(
                "AWS",
                "G1",
                13500.23
        );
        result.setProductionYear("2014");
        result.setVin("PASS12345");

        return result;
    }

    private Brand getBrand() {
        Brand result = new Brand();
        result.setName("NEW1");
        Model modelOne = new Model();
        modelOne.setName("one");
        Model modelTwo = new Model();
        modelOne.setName("two");
        result.setModels(List.of(modelOne, modelTwo));

        return result;
    }

    private void compareModels(List<org.openapitools.model.Model> modelDtoList, List<Model> modelList) {
        assertEquals(modelDtoList.size(), modelList.size());
        Iterator<org.openapitools.model.Model> dtoIterator = modelDtoList.iterator();
        Iterator<Model> modelIterator = modelList.iterator();
        while (dtoIterator.hasNext() && modelIterator.hasNext()) {
            org.openapitools.model.Model dto = dtoIterator.next();
            Model model = modelIterator.next();

            assertEquals(dto.getName(), model.getName());
        }
    }
}