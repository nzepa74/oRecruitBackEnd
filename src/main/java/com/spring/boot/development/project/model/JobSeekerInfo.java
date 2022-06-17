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
@Table(name = "job_seeker_info")
public class JobSeekerInfo extends BaseEntity {

    //region private variables
    @Id
    @Column(name = "jobSeekerInfoId")
    private String jobSeekerInfoId;

    @Column(name = "userId")
    private String userId;

    @Column(name = "cid")
    private String cid;

    @Column(name = "dob")
    private Date dob;

    @Column(name = "currentAddress")
    private String currentAddress;

    @Column(name = "description")
    private String description;

    @Column(name = "fatherName")
    private String fatherName;

    @Column(name = "village")
    private String village;

    @Column(name = "geog")
    private String geog;

    @Column(name = "dzongkhag")
    private String dzongkhag;

    @Column(name = "updatedBy")
    private String updatedBy;

    @Column(name = "updatedDate")
    private Date updatedDate;
    //endregion

}
