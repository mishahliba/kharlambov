package com.di.entity.cabentity;

import com.di.entity.infoentity.ReservationInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by beerman on 23.02.2017.
 */
public class YandexCabAgency implements CabAgency {

private static Integer availableCars = 100;
    private static List<String> blackList = new ArrayList<>();

    @Override
    public String reserve(ReservationInfo reservationInfo) {
        if (availableCars>0 && !blackList.contains(reservationInfo.getPassport()) ) {
            return "reserved successfully";
        } else {
            return "no free cars";
        }
    }
}
