package com.zwavepublic.zwaveip.command;

import java.util.HashMap;

/* DeviceResetLocally commands (version 1) */
public enum DeviceResetLocallyCommand implements Command {
    NOTIFICATION((byte)0x01);

    private static final HashMap<Byte, DeviceResetLocallyCommand> _map = new HashMap<Byte, DeviceResetLocallyCommand>(1);
    static {
        for (DeviceResetLocallyCommand value: DeviceResetLocallyCommand.values()) {
            _map.put(value.byteValue(), value);
        }
    }

    private byte _byteValue;

    private DeviceResetLocallyCommand(byte value) {
        this._byteValue = value;
    }

    @Override
    public byte byteValue() {
        return this._byteValue;
    }

    public static DeviceResetLocallyCommand valueOf(byte byteValue) {
        DeviceResetLocallyCommand result = _map.get(byteValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static DeviceResetLocallyCommand valueOfIfPresent(byte byteValue) {
        return _map.get(byteValue);
    }
}

