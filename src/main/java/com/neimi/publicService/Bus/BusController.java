package com.neimi.publicService.Bus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path = "api/nemi_v1/bus")
public class BusController {
    private final BusService busService;

    @Autowired
    public BusController(BusService busService) {
        this.busService = busService;
    }

    @GetMapping
    public List<Bus> getAllBuses(){
        return busService.getAllBuses();
    }
    @PostMapping
    public void createBus(@RequestBody Bus bus){
        busService.addNewBus(bus);
    }

    @DeleteMapping(path= "{busId}")
    public void deleteBus(@PathVariable("busId") Long busId){
        busService.deleteBus(busId);
    }

    @PutMapping(path= "{busId}")
    public void updateBus(
            @PathVariable("busId") Long busId,
            @RequestParam(required = false) String name
    ){
       busService.updateBus(busId,name);
    }
}
