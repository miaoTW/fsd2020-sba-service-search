package com.fsd.sba.client;

import com.fsd.sba.web.rest.vm.technologies.TechnologyOptionVM;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;

@FeignClient(name = "technology")
public interface TechnologiesClient {
    @RequestMapping(value = "/api/technologies/options", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    List<TechnologyOptionVM> getAllTechnologiesOptions();
}
