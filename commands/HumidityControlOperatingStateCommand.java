package com.zwavepublic.zwaveip.commands;

import java.util.HashMap;

/* HumidityControlOperatingState commands (version 1) */
public enum HumidityControlOperatingStateCommand implements com.zwavepublic.zwaveip.commands.Command {
    GET(0x01),
    REPORT(0x02);

    private static final HashMap<Integer, HumidityControlOperatingStateCommand> _map = new HashMap<Integer, HumidityControlOperatingStateCommand>(2);
    static {
        for (HumidityControlOperatingStateCommand value: HumidityControlOperatingStateCommand.values()) {
            _map.put(value.intValue(), value);
        }
    }

    private int _intValue;

    private HumidityControlOperatingStateCommand(int value) {
        this._intValue = value;
    }

    @Override
    public int intValue() {
        return this._intValue;
    }

    public static HumidityControlOperatingStateCommand valueOf(int intValue) {
        HumidityControlOperatingStateCommand result = _map.get(intValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static HumidityControlOperatingStateCommand valueOfIfPresent(int intValue) {
        return _map.get(intValue);
    }
}

