package com.di.entity.cabentity;

import com.di.entity.Employee;
import com.di.entity.infoentity.ReservationInfo;

/**
 * Created by beerman on 23.02.2017.
 */
public interface CabAgency {

    public String reserve(ReservationInfo reservationInfo);
}
