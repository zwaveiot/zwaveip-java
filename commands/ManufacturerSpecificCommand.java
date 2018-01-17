package com.zwavepublic.zwaveip.commands;

import java.util.HashMap;

/* ManufacturerSpecific commands (version 2) */
public enum ManufacturerSpecificCommand implements com.zwavepublic.zwaveip.commands.Command {
    GET(0x04),
    REPORT(0x05),
    DEVICE_SPECIFIC_GET(0x06),
    DEVICE_SPECIFIC_REPORT(0x07);

    private static final HashMap<Integer, ManufacturerSpecificCommand> _map = new HashMap<Integer, ManufacturerSpecificCommand>(4);
    static {
        for (ManufacturerSpecificCommand value: ManufacturerSpecificCommand.values()) {
            _map.put(value.intValue(), value);
        }
    }

    private int _intValue;

    private ManufacturerSpecificCommand(int value) {
        this._intValue = value;
    }

    @Override
    public int intValue() {
        return this._intValue;
    }

    public static ManufacturerSpecificCommand valueOf(int intValue) {
        ManufacturerSpecificCommand result = _map.get(intValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static ManufacturerSpecificCommand valueOfIfPresent(int intValue) {
        return _map.get(intValue);
    }
}

