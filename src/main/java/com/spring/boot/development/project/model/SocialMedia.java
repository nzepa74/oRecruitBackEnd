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
@Table(name = "social_media")
public class SocialMedia extends BaseEntity {

    //region private variables
    @Id
    @Column(name = "socialMediaId")
    private String socialMediaId;

    @Column(name = "userId")
    private String userId;

    @Column(name = "link")
    private String link;

    @Column(name = "updatedBy")
    private String updatedBy;

    @Column(name = "updatedDate")
    private Date updatedDate;
    //endregion

}
