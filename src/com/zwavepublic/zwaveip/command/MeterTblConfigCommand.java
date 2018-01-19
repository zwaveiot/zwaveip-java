package com.zwavepublic.zwaveip.command;

import java.util.HashMap;

/* MeterTblConfig commands (version 1) */
public enum MeterTblConfigCommand implements Command {
    METER_TBL_TABLE_POINT_ADM_NO_SET((byte)0x01);

    private static final HashMap<Byte, MeterTblConfigCommand> _map = new HashMap<Byte, MeterTblConfigCommand>(1);
    static {
        for (MeterTblConfigCommand value: MeterTblConfigCommand.values()) {
            _map.put(value.byteValue(), value);
        }
    }

    private byte _byteValue;

    private MeterTblConfigCommand(byte value) {
        this._byteValue = value;
    }

    @Override
    public byte byteValue() {
        return this._byteValue;
    }

    public static MeterTblConfigCommand valueOf(byte byteValue) {
        MeterTblConfigCommand result = _map.get(byteValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static MeterTblConfigCommand valueOfIfPresent(byte byteValue) {
        return _map.get(byteValue);
    }
}

