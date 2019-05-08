package guru.springframework.mocks;

import guru.springframework.sfgpetclinic.fauxspring.Model;
import guru.springframework.sfgpetclinic.model.Vet;

import java.util.HashMap;
import java.util.Set;

public class ModelMock implements Model {

    public HashMap<String, Set<Vet>> mockData = new HashMap<>();

    @Override
    public void addAttribute(String key, Object o) {
        mockData.put(key, (Set<Vet>) o);
    }

    @Override
    public void addAttribute(Object o) {
        mockData.put("nothing", (Set<Vet>) o);
    }
}
