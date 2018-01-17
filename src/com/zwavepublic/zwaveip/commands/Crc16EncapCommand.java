package com.zwavepublic.zwaveip.commands;

import java.util.HashMap;

/* Crc16Encap commands (version 1) */
public enum Crc16EncapCommand implements com.zwavepublic.zwaveip.commands.Command {
    CRC_16_ENCAP(0x01);

    private static final HashMap<Integer, Crc16EncapCommand> _map = new HashMap<Integer, Crc16EncapCommand>(1);
    static {
        for (Crc16EncapCommand value: Crc16EncapCommand.values()) {
            _map.put(value.intValue(), value);
        }
    }

    private int _intValue;

    private Crc16EncapCommand(int value) {
        this._intValue = value;
    }

    @Override
    public int intValue() {
        return this._intValue;
    }

    public static Crc16EncapCommand valueOf(int intValue) {
        Crc16EncapCommand result = _map.get(intValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static Crc16EncapCommand valueOfIfPresent(int intValue) {
        return _map.get(intValue);
    }
}

