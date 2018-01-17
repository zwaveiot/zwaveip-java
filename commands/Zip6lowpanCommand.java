package com.zwavepublic.zwaveip.commands;

import java.util.HashMap;

/* Zip6lowpan commands (version 1) */
public enum Zip6lowpanCommand implements com.zwavepublic.zwaveip.commands.Command {
    LOWPAN_FIRST_FRAGMENT(0xc0),
    LOWPAN_SUBSEQUENT_FRAGMENT(0xe0);

    private static final HashMap<Integer, Zip6lowpanCommand> _map = new HashMap<Integer, Zip6lowpanCommand>(2);
    static {
        for (Zip6lowpanCommand value: Zip6lowpanCommand.values()) {
            _map.put(value.intValue(), value);
        }
    }

    private int _intValue;

    private Zip6lowpanCommand(int value) {
        this._intValue = value;
    }

    @Override
    public int intValue() {
        return this._intValue;
    }

    public static Zip6lowpanCommand valueOf(int intValue) {
        Zip6lowpanCommand result = _map.get(intValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static Zip6lowpanCommand valueOfIfPresent(int intValue) {
        return _map.get(intValue);
    }
}

