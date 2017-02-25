package com.di.service;

import com.di.entity.Employee;
import com.di.entity.cabentity.CabAgency;
import com.di.entity.infoentity.ReservationInfo;
import com.di.entity.planeentity.PlaneAgency;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;

/**
 * Created by beerman on 23.02.2017.
 */
public class ReservationService {
    private CabAgency cabAgency;

    public ReservationInfo getReservationInfo() {
        return reservationInfo;
    }

    public void setReservationInfo(ReservationInfo reservationInfo) {
        this.reservationInfo = reservationInfo;
    }

    @PostConstruct
    public void    fillReservationInfo(){
        System.out.println("in post construct");
        reservationInfo.processUserReservationInfo();
    }



    public String reserveTravel(Employee employee){
       String cabResponse = cabAgency.reserve(reservationInfo.findUserByInnerCode(employee.getInnerCode()));
        String planeResponse = planeAgency.reserve(reservationInfo.findUserByInnerCode(employee.getInnerCode()));
        return cabResponse + " " + planeResponse;
    }


    private ReservationInfo reservationInfo;


    public PlaneAgency getPlaneAgency() {
        return planeAgency;
    }

    public void setPlaneAgency(PlaneAgency planeAgency) {
        this.planeAgency = planeAgency;
    }

    private PlaneAgency planeAgency;

    public CabAgency getCabAgency() {
        return cabAgency;
    }

    public void setCabAgency(CabAgency cabAgency) {
        this.cabAgency = cabAgency;
    }


}
