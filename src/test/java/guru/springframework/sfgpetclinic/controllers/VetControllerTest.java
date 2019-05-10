package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.mocks.ModelMock;
import guru.springframework.sfgpetclinic.model.Speciality;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.VetService;
import guru.springframework.sfgpetclinic.services.map.SpecialityMapService;
import guru.springframework.sfgpetclinic.services.map.VetMapService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class VetControllerTest {

    VetController vetController;
    ModelMock mockModel;
    Set<Speciality> specs;
    Vet vet1;
    Vet vet2;

    @BeforeEach
    void setUp() {
        VetService vetService = new VetMapService(new SpecialityMapService());
        Speciality spec1 = new Speciality("Dogs");
        Speciality spec2 = new Speciality("Cats");
        specs = new HashSet<>();
        specs.add(spec1);
        specs.add(spec2);
        vet1 = new Vet(1l, "John", "Baker",specs);
        vet2 = new Vet(2l, "Lisa", "Smith", new HashSet<>());
        vetService.save(vet1);
        vetService.save(vet2);
        vetController = new VetController(vetService);
        mockModel = new ModelMock();

    }

    @Test
    void listVets() {
        String result = vetController.listVets(mockModel);
        assertEquals("vets/index", result, "Controller gives back correct name");

        HashMap<String, Object> mockData = mockModel.getMockData();
        assertEquals(mockData.size(), 1, "Only one thing added to scope");
        assertNotNull(mockData.get("vets"),  "There is a vet entry");
        Set<Vet> vets = (Set<Vet>) mockData.get("vets");
        assertEquals(vets.size(), 2, "There are two vets");
        assertAll("Testing the vets",
                () -> {
                    assertTrue(vets.contains(vet1), "Vet1 is in the set");
                },
                () -> {
                    assertTrue(vets.contains(vet2), "Vet2 is in the set");
                });

    }
}