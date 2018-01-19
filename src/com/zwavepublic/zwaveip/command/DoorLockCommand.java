package com.zwavepublic.zwaveip.command;

import java.util.HashMap;

/* DoorLock commands (version 3) */
public enum DoorLockCommand implements Command {
    CONFIGURATION_GET((byte)0x05),
    CONFIGURATION_REPORT((byte)0x06),
    CONFIGURATION_SET((byte)0x04),
    OPERATION_GET((byte)0x02),
    OPERATION_REPORT((byte)0x03),
    OPERATION_SET((byte)0x01);

    private static final HashMap<Byte, DoorLockCommand> _map = new HashMap<Byte, DoorLockCommand>(6);
    static {
        for (DoorLockCommand value: DoorLockCommand.values()) {
            _map.put(value.byteValue(), value);
        }
    }

    private byte _byteValue;

    private DoorLockCommand(byte value) {
        this._byteValue = value;
    }

    @Override
    public byte byteValue() {
        return this._byteValue;
    }

    public static DoorLockCommand valueOf(byte byteValue) {
        DoorLockCommand result = _map.get(byteValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static DoorLockCommand valueOfIfPresent(byte byteValue) {
        return _map.get(byteValue);
    }
}

