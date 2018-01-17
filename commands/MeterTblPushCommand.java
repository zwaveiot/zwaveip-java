package com.zwavepublic.zwaveip.commands;

import java.util.HashMap;

/* MeterTblPush commands (version 1) */
public enum MeterTblPushCommand implements com.zwavepublic.zwaveip.commands.Command {
    CONFIGURATION_GET(0x02),
    CONFIGURATION_REPORT(0x03),
    CONFIGURATION_SET(0x01);

    private static final HashMap<Integer, MeterTblPushCommand> _map = new HashMap<Integer, MeterTblPushCommand>(3);
    static {
        for (MeterTblPushCommand value: MeterTblPushCommand.values()) {
            _map.put(value.intValue(), value);
        }
    }

    private int _intValue;

    private MeterTblPushCommand(int value) {
        this._intValue = value;
    }

    @Override
    public int intValue() {
        return this._intValue;
    }

    public static MeterTblPushCommand valueOf(int intValue) {
        MeterTblPushCommand result = _map.get(intValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static MeterTblPushCommand valueOfIfPresent(int intValue) {
        return _map.get(intValue);
    }
}

