package com.zwavepublic.zwaveip.commands;

import java.util.HashMap;

/* WakeUp commands (version 2) */
public enum WakeUpCommand implements com.zwavepublic.zwaveip.commands.Command {
    INTERVAL_CAPABILITIES_GET(0x09),
    INTERVAL_CAPABILITIES_REPORT(0x0a),
    INTERVAL_GET(0x05),
    INTERVAL_REPORT(0x06),
    INTERVAL_SET(0x04),
    NO_MORE_INFORMATION(0x08),
    NOTIFICATION(0x07);

    private static final HashMap<Integer, WakeUpCommand> _map = new HashMap<Integer, WakeUpCommand>(7);
    static {
        for (WakeUpCommand value: WakeUpCommand.values()) {
            _map.put(value.intValue(), value);
        }
    }

    private int _intValue;

    private WakeUpCommand(int value) {
        this._intValue = value;
    }

    @Override
    public int intValue() {
        return this._intValue;
    }

    public static WakeUpCommand valueOf(int intValue) {
        WakeUpCommand result = _map.get(intValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static WakeUpCommand valueOfIfPresent(int intValue) {
        return _map.get(intValue);
    }
}

