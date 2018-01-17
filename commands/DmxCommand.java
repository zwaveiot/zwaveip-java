package com.zwavepublic.zwaveip.commands;

import java.util.HashMap;

/* Dmx commands (version 1) */
public enum DmxCommand implements com.zwavepublic.zwaveip.commands.Command {
    ADDRESS_SET(0x01),
    ADDRESS_GET(0x02),
    ADDRESS_REPORT(0x03),
    CAPABILITY_GET(0x04),
    CAPABILITY_REPORT(0x05),
    DATA(0x06);

    private static final HashMap<Integer, DmxCommand> _map = new HashMap<Integer, DmxCommand>(6);
    static {
        for (DmxCommand value: DmxCommand.values()) {
            _map.put(value.intValue(), value);
        }
    }

    private int _intValue;

    private DmxCommand(int value) {
        this._intValue = value;
    }

    @Override
    public int intValue() {
        return this._intValue;
    }

    public static DmxCommand valueOf(int intValue) {
        DmxCommand result = _map.get(intValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static DmxCommand valueOfIfPresent(int intValue) {
        return _map.get(intValue);
    }
}

