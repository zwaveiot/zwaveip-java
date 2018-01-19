package com.zwavepublic.zwaveip.command;

import java.util.HashMap;

/* ControllerReplication commands (version 1) */
public enum ControllerReplicationCommand implements Command {
    CTRL_REPLICATION_TRANSFER_GROUP((byte)0x31),
    CTRL_REPLICATION_TRANSFER_GROUP_NAME((byte)0x32),
    CTRL_REPLICATION_TRANSFER_SCENE((byte)0x33),
    CTRL_REPLICATION_TRANSFER_SCENE_NAME((byte)0x34);

    private static final HashMap<Byte, ControllerReplicationCommand> _map = new HashMap<Byte, ControllerReplicationCommand>(4);
    static {
        for (ControllerReplicationCommand value: ControllerReplicationCommand.values()) {
            _map.put(value.byteValue(), value);
        }
    }

    private byte _byteValue;

    private ControllerReplicationCommand(byte value) {
        this._byteValue = value;
    }

    @Override
    public byte byteValue() {
        return this._byteValue;
    }

    public static ControllerReplicationCommand valueOf(byte byteValue) {
        ControllerReplicationCommand result = _map.get(byteValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static ControllerReplicationCommand valueOfIfPresent(byte byteValue) {
        return _map.get(byteValue);
    }
}

