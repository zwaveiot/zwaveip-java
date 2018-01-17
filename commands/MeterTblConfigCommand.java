package com.zwavepublic.zwaveip.commands;

import java.util.HashMap;

/* MeterTblConfig commands (version 1) */
public enum MeterTblConfigCommand implements com.zwavepublic.zwaveip.commands.Command {
    METER_TBL_TABLE_POINT_ADM_NO_SET(0x01);

    private static final HashMap<Integer, MeterTblConfigCommand> _map = new HashMap<Integer, MeterTblConfigCommand>(1);
    static {
        for (MeterTblConfigCommand value: MeterTblConfigCommand.values()) {
            _map.put(value.intValue(), value);
        }
    }

    private int _intValue;

    private MeterTblConfigCommand(int value) {
        this._intValue = value;
    }

    @Override
    public int intValue() {
        return this._intValue;
    }

    public static MeterTblConfigCommand valueOf(int intValue) {
        MeterTblConfigCommand result = _map.get(intValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static MeterTblConfigCommand valueOfIfPresent(int intValue) {
        return _map.get(intValue);
    }
}

