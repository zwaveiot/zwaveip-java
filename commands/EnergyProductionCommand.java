package com.zwavepublic.zwaveip.commands;

import java.util.HashMap;

/* EnergyProduction commands (version 1) */
public enum EnergyProductionCommand implements com.zwavepublic.zwaveip.commands.Command {
    GET(0x02),
    REPORT(0x03);

    private static final HashMap<Integer, EnergyProductionCommand> _map = new HashMap<Integer, EnergyProductionCommand>(2);
    static {
        for (EnergyProductionCommand value: EnergyProductionCommand.values()) {
            _map.put(value.intValue(), value);
        }
    }

    private int _intValue;

    private EnergyProductionCommand(int value) {
        this._intValue = value;
    }

    @Override
    public int intValue() {
        return this._intValue;
    }

    public static EnergyProductionCommand valueOf(int intValue) {
        EnergyProductionCommand result = _map.get(intValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static EnergyProductionCommand valueOfIfPresent(int intValue) {
        return _map.get(intValue);
    }
}

