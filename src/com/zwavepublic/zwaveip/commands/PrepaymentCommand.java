package com.zwavepublic.zwaveip.commands;

import java.util.HashMap;

/* Prepayment commands (version 1) */
public enum PrepaymentCommand implements com.zwavepublic.zwaveip.commands.Command {
    BALANCE_GET(0x01),
    BALANCE_REPORT(0x02),
    SUPPORTED_GET(0x03),
    SUPPORTED_REPORT(0x04);

    private static final HashMap<Integer, PrepaymentCommand> _map = new HashMap<Integer, PrepaymentCommand>(4);
    static {
        for (PrepaymentCommand value: PrepaymentCommand.values()) {
            _map.put(value.intValue(), value);
        }
    }

    private int _intValue;

    private PrepaymentCommand(int value) {
        this._intValue = value;
    }

    @Override
    public int intValue() {
        return this._intValue;
    }

    public static PrepaymentCommand valueOf(int intValue) {
        PrepaymentCommand result = _map.get(intValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static PrepaymentCommand valueOfIfPresent(int intValue) {
        return _map.get(intValue);
    }
}

