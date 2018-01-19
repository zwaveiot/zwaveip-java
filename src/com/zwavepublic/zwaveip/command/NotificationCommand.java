package com.zwavepublic.zwaveip.command;

import java.util.HashMap;

/* Notification commands (version 8) */
public enum NotificationCommand implements Command {
    GET((byte)0x04),
    REPORT((byte)0x05),
    SET((byte)0x06),
    SUPPORTED_GET((byte)0x07),
    SUPPORTED_REPORT((byte)0x08),
    EVENT_SUPPORTED_GET((byte)0x01),
    EVENT_SUPPORTED_REPORT((byte)0x02);

    private static final HashMap<Byte, NotificationCommand> _map = new HashMap<Byte, NotificationCommand>(7);
    static {
        for (NotificationCommand value: NotificationCommand.values()) {
            _map.put(value.byteValue(), value);
        }
    }

    private byte _byteValue;

    private NotificationCommand(byte value) {
        this._byteValue = value;
    }

    @Override
    public byte byteValue() {
        return this._byteValue;
    }

    public static NotificationCommand valueOf(byte byteValue) {
        NotificationCommand result = _map.get(byteValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static NotificationCommand valueOfIfPresent(byte byteValue) {
        return _map.get(byteValue);
    }
}

