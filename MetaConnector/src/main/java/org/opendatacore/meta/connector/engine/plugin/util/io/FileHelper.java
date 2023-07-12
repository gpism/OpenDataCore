package org.opendatacore.meta.connector.engine.plugin.util.io;
//JSON 

import com.fasterxml.jackson.annotation.JsonInclude;
//logging

import org.apache.commons.io.FileUtils;
import org.jboss.logging.Logger;
import org.opendatacore.meta.connector.engine.plugin.security.Key;
import org.opendatacore.meta.connector.engine.plugin.storage.ResourceStorage;

import java.io.File;
import java.io.IOException;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;
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
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FileHelper {
    private static final Logger _logger = Logger.getLogger(FileHelper.class);
    static String app_folder = "odc";

    public static final String JSON_EXTENSION = "json";


    public static final String FS = System.getProperty("file.separator");

    //get base path
    public static String getBasePath() {
        return System.getProperty("user.dir");
    }

    //get file path from type , subType and name
    public static String getFilePath(String name , String type, String subType, String extension) {
        return getBasePath() +FS+app_folder + FS + type + FS + subType + FS + name + "." + extension;
    }


    public static void saveResources(ResourceStorage resourceStorage) {

        String path = getFilePath("resources", "app", "storage", JSON_EXTENSION);
        _logger.info("saving resources to path: " + path);
        try {
            String json = resourceStorage.toJson();
            writeStringToFilePath(path, json);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    //get release notes md as html
    public static String getReleaseNotes() {
        String path = getFilePath("release_notes", "app", "release", "md");
        _logger.info("getting release notes from path: " + path);
        try {
            String md = readFile(path);
            return convertMarkdownToHtml(md);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String convertMarkdownToHtml(String markdown) {
        Parser parser = Parser.builder().build();
        Node document = parser.parse(markdown);
        HtmlRenderer renderer = HtmlRenderer.builder().build();
        return renderer.render(document);
    }

    //Load ResourceStorage from file
    public static ResourceStorage loadResources() {

        String path = getFilePath("resources", "app", "storage", JSON_EXTENSION);
        _logger.info("Loading resources to path: " + path);
        try {
            //Check if file exists in path
            if(!new File(path).exists()){
                _logger.info("File does not exist in path: " + path);
                return new ResourceStorage();
            }else{
                _logger.info("File exists in path: " + path);
                String json = readFile(path);
                return ResourceStorage.fromJson(json);
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }



    //Write string to file
    public static void writeStringToFilePath(String filePath, String content) throws IOException {

        FileUtils.writeStringToFile(new File(filePath), content);

    }

    public static void writeFile(String name ,String type, String subType,String content ,String extension) throws IOException {
        String path= getFilePath(name,type,subType,extension);
        _logger.info("writing file to path: " + path);
        writeStringToFilePath(path,content);

    }
    //Write string to file
    public static void writeStringToFile(String filePath, String content) throws IOException {

        FileUtils.writeStringToFile(new File(filePath), content);

    }
    //Read file from path
    public static String readFile(String path) throws IOException {

        _logger.info("reading file from path: " + path);
        return FileUtils.readFileToString(new File(path));

    }

    //private get masterKey path
    private static String getMasterKeyPath() {
        return getBasePath() + FS + "app" + FS + "key" + FS + "master.key" +"." + JSON_EXTENSION;
    }

    // Read the Key from the file in application dir
    public static String readMasterKeyFromFile() throws IOException {
        String path= getMasterKeyPath();
        _logger.info("reading file from path: " + path);
        return readFile(path);
    }

    public static void writeMasterKeyFromFile(Key key) throws Exception {
        String path=  getMasterKeyPath();
        _logger.info("reading file from path: " + path);
         writeStringToFile(path, key.toJson());
    }

    //check if exists in path
    public static boolean checkIfFileExists(String path) {
        File file = new File(path);
        return file.exists();
    }

    //check if master key exists
    public static boolean checkIfMasterKeyExists() {
        String path= getMasterKeyPath();
        return checkIfFileExists(path);
    }



}
