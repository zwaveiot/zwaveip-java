package com.zwavepublic.zwaveip.command;

import java.util.HashMap;

/* HumidityControlOperatingState commands (version 1) */
public enum HumidityControlOperatingStateCommand implements Command {
    GET((byte)0x01),
    REPORT((byte)0x02);

    private static final HashMap<Byte, HumidityControlOperatingStateCommand> _map = new HashMap<Byte, HumidityControlOperatingStateCommand>(2);
    static {
        for (HumidityControlOperatingStateCommand value: HumidityControlOperatingStateCommand.values()) {
            _map.put(value.byteValue(), value);
        }
    }

    private byte _byteValue;

    private HumidityControlOperatingStateCommand(byte value) {
        this._byteValue = value;
    }

    @Override
    public byte byteValue() {
        return this._byteValue;
    }

    public static HumidityControlOperatingStateCommand valueOf(byte byteValue) {
        HumidityControlOperatingStateCommand result = _map.get(byteValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static HumidityControlOperatingStateCommand valueOfIfPresent(byte byteValue) {
        return _map.get(byteValue);
    }
}

