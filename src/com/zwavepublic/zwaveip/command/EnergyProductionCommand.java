package com.zwavepublic.zwaveip.command;

import java.util.HashMap;

/* EnergyProduction commands (version 1) */
public enum EnergyProductionCommand implements Command {
    GET((byte)0x02),
    REPORT((byte)0x03);

    private static final HashMap<Byte, EnergyProductionCommand> _map = new HashMap<Byte, EnergyProductionCommand>(2);
    static {
        for (EnergyProductionCommand value: EnergyProductionCommand.values()) {
            _map.put(value.byteValue(), value);
        }
    }

    private byte _byteValue;

    private EnergyProductionCommand(byte value) {
        this._byteValue = value;
    }

    @Override
    public byte byteValue() {
        return this._byteValue;
    }

    public static EnergyProductionCommand valueOf(byte byteValue) {
        EnergyProductionCommand result = _map.get(byteValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static EnergyProductionCommand valueOfIfPresent(byte byteValue) {
        return _map.get(byteValue);
    }
}

