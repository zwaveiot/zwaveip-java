package com.zwavepublic.zwaveip.command;

import java.util.HashMap;

/* NetworkManagementInstallationMaintenance commands (version 1) */
public enum NetworkManagementInstallationMaintenanceCommand implements Command {
    LAST_WORKING_ROUTE_SET((byte)0x01),
    LAST_WORKING_ROUTE_GET((byte)0x02),
    LAST_WORKING_ROUTE_REPORT((byte)0x03),
    STATISTICS_GET((byte)0x04),
    STATISTICS_REPORT((byte)0x05),
    STATISTICS_CLEAR((byte)0x06);

    private static final HashMap<Byte, NetworkManagementInstallationMaintenanceCommand> _map = new HashMap<Byte, NetworkManagementInstallationMaintenanceCommand>(6);
    static {
        for (NetworkManagementInstallationMaintenanceCommand value: NetworkManagementInstallationMaintenanceCommand.values()) {
            _map.put(value.byteValue(), value);
        }
    }

    private byte _byteValue;

    private NetworkManagementInstallationMaintenanceCommand(byte value) {
        this._byteValue = value;
    }

    @Override
    public byte byteValue() {
        return this._byteValue;
    }

    public static NetworkManagementInstallationMaintenanceCommand valueOf(byte byteValue) {
        NetworkManagementInstallationMaintenanceCommand result = _map.get(byteValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static NetworkManagementInstallationMaintenanceCommand valueOfIfPresent(byte byteValue) {
        return _map.get(byteValue);
    }
}

