package com.zwavepublic.zwaveip.command;

import java.util.HashMap;

/* BasicTariffInfo commands (version 1) */
public enum BasicTariffInfoCommand implements Command {
    GET((byte)0x01),
    REPORT((byte)0x02);

    private static final HashMap<Byte, BasicTariffInfoCommand> _map = new HashMap<Byte, BasicTariffInfoCommand>(2);
    static {
        for (BasicTariffInfoCommand value: BasicTariffInfoCommand.values()) {
            _map.put(value.byteValue(), value);
        }
    }

    private byte _byteValue;

    private BasicTariffInfoCommand(byte value) {
        this._byteValue = value;
    }

    @Override
    public byte byteValue() {
        return this._byteValue;
    }

    public static BasicTariffInfoCommand valueOf(byte byteValue) {
        BasicTariffInfoCommand result = _map.get(byteValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static BasicTariffInfoCommand valueOfIfPresent(byte byteValue) {
        return _map.get(byteValue);
    }
}

