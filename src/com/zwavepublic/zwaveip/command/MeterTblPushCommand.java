package com.zwavepublic.zwaveip.command;

import java.util.HashMap;

/* MeterTblPush commands (version 1) */
public enum MeterTblPushCommand implements Command {
    CONFIGURATION_GET((byte)0x02),
    CONFIGURATION_REPORT((byte)0x03),
    CONFIGURATION_SET((byte)0x01);

    private static final HashMap<Byte, MeterTblPushCommand> _map = new HashMap<Byte, MeterTblPushCommand>(3);
    static {
        for (MeterTblPushCommand value: MeterTblPushCommand.values()) {
            _map.put(value.byteValue(), value);
        }
    }

    private byte _byteValue;

    private MeterTblPushCommand(byte value) {
        this._byteValue = value;
    }

    @Override
    public byte byteValue() {
        return this._byteValue;
    }

    public static MeterTblPushCommand valueOf(byte byteValue) {
        MeterTblPushCommand result = _map.get(byteValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static MeterTblPushCommand valueOfIfPresent(byte byteValue) {
        return _map.get(byteValue);
    }
}

