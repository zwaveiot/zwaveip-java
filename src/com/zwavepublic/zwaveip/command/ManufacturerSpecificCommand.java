package com.zwavepublic.zwaveip.command;

import java.util.HashMap;

/* ManufacturerSpecific commands (version 2) */
public enum ManufacturerSpecificCommand implements Command {
    GET((byte)0x04),
    REPORT((byte)0x05),
    DEVICE_SPECIFIC_GET((byte)0x06),
    DEVICE_SPECIFIC_REPORT((byte)0x07);

    private static final HashMap<Byte, ManufacturerSpecificCommand> _map = new HashMap<Byte, ManufacturerSpecificCommand>(4);
    static {
        for (ManufacturerSpecificCommand value: ManufacturerSpecificCommand.values()) {
            _map.put(value.byteValue(), value);
        }
    }

    private byte _byteValue;

    private ManufacturerSpecificCommand(byte value) {
        this._byteValue = value;
    }

    @Override
    public byte byteValue() {
        return this._byteValue;
    }

    public static ManufacturerSpecificCommand valueOf(byte byteValue) {
        ManufacturerSpecificCommand result = _map.get(byteValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static ManufacturerSpecificCommand valueOfIfPresent(byte byteValue) {
        return _map.get(byteValue);
    }
}

