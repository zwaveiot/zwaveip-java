package com.zwavepublic.zwaveip.commands;

import java.util.HashMap;

/* NetworkManagementInstallationMaintenance commands (version 1) */
public enum NetworkManagementInstallationMaintenanceCommand implements com.zwavepublic.zwaveip.commands.Command {
    LAST_WORKING_ROUTE_SET(0x01),
    LAST_WORKING_ROUTE_GET(0x02),
    LAST_WORKING_ROUTE_REPORT(0x03),
    STATISTICS_GET(0x04),
    STATISTICS_REPORT(0x05),
    STATISTICS_CLEAR(0x06);

    private static final HashMap<Integer, NetworkManagementInstallationMaintenanceCommand> _map = new HashMap<Integer, NetworkManagementInstallationMaintenanceCommand>(6);
    static {
        for (NetworkManagementInstallationMaintenanceCommand value: NetworkManagementInstallationMaintenanceCommand.values()) {
            _map.put(value.intValue(), value);
        }
    }

    private int _intValue;

    private NetworkManagementInstallationMaintenanceCommand(int value) {
        this._intValue = value;
    }

    @Override
    public int intValue() {
        return this._intValue;
    }

    public static NetworkManagementInstallationMaintenanceCommand valueOf(int intValue) {
        NetworkManagementInstallationMaintenanceCommand result = _map.get(intValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static NetworkManagementInstallationMaintenanceCommand valueOfIfPresent(int intValue) {
        return _map.get(intValue);
    }
}

