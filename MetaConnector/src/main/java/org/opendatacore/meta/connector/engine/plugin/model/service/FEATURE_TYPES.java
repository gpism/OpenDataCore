package org.opendatacore.meta.connector.engine.plugin.model.service;
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
public interface FEATURE_TYPES {
    String UI_GROUP = "ui";

    String UI_TYPE_STRING = "text";

    String UI_TYPE_STRING_PASSWORD = "text_password";

    String UI_TYPE_STRING_URL = "text_url";
    String UI_TYPE_INT = "number";
    String UI_TYPE_BOOLEAN = "boolean";
    String UI_TYPE_DATE = "date";
    String UI_TYPE_DATETIME = "datetime";
    String UI_TYPE_TIME = "time";
    String UI_TYPE_FILE = "file";
    String UI_TYPE_FOLDER = "folder";

    String FEATURE_GROUP = "ui";

    String CONFIG_TYPE = "config";
    String VALIDATION_TYPE = "validation";

    String COMPUTE_TYPE = "compute";


    String ACCESS_SUB_TYPE = "access";


}
