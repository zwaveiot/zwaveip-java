package com.zwavepublic.zwaveip.command;

import java.util.HashMap;

/* ChimneyFan commands (version 1) */
public enum ChimneyFanCommand implements Command {
    ALARM_LOG_GET((byte)0x20),
    ALARM_LOG_REPORT((byte)0x21),
    ALARM_LOG_SET((byte)0x1f),
    ALARM_STATUS_GET((byte)0x23),
    ALARM_STATUS_REPORT((byte)0x24),
    ALARM_STATUS_SET((byte)0x22),
    ALARM_TEMP_GET((byte)0x0e),
    ALARM_TEMP_REPORT((byte)0x0f),
    ALARM_TEMP_SET((byte)0x0d),
    BOOST_TIME_GET((byte)0x11),
    BOOST_TIME_REPORT((byte)0x12),
    BOOST_TIME_SET((byte)0x10),
    DEFAULT_SET((byte)0x28),
    MIN_SPEED_GET((byte)0x26),
    MIN_SPEED_REPORT((byte)0x27),
    MIN_SPEED_SET((byte)0x25),
    MODE_GET((byte)0x17),
    MODE_REPORT((byte)0x18),
    MODE_SET((byte)0x16),
    SETUP_GET((byte)0x1a),
    SETUP_REPORT((byte)0x1b),
    SETUP_SET((byte)0x19),
    SPEED_GET((byte)0x05),
    SPEED_REPORT((byte)0x06),
    SPEED_SET((byte)0x04),
    START_TEMP_GET((byte)0x08),
    START_TEMP_REPORT((byte)0x09),
    START_TEMP_SET((byte)0x07),
    STATE_GET((byte)0x02),
    STATE_REPORT((byte)0x03),
    STATE_SET((byte)0x01),
    STATUS_GET((byte)0x1d),
    STATUS_REPORT((byte)0x1e),
    STOP_TEMP_GET((byte)0x0b),
    STOP_TEMP_REPORT((byte)0x0c),
    STOP_TEMP_SET((byte)0x0a),
    STOP_TIME_GET((byte)0x14),
    STOP_TIME_REPORT((byte)0x15),
    STOP_TIME_SET((byte)0x13);

    private static final HashMap<Byte, ChimneyFanCommand> _map = new HashMap<Byte, ChimneyFanCommand>(39);
    static {
        for (ChimneyFanCommand value: ChimneyFanCommand.values()) {
            _map.put(value.byteValue(), value);
        }
    }

    private byte _byteValue;

    private ChimneyFanCommand(byte value) {
        this._byteValue = value;
    }

    @Override
    public byte byteValue() {
        return this._byteValue;
    }

    public static ChimneyFanCommand valueOf(byte byteValue) {
        ChimneyFanCommand result = _map.get(byteValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static ChimneyFanCommand valueOfIfPresent(byte byteValue) {
        return _map.get(byteValue);
    }
}

