package com.zwavepublic.zwaveip.command;

import java.util.HashMap;

/* PrepaymentEncapsulation commands (version 1) */
public enum PrepaymentEncapsulationCommand implements Command {
    CMD_ENCAPSULATION((byte)0x01);

    private static final HashMap<Byte, PrepaymentEncapsulationCommand> _map = new HashMap<Byte, PrepaymentEncapsulationCommand>(1);
    static {
        for (PrepaymentEncapsulationCommand value: PrepaymentEncapsulationCommand.values()) {
            _map.put(value.byteValue(), value);
        }
    }

    private byte _byteValue;

    private PrepaymentEncapsulationCommand(byte value) {
        this._byteValue = value;
    }

    @Override
    public byte byteValue() {
        return this._byteValue;
    }

    public static PrepaymentEncapsulationCommand valueOf(byte byteValue) {
        PrepaymentEncapsulationCommand result = _map.get(byteValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static PrepaymentEncapsulationCommand valueOfIfPresent(byte byteValue) {
        return _map.get(byteValue);
    }
}

