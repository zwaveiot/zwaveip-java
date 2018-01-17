package com.zwavepublic.zwaveip.commands;

import java.util.HashMap;

/* IpAssociation commands (version 1) */
public enum IpAssociationCommand implements com.zwavepublic.zwaveip.commands.Command {
    SET(0x01),
    GET(0x02),
    REPORT(0x03),
    REMOVE(0x04);

    private static final HashMap<Integer, IpAssociationCommand> _map = new HashMap<Integer, IpAssociationCommand>(4);
    static {
        for (IpAssociationCommand value: IpAssociationCommand.values()) {
            _map.put(value.intValue(), value);
        }
    }

    private int _intValue;

    private IpAssociationCommand(int value) {
        this._intValue = value;
    }

    @Override
    public int intValue() {
        return this._intValue;
    }

    public static IpAssociationCommand valueOf(int intValue) {
        IpAssociationCommand result = _map.get(intValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static IpAssociationCommand valueOfIfPresent(int intValue) {
        return _map.get(intValue);
    }
}

