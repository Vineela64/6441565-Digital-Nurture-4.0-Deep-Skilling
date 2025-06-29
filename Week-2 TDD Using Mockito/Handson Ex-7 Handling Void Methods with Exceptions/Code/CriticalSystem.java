package com.example;

public class CriticalSystem {
	private AlertService alertService;

    public CriticalSystem(AlertService alertService) {
        this.alertService = alertService;
    }

    public void performCriticalOperation() {
        alertService.sendAlert("CRITICAL: System failure!");
    }

}
