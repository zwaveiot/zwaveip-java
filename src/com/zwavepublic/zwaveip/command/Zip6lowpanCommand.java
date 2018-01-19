package com.zwavepublic.zwaveip.command;

import java.util.HashMap;

/* Zip6lowpan commands (version 1) */
public enum Zip6lowpanCommand implements Command {
    LOWPAN_FIRST_FRAGMENT((byte)0xc0),
    LOWPAN_SUBSEQUENT_FRAGMENT((byte)0xe0);

    private static final HashMap<Byte, Zip6lowpanCommand> _map = new HashMap<Byte, Zip6lowpanCommand>(2);
    static {
        for (Zip6lowpanCommand value: Zip6lowpanCommand.values()) {
            _map.put(value.byteValue(), value);
        }
    }

    private byte _byteValue;

    private Zip6lowpanCommand(byte value) {
        this._byteValue = value;
    }

    @Override
    public byte byteValue() {
        return this._byteValue;
    }

    public static Zip6lowpanCommand valueOf(byte byteValue) {
        Zip6lowpanCommand result = _map.get(byteValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static Zip6lowpanCommand valueOfIfPresent(byte byteValue) {
        return _map.get(byteValue);
    }
}

