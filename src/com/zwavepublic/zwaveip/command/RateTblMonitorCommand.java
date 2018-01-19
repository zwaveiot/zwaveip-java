package com.zwavepublic.zwaveip.command;

import java.util.HashMap;

/* RateTblMonitor commands (version 1) */
public enum RateTblMonitorCommand implements Command {
    RATE_TBL_ACTIVE_RATE_GET((byte)0x05),
    RATE_TBL_ACTIVE_RATE_REPORT((byte)0x06),
    RATE_TBL_CURRENT_DATA_GET((byte)0x07),
    RATE_TBL_CURRENT_DATA_REPORT((byte)0x08),
    RATE_TBL_GET((byte)0x03),
    RATE_TBL_HISTORICAL_DATA_GET((byte)0x09),
    RATE_TBL_HISTORICAL_DATA_REPORT((byte)0x0a),
    RATE_TBL_REPORT((byte)0x04),
    RATE_TBL_SUPPORTED_GET((byte)0x01),
    RATE_TBL_SUPPORTED_REPORT((byte)0x02);

    private static final HashMap<Byte, RateTblMonitorCommand> _map = new HashMap<Byte, RateTblMonitorCommand>(10);
    static {
        for (RateTblMonitorCommand value: RateTblMonitorCommand.values()) {
            _map.put(value.byteValue(), value);
        }
    }

    private byte _byteValue;

    private RateTblMonitorCommand(byte value) {
        this._byteValue = value;
    }

    @Override
    public byte byteValue() {
        return this._byteValue;
    }

    public static RateTblMonitorCommand valueOf(byte byteValue) {
        RateTblMonitorCommand result = _map.get(byteValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static RateTblMonitorCommand valueOfIfPresent(byte byteValue) {
        return _map.get(byteValue);
    }
}

