package org.opendatacore.meta.connector.engine.plugin.util.config.model;
//JSON 

//logging
/**
 * ODC Meta Connector - Java Class
 *
 * This class is part of the ODC Meta Connector project.
 *
 * ODC Meta Connector is free software: you can redistribute it and/or modify
 * it under the terms of the Apache License, Version 2.0 (the "License").
 *
 * ODC Meta Connector is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * Apache License, Version 2.0 for more details.
 *
 * You should have received a copy of the Apache License, Version 2.0
 * along with ODC Meta Connector. If not, see <https://www.apache.org/licenses/LICENSE-2.0>.
 */

public interface OPERATION_TYPES {


        public static final String CHK_CONNECTION_STATUS = "chk_connection_status";

        public static final String SCHEDULED_MONITORING = "schedule_monitoring";
        public static final String SCHEDULED_MONITORING_START = "schedule_monitoring_start";
        public static final String SCHEDULED_MONITORING_STOP = "schedule_monitoring_stop";
        public static final String SCHEDULED_MONITORING_PAUSE = "schedule_monitoring_pause";
        public static final String SCHEDULED_MONITORING_RESUME = "schedule_monitoring_resume";
        public static final String SCHEDULED_MONITORING_STATUS = "schedule_monitoring_status";

    public static final String SCHEDULED_TESTING ="schedule_testing";
    public static final String SCHEDULED_TESTING_START ="schedule_testing_start";
    public static final String SCHEDULED_TESTING_STOP ="schedule_testing_stop";
    public static final String SCHEDULED_TESTING_PAUSE ="schedule_testing_pause";
    public static final String SCHEDULED_TESTING_RESUME ="schedule_testing_resume";
    public static final String SCHEDULED_TESTING_STATUS ="schedule_testing_status";
    public static final String SCHEDULED_TESTING_STATUS_ALL ="schedule_testing_status_all";


    public static final String CACHE_PUT  ="cache_put";
    public static final String CACHE_GET  ="cache_get";
    public static final String CACHE_DELETE  ="cache_delete";
    public static final String CACHE_CLEAR  ="cache_clear";
    public static final String CACHE_GET_ALL  ="cache_get_all";


}
