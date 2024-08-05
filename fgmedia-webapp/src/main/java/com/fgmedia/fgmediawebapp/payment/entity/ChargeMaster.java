package com.fgmedia.fgmediawebapp.payment.entity;

import com.fgmedia.fgmediawebapp.utils.CommonConstant;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "charges_master")
public class ChargeMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String paymentMethod;

    private Float chargesPercentage;

    @Column(updatable = false)
    private Integer createdBy;

    @Column(updatable = false)
    @DateTimeFormat(pattern = CommonConstant.DATE_TIME_FORMAT)
    private Date createdDate;

    private Integer modifiedBy;

    @DateTimeFormat(pattern = CommonConstant.DATE_TIME_FORMAT)
    private Date modifiedDate;

}
