package za.ac.readiculous.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.readiculous.domain.JoinPage;
import za.ac.readiculous.service.JoinPageService;

import java.util.List;
@RestController
@RequestMapping("/api/JoinPage")
@CrossOrigin(origins = "http://localhost:5173")
public class JoinPageController {

    private final JoinPageService joinPageService;
    private JoinPageService service;

    @Autowired
    public JoinPageController(JoinPageService joinPageService, JoinPageService service) {
        this.joinPageService = joinPageService;
        this.service = service;
    }

    @PostMapping("/create")
    public JoinPage create(@RequestBody JoinPage joinPage) {
        return service.create(joinPage);
    }

    @GetMapping("/read/{id}")
    public JoinPage read(@PathVariable Long id) {
        return service.read(id);
    }

    @PutMapping("/update")
    public JoinPage update(@RequestBody JoinPage joinPage) {
        return service.update(joinPage);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable Long id) {
        return service.delete(id);
    }

    @GetMapping("/getAll")
    public List<JoinPage> getAll() {
        return service.getAll();
    }
}

