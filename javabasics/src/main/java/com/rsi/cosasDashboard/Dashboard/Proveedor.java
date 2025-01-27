package com.rsi.cosasDashboard.Dashboard;

public enum Proveedor {

    RANDSTAD("RANDSTAD"),
    CAPITOL("CAPITOL");

	private String proveedorCode;

    Proveedor(String proveedorCode) {
    }

    public String getProveedorCode() {
        return proveedorCode;
    }

    public void setProveedorCode(String proveedorCode) {
        this.proveedorCode = proveedorCode;
    }
}
