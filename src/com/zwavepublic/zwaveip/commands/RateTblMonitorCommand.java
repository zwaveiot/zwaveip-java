package com.zwavepublic.zwaveip.commands;

import java.util.HashMap;

/* RateTblMonitor commands (version 1) */
public enum RateTblMonitorCommand implements com.zwavepublic.zwaveip.commands.Command {
    RATE_TBL_ACTIVE_RATE_GET(0x05),
    RATE_TBL_ACTIVE_RATE_REPORT(0x06),
    RATE_TBL_CURRENT_DATA_GET(0x07),
    RATE_TBL_CURRENT_DATA_REPORT(0x08),
    RATE_TBL_GET(0x03),
    RATE_TBL_HISTORICAL_DATA_GET(0x09),
    RATE_TBL_HISTORICAL_DATA_REPORT(0x0a),
    RATE_TBL_REPORT(0x04),
    RATE_TBL_SUPPORTED_GET(0x01),
    RATE_TBL_SUPPORTED_REPORT(0x02);

    private static final HashMap<Integer, RateTblMonitorCommand> _map = new HashMap<Integer, RateTblMonitorCommand>(10);
    static {
        for (RateTblMonitorCommand value: RateTblMonitorCommand.values()) {
            _map.put(value.intValue(), value);
        }
    }

    private int _intValue;

    private RateTblMonitorCommand(int value) {
        this._intValue = value;
    }

    @Override
    public int intValue() {
        return this._intValue;
    }

    public static RateTblMonitorCommand valueOf(int intValue) {
        RateTblMonitorCommand result = _map.get(intValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static RateTblMonitorCommand valueOfIfPresent(int intValue) {
        return _map.get(intValue);
    }
}

