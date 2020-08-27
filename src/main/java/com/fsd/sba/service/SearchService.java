package com.fsd.sba.service;

import com.fsd.sba.client.GatewayClient;
import com.fsd.sba.client.TechnologiesClient;
import com.fsd.sba.client.TrainingClient;
import com.fsd.sba.client.UserClient;
import com.fsd.sba.service.dto.UserDTO;
import com.fsd.sba.web.rest.vm.search.SendProposalVM;
import com.fsd.sba.web.rest.vm.technologies.TechnologyOptionVM;
import com.fsd.sba.web.rest.vm.training.ProposalVM;
import com.fsd.sba.web.rest.vm.user.MentorSkillVM;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class SearchService {

    private final Logger log = LoggerFactory.getLogger(SearchService.class);

    private TechnologiesClient technologiesClient;
    private UserClient userClient;
    private TrainingClient trainingClient;
    private GatewayClient gatewayClient;

    public SearchService(TechnologiesClient technologiesClient, UserClient userClient, TrainingClient trainingClient, GatewayClient gatewayClient) {
        this.technologiesClient = technologiesClient;
        this.userClient = userClient;
        this.trainingClient = trainingClient;
        this.gatewayClient = gatewayClient;
    }


    public List<MentorSkillVM> findMentors(Long skill, String timeSlot) {
        return userClient.getMentorSkill(skill);
    }

    public List<TechnologyOptionVM> getSkills() {
        return technologiesClient.getAllTechnologiesOptions();
    }

    public void sendProposal(SendProposalVM sendProposalVM) {
        UserDTO userDTO = gatewayClient.getUser(sendProposalVM.getLogin());
        ProposalVM proposal = new ProposalVM();
        proposal.setMentorId(sendProposalVM.getMentorId());
        proposal.setSkillId(sendProposalVM.getSkillId());
        proposal.setUserId(userDTO.getId());
        proposal.setStartDatetime(sendProposalVM.getStartDatetime());
        proposal.setEndDatetime(sendProposalVM.getEndDatetime());
        trainingClient.sendProposal(proposal);
    }
}
