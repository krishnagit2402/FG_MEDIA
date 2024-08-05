package com.fgmedia.fgmediawebapp.wallet.repository;

import com.fgmedia.fgmediawebapp.wallet.entity.UserWalletDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserWalletDetailsRepo extends JpaRepository<UserWalletDetails, Integer> {

}
