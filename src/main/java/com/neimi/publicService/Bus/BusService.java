package com.neimi.publicService.Bus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class BusService {
    private BusRepository busRepository;

    @Autowired
    public BusService(BusRepository busRepository) {
        this.busRepository = busRepository;
    }

    public List<Bus> getAllBuses(){
        return busRepository.findAll();
    }

    public void addNewBus(Bus bus) {
        Optional<Bus> result = busRepository.findBusByName(bus.getName());
        if(result.isPresent()){
           throw new IllegalStateException("This bus is taken!");
        }
        busRepository.save(bus);
    }

    public void deleteBus(Long busId) {
        boolean result = busRepository.existsById(busId);
        if(!result){
            throw new IllegalStateException("There is no such bus "+busId+" in the db");
        }
        busRepository.deleteById(busId);

    }

    @Transactional
    public void updateBus(
            Long busId,
            String name
    ) {
        Bus bus = busRepository.findById(busId)
                .orElseThrow(()-> new IllegalStateException("This bus is not exist"));
        if(name!=null && name.length()>0 && !Objects.equals(bus.getName(),name)){
            bus.setName(name);
        }
    }
}
