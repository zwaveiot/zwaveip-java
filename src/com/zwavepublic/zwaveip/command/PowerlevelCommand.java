package com.zwavepublic.zwaveip.command;

import java.util.HashMap;

/* Powerlevel commands (version 1) */
public enum PowerlevelCommand implements Command {
    GET((byte)0x02),
    REPORT((byte)0x03),
    SET((byte)0x01),
    TEST_NODE_GET((byte)0x05),
    TEST_NODE_REPORT((byte)0x06),
    TEST_NODE_SET((byte)0x04);

    private static final HashMap<Byte, PowerlevelCommand> _map = new HashMap<Byte, PowerlevelCommand>(6);
    static {
        for (PowerlevelCommand value: PowerlevelCommand.values()) {
            _map.put(value.byteValue(), value);
        }
    }

    private byte _byteValue;

    private PowerlevelCommand(byte value) {
        this._byteValue = value;
    }

    @Override
    public byte byteValue() {
        return this._byteValue;
    }

    public static PowerlevelCommand valueOf(byte byteValue) {
        PowerlevelCommand result = _map.get(byteValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static PowerlevelCommand valueOfIfPresent(byte byteValue) {
        return _map.get(byteValue);
    }
}

