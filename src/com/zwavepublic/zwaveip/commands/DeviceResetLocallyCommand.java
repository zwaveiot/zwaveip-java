package com.zwavepublic.zwaveip.commands;

import java.util.HashMap;

/* DeviceResetLocally commands (version 1) */
public enum DeviceResetLocallyCommand implements com.zwavepublic.zwaveip.commands.Command {
    NOTIFICATION(0x01);

    private static final HashMap<Integer, DeviceResetLocallyCommand> _map = new HashMap<Integer, DeviceResetLocallyCommand>(1);
    static {
        for (DeviceResetLocallyCommand value: DeviceResetLocallyCommand.values()) {
            _map.put(value.intValue(), value);
        }
    }

    private int _intValue;

    private DeviceResetLocallyCommand(int value) {
        this._intValue = value;
    }

    @Override
    public int intValue() {
        return this._intValue;
    }

    public static DeviceResetLocallyCommand valueOf(int intValue) {
        DeviceResetLocallyCommand result = _map.get(intValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static DeviceResetLocallyCommand valueOfIfPresent(int intValue) {
        return _map.get(intValue);
    }
}

