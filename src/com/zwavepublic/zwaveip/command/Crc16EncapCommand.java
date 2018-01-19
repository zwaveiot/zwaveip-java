package com.zwavepublic.zwaveip.command;

import java.util.HashMap;

/* Crc16Encap commands (version 1) */
public enum Crc16EncapCommand implements Command {
    CRC_16_ENCAP((byte)0x01);

    private static final HashMap<Byte, Crc16EncapCommand> _map = new HashMap<Byte, Crc16EncapCommand>(1);
    static {
        for (Crc16EncapCommand value: Crc16EncapCommand.values()) {
            _map.put(value.byteValue(), value);
        }
    }

    private byte _byteValue;

    private Crc16EncapCommand(byte value) {
        this._byteValue = value;
    }

    @Override
    public byte byteValue() {
        return this._byteValue;
    }

    public static Crc16EncapCommand valueOf(byte byteValue) {
        Crc16EncapCommand result = _map.get(byteValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static Crc16EncapCommand valueOfIfPresent(byte byteValue) {
        return _map.get(byteValue);
    }
}

