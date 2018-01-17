package com.zwavepublic.zwaveip.commands;

import java.util.HashMap;

/* Supervision commands (version 1) */
public enum SupervisionCommand implements com.zwavepublic.zwaveip.commands.Command {
    GET(0x01),
    REPORT(0x02);

    private static final HashMap<Integer, SupervisionCommand> _map = new HashMap<Integer, SupervisionCommand>(2);
    static {
        for (SupervisionCommand value: SupervisionCommand.values()) {
            _map.put(value.intValue(), value);
        }
    }

    private int _intValue;

    private SupervisionCommand(int value) {
        this._intValue = value;
    }

    @Override
    public int intValue() {
        return this._intValue;
    }

    public static SupervisionCommand valueOf(int intValue) {
        SupervisionCommand result = _map.get(intValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static SupervisionCommand valueOfIfPresent(int intValue) {
        return _map.get(intValue);
    }
}

