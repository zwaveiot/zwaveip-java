package com.zwavepublic.zwaveip.command;

import java.util.HashMap;

/* Prepayment commands (version 1) */
public enum PrepaymentCommand implements Command {
    BALANCE_GET((byte)0x01),
    BALANCE_REPORT((byte)0x02),
    SUPPORTED_GET((byte)0x03),
    SUPPORTED_REPORT((byte)0x04);

    private static final HashMap<Byte, PrepaymentCommand> _map = new HashMap<Byte, PrepaymentCommand>(4);
    static {
        for (PrepaymentCommand value: PrepaymentCommand.values()) {
            _map.put(value.byteValue(), value);
        }
    }

    private byte _byteValue;

    private PrepaymentCommand(byte value) {
        this._byteValue = value;
    }

    @Override
    public byte byteValue() {
        return this._byteValue;
    }

    public static PrepaymentCommand valueOf(byte byteValue) {
        PrepaymentCommand result = _map.get(byteValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static PrepaymentCommand valueOfIfPresent(byte byteValue) {
        return _map.get(byteValue);
    }
}

