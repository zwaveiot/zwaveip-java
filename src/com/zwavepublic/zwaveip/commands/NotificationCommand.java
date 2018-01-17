package com.zwavepublic.zwaveip.commands;

import java.util.HashMap;

/* Notification commands (version 8) */
public enum NotificationCommand implements com.zwavepublic.zwaveip.commands.Command {
    GET(0x04),
    REPORT(0x05),
    SET(0x06),
    SUPPORTED_GET(0x07),
    SUPPORTED_REPORT(0x08),
    EVENT_SUPPORTED_GET(0x01),
    EVENT_SUPPORTED_REPORT(0x02);

    private static final HashMap<Integer, NotificationCommand> _map = new HashMap<Integer, NotificationCommand>(7);
    static {
        for (NotificationCommand value: NotificationCommand.values()) {
            _map.put(value.intValue(), value);
        }
    }

    private int _intValue;

    private NotificationCommand(int value) {
        this._intValue = value;
    }

    @Override
    public int intValue() {
        return this._intValue;
    }

    public static NotificationCommand valueOf(int intValue) {
        NotificationCommand result = _map.get(intValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static NotificationCommand valueOfIfPresent(int intValue) {
        return _map.get(intValue);
    }
}

