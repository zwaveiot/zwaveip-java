package com.zwavepublic.zwaveip.commands;

import java.util.HashMap;

/* Z-Wave command classes */
public enum CommandClass {
    ANTITHEFT(0x5d),
    APPLICATION_CAPABILITY(0x57),
    APPLICATION_STATUS(0x22),
    ASSOCIATION(0x85),
    ASSOCIATION_COMMAND_CONFIGURATION(0x9b),
    ASSOCIATION_GRP_INFO(0x59),
    AV_CONTENT_DIRECTORY_MD(0x95),
    AV_CONTENT_SEARCH_MD(0x97),
    AV_RENDERER_STATUS(0x96),
    AV_TAGGING_MD(0x99),
    BARRIER_OPERATOR(0x66),
    BASIC(0x20),
    BASIC_TARIFF_INFO(0x36),
    BASIC_WINDOW_COVERING(0x50),
    BATTERY(0x80),
    CENTRAL_SCENE(0x5b),
    CHIMNEY_FAN(0x2a),
    CLIMATE_CONTROL_SCHEDULE(0x46),
    CLOCK(0x81),
    CONFIGURATION(0x70),
    CONTROLLER_REPLICATION(0x21),
    CRC_16_ENCAP(0x56),
    DCP_CONFIG(0x3a),
    DCP_MONITOR(0x3b),
    DEVICE_RESET_LOCALLY(0x5a),
    DMX(0x65),
    DOOR_LOCK(0x62),
    DOOR_LOCK_LOGGING(0x4c),
    ENERGY_PRODUCTION(0x90),
    ENTRY_CONTROL(0x6f),
    FIRMWARE_UPDATE_MD(0x7a),
    GEOGRAPHIC_LOCATION(0x8c),
    GROUPING_NAME(0x7b),
    HAIL(0x82),
    HRV_CONTROL(0x39),
    HRV_STATUS(0x37),
    HUMIDITY_CONTROL_MODE(0x6d),
    HUMIDITY_CONTROL_OPERATING_STATE(0x6e),
    HUMIDITY_CONTROL_SETPOINT(0x64),
    INCLUSION_CONTROLLER(0x74),
    INDICATOR(0x87),
    IP_ASSOCIATION(0x5c),
    IP_CONFIGURATION(0x9a),
    IRRIGATION(0x6b),
    LANGUAGE(0x89),
    LOCK(0x76),
    MAILBOX(0x69),
    MANUFACTURER_PROPRIETARY(0x91),
    MANUFACTURER_SPECIFIC(0x72),
    MARK(0xef),
    METER(0x32),
    METER_PULSE(0x35),
    METER_TBL_CONFIG(0x3c),
    METER_TBL_MONITOR(0x3d),
    METER_TBL_PUSH(0x3e),
    MTP_WINDOW_COVERING(0x51),
    MULTI_CHANNEL(0x60),
    MULTI_CHANNEL_ASSOCIATION(0x8e),
    MULTI_CMD(0x8f),
    NETWORK_MANAGEMENT_BASIC(0x4d),
    NETWORK_MANAGEMENT_INCLUSION(0x34),
    NETWORK_MANAGEMENT_INSTALLATION_MAINTENANCE(0x67),
    NETWORK_MANAGEMENT_PRIMARY(0x54),
    NETWORK_MANAGEMENT_PROXY(0x52),
    NO_OPERATION(0x00),
    NODE_NAMING(0x77),
    NON_INTEROPERABLE(0xf0),
    NOTIFICATION(0x71),
    POWERLEVEL(0x73),
    PREPAYMENT(0x3f),
    PREPAYMENT_ENCAPSULATION(0x41),
    PROPRIETARY(0x88),
    PROTECTION(0x75),
    RATE_TBL_CONFIG(0x48),
    RATE_TBL_MONITOR(0x49),
    REMOTE_ASSOCIATION(0x7d),
    REMOTE_ASSOCIATION_ACTIVATE(0x7c),
    SCENE_ACTIVATION(0x2b),
    SCENE_ACTUATOR_CONF(0x2c),
    SCENE_CONTROLLER_CONF(0x2d),
    SCHEDULE(0x53),
    SCHEDULE_ENTRY_LOCK(0x4e),
    SCREEN_ATTRIBUTES(0x93),
    SCREEN_MD(0x92),
    SECURITY(0x98),
    SECURITY_2(0x9f),
    SECURITY_PANEL_MODE(0x24),
    SECURITY_PANEL_ZONE(0x2e),
    SECURITY_PANEL_ZONE_SENSOR(0x2f),
    SENSOR_ALARM(0x9c),
    SENSOR_BINARY(0x30),
    SENSOR_CONFIGURATION(0x9e),
    SENSOR_MULTILEVEL(0x31),
    SILENCE_ALARM(0x9d),
    SIMPLE_AV_CONTROL(0x94),
    SUPERVISION(0x6c),
    SWITCH_ALL(0x27),
    SWITCH_BINARY(0x25),
    SWITCH_COLOR(0x33),
    SWITCH_MULTILEVEL(0x26),
    SWITCH_TOGGLE_BINARY(0x28),
    SWITCH_TOGGLE_MULTILEVEL(0x29),
    TARIFF_CONFIG(0x4a),
    TARIFF_TBL_MONITOR(0x4b),
    THERMOSTAT_FAN_MODE(0x44),
    THERMOSTAT_FAN_STATE(0x45),
    THERMOSTAT_HEATING(0x38),
    THERMOSTAT_MODE(0x40),
    THERMOSTAT_OPERATING_STATE(0x42),
    THERMOSTAT_SETBACK(0x47),
    THERMOSTAT_SETPOINT(0x43),
    TIME(0x8a),
    TIME_PARAMETERS(0x8b),
    TRANSPORT_SERVICE(0x55),
    USER_CODE(0x63),
    VERSION(0x86),
    WAKE_UP(0x84),
    WINDOW_COVERING(0x6a),
    ZENSOR_NET(0x02),
    ZIP(0x23),
    ZIP_6LOWPAN(0x4f),
    ZIP_GATEWAY(0x5f),
    ZIP_NAMING(0x68),
    ZIP_ND(0x58),
    ZIP_PORTAL(0x61),
    ZWAVEPLUS_INFO(0x5e);

    private static final HashMap<Integer, CommandClass> _map = new HashMap<Integer, CommandClass>();
    static {
        for (CommandClass value: CommandClass.values()) {
            _map.put(value.intValue(), value);
        }
    }

    private int _intValue;

    private CommandClass(int value) {
        this._intValue = value;
    }

    public int intValue() {
        return this._intValue;
    }

    public static CommandClass valueOf(int intValue) {
        CommandClass result = _map.get(intValue);
        if(result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static CommandClass valueOfIfPresent(int intValue) {
        return _map.get(intValue);
    }
}

