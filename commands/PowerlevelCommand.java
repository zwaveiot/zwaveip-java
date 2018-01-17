package com.zwavepublic.zwaveip.commands;

import java.util.HashMap;

/* Powerlevel commands (version 1) */
public enum PowerlevelCommand implements com.zwavepublic.zwaveip.commands.Command {
    GET(0x02),
    REPORT(0x03),
    SET(0x01),
    TEST_NODE_GET(0x05),
    TEST_NODE_REPORT(0x06),
    TEST_NODE_SET(0x04);

    private static final HashMap<Integer, PowerlevelCommand> _map = new HashMap<Integer, PowerlevelCommand>(6);
    static {
        for (PowerlevelCommand value: PowerlevelCommand.values()) {
            _map.put(value.intValue(), value);
        }
    }

    private int _intValue;

    private PowerlevelCommand(int value) {
        this._intValue = value;
    }

    @Override
    public int intValue() {
        return this._intValue;
    }

    public static PowerlevelCommand valueOf(int intValue) {
        PowerlevelCommand result = _map.get(intValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static PowerlevelCommand valueOfIfPresent(int intValue) {
        return _map.get(intValue);
    }
}

