package com.zwavepublic.zwaveip.commands;

import java.util.HashMap;

/* ChimneyFan commands (version 1) */
public enum ChimneyFanCommand implements com.zwavepublic.zwaveip.commands.Command {
    ALARM_LOG_GET(0x20),
    ALARM_LOG_REPORT(0x21),
    ALARM_LOG_SET(0x1f),
    ALARM_STATUS_GET(0x23),
    ALARM_STATUS_REPORT(0x24),
    ALARM_STATUS_SET(0x22),
    ALARM_TEMP_GET(0x0e),
    ALARM_TEMP_REPORT(0x0f),
    ALARM_TEMP_SET(0x0d),
    BOOST_TIME_GET(0x11),
    BOOST_TIME_REPORT(0x12),
    BOOST_TIME_SET(0x10),
    DEFAULT_SET(0x28),
    MIN_SPEED_GET(0x26),
    MIN_SPEED_REPORT(0x27),
    MIN_SPEED_SET(0x25),
    MODE_GET(0x17),
    MODE_REPORT(0x18),
    MODE_SET(0x16),
    SETUP_GET(0x1a),
    SETUP_REPORT(0x1b),
    SETUP_SET(0x19),
    SPEED_GET(0x05),
    SPEED_REPORT(0x06),
    SPEED_SET(0x04),
    START_TEMP_GET(0x08),
    START_TEMP_REPORT(0x09),
    START_TEMP_SET(0x07),
    STATE_GET(0x02),
    STATE_REPORT(0x03),
    STATE_SET(0x01),
    STATUS_GET(0x1d),
    STATUS_REPORT(0x1e),
    STOP_TEMP_GET(0x0b),
    STOP_TEMP_REPORT(0x0c),
    STOP_TEMP_SET(0x0a),
    STOP_TIME_GET(0x14),
    STOP_TIME_REPORT(0x15),
    STOP_TIME_SET(0x13);

    private static final HashMap<Integer, ChimneyFanCommand> _map = new HashMap<Integer, ChimneyFanCommand>(39);
    static {
        for (ChimneyFanCommand value: ChimneyFanCommand.values()) {
            _map.put(value.intValue(), value);
        }
    }

    private int _intValue;

    private ChimneyFanCommand(int value) {
        this._intValue = value;
    }

    @Override
    public int intValue() {
        return this._intValue;
    }

    public static ChimneyFanCommand valueOf(int intValue) {
        ChimneyFanCommand result = _map.get(intValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static ChimneyFanCommand valueOfIfPresent(int intValue) {
        return _map.get(intValue);
    }
}

