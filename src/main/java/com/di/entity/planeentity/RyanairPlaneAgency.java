package com.di.entity.planeentity;

import com.di.entity.infoentity.ReservationInfo;

/**
 * Created by beerman on 25.02.2017.
 */
public class RyanairPlaneAgency implements PlaneAgency {
    @Override
    public String reserve(ReservationInfo reservationInfo) {
        if(reservationInfo.getVisaExpiration()<2017){
            return "flight reserved";
        }else{
            return "visa is expired";
        }

    }
}
