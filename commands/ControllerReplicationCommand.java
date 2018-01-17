package com.zwavepublic.zwaveip.commands;

import java.util.HashMap;

/* ControllerReplication commands (version 1) */
public enum ControllerReplicationCommand implements com.zwavepublic.zwaveip.commands.Command {
    CTRL_REPLICATION_TRANSFER_GROUP(0x31),
    CTRL_REPLICATION_TRANSFER_GROUP_NAME(0x32),
    CTRL_REPLICATION_TRANSFER_SCENE(0x33),
    CTRL_REPLICATION_TRANSFER_SCENE_NAME(0x34);

    private static final HashMap<Integer, ControllerReplicationCommand> _map = new HashMap<Integer, ControllerReplicationCommand>(4);
    static {
        for (ControllerReplicationCommand value: ControllerReplicationCommand.values()) {
            _map.put(value.intValue(), value);
        }
    }

    private int _intValue;

    private ControllerReplicationCommand(int value) {
        this._intValue = value;
    }

    @Override
    public int intValue() {
        return this._intValue;
    }

    public static ControllerReplicationCommand valueOf(int intValue) {
        ControllerReplicationCommand result = _map.get(intValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static ControllerReplicationCommand valueOfIfPresent(int intValue) {
        return _map.get(intValue);
    }
}

