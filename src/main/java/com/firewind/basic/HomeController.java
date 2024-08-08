package com.firewind.basic;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Controller
public class HomeController {
    private int count;
    private List<Person> people;

    public HomeController() {
        count = -1;
        people = new ArrayList<>();
    }
//    @GetMapping("/home/main")
//    @ResponseBody
//    public String showHome() {
//        return "안녕하세요.";
//    }

//    @GetMapping("/home/plus")
//    @ResponseBody
//    // @RequestParam은 생략 가능하다
//    public int showPlus (@RequestParam(defaultValue = "0") int a, @RequestParam(defaultValue = "0") int b) {
//        return a + b;
//    }
//
//    @GetMapping("/home/boolean")
//    @ResponseBody
//    // @RequestParam은 생략 가능하다
//    public boolean showBoolean () {
//        return true;
//    }

//    @GetMapping("/home/double")
//    @ResponseBody
//    // @RequestParam은 생략 가능하다
//    public double showDouble () {
//        return Math.PI;
//    }
//
//    @GetMapping("/home/intList")
//    @ResponseBody
//    // @RequestParam은 생략 가능하다
//    public List<Integer> showIntArray () {
//        List<Integer> list = new ArrayList<>() {
//            {   add(10);
//                add(20);
//                add(30);
//                add(40);
//            }
//        };
//        return list;
//    }

//    @GetMapping("/home/map")
//    @ResponseBody
//    public Map<String, Object> showMap() {
//        Map<String, Object> map = new LinkedHashMap<String, Object>();
//        map.put("id", 1);
//        map.put("speed", 100);
//        map.put("name", "그랜저");
//
//        List<Integer> relatedIds = new ArrayList<>();
//        relatedIds.add(1);
//        relatedIds.add(2);
//        relatedIds.add(3);
//        relatedIds.add(4);
//
//        map.put("relatedIds", relatedIds);
//
//        return map;
//    }
//
//    @GetMapping("/home/mapList")
//    @ResponseBody
//    public List<Map<String, Object>> showMapList() {
//        Map<String, Object> map1 = new LinkedHashMap<String, Object>();
//        map1.put("id", 1);
//        map1.put("speed", 100);
//        map1.put("name", "그랜저");
//
//        List<Integer> relatedIds1 = new ArrayList<>();
//        relatedIds1.add(11);
//        relatedIds1.add(12);
//        relatedIds1.add(13);
//        relatedIds1.add(14);
//        map1.put("relatedIds", relatedIds1);
//
//        Map<String, Object> map2 = new LinkedHashMap<String, Object>();
//        map2.put("id", 2);
//        map2.put("speed", 200);
//        map2.put("name", "볼보");
//
//        List<Integer> relatedIds2 = new ArrayList<>();
//        relatedIds2.add(21);
//        relatedIds2.add(22);
//        relatedIds2.add(23);
//        relatedIds2.add(24);
//        map2.put("relatedIds", relatedIds2);
//
//        List<Map<String, Object>> list = new ArrayList<>();
//        list.add(map1);
//        list.add(map2);
//
//        return list;
//    }
//
//
//    @GetMapping("/home/car")
//    @ResponseBody
//    public Car showCar() {
//        return new Car(1, 100, "티고", new ArrayList<>() {{
//            add(10);
//            add(20);
//            add(30);
//        }});
//    }
//
//    static class Car {
//        private final int id;
//        private final int speed;
//        private final String name;
//        private final List<Integer> relatedIds;
//
//        public Car(int id, int speed, String name, List<Integer> relatedIds) {
//            this.id = id;
//            this.speed = speed;
//            this.name = name;
//            this.relatedIds = relatedIds;
//        }
//
//        public int getId() {
//            return id;
//        }
//
//        public int getSpeed() {
//            return speed;
//        }
//
//        public String getName() {
//            return name;
//        }
//
//        public List<Integer> getRelatedIds() {
//            return relatedIds;
//        }
//    }
//
//    @GetMapping("/home/car2")
//    @ResponseBody
//    public Car2 showCar2() {
//
//        Car2 car2 = new Car2(1, 100, "티고", new ArrayList<>() {{
//            add(10);
//            add(20);
//            add(30);
//        }});
//
//        car2.setSpeed(car2.getSpeed() + 200);
//        return car2;
//    }
//
//    @AllArgsConstructor
//    @Getter
//    class Car2 {
//        private int id;
//        @Setter
//        private int speed;
//        private String name;
//        private List<Integer> relatedIds;
//    }

//    @GetMapping("/home/mapListCar")
//    @ResponseBody
//    public List<Car2> showMapListCar() {
//        Car2 car21 = new Car2(1, 100, "티고", new ArrayList<>() {{
//            add(10);
//            add(20);
//            add(30);
//        }});
//
//        Car2 car22 = new Car2(2, 200, "망고", new ArrayList<>() {{
//            add(50);
//            add(60);
//            add(70);
//        }});
//
//        List<Car2> list = new ArrayList<>();
//        list.add(car21);
//        list.add(car22);
//
//        return list;
//    }

    @GetMapping("/home/addPerson")
    @ResponseBody
    public String addPerson(String name, int age) {
        Person person = new Person(name, age);

        people.add(person);
//        System.out.println(person);
        return "%d번 사람을 추가되었습니다." .formatted(person.getId());
    }

    @AllArgsConstructor
    @Getter
    @Setter
    @ToString
    class Person {
        private static int lastId;
        private int id;
        private String name;
        private int age;

        static {
            lastId = 0;
        }

        public Person(String name, int age) {
            this.id = ++lastId;
            this.name = name;
            this.age = age;
        }
    }

    @GetMapping("/home/people")
    @ResponseBody
    public List<Person> showPeople() {
        return people;
    }

    @GetMapping("/home/removePerson")
    @ResponseBody
    public String removePerson(int id) {
        boolean removed = people.removeIf(person -> person.getId() == id);

        if (removed) {
            return "%d번 사람을 삭제하였습니다.".formatted(id);
        } else {
            return "%d번 사람이 존재하지 않습니다.".formatted(id);
        }
    }

    @GetMapping("/home/modifyPerson")
    @ResponseBody
    public String modifyPerson(int id, String name, int age) {
        Person found = people.stream()
                .filter(person -> person.getId() == id)
                .findFirst()
                .orElse(null);

        if (found != null) {
            found.setName(name);
            found.setAge(age);
            return "%d번 사람을 수정하였습니다.".formatted(id);
        } else {
            return "%d번 사람이 존재하지 않습니다.".formatted(id);
        }
    }

}
