package com.zwavepublic.zwaveip.commands;

import java.util.HashMap;

/* MeterPulse commands (version 1) */
public enum MeterPulseCommand implements com.zwavepublic.zwaveip.commands.Command {
    GET(0x04),
    REPORT(0x05);

    private static final HashMap<Integer, MeterPulseCommand> _map = new HashMap<Integer, MeterPulseCommand>(2);
    static {
        for (MeterPulseCommand value: MeterPulseCommand.values()) {
            _map.put(value.intValue(), value);
        }
    }

    private int _intValue;

    private MeterPulseCommand(int value) {
        this._intValue = value;
    }

    @Override
    public int intValue() {
        return this._intValue;
    }

    public static MeterPulseCommand valueOf(int intValue) {
        MeterPulseCommand result = _map.get(intValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static MeterPulseCommand valueOfIfPresent(int intValue) {
        return _map.get(intValue);
    }
}

