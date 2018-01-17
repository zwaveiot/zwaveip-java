package com.zwavepublic.zwaveip.commands;

import java.util.HashMap;

/* PrepaymentEncapsulation commands (version 1) */
public enum PrepaymentEncapsulationCommand implements com.zwavepublic.zwaveip.commands.Command {
    CMD_ENCAPSULATION(0x01);

    private static final HashMap<Integer, PrepaymentEncapsulationCommand> _map = new HashMap<Integer, PrepaymentEncapsulationCommand>(1);
    static {
        for (PrepaymentEncapsulationCommand value: PrepaymentEncapsulationCommand.values()) {
            _map.put(value.intValue(), value);
        }
    }

    private int _intValue;

    private PrepaymentEncapsulationCommand(int value) {
        this._intValue = value;
    }

    @Override
    public int intValue() {
        return this._intValue;
    }

    public static PrepaymentEncapsulationCommand valueOf(int intValue) {
        PrepaymentEncapsulationCommand result = _map.get(intValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static PrepaymentEncapsulationCommand valueOfIfPresent(int intValue) {
        return _map.get(intValue);
    }
}

