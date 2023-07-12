package org.opendatacore.meta.connector.engine.plugin.storage;

import org.jboss.logging.Logger;
import org.opendatacore.meta.connector.engine.plugin.resource.Access;
import org.opendatacore.meta.connector.engine.plugin.resource.Resource;
import org.opendatacore.meta.connector.engine.plugin.util.io.FileHelper;

import java.util.List;
import java.util.stream.Collectors;
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
public class ResourceRegistry {
    private static final Logger _logger = Logger.getLogger(ResourceRegistry.class);
    //public List<Resource> resources= new ArrayList<Resource>();
    private  ResourceStorage resourceStorage = new ResourceStorage();







    //singleton
    private static ResourceRegistry instance = null;






    private ResourceRegistry() {
        loadResourcesFromFile();
    }
    public static ResourceRegistry getInstance() {
        if(instance == null) {
            instance = new ResourceRegistry();



        }
        return instance;
    }


    private void loadResourcesFromFile() {
        resourceStorage = FileHelper.loadResources();

    }

    public void saveResourcesToFile() {
        FileHelper.saveResources(resourceStorage);
    }

    public void loadResources() {
        resourceStorage = FileHelper.loadResources();
    }


    //add resource
    public void addResource(Resource resource){



        resourceStorage.resources.add(resource);

        saveResourcesToFile();
    }


    public void addEncryptedResource(Resource resource){


        resource.access.encrypt();

        resourceStorage.resources.add(resource);

        saveResourcesToFile();
    }
    //Save resourses as Jsoin to file


    //get resource by id using stream API
    public Resource getResourceById(String id){
        id=id.trim();
        _logger.info("Getting resource by id: " + id);

        String finalId = id;
        Resource resource = resourceStorage.resources.stream()
                .filter(res -> res.id.equals(finalId))
                .findAny()
                .orElse(null);
        _logger.info("Resource found: " + resource);
        return resource;
    }

    //get resource by name using stream API
    public Resource getResourceByName(String name){
        Resource resource = resourceStorage.resources.stream()
                .filter(res -> res.name.equals(name))
                .findAny()
                .orElse(null);
        return resource;
    }

    //get all resource by type using stream API
    public List<Resource> getResourceByType(String type){
        List<Resource> resource = resourceStorage.resources.stream()
                .filter(res -> res.type.equals(type))
                .collect(Collectors.toList());
        return resource;
    }

    //get access for resource by id using stream API
    public Access getAccessById(String id){
        Access access = resourceStorage.resources.stream()
                .filter(res -> res.id.equals(id))
                .findAny()
                .orElse(null).access;
        return access;
    }

    //delete resource by id using stream API
    public void deleteResourceById(String id){
        resourceStorage.resources.removeIf(res -> res.id.equals(id));
        saveResourcesToFile();
    }

    //delete resource by name using stream API
    public void deleteResourceByName(String name){
        resourceStorage.resources.removeIf(res -> res.name.equals(name));
        saveResourcesToFile();
    }

    //update resource by id using stream API
    public void updateResourceById( Resource resource){
        resourceStorage.resources.stream()
                .filter(res -> res.id.equals(resource.id))
                .forEach(res -> {
                    res.access = resource.access;
                    res.id = resource.id;
                    res.type = resource.type;
                    res.subType = resource.subType;
                    res.name = resource.name;
                    res.orgId = resource.orgId;
                    res.department = resource.department;
                    res.owner = resource.owner;
                    res.supportEmail = resource.supportEmail;
                });
        saveResourcesToFile();
    }


}
