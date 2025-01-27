package com.rsi.cosasDashboard.Dashboard;

public enum Area {
    BACKEND("BACKEND"), 
    UX("UX"),
    FRONTEND("FRONTEND"),
    DATA("DATA"),
    NEGOCIO("NEGOCIO"),
    ANALISTA("ANALISTA");

	private String areaCode;

    Area(String areaCode) {
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }
}
