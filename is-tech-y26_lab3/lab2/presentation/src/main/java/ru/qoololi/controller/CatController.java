package ru.qoololi.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.qoololi.CatService.CatService;
import ru.qoololi.dtos.CatDto;
import ru.qoololi.models.Cat;
import ru.qoololi.models.Owner;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/cats")
public class CatController {
    @Autowired
    private CatService service;

    @GetMapping
    public List<CatDto> findAllCats() {
        return service.findAllCats();
    }

    @PostMapping("save_cat")
    public CatDto saveCat(@RequestBody Cat cat) {
        return service.saveCat(cat);
    }

    @PostMapping("save_cats")
    public List<CatDto> saveCats(@RequestBody List<Cat> cats) {
        return cats.stream()
                .map(service::saveCat)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public CatDto findCat(@PathVariable("id") Long id) {
        return service.findCat(id);
    }

    @PutMapping("update_cat")
    public CatDto updateCat(@RequestBody Cat cat) {
        return service.updateCat(cat);
    }

    @DeleteMapping("delete_cat/{catId}")
    public String deleteCat(@PathVariable("catId") Long catId) {
        return service.deleteCat(catId);
    }

    @GetMapping("/color/{color}")
    public List<CatDto> findCatsByColor(@PathVariable("color") String color) {
        return service.findCatsByColor(color);
    }

    @GetMapping("/owner/{ownerId}")
    public List<CatDto> findCatsByOwner(@PathVariable("ownerId") Long ownerId) {
        return service.findCatsByOwner(ownerId);
    }

    @PutMapping("/set_owner")
    public void setOwner(@RequestBody SetOwnerRequest request) {
        service.setOwner(request.getCat(), request.getOwner());
    }

    @PutMapping("/make_friends")
    public void makeFriends(@RequestBody MakeFriendsRequest request) {
        service.makeFriends(request.getCat1(), request.getCat2());
    }

    @Getter
    @Setter
    public static class SetOwnerRequest {
        private Cat cat;
        private Owner owner;
    }

    @Getter
    @Setter
    public static class MakeFriendsRequest {
        private Cat cat1;
        private Cat cat2;
    }
}
