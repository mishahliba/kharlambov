package com.di.service;

import com.di.entity.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by beerman on 25.02.2017.
 */
public class TestReservationService {

    static ReservationService service;
    static Employee employee;
    static ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
    public static void main(String[] args) {
        service = (ReservationService) context.getBean("reservationService");
        employee = (Employee) context.getBean("employee");
        service.fillReservationInfo();
        String response = service.reserveTravel(employee);
        System.out.println(response);
    }
}
