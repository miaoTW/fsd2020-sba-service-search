package com.fsd.sba.client;

import com.fsd.sba.web.rest.vm.user.MentorSkillVM;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "user")
public interface UserClient {
    @RequestMapping(value = "/api/mentor-skills/skill/{skillId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    List<MentorSkillVM> getMentorSkill(@PathVariable("skillId") Long skillId);
}
