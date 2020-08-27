package com.fsd.sba.client;

import com.fsd.sba.web.rest.vm.training.ProposalVM;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "training")
public interface TrainingClient {
    @RequestMapping(value = "/api/training/proposal", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    String sendProposal(ProposalVM proposal);
}
