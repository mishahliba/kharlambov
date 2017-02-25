package com.di.entity.planeentity;

import com.di.entity.infoentity.ReservationInfo;

/**
 * Created by beerman on 25.02.2017.
 */
public class WizzPlaneAgency implements PlaneAgency {
    @Override
    public String reserve(ReservationInfo reservationInfo) {
        if(reservationInfo.getVisaExpiration()<2017 && reservationInfo.getCacheAmount()>100){
            return "flight reserved";
        }else{
            return "can`t reserve flight";
        }
    }
}
