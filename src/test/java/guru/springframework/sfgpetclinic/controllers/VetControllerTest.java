package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.mocks.ModelMock;
import guru.springframework.sfgpetclinic.fauxspring.Model;
import guru.springframework.sfgpetclinic.model.Speciality;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.VetService;
import guru.springframework.sfgpetclinic.services.map.SpecialityMapService;
import guru.springframework.sfgpetclinic.services.map.VetMapService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VetControllerTest {

    VetController vetController;
    Model mockModel;

    @BeforeEach
    void setUp() {
        VetService vetService = new VetMapService(new SpecialityMapService());
        Speciality spec1 = new Speciality("Dogs");
        Speciality spec2 = new Speciality("Cats");
        Set<Speciality> specs = new HashSet<>();
        specs.add(spec1);
        specs.add(spec2);
        Vet vet1 = new Vet(1l, "John", "Baker",null);
        Vet vet2 = new Vet(2l, "Lisa", "Smith", specs);
        vetController = new VetController(vetService);
        mockModel = new ModelMock();

    }

    @Test
    void listVets() {
        String result = vetController.listVets(mockModel);
        assertEquals("vets/index", result, "Controller gives back correct name");


    }
}