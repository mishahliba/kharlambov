package com.di.entity.cabentity;

import com.di.entity.infoentity.ReservationInfo;

/**
 * Created by beerman on 23.02.2017.
 */
public class UberCabAgency implements CabAgency {


    @Override
    public String reserve(ReservationInfo reservationInfo) {

        if(reservationInfo.getCacheAmount()<150){
            return "cache is not enough";
        }else{
            return "reserved successfully";
        }
    }
}
