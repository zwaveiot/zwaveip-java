package com.zwavepublic.zwaveip.commands;

import java.util.HashMap;

/* MeterTblMonitor commands (version 2) */
public enum MeterTblMonitorCommand implements com.zwavepublic.zwaveip.commands.Command {
    METER_TBL_STATUS_REPORT(0x0b),
    METER_TBL_STATUS_DATE_GET(0x0a),
    METER_TBL_STATUS_DEPTH_GET(0x09),
    METER_TBL_STATUS_SUPPORTED_GET(0x07),
    METER_TBL_STATUS_SUPPORTED_REPORT(0x08),
    METER_TBL_CURRENT_DATA_GET(0x0c),
    METER_TBL_CURRENT_DATA_REPORT(0x0d),
    METER_TBL_HISTORICAL_DATA_GET(0x0e),
    METER_TBL_HISTORICAL_DATA_REPORT(0x0f),
    METER_TBL_REPORT(0x06),
    METER_TBL_TABLE_CAPABILITY_GET(0x05),
    METER_TBL_TABLE_ID_GET(0x03),
    METER_TBL_TABLE_ID_REPORT(0x04),
    METER_TBL_TABLE_POINT_ADM_NO_GET(0x01),
    METER_TBL_TABLE_POINT_ADM_NO_REPORT(0x02);

    private static final HashMap<Integer, MeterTblMonitorCommand> _map = new HashMap<Integer, MeterTblMonitorCommand>(15);
    static {
        for (MeterTblMonitorCommand value: MeterTblMonitorCommand.values()) {
            _map.put(value.intValue(), value);
        }
    }

    private int _intValue;

    private MeterTblMonitorCommand(int value) {
        this._intValue = value;
    }

    @Override
    public int intValue() {
        return this._intValue;
    }

    public static MeterTblMonitorCommand valueOf(int intValue) {
        MeterTblMonitorCommand result = _map.get(intValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static MeterTblMonitorCommand valueOfIfPresent(int intValue) {
        return _map.get(intValue);
    }
}

