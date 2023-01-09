//package com.mate.autoservice.controller;
//
//import com.mate.autoservice.model.Car;
//import com.mate.autoservice.model.CarOwner;
//import com.mate.autoservice.repository.CarOwnerRepository;
//import com.mate.autoservice.service.impl.CarServiceImpl;
//import com.mate.autoservice.dto.request.CarRequestDto;
//import io.restassured.http.ContentType;
//import io.restassured.module.mockmvc.RestAssuredMockMvc;
//import org.hamcrest.Matchers;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.HttpStatus;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.test.web.servlet.MockMvc;
//
//import java.time.LocalDate;
//
////@ExtendWith(SpringExtension.class)
////@SpringBootTest
////@AutoConfigureMockMvc
//public class CarControllerTest {
//    @MockBean
//    private CarServiceImpl carService;
//    @Autowired
//    private CarOwnerRepository<CarOwner> carOwnerRepository;
//    @Autowired
//    private MockMvc mockMvc;
//
//    @BeforeEach
//    public void setUp() {
//        RestAssuredMockMvc.mockMvc(mockMvc);
//    }
//
//    @Test
//    void shouldCreateCar() {
//        Car carToSave = new Car();
//        carToSave.setId(1L);
//        carToSave.setModel("model");
//        carToSave.setMark("mark");
//        carToSave.setYearOfManufacture(LocalDate.now());
//        carToSave.setNumber("AX2156OL");
//        carOwnerRepository.save(new CarOwner());
//        CarRequestDto carRequestDto = new CarRequestDto();
//        carRequestDto.setOwnerId(1L);
//        carRequestDto.setMark("Nissan");
//        carRequestDto.setModel("C-13a");
//        carRequestDto.setYearOfManufacture(LocalDate.now());
//        carRequestDto.setNumber("AX2156OL");
//
//        Mockito.when(carService.add(carToSave))
//                .thenReturn(carToSave);
//        RestAssuredMockMvc
//                .given()
//                .contentType(ContentType.JSON)
//                .body(carRequestDto)
//                .when()
//                .post("/car")
//                .then()
//                .status(HttpStatus.OK)
//                .body("id", Matchers.equalTo(1L))
//                .body("mark", Matchers.equalTo(carRequestDto.getMark()))
//                .body("model", Matchers.equalTo(carRequestDto.getModel()))
//                .body("number", Matchers.equalTo(carRequestDto.getNumber()))
//                .body("yearOfManufacture", Matchers.equalTo(carRequestDto.getYearOfManufacture()));
//        carOwnerRepository.deleteAll();
//    }
//}
//
//
