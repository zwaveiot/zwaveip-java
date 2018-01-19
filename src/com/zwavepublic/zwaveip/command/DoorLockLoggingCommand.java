package com.zwavepublic.zwaveip.command;

import java.util.HashMap;

/* DoorLockLogging commands (version 1) */
public enum DoorLockLoggingCommand implements Command {
    RECORDS_SUPPORTED_GET((byte)0x01),
    RECORDS_SUPPORTED_REPORT((byte)0x02),
    RECORD_GET((byte)0x03),
    RECORD_REPORT((byte)0x04);

    private static final HashMap<Byte, DoorLockLoggingCommand> _map = new HashMap<Byte, DoorLockLoggingCommand>(4);
    static {
        for (DoorLockLoggingCommand value: DoorLockLoggingCommand.values()) {
            _map.put(value.byteValue(), value);
        }
    }

    private byte _byteValue;

    private DoorLockLoggingCommand(byte value) {
        this._byteValue = value;
    }

    @Override
    public byte byteValue() {
        return this._byteValue;
    }

    public static DoorLockLoggingCommand valueOf(byte byteValue) {
        DoorLockLoggingCommand result = _map.get(byteValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static DoorLockLoggingCommand valueOfIfPresent(byte byteValue) {
        return _map.get(byteValue);
    }
}

