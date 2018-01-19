package com.zwavepublic.zwaveip.command;

import java.util.HashMap;

/* IpAssociation commands (version 1) */
public enum IpAssociationCommand implements Command {
    SET((byte)0x01),
    GET((byte)0x02),
    REPORT((byte)0x03),
    REMOVE((byte)0x04);

    private static final HashMap<Byte, IpAssociationCommand> _map = new HashMap<Byte, IpAssociationCommand>(4);
    static {
        for (IpAssociationCommand value: IpAssociationCommand.values()) {
            _map.put(value.byteValue(), value);
        }
    }

    private byte _byteValue;

    private IpAssociationCommand(byte value) {
        this._byteValue = value;
    }

    @Override
    public byte byteValue() {
        return this._byteValue;
    }

    public static IpAssociationCommand valueOf(byte byteValue) {
        IpAssociationCommand result = _map.get(byteValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static IpAssociationCommand valueOfIfPresent(byte byteValue) {
        return _map.get(byteValue);
    }
}

