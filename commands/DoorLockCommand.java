package com.zwavepublic.zwaveip.commands;

import java.util.HashMap;

/* DoorLock commands (version 3) */
public enum DoorLockCommand implements com.zwavepublic.zwaveip.commands.Command {
    CONFIGURATION_GET(0x05),
    CONFIGURATION_REPORT(0x06),
    CONFIGURATION_SET(0x04),
    OPERATION_GET(0x02),
    OPERATION_REPORT(0x03),
    OPERATION_SET(0x01);

    private static final HashMap<Integer, DoorLockCommand> _map = new HashMap<Integer, DoorLockCommand>(6);
    static {
        for (DoorLockCommand value: DoorLockCommand.values()) {
            _map.put(value.intValue(), value);
        }
    }

    private int _intValue;

    private DoorLockCommand(int value) {
        this._intValue = value;
    }

    @Override
    public int intValue() {
        return this._intValue;
    }

    public static DoorLockCommand valueOf(int intValue) {
        DoorLockCommand result = _map.get(intValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static DoorLockCommand valueOfIfPresent(int intValue) {
        return _map.get(intValue);
    }
}

