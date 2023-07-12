package org.opendatacore.meta.connector.engine.plugin.util.config.model;
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
public interface DATA_OPS {
    String AND = "and";
    String OR = "or";
    String NOT = "not";


    String LESS_THAN = "<";
    String LESS_THAN_OR_EQUAL = "<=";
    String EQUAL = "=";
    String GREATER_THAN = ">";
    String GREATER_THAN_OR_EQUAL = ">=";
    String NOT_EQUAL = "!=";
    String BETWEEN = "between";
    String NOT_BETWEEN = "not between";
    String IN = "in";
    String NOT_IN = "not in";
    String LIKE = "like";
    String NOT_LIKE = "not like";
    String IS_NULL = "is null";
    String IS_NOT_NULL = "is not null";
    String IS_EMPTY = "is empty";
    String IS_NOT_EMPTY = "is not empty";
    String CONTAINS = "contains";
    String NOT_CONTAINS = "not contains";
    String STARTS_WITH = "starts with";
    String ENDS_WITH = "ends with";
    String IS_TRUE = "is true";
    String IS_FALSE = "is false";
    String IS_BLANK = "is blank";
    String IS_NOT_BLANK = "is not blank";

    String[] OPS = {LESS_THAN, LESS_THAN_OR_EQUAL, EQUAL, GREATER_THAN, GREATER_THAN_OR_EQUAL, NOT_EQUAL, BETWEEN, NOT_BETWEEN, IN, NOT_IN, LIKE, NOT_LIKE, IS_NULL, IS_NOT_NULL, IS_EMPTY, IS_NOT_EMPTY, CONTAINS, NOT_CONTAINS, STARTS_WITH, ENDS_WITH, IS_TRUE, IS_FALSE, IS_BLANK, IS_NOT_BLANK};

}
