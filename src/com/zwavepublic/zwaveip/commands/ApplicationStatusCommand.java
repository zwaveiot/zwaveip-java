package com.zwavepublic.zwaveip.commands;

import java.util.HashMap;

/* ApplicationStatus commands (version 1) */
public enum ApplicationStatusCommand implements com.zwavepublic.zwaveip.commands.Command {
    APPLICATION_BUSY(0x01),
    APPLICATION_REJECTED_REQUEST(0x02);

    private static final HashMap<Integer, ApplicationStatusCommand> _map = new HashMap<Integer, ApplicationStatusCommand>(2);
    static {
        for (ApplicationStatusCommand value: ApplicationStatusCommand.values()) {
            _map.put(value.intValue(), value);
        }
    }

    private int _intValue;

    private ApplicationStatusCommand(int value) {
        this._intValue = value;
    }

    @Override
    public int intValue() {
        return this._intValue;
    }

    public static ApplicationStatusCommand valueOf(int intValue) {
        ApplicationStatusCommand result = _map.get(intValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static ApplicationStatusCommand valueOfIfPresent(int intValue) {
        return _map.get(intValue);
    }
}

