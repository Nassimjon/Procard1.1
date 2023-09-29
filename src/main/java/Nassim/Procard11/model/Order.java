package Nassim.Procard11.model;

import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int orderId;
    @Column(name = "clientpan")
    public String clientPan;
    @Column(name = "clientmbr")
    public String clientMbr;
    @Column(name = "service_code")
    public String serviceCode;
    @Column(name = "first_name")
    public String firstName;
    @Column(name = "second_name")
    public String secondName;
    @Column(name = "first_name_on_card")
    public String firstNameOnCard;
    @Column(name = "second_name_on_card")
    public String secondNameOnCard;
    @Column(name = "card_date_input")
    public String cardDateInput;
    @Column(name = "card_date_expire")
    public String cardDateExpire;
    @Column(name = "full_name_on_env")
    public String fullNameOnEnv;
    @Column(name = "name_bank")
    public String bankName;
    @Column(name = "card_status")
    public String cardStatus;
    @Column(name = "passport_no")
    public String passportNo;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getClientPan() {
        return clientPan;
    }

    public void setClientPan(String clientPan) {
        this.clientPan = clientPan;
    }

    public String getClientMbr() {
        return clientMbr;
    }

    public void setClientMbr(String clientMbr) {
        this.clientMbr = clientMbr;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getFirstNameOnCard() {
        return firstNameOnCard;
    }

    public void setFirstNameOnCard(String firstNameOnCard) {
        this.firstNameOnCard = firstNameOnCard;
    }

    public String getSecondNameOnCard() {
        return secondNameOnCard;
    }

    public void setSecondNameOnCard(String secondNameOnCard) {
        this.secondNameOnCard = secondNameOnCard;
    }

    public String getCardDateInput() {
        return cardDateInput;
    }

    public void setCardDateInput(String cardDateInput) {
        this.cardDateInput = cardDateInput;
    }

    public String getCardDateExpire() {
        return cardDateExpire;
    }

    public void setCardDateExpire(String cardDateExpire) {
        this.cardDateExpire = cardDateExpire;
    }

    public String getFullNameOnEnv() {
        return fullNameOnEnv;
    }

    public void setFullNameOnEnv(String fullNameOnEnv) {
        this.fullNameOnEnv = fullNameOnEnv;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getCardStatus() {
        return cardStatus;
    }

    public void setCardStatus(String cardStatus) {
        this.cardStatus = cardStatus;
    }

    public String getPassportNo() {
        return passportNo;
    }

    public void setPassportNo(String passportNo) {
        this.passportNo = passportNo;
    }


}
