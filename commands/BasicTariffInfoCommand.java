package com.zwavepublic.zwaveip.commands;

import java.util.HashMap;

/* BasicTariffInfo commands (version 1) */
public enum BasicTariffInfoCommand implements com.zwavepublic.zwaveip.commands.Command {
    GET(0x01),
    REPORT(0x02);

    private static final HashMap<Integer, BasicTariffInfoCommand> _map = new HashMap<Integer, BasicTariffInfoCommand>(2);
    static {
        for (BasicTariffInfoCommand value: BasicTariffInfoCommand.values()) {
            _map.put(value.intValue(), value);
        }
    }

    private int _intValue;

    private BasicTariffInfoCommand(int value) {
        this._intValue = value;
    }

    @Override
    public int intValue() {
        return this._intValue;
    }

    public static BasicTariffInfoCommand valueOf(int intValue) {
        BasicTariffInfoCommand result = _map.get(intValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static BasicTariffInfoCommand valueOfIfPresent(int intValue) {
        return _map.get(intValue);
    }
}

