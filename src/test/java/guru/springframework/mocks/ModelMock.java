package guru.springframework.mocks;

import guru.springframework.sfgpetclinic.fauxspring.Model;

import java.util.HashMap;

public class ModelMock implements Model {

    public HashMap<String, Object> getMockData() {
        return mockData;
    }

    public HashMap<String, Object> mockData = new HashMap<>();

    @Override
    public void addAttribute(String key, Object o) {
        mockData.put(key, o);
    }

    @Override
    public void addAttribute(Object o) {
        mockData.put("nothing", o);
    }

}
