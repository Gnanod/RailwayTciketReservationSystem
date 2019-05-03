/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.rtrsc.dto;

/**
 *
 * @author Gnanod-PC
 */
public class DayDto extends SuperDto{
    private String dateId;
    private boolean monday;
    private boolean tuesday;
    private boolean wednesday;
    private boolean thursday;
    private boolean friday;
    private boolean saturday;
    private boolean sunday;
    private boolean holiday;
    public DayDto() {
    }

    public DayDto(String dateId, boolean monday, boolean tuesday, boolean wednesday, boolean thursday, boolean friday, boolean saturday, boolean sunday, boolean holiday) {
        this.dateId = dateId;
        this.monday = monday;
        this.tuesday = tuesday;
        this.wednesday = wednesday;
        this.thursday = thursday;
        this.friday = friday;
        this.saturday = saturday;
        this.sunday = sunday;
        this.holiday = holiday;
    }

    /**
     * @return the dateId
     */
    public String getDateId() {
        return dateId;
    }

    /**
     * @param dateId the dateId to set
     */
    public void setDateId(String dateId) {
        this.dateId = dateId;
    }

    /**
     * @return the monday
     */
    public boolean isMonday() {
        return monday;
    }

    /**
     * @param monday the monday to set
     */
    public void setMonday(boolean monday) {
        this.monday = monday;
    }

    /**
     * @return the tuesday
     */
    public boolean isTuesday() {
        return tuesday;
    }

    /**
     * @param tuesday the tuesday to set
     */
    public void setTuesday(boolean tuesday) {
        this.tuesday = tuesday;
    }

    /**
     * @return the wednesday
     */
    public boolean isWednesday() {
        return wednesday;
    }

    /**
     * @param wednesday the wednesday to set
     */
    public void setWednesday(boolean wednesday) {
        this.wednesday = wednesday;
    }

    /**
     * @return the thursday
     */
    public boolean isThursday() {
        return thursday;
    }

    /**
     * @param thursday the thursday to set
     */
    public void setThursday(boolean thursday) {
        this.thursday = thursday;
    }

    /**
     * @return the friday
     */
    public boolean isFriday() {
        return friday;
    }

    /**
     * @param friday the friday to set
     */
    public void setFriday(boolean friday) {
        this.friday = friday;
    }

    /**
     * @return the saturday
     */
    public boolean isSaturday() {
        return saturday;
    }

    /**
     * @param saturday the saturday to set
     */
    public void setSaturday(boolean saturday) {
        this.saturday = saturday;
    }

    /**
     * @return the sunday
     */
    public boolean isSunday() {
        return sunday;
    }

    /**
     * @param sunday the sunday to set
     */
    public void setSunday(boolean sunday) {
        this.sunday = sunday;
    }

    /**
     * @return the holiday
     */
    public boolean isHoliday() {
        return holiday;
    }

    /**
     * @param holiday the holiday to set
     */
    public void setHoliday(boolean holiday) {
        this.holiday = holiday;
    }

    
    
    
}
