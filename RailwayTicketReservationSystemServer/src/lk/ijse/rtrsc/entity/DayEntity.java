/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.rtrsc.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Gnanod-PC
 */
@Entity
public class DayEntity {
    @Id
    private String dateId;
    private boolean Monday;
    private boolean Tuesday;
    private boolean Wednesday;
    private boolean Thursday;
    private boolean Friday;
    private boolean Saturday;
    private boolean Sunday;
    private boolean HolyDay;
    
    public DayEntity() {
    }

    public DayEntity(String dateId, boolean Monday, boolean Tuesday, boolean Wednesday, boolean Thursday, boolean Friday, boolean Saturday, boolean Sunday, boolean HolyDay) {
        this.dateId = dateId;
        this.Monday = Monday;
        this.Tuesday = Tuesday;
        this.Wednesday = Wednesday;
        this.Thursday = Thursday;
        this.Friday = Friday;
        this.Saturday = Saturday;
        this.Sunday = Sunday;
        this.HolyDay = HolyDay;
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
     * @return the Monday
     */
    public boolean isMonday() {
        return Monday;
    }

    /**
     * @param Monday the Monday to set
     */
    public void setMonday(boolean Monday) {
        this.Monday = Monday;
    }

    /**
     * @return the Tuesday
     */
    public boolean isTuesday() {
        return Tuesday;
    }

    /**
     * @param Tuesday the Tuesday to set
     */
    public void setTuesday(boolean Tuesday) {
        this.Tuesday = Tuesday;
    }

    /**
     * @return the Wednesday
     */
    public boolean isWednesday() {
        return Wednesday;
    }

    /**
     * @param Wednesday the Wednesday to set
     */
    public void setWednesday(boolean Wednesday) {
        this.Wednesday = Wednesday;
    }

    /**
     * @return the Thursday
     */
    public boolean isThursday() {
        return Thursday;
    }

    /**
     * @param Thursday the Thursday to set
     */
    public void setThursday(boolean Thursday) {
        this.Thursday = Thursday;
    }

    /**
     * @return the Friday
     */
    public boolean isFriday() {
        return Friday;
    }

    /**
     * @param Friday the Friday to set
     */
    public void setFriday(boolean Friday) {
        this.Friday = Friday;
    }

    /**
     * @return the Saturday
     */
    public boolean isSaturday() {
        return Saturday;
    }

    /**
     * @param Saturday the Saturday to set
     */
    public void setSaturday(boolean Saturday) {
        this.Saturday = Saturday;
    }

    /**
     * @return the Sunday
     */
    public boolean isSunday() {
        return Sunday;
    }

    /**
     * @param Sunday the Sunday to set
     */
    public void setSunday(boolean Sunday) {
        this.Sunday = Sunday;
    }

    /**
     * @return the HolyDay
     */
    public boolean isHolyDay() {
        return HolyDay;
    }

    /**
     * @param HolyDay the HolyDay to set
     */
    public void setHolyDay(boolean HolyDay) {
        this.HolyDay = HolyDay;
    }

    

    
    
    
}
