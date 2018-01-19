package com.zwavepublic.zwaveip.command;

import java.util.HashMap;

/* Dmx commands (version 1) */
public enum DmxCommand implements Command {
    ADDRESS_SET((byte)0x01),
    ADDRESS_GET((byte)0x02),
    ADDRESS_REPORT((byte)0x03),
    CAPABILITY_GET((byte)0x04),
    CAPABILITY_REPORT((byte)0x05),
    DATA((byte)0x06);

    private static final HashMap<Byte, DmxCommand> _map = new HashMap<Byte, DmxCommand>(6);
    static {
        for (DmxCommand value: DmxCommand.values()) {
            _map.put(value.byteValue(), value);
        }
    }

    private byte _byteValue;

    private DmxCommand(byte value) {
        this._byteValue = value;
    }

    @Override
    public byte byteValue() {
        return this._byteValue;
    }

    public static DmxCommand valueOf(byte byteValue) {
        DmxCommand result = _map.get(byteValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static DmxCommand valueOfIfPresent(byte byteValue) {
        return _map.get(byteValue);
    }
}

