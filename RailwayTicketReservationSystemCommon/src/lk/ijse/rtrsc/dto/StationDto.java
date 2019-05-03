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
public class StationDto extends SuperDto{
     private String stationId;
    private String stationName;
    private boolean mathara_Colombo;
    private boolean colombo_Kandy;
    private boolean kandy_Jaffna;
    
    public StationDto() {
    }

    public StationDto(String stationId, String stationName) {
        this.stationId = stationId;
        this.stationName = stationName;
    }

    public StationDto(String stationId, String stationName, boolean mathara_Colombo, boolean colombo_Kandy, boolean kandy_Jaffna) {
        this.stationId = stationId;
        this.stationName = stationName;
        this.mathara_Colombo = mathara_Colombo;
        this.colombo_Kandy = colombo_Kandy;
        this.kandy_Jaffna = kandy_Jaffna;
    }

    /**
     * @return the stationId
     */
    public String getStationId() {
        return stationId;
    }

    /**
     * @param stationId the stationId to set
     */
    public void setStationId(String stationId) {
        this.stationId = stationId;
    }

    /**
     * @return the stationName
     */
    public String getStationName() {
        return stationName;
    }

    /**
     * @param stationName the stationName to set
     */
    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    /**
     * @return the mathara_Colombo
     */
    public boolean isMathara_Colombo() {
        return mathara_Colombo;
    }

    /**
     * @param mathara_Colombo the mathara_Colombo to set
     */
    public void setMathara_Colombo(boolean mathara_Colombo) {
        this.mathara_Colombo = mathara_Colombo;
    }

    /**
     * @return the colombo_Kandy
     */
    public boolean isColombo_Kandy() {
        return colombo_Kandy;
    }

    /**
     * @param colombo_Kandy the colombo_Kandy to set
     */
    public void setColombo_Kandy(boolean colombo_Kandy) {
        this.colombo_Kandy = colombo_Kandy;
    }

    /**
     * @return the kandy_Jaffna
     */
    public boolean isKandy_Jaffna() {
        return kandy_Jaffna;
    }

    /**
     * @param kandy_Jaffna the kandy_Jaffna to set
     */
    public void setKandy_Jaffna(boolean kandy_Jaffna) {
        this.kandy_Jaffna = kandy_Jaffna;
    }
    
}
