package com.fsd.sba.web.rest;

import com.fsd.sba.service.SearchService;
import com.fsd.sba.web.rest.vm.search.SendProposalVM;
import com.fsd.sba.web.rest.vm.technologies.TechnologyOptionVM;
import com.fsd.sba.web.rest.vm.user.MentorSkillVM;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class SearchResource {

    private static final String ENTITY_NAME = "userMentor";
    private final Logger log = LoggerFactory.getLogger(SearchResource.class);
    private final SearchService searchService;
    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    public SearchResource(SearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping("/findMentors/{skill}")
    public List<MentorSkillVM> findMentors(@PathVariable Long skill, @RequestParam(required = false) String timeSlot) {
        return searchService.findMentors(skill, timeSlot);
    }

    @GetMapping("/skills/options")
    public List<TechnologyOptionVM> getSkills() {
        return searchService.getSkills();
    }

    @PostMapping("/sendProposal")
    public ResponseEntity<Void> sendProposal(@RequestBody SendProposalVM sendProposalVM) {
        searchService.sendProposal(sendProposalVM);
        return ResponseEntity.noContent().build();
    }
}
