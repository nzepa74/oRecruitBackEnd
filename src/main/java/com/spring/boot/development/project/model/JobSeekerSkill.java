package com.spring.boot.development.project.model;

import com.spring.boot.development.project.helper.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created By zepaG on 6/9/2022.
 */
@Setter
@Getter
@Entity
@Table(name = "job_seeker_skill")
public class JobSeekerSkill extends BaseEntity {

    //region private variables
    @Id
    @Column(name = "skillId")
    private String skillId;

    @Column(name = "userId")
    private String userId;

    @Column(name = "skill")
    private String skill;

    @Column(name = "updatedBy")
    private String updatedBy;

    @Column(name = "updatedDate")
    private Date updatedDate;
    //endregion

}
