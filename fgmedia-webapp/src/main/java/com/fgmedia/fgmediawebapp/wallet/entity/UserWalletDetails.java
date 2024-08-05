package com.fgmedia.fgmediawebapp.wallet.entity;

import com.fgmedia.fgmediawebapp.utils.CommonConstant;
//import com.fgmedia.fgmediawebapp.security.entity.UserEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "wa_user_wallet_details")
public class UserWalletDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private UserEntity user;
    private Integer user;

    @ManyToOne
    @JoinColumn(name = "wallet_type_id")
    private WalletType walletType;

    @Column(nullable = false)
    @NotNull(message = "Pin Code cannot be null")
    private Double walletAmount;

    @Column(updatable = false)
    private Integer createdBy;

    @Column(updatable = false)
    @DateTimeFormat(pattern = CommonConstant.DATE_TIME_FORMAT)
    private Date createdDate;

    private Integer modifiedBy;

    @DateTimeFormat(pattern = CommonConstant.DATE_TIME_FORMAT)
    private Date modifiedDate;
}
