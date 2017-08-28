package com.rentalservice.webapp;

import com.rentalservice.webapp.data.RentalService;
import com.rentalservice.webapp.data.RentalServiceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RequestMapping("/api/rentalservice")
@RestController
public class RentalServiceController {
    @Autowired
    private RentalServiceRepository repositoryRentalService;

    @RequestMapping(method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<RentalServiceDTO> index() {
        return convertToDTOs(repositoryRentalService.findAll());
    }

    private List<RentalServiceDTO> convertToDTOs(List<RentalService> models) {
        return models.stream()
                .map(this::convertToDTO)
                .collect(toList());
    }

    private RentalServiceDTO convertToDTO(RentalService model) {
        return new RentalServiceDTO(model);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    RentalServiceDTO delete(@PathVariable("id") String id) {
        RentalServiceDTO deleted = convertToDTO(repositoryRentalService.findById(id));
        repositoryRentalService.delete(id);
        return deleted;
    }
}


