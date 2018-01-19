package com.zwavepublic.zwaveip.command;

import java.util.HashMap;

/* Battery commands (version 1) */
public enum BatteryCommand implements Command {
    GET((byte)0x02),
    REPORT((byte)0x03);

    private static final HashMap<Byte, BatteryCommand> _map = new HashMap<Byte, BatteryCommand>(2);
    static {
        for (BatteryCommand value: BatteryCommand.values()) {
            _map.put(value.byteValue(), value);
        }
    }

    private byte _byteValue;

    private BatteryCommand(byte value) {
        this._byteValue = value;
    }

    @Override
    public byte byteValue() {
        return this._byteValue;
    }

    public static BatteryCommand valueOf(byte byteValue) {
        BatteryCommand result = _map.get(byteValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static BatteryCommand valueOfIfPresent(byte byteValue) {
        return _map.get(byteValue);
    }
}

