package com.zwavepublic.zwaveip.command;

import java.util.HashMap;

/* MeterTblMonitor commands (version 2) */
public enum MeterTblMonitorCommand implements Command {
    METER_TBL_STATUS_REPORT((byte)0x0b),
    METER_TBL_STATUS_DATE_GET((byte)0x0a),
    METER_TBL_STATUS_DEPTH_GET((byte)0x09),
    METER_TBL_STATUS_SUPPORTED_GET((byte)0x07),
    METER_TBL_STATUS_SUPPORTED_REPORT((byte)0x08),
    METER_TBL_CURRENT_DATA_GET((byte)0x0c),
    METER_TBL_CURRENT_DATA_REPORT((byte)0x0d),
    METER_TBL_HISTORICAL_DATA_GET((byte)0x0e),
    METER_TBL_HISTORICAL_DATA_REPORT((byte)0x0f),
    METER_TBL_REPORT((byte)0x06),
    METER_TBL_TABLE_CAPABILITY_GET((byte)0x05),
    METER_TBL_TABLE_ID_GET((byte)0x03),
    METER_TBL_TABLE_ID_REPORT((byte)0x04),
    METER_TBL_TABLE_POINT_ADM_NO_GET((byte)0x01),
    METER_TBL_TABLE_POINT_ADM_NO_REPORT((byte)0x02);

    private static final HashMap<Byte, MeterTblMonitorCommand> _map = new HashMap<Byte, MeterTblMonitorCommand>(15);
    static {
        for (MeterTblMonitorCommand value: MeterTblMonitorCommand.values()) {
            _map.put(value.byteValue(), value);
        }
    }

    private byte _byteValue;

    private MeterTblMonitorCommand(byte value) {
        this._byteValue = value;
    }

    @Override
    public byte byteValue() {
        return this._byteValue;
    }

    public static MeterTblMonitorCommand valueOf(byte byteValue) {
        MeterTblMonitorCommand result = _map.get(byteValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static MeterTblMonitorCommand valueOfIfPresent(byte byteValue) {
        return _map.get(byteValue);
    }
}

