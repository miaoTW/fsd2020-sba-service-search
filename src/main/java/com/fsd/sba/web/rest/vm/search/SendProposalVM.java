package com.fsd.sba.web.rest.vm.search;

import java.time.Instant;

public class SendProposalVM {
    private Long skillId;
    private Long mentorId;
    private String login;
    private Instant startDatetime;
    private Instant endDatetime;

    public Long getSkillId() {
        return skillId;
    }

    public void setSkillId(Long skillId) {
        this.skillId = skillId;
    }

    public Long getMentorId() {
        return mentorId;
    }

    public void setMentorId(Long mentorId) {
        this.mentorId = mentorId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Instant getStartDatetime() {
        return startDatetime;
    }

    public void setStartDatetime(Instant startDatetime) {
        this.startDatetime = startDatetime;
    }

    public Instant getEndDatetime() {
        return endDatetime;
    }

    public void setEndDatetime(Instant endDatetime) {
        this.endDatetime = endDatetime;
    }
}
