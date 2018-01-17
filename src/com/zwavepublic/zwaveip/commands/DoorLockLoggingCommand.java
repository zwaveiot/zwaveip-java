package com.zwavepublic.zwaveip.commands;

import java.util.HashMap;

/* DoorLockLogging commands (version 1) */
public enum DoorLockLoggingCommand implements com.zwavepublic.zwaveip.commands.Command {
    RECORDS_SUPPORTED_GET(0x01),
    RECORDS_SUPPORTED_REPORT(0x02),
    RECORD_GET(0x03),
    RECORD_REPORT(0x04);

    private static final HashMap<Integer, DoorLockLoggingCommand> _map = new HashMap<Integer, DoorLockLoggingCommand>(4);
    static {
        for (DoorLockLoggingCommand value: DoorLockLoggingCommand.values()) {
            _map.put(value.intValue(), value);
        }
    }

    private int _intValue;

    private DoorLockLoggingCommand(int value) {
        this._intValue = value;
    }

    @Override
    public int intValue() {
        return this._intValue;
    }

    public static DoorLockLoggingCommand valueOf(int intValue) {
        DoorLockLoggingCommand result = _map.get(intValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static DoorLockLoggingCommand valueOfIfPresent(int intValue) {
        return _map.get(intValue);
    }
}

