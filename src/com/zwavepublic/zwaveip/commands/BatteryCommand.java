package com.zwavepublic.zwaveip.commands;

import java.util.HashMap;

/* Battery commands (version 1) */
public enum BatteryCommand implements com.zwavepublic.zwaveip.commands.Command {
    GET(0x02),
    REPORT(0x03);

    private static final HashMap<Integer, BatteryCommand> _map = new HashMap<Integer, BatteryCommand>(2);
    static {
        for (BatteryCommand value: BatteryCommand.values()) {
            _map.put(value.intValue(), value);
        }
    }

    private int _intValue;

    private BatteryCommand(int value) {
        this._intValue = value;
    }

    @Override
    public int intValue() {
        return this._intValue;
    }

    public static BatteryCommand valueOf(int intValue) {
        BatteryCommand result = _map.get(intValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static BatteryCommand valueOfIfPresent(int intValue) {
        return _map.get(intValue);
    }
}

