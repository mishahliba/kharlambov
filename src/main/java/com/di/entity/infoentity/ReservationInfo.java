package com.di.entity.infoentity;

import com.di.entity.Employee;

import javax.sound.midi.MidiDevice;
import java.util.*;

/**
 * Created by beerman on 25.02.2017.
 */
public class ReservationInfo {
    private static Map<String, ReservationInfo> reservationInfo = new HashMap<>();
    private String userAddress;
    private String userPhoneNumber;
    private String agencyCode;
    private Visa visa;
    private String passportNumber;
    private Integer cashAmount;
    private CreditCard creditCard;

    private InfoGenerator generator = new InfoGenerator();

    public ReservationInfo(Employee employee){
        setUserAddress();
        setUserPhoneNumber();
        setAgencyCode();
        setVisa();
        setPassportNumber();
        setCacheAmount();
        setCreditCard();
        reservationInfo.put(employee.getInnerCode(), this);
        processUserReservationInfo();
    }

    public Integer getCacheAmount(){
        return this.cashAmount;
    }

    public String getPassport(){
        return this.passportNumber;
    }

    public Integer getVisaExpiration(){
        return this.visa.expirationYear;
    }

    public void processUserReservationInfo(){
            reservationInfo.forEach((k,v) -> System.out.println(k + " " + v.toString()));
        }


    public ReservationInfo findUserByInnerCode(String innerCode){
        return reservationInfo.get(innerCode);

    }

    public void setCacheAmount(){this.cashAmount = generator.generateCacheAmount(); }
    public void setPassportNumber() {
        this.passportNumber = generator.generatePassportNumber();
    }

    public static Map<String, ReservationInfo> getReservationInfo() {
        return reservationInfo;
    }


    public void setVisa() {
        this.visa = new Visa();
    }

    public void setAgencyCode() {
        this.agencyCode = generator.generateAgencyCode();
    }


    public void setUserPhoneNumber() {
        this.userPhoneNumber = generator.generateUserPhoneNumber();
    }


    public void setUserAddress() {
        this.userAddress = generator.generateUserAddress();
    }

    public void setCreditCard(){this.creditCard = new CreditCard(); }

    @Override
    public String toString() {
        return "ReservationInfo{" +
                "userAddress='" + userAddress + '\'' +
                ", userPhoneNumber='" + userPhoneNumber + '\'' +
                ", agencyCode='" + agencyCode + '\'' +
                ", passportNumber='" + passportNumber + '\'' +
                ", cacheAmount='" + cashAmount + '\'' +
                ", credit card number='" + creditCard.number + '\''+
                ", credit card cache= ' " + creditCard.cache + '\'' +
                ", visa number= ' " + visa.visaNumber + '\'' +
                ", visa expiration year = ' " + visa.expirationYear +
                '}';
    }

    class InfoGenerator {
        private List<String> streets = new ArrayList<>(Arrays.asList("Shevchenka", "Banderu", "Shushevicha"));
        private List<String> passportLetters = new ArrayList<>(Arrays.asList("AO", "CD", "UD"));
        private String passportLetter;
        private String street;
        private Integer building;
        private Integer appartment;

        public String generateUserAddress() {
            int rnd = new Random().nextInt(streets.size());
            street = streets.get(rnd);
            building = new Random().nextInt(50);
            appartment = new Random().nextInt(300);
            return street + "," + building + ", " + appartment;
        }

        public Integer generateCacheAmount(){
            return new Random().nextInt(200);
        }
        public String generateUserPhoneNumber() {
            String phoneNumber = "+380";
            for (int i = 0; i < 8; i++) {
                phoneNumber += new Random().nextInt(9);
            }
            return phoneNumber;
        }

        public String generateAgencyCode() {
            String agencyCode = "";
            for (int i = 0; i < 10; i++) {
                agencyCode += new Random().nextInt(9);
            }
            return agencyCode;
        }


        public String generatePassportNumber(){
            int rnd = new Random().nextInt(passportLetters.size());
            passportLetter = passportLetters.get(rnd);
            String passportNumbers = "";
            for (int i = 0; i < 7; i++) {
                passportNumbers += new Random().nextInt(9);
            }
            return passportLetter+passportNumbers;
        }

    }

    class CreditCard{
        String number="";
        Integer cache;

        public String generateNumber(){
            for (int i = 0; i <12 ; i++) {
                number+=String.valueOf(new Random().nextInt(9));
            }
            return number;
        }

        public Integer generateCache(){
            cache = new Random().nextInt(1000);
            return cache;
        }

        public CreditCard(){
            generateCache();
            generateNumber();
        }
    }

    class Visa{
        private String visaNumber="";
        private Integer expirationYear;

        public String generateVisaNumber() {
            for (int i = 0; i < 5; i++) {
                visaNumber += new Random().nextInt(9);
            }
            return visaNumber;
        }

        public Integer generateExpirationYear(){
            expirationYear = 2010 + new Random().nextInt(30);
            return expirationYear;
        }

        public Visa(){
            generateExpirationYear();
            generateVisaNumber();
        }
    }
}
